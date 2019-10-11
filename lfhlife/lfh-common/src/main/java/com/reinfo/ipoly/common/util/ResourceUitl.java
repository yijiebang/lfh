package com.reinfo.ipoly.common.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reinfo.ipoly.common.config.ConstantContext;

public class ResourceUitl {
    public static final Logger LOG = LoggerFactory.getLogger(ResourceUitl.class);

    private static final String RESOURCE_FILE = "file";

    private static final String RESOURCE_DELIM = ":";

    private static Map<String, String> map = new HashMap();
    /**
     * 配置文件根目录
     */
    private static String configPath = null;

    /**
     * Open a input stream from classpath of filepath.
     */
    public static InputStream openInputStream(String propFile) throws Exception {
        if (LOG.isDebugEnabled()) {
            LOG.debug("The properties file is :" + propFile + ".");
        }
        if (propFile.startsWith(ConstantContext.RESOURCE_CLASSPATH)) {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            if (cl == null) {
                // support for jre1.3 or below
                cl = ResourceUitl.class.getClassLoader();
            }
            return cl.getResourceAsStream(extract(propFile));
        } else if (propFile.startsWith(RESOURCE_FILE)) {
            File file = new File(extract(propFile));
            return new FileInputStream(file);
        } else {
            throw new IllegalStateException("Unsupport resource type: " + propFile);
        }
    }

    public static String openPath(String propFile) throws Exception {
        if (propFile.startsWith(ConstantContext.RESOURCE_CLASSPATH)) {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            if (cl == null) {
                // support for jre1.3 or below
                cl = ResourceUitl.class.getClassLoader();
            }
            return cl.getResource(extract(propFile)).getPath();
        } else if (propFile.startsWith(RESOURCE_FILE)) {
            File file = new File(extract(propFile));
            return file.getAbsolutePath();
        } else {
            throw new IllegalStateException("Unsupport resource type: " + propFile);
        }
    }

    public static String getMailContent(String file) throws Exception {
        if (file != null) {
            if (map.get(file) != null) {
                return map.get(file);
            }
            InputStream is = openInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line = null;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "/n");
                }

            } catch (Exception e) {
                throw e;
            } finally {
                try {
                    is.close();
                } catch (Exception e) {
                    throw e;
                }
            }
            map.put(file, sb.toString());
            return sb.toString();
        }
        return null;

    }

    public static String extract(String propFile) {
        int index = propFile.indexOf(RESOURCE_DELIM);
        if (index == -1) {
            throw new IllegalStateException("Wrong format of properties file path:" + propFile);
        }
        return propFile.substring(index + 1);
    }

    /**
     * 将该对象序列化成流,因为写在流里的是对象的一个拷贝，而原对象仍然存在于JVM里面。所以利用这个特性可以实现对象的深拷贝
     * 
     * @return
     * @throws Exception
     */
    public static Object deepCopy(Object obj) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            ObjectOutputStream oos = new ObjectOutputStream(bos);

            oos.writeObject(obj);

            // 将流序列化成对象
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());

            ObjectInputStream ois = new ObjectInputStream(bis);

            return ois.readObject();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return obj;
        }
    }

    /**
     * 获取配置文件 的根目录
     * 
     * @return
     */
    public static String getConfigPath() {
        if (configPath != null) {
            return configPath;
        }
        String root = System.getProperty("user.dir");
        if (new File(root + System.getProperty("file.separator") + "conf").exists()) {
            configPath = root;
        } else if (new File(new File(root).getParent() + System.getProperty("file.separator") + "conf").exists()) {
            configPath = new File(root).getParent();
        } else {
            configPath = root;
        }
        // 表示本地开发路径
        return configPath;
    }
}
