package com.reinfo.ipoly.common.httprequest;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class HttpRequest {
    public static final Logger LOG = LoggerFactory.getLogger(HttpRequest.class);
    public static final String HEADFIELD_CHARSET = "charset=";
    public static final String MODE_GET = "GET";
    public static final String MODE_POST = "POST";
    public static final String DEFAULT_ACCEPT = "text/html, application/xhtml+xml, */*";

    // http请求超时时间，单位：ms
    public static final int CONNECT_TIME_OUT = 10000;
    // http响应超时时间，单位：ms
    public static final int READ_TIME_OUT = 200000;
    public static final String DEFAULT_CHARSET = "utf-8";

    public static Map<String, Map<String, String>> cookie = new HashMap<String, Map<String, String>>();
    public static Map<String, Map<String, String>> parameter = new HashMap<String, Map<String, String>>();

    /**
     * 发送POST请求
     * 
     * @param url
     * @param parameterOfPost
     * @return
     */
    public static String sendPost(String url, String parameterOfPost, Map<String, String> requestProperty) {
        requestProperty = requestProperty == null ? new HashMap() : requestProperty;
        requestProperty.put("X-Requested-With", "XMLHttpRequest");
        requestProperty.put("Content-Type", "application/json");
        return HttpRequest.sendHttpRequestProxy(false, null, "POST", url, parameterOfPost, null, DEFAULT_CHARSET, requestProperty);
    }

    /**
     * 发送POST请求
     * 
     * @param url
     * @param parameterOfPost
     * @return
     */
    public static String sendPost(String url, String parameterOfPost) {
        Map<String, String> requestProperty = new HashMap();
        requestProperty.put("X-Requested-With", "XMLHttpRequest");
        requestProperty.put("Content-Type", "application/json");
        return HttpRequest.sendHttpRequestProxy(false, null, "POST", url, parameterOfPost, null, DEFAULT_CHARSET, requestProperty);
    }

    /**
     * 发送POST请求
     * 
     * @param url
     * @param parameterOfPost
     * @return
     */
    public static String sendPostMoka(String url, String parameterOfPost) {
        Map<String, String> requestProperty = new HashMap();
        requestProperty.put("Content-Type", "application/x-www-form-urlencoded");
        return HttpRequest.sendHttpRequestProxy(false, null, "POST", url, parameterOfPost, null, DEFAULT_CHARSET, requestProperty);
    }

    /**
     * 发送GET请求
     * 
     * @param url
     * @param parameterOfPost
     * @return
     */
    public static String sendGet(String url) {
        Map<String, String> requestProperty = new HashMap<>();
        requestProperty.put("X-Requested-With", "XMLHttpRequest");
        requestProperty.put("Content-Type", "x-www-form-urlencoded");
        return HttpRequest.sendHttpRequestProxy(false, null, "GET", url, null, null, DEFAULT_CHARSET, requestProperty);
    }

    public static String sendHttpRequestProxy(Boolean isFollowRedirects, String cookieKey, String mode, String url, String parameterOfPost,
            com.reinfo.ipoly.common.httprequest.Proxy proxyOfModule, String charset, Map<String, String> requestProperty) {
        return sendHttpRequestProxy(isFollowRedirects, cookieKey, mode, url, parameterOfPost, null, proxyOfModule, charset, requestProperty);
    }

    public static String sendRequest(String url, byte[] data) {
        InputStream ins = null;
        InputStreamReader inr = null;
        BufferedReader br = null;
        HttpURLConnection connection = null;
        StringBuffer html = new StringBuffer();
        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setDoOutput(true);// http正文内，因此需要设为true, 默认情况下是false;
            connection.setDoInput(true);// 设置是否从httpUrlConnection读入，默认情况下是true;
            connection.setUseCaches(false);// Post 请求不能使用缓存
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/octet-stream");
            connection.setConnectTimeout(CONNECT_TIME_OUT);
            connection.setReadTimeout(READ_TIME_OUT);

            // 二进制报告放到outputStream
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(data);
            outputStream.flush();
            // 处理结果
            ins = connection.getInputStream();

            String line = "";

            inr = new InputStreamReader(ins, DEFAULT_CHARSET);
            br = new BufferedReader(inr);
            do {
                line = br.readLine();
                html.append(line == null ? "" : line + "\n");
            } while (line != null);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return null;
        } finally {
            try {
                if (ins != null) {
                    ins.close();
                }
                if (inr != null) {
                    inr.close();
                }
                if (br != null) {
                    br.close();
                }
                if (connection != null) {
                    connection.disconnect();
                }
            } catch (Exception e) {
                LOG.error("Close streaming error", e);
            }
        }
        return html.toString();
    }

    /**
     * 发送请求数据
     * 
     * @param cookieKey 响应后的cookie对应的key,每个交易有个唯一的key，能够获取cookie和设置cookie
     * @param isUpdateCookie 响应后的cookie是否更新到全局缓存中. 更新：true, 不更新 ：false
     * @param mode 请求方式 ： 如果是get,请用HttpRequest.MODE_GET 如果是post,请用HttpRequest.MODE_POST
     * @param url 请求的URL
     * @return 返回请求的html
     * @throws Exception
     */
    public static String sendHttpRequestProxy(Boolean isFollowRedirects, String cookieKey, String mode, String url, String parameterOfPost, byte[] data,
            com.reinfo.ipoly.common.httprequest.Proxy proxyOfModule, String charset, Map<String, String> requestProperty) {
        String html = null;
        if ("".equals(parameterOfPost)) {
            parameterOfPost = null;
        }
        int numberOfError = 1;
        int numberOfBlock = 1;
        com.reinfo.ipoly.common.httprequest.Proxy proxy =
                proxyOfModule == null ? null : (com.reinfo.ipoly.common.httprequest.Proxy) proxyOfModule.clone();
        int number = numberOfError + numberOfBlock;
        int j = 0;
        int k = 0;
        for (int i = 1; i <= number; i++) {
            try {
                html = sendHttpRequest(isFollowRedirects, cookieKey, mode, url, parameterOfPost, data, proxy, charset, requestProperty);
                if (proxy != null) {
                    if (k != numberOfBlock && proxy.isExist(html)) {
                        Thread.sleep(500);// 出现屏蔽就睡眠500ms
                        proxy.setIp(null);
                        LOG.error(url + " : 屏蔽第[ " + k + " ]");
                        k++;
                        continue;
                    }
                }
            } catch (Exception e) {
                try {
                    Thread.sleep(500);// 出现异常就睡眠500ms
                } catch (Exception e1) {
                    LOG.error(url + " : 出现异常第 [ " + j + " ] 次,错误信息[ " + e.getMessage() + " ]");
                }
                // 如果失败次数是最后一次就使用本地IP
                if (proxy != null && proxy.getHasLocalAdder() && j == numberOfError - 1) {
                    proxy = null;
                }
                if (proxy != null && proxy.getIp() == null) {
                    proxy.setIp(null);
                }
                if (j != numberOfError) {
                    LOG.error(url + " : 出现异常第 [ " + j + " ] 次,错误信息[ " + e.getMessage() + " ]");
                    j++;
                    continue;
                }
                LOG.error(url + " : 出现异常第 [ " + j + " ] 次,错误信息 : ", e);
                return null;
            }
            break;
        }
        return html;
    }

    /**
     * 发送请求数据.
     * 
     * @param cookieKey 响应后的cookie对应的key,每个交易有个唯一的key，能够获取cookie和设置cookie
     * @param isFollowRedirects 是否允许响应后跳转. 允许：true, 不允许 ：false
     * @param mode 请求方式 ： 如果是get,请用HttpRequest.MODE_GET 如果是post,请用HttpRequest.MODE_POST
     * @param url 请求的URL
     * @param referer 如果没值 就没设置
     * @param accept 请求参数
     * @param parameterOfPost 如果没值 就没设置
     * @return 返回请求的html
     * @throws Exception
     */
    public static String sendHttpRequest(Boolean isFollowRedirects, String key, String mode, String url, String parameterOfPost, byte[] data,
            com.reinfo.ipoly.common.httprequest.Proxy proxyOfModule, String charset, Map<String, String> requestProperty) throws Exception {
        if (url == null || "".equals(url)) {
            return null;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ByteArrayOutputStream bao = null;
        InputStream ins = null;
        InputStream insClone = null;
        InputStream insError = null;
        GZIPInputStream gzip = null;
        HttpURLConnection conn = null;
        InputStreamReader inr = null;
        BufferedReader br = null;
        try {
            conn = getHttpURLConnection(isFollowRedirects, key, mode, url, parameterOfPost, data, proxyOfModule, requestProperty);
            if (conn == null) {
                return null;
            }
            /**
             * 响应请求：获取网页数据
             */
            if (charset == null || "".equals(charset)) {
                if (conn.getHeaderFields().get("Content-Type") != null) {
                    charset = getCharset(conn.getHeaderFields().get("Content-Type").toString());
                }
            }
            ins = conn.getInputStream();

            /**
             * 响应请求：取响应后的cookie并根据条件设置cookie信息
             */
            setCookieParameter(key, conn, requestProperty);

            /**
             * 响应请求：获取gzip压缩数据
             */
            if (null != conn.getHeaderField("Content-Encoding") && conn.getHeaderField("Content-Encoding").equals("gzip")) {
                gzip = new GZIPInputStream(ins);
                byte[] b = null;
                byte[] buf = new byte[1024];
                int num = -1;

                while ((num = gzip.read(buf, 0, buf.length)) != -1) {
                    baos.write(buf, 0, num);
                }
                b = baos.toByteArray();

                return new String(b, charset).trim();
            }

            if (charset == null) {
                bao = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = ins.read(buffer)) > -1) {
                    bao.write(buffer, 0, len);
                }
                bao.flush();
                // 打开一个新的输入流
                ins = new ByteArrayInputStream(bao.toByteArray());
            }

            StringBuffer html = new StringBuffer();
            String line = "";
            inr = new InputStreamReader(ins, charset == null ? DEFAULT_CHARSET : charset);
            br = new BufferedReader(inr);
            do {
                line = br.readLine();
                html.append(line == null ? "" : line + "\n");
            } while (line != null);

            // 如果没有指定网页编码格式，会第一次从Content-Type获取编码格式，如果获取不到就从网页本身获取编码格式，就需要克隆流重新加入编码格式进行解析
            if (charset == null) {
                if (html.toString().indexOf("charset=\"") != -1) {
                    charset = html.toString().split("charset=\"")[1].split("\"")[0];
                } else if (html.toString().indexOf("charset=") != -1) {
                    charset = html.toString().split("charset=")[1].split("\"")[0];
                }
                if (charset != null && charset.indexOf("8") == -1) {
                    html = new StringBuffer();
                    insClone = new ByteArrayInputStream(bao.toByteArray());
                    inr = new InputStreamReader(insClone, charset);
                    br = new BufferedReader(inr);
                    do {
                        line = br.readLine();
                        html.append(line == null ? "" : line + "\n");
                    } while (line != null);
                }
            }

            // 处理重定向URL，因为自动重定向，sessionID发生变化
            if (isFollowRedirects) {
                String locationUrl = conn.getHeaderField("Location");
                if (locationUrl != null) {
                    if (locationUrl.indexOf("http") == -1) {
                        String[] prexUrls = url.split("/");
                        locationUrl = prexUrls[0] + "//" + prexUrls[2] + locationUrl;
                    }
                } else if (html.indexOf("window.location.replace(\"") != -1) {
                    locationUrl = html.toString().split("window.location.replace\\(\"")[1].split("\"\\)")[0];
                }

                if (locationUrl != null) {
                    LOG.info("Request           重定向URL ：" + locationUrl);
                    return sendHttpRequest(false, key, HttpRequest.MODE_GET, locationUrl, null, null, proxyOfModule, null, requestProperty);
                }
            }
            return html.toString();

        } catch (Exception e) {
            throw e;
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
                if (bao != null) {
                    bao.close();
                }
                if (gzip != null) {
                    gzip.close();
                }
                if (ins != null) {
                    ins.close();
                }
                if (insError != null) {
                    insError.close();
                }
                if (inr != null) {
                    inr.close();
                }
                if (insClone != null) {
                    insClone.close();
                }
                if (br != null) {
                    br.close();
                }
                if (conn != null) {
                    conn.disconnect();
                }
                // 释放IP的连接数的逻辑记录
                // if (proxy != null && isFreeProxy) {
                // proxyService.freeProxy(proxy);
                // }
            } catch (IOException e) {
                LOG.error("Close streaming error", e);
            }
        }
    }

    /**
     * 返回链接
     * 
     * @param isFollowRedirects
     * @param cookieKey
     * @param mode
     * @param url
     * @param referer
     * @param accept
     * @param contentType
     * @param parameterOfPost
     * @param proxyOfModule
     * @return
     * @throws Exception
     */
    private static HttpURLConnection getHttpURLConnection(Boolean isFollowRedirects, String cookieKey, String mode, String url, String parameterOfPost,
            byte[] data, com.reinfo.ipoly.common.httprequest.Proxy proxyOfModule, Map<String, String> requestProperty) throws Exception {
        // if (ManagementConfig.getInstance().getBoolean("application.isTest")) {
        // System.getProperties().put("proxySet", "true");
        // System.getProperties().put("proxyHost", "127.0.0.1");
        // System.getProperties().put("proxyPort", "8888");
        // }
        if (LOG.isDebugEnabled()) {
            LOG.debug("Request isFollowRedirects ：" + isFollowRedirects);
            if (requestProperty != null) {
                LOG.debug("Request   requestProperty ：" + JSON.toJSONString(requestProperty));
            }
            LOG.debug("Request              mode ：{}", mode);
            LOG.debug("Request               url ：" + url);
            LOG.debug("Request   parameterOfPost ：" + parameterOfPost);
        }
        if (url.startsWith("https://")) {
            try {
                HttpsURLConnection.setDefaultHostnameVerifier(new javax.net.ssl.HostnameVerifier() {
                    public boolean verify(String hostname, javax.net.ssl.SSLSession sslSession) {
                        return true;
                    }
                });
                TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    @Override
                    public void checkClientTrusted(java.security.cert.X509Certificate[] arg0, String arg1) throws CertificateException {}

                    @Override
                    public void checkServerTrusted(java.security.cert.X509Certificate[] arg0, String arg1) throws CertificateException {}
                }};

                SSLContext sc = SSLContext.getInstance("TLS");
                sc.init(null, trustAllCerts, new SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            } catch (Exception e) {
                LOG.error("Request https error !", e);
                return null;
            }
        }

        /**
         * 设置请求参数
         */
        URL serverUrl = new URL(url);
        HttpURLConnection conn = null;
        /**
         * 判断是否需要代理IP
         */
        /**
         * 判断是否需要代理IP
         */
        /**
         * 判断是否需要代理IP,如果设置需要代理，但数据库没有代理IP且传入没有代理IP，那就不使用代理IP
         */
        if (proxyOfModule != null && proxyOfModule.getIp() != null) {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyOfModule.getIp(), proxyOfModule.getPort()));
            if (proxyOfModule.getUserName() != null && !"".equals(proxyOfModule.getUserName())) {
                Authenticator.setDefault(new MyAuthenticator(proxyOfModule.getUserName(), proxyOfModule.getPassword()));// 设置代理的用户和密码
            }
            conn = (HttpURLConnection) serverUrl.openConnection(proxy);
            if (proxyOfModule.getConnectTimeout() != null) {
                conn.setConnectTimeout(proxyOfModule.getConnectTimeout().intValue());
            }
            if (proxyOfModule.getReadTimeout() != null) {
                conn.setReadTimeout(proxyOfModule.getReadTimeout().intValue());
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("切换动态代理IP[" + proxyOfModule.getIp() + ":" + proxyOfModule.getPort() + "]");
            }
        } else {
            conn = (HttpURLConnection) serverUrl.openConnection();
            conn.setConnectTimeout(CONNECT_TIME_OUT);
            conn.setReadTimeout(READ_TIME_OUT);
        }

        conn.setInstanceFollowRedirects(false);
        conn.setRequestMethod(mode);

        if (requestProperty != null && requestProperty.size() > 0) {
            for (Map.Entry<String, String> map : requestProperty.entrySet()) {
                conn.addRequestProperty(map.getKey(), map.getValue());
            }
        }
        /**
         * 取当前用户的cookie
         */
        Map<String, String> curentCookie = null;
        if (cookieKey != null) {
            StringBuffer curentCookieInfo = new StringBuffer();
            curentCookie = cookie.get(cookieKey);
            if (curentCookie != null && curentCookie.size() > 0) {
                for (String key : curentCookie.keySet()) {
                    curentCookieInfo.append(key + "=" + curentCookie.get(key) + ";");
                }
                conn.addRequestProperty("Cookie", curentCookieInfo.substring(0, curentCookieInfo.length() - 1));
            }
        }

        /**
         * 开始发送请求
         */
        if (MODE_GET.equalsIgnoreCase(mode)) {
            conn.connect();
        } else if (MODE_POST.equalsIgnoreCase(mode)) {
            conn.setDoOutput(true);// http正文内，因此需要设为true, 默认情况下是false;
            conn.setDoInput(true);// 设置是否从httpUrlConnection读入，默认情况下是true;
            conn.setUseCaches(false);// Post 请求不能使用缓存
            conn.connect();
            if (parameterOfPost != null) {
                conn.getOutputStream().write(parameterOfPost.getBytes("UTF8"));
            } else if (data != null) {
                conn.getOutputStream().write(data);
            } else {
                conn.getOutputStream().write("".getBytes());
            }
        }

        return conn;
    }

    /**
     * 获取<input>标签中value的值
     * 
     * @param html
     * @param key
     * @return
     */
    public static String getParameterByInput(String html, String key) {
        String startTag = "value=\"";
        String endTag = "\"";
        String value = null;
        int index = html.indexOf(key);
        if (index == -1) {
            return null;
        }
        int startIndex = html.indexOf(startTag, index);
        int endIndex = html.indexOf(endTag, startIndex + startTag.length());
        if (startIndex != -1 && endIndex != -1) {
            value = html.substring(startIndex + startTag.length(), endIndex);
        }
        return replaceValue(value);
    }

    /**
     * 根据字段值 通过开始标签与结束标签在html截取对应的值
     * 
     * @param html 页面数据
     * @param key 要取字段的名
     * @param startTag 从字段对应开始标签开始
     * @param endTag 从字段对应开始标签结束
     * @return
     */

    public static String getParameterByKey(String html, String key, String startTag, String endTag) {
        String value = null;
        int index = html.indexOf(key);
        if (index == -1) {
            return "";
        }
        int startIndex = html.indexOf(startTag, index);
        int endIndex = html.indexOf(endTag, startIndex + startTag.length());
        if (startIndex != -1 && endIndex != -1) {
            value = html.substring(startIndex + startTag.length(), endIndex);
        }
        return replaceValue(value);
    }

    /**
     * 替换特殊字符.
     * 
     * @param src
     * @return
     */
    public static String replaceValue(String src) {
        if (src == null || src.length() == 0) {
            return null;
        }
        String dst = "";
        // %2F /
        // %3A :
        // %3D =
        // %7C |
        // %2B +
        dst = src.replace("/", "%2F");
        dst = dst.replace(":", "%3A");
        dst = dst.replace("=", "%3D");
        dst = dst.replace("|", "%7C");
        dst = dst.replace("+", "%2B");

        // 空格替换成+
        dst = dst.replace(" ", "+");
        return dst;
    }

    /**
     * 从页面头部获取编码格式.
     * 
     * @param headField
     * @return
     */
    private static String getCharset(String headField) {
        if (headField == null) {
            LOG.warn("headField is null");
            return null;
        }
        int begin = 0, end = 0;
        begin = headField.indexOf(HEADFIELD_CHARSET);
        String charset = "";
        if (begin != -1) {
            end = headField.indexOf(";", begin);
            if (end == -1) {
                end = headField.indexOf("]", begin);
            }
            if (end != -1) {
                charset = headField.substring(begin + 8, end);
                return charset;
            }
        }
        return null;
    }

    /**
     * 响应请求：取响应后的cookie并根据条件设置cookie信息
     */
    private static void setCookieParameter(String key, HttpURLConnection conn, Map<String, String> requestProperty) {
        if (key != null) {
            Map<String, String> curentCookie = cookie.get(key);
            Map<String, String> parameterMap = parameter.get(key);

            if (curentCookie == null) {
                curentCookie = new HashMap<String, String>();
                cookie.put(key, curentCookie);
            }
            if (parameterMap == null) {
                parameterMap = new HashMap<String, String>();
                parameter.put(key, parameterMap);
            }
            if (conn.getHeaderFields().get("Set-Cookie") == null) {
                return;
            }
            synchronized (curentCookie) {
                String location = conn.getHeaderField("Location");
                if (location != null) {
                    parameterMap.put("Location", location);
                }
                List<String> setCookieList = conn.getHeaderFields().get("Set-Cookie");
                // 如果配置获取第几个Set-Cookie，就返回第几个，否则就拿所有Set-Cookie信息。因为有返回两个JSESSIONID,只能指定某一个
                for (String cookieInfo : setCookieList) {
                    int index1 = cookieInfo.indexOf(";");
                    int index2 = cookieInfo.indexOf("=");
                    if (index1 != -1 && index2 != -1 && index2 < index1) {
                        String cookieKey = cookieInfo.substring(0, index2);
                        String value = cookieInfo.substring(index2 + 1, index1);
                        if (value != null && !"".equals(value) && !"\"\"".equals(value) && !"null".equalsIgnoreCase(value)) {
                            curentCookie.put(cookieKey, value);
                            parameterMap.put(cookieKey, value);
                        }
                    } else if (index1 == -1 && index2 != -1) {
                        String cookieKey = cookieInfo.substring(0, index2);
                        String value = cookieInfo.substring(index2 + 1);
                        if (value != null && !"".equals(value) && !"\"\"".equals(value) && !"null".equalsIgnoreCase(value)) {
                            curentCookie.put(cookieKey, value);
                            parameterMap.put(cookieKey, value);
                        }
                    }
                }
            }
        }
    }

    /**
     * 从缓存中迁移formKeyID的数据到toKeyID中，并删除formKeyID数据
     * 
     * @param formKeyID 被迁移数据
     * @param toKeyID 迁移到的数据
     */
    public static void migrationCookieAndParameter(String formKeyID, String toKeyID) {
        if (toKeyID != null && !toKeyID.equals(formKeyID)) {
            Map<String, String> cookie = HttpRequest.cookie.get(formKeyID);
            Map<String, String> currentCookie = HttpRequest.cookie.get(toKeyID);
            if (currentCookie != null && cookie != null) {
                for (Map.Entry<String, String> entry : cookie.entrySet()) {
                    if (entry.getValue() != null && !"".equals(entry.getValue())) {
                        currentCookie.put(entry.getKey(), entry.getValue());
                    }
                }
            } else if (currentCookie == null) {
                currentCookie = cookie;
            }
            HttpRequest.cookie.put(toKeyID, currentCookie);
            HttpRequest.cookie.remove(formKeyID);

            Map<String, String> parameter = HttpRequest.parameter.get(formKeyID);
            Map<String, String> currentParameter = HttpRequest.parameter.get(toKeyID);
            if (currentParameter != null && parameter != null) {
                for (Map.Entry<String, String> entry : parameter.entrySet()) {
                    if (entry.getValue() != null && !"".equals(entry.getValue())) {
                        currentParameter.put(entry.getKey(), entry.getValue());
                    }
                }
            } else if (currentParameter == null) {
                currentParameter = parameter;
            }
            HttpRequest.parameter.put(toKeyID, currentParameter);

            HttpRequest.parameter.remove(formKeyID);
        }
    }


    /**
     * 查找变量是否被替换。
     * 
     * @param value
     * @return
     */
    public static boolean isFindVariable(Object value) {
        if (value == null || "".equals(value) || value instanceof Byte) {
            return false;
        }
        String emailPattern = "\\$\\{\\S*\\}";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher((String) value);
        return matcher.find();
    }

    static class MyAuthenticator extends Authenticator {
        private String user = "";
        private String password = "";

        public MyAuthenticator(String user, String password) {
            this.user = user;
            this.password = password;
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(user, password.toCharArray());
        }
    }

    public static void main(String[] args) throws Exception {
        com.reinfo.ipoly.common.httprequest.Proxy proxy = new com.reinfo.ipoly.common.httprequest.Proxy();
        proxy.setHasLocalAdder(false);
        proxy.setIp("27.30.28.249");
        proxy.setPort(2040);
        proxy.setUserName("cj531a!!!!");
        proxy.setPassword("cj531a!!!!");
        String method = "GET";
        String uRLEncode = URLEncoder.encode("北京安捷迅工贸有限公司", "utf-8");
        String url = "http://www.qichacha.com/search?key=" + uRLEncode + "&index=";
        String html = HttpRequest.sendHttpRequestProxy(true, "afafaf", method, url, null, null, proxy, null, null);
        System.out.println(html);
    }
}
