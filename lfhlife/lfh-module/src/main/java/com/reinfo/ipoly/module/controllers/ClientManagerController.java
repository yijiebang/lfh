package com.reinfo.ipoly.module.controllers;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reinfo.ipoly.common.config.ConstantContext;
import com.reinfo.ipoly.common.config.SessionManager;
import com.reinfo.ipoly.common.config.SystemCode;
import com.reinfo.ipoly.common.exception.ApplicationException;
import com.reinfo.ipoly.common.mappers.common.Criteria;
import com.reinfo.ipoly.common.util.DateTimeUtil;
import com.reinfo.ipoly.common.util.FileUtil;
import com.reinfo.ipoly.module.base.controllers.BaseWebController;
import com.reinfo.ipoly.module.base.models.Page;
import com.reinfo.ipoly.module.models.Clafl;
import com.reinfo.ipoly.module.models.Clefl;
import com.reinfo.ipoly.module.models.Clifl;
import com.reinfo.ipoly.module.models.Cllfl;
import com.reinfo.ipoly.module.models.Imgfl;
import com.reinfo.ipoly.module.models.K3ufl;
import com.reinfo.ipoly.module.models.Polfl;
import com.reinfo.ipoly.module.models.Stafl;
import com.reinfo.ipoly.module.models.Tchfl;
import com.reinfo.ipoly.module.report.utils.ClientReportUtil;
import com.reinfo.ipoly.module.services.Cl6flService;
import com.reinfo.ipoly.module.services.ClaflService;
import com.reinfo.ipoly.module.services.ClcflService;
import com.reinfo.ipoly.module.services.CleflService;
import com.reinfo.ipoly.module.services.ClgflService;
import com.reinfo.ipoly.module.services.ClhflService;
import com.reinfo.ipoly.module.services.CliflService;
import com.reinfo.ipoly.module.services.CllflService;
import com.reinfo.ipoly.module.services.ImgflService;
import com.reinfo.ipoly.module.services.K3uflService;
import com.reinfo.ipoly.module.services.PolflService;
import com.reinfo.ipoly.module.services.SecflService;
import com.reinfo.ipoly.module.services.TchflService;
import com.reinfo.ipoly.module.services.YpromptService;
import com.reinfo.ipoly.module.services.YremarkService;
import com.reinfo.ipoly.module.services.YusrgrpsecuService;
import com.reinfo.ipoly.module.utils.PrimaryKeyUtils;

@Controller
@RequestMapping(value = "clientManager")
public class ClientManagerController extends BaseWebController {
    public static final Logger LOG = LoggerFactory.getLogger(ClientManagerController.class);

    @Autowired
    protected CliflService cliflService;
    @Autowired
    protected ClaflService claflService;
    @Autowired
    protected Cl6flService cl6flService;
    @Autowired
    protected ClcflService clcflService;
    @Autowired
    protected ClgflService clgflService;
    @Autowired
    protected CleflService cleflService;
    @Autowired
    protected ClhflService clhflService;
    @Autowired
    protected CllflService cllflService;
    @Autowired
    protected K3uflService k3uflService;
    @Autowired
    protected PolflService polflService;
    @Autowired
    protected TchflService tchflService;
    @Autowired
    protected ImgflService imgflService;
    @Autowired
    protected SecflService secflService;
    @Autowired
    protected YpromptService ypromptService;
    @Autowired
    protected YremarkService yremarkService;
    @Autowired
    protected YusrgrpsecuService yusrgrpsecuService;

    
    @RequestMapping(value = "method.json")
    public String method() {
    	System.out.println("123");
    	return "123";
    }
    
    /**
     * (clientManager) query list.
     * 
     * @param payTransaction
     * @param map
     * @param session
     * @throws ApplicationException
     */
    @ResponseBody
    @RequestMapping(value = "getList.json")
    public Object getList(@RequestBody Clifl clifl, HttpSession session) throws ApplicationException {
        Stafl stafl = SessionManager.getUser(session);
        yusrgrpsecuService.authority(stafl.getStaUser(), ConstantContext.AUTHORITY_TYPE_VIEW);
        if (clifl.getPage() == null) {
            clifl.setPage(new Page());
        }

        if (clifl.getCliLname() != null && StringUtils.isNotBlank(clifl.getCliLname().toString())) {
            clifl.setCliLname("%" + clifl.getCliLname().toString().toUpperCase() + "%");
        }
        clifl.getPage().setTotalRecord(cliflService.getListCount(clifl));

        Map<String, Object> result = new HashMap<>();
        result.put(ConstantContext.RESPONSE_DATA_PAGE, clifl.getPage());
        result.put(ConstantContext.RESPONSE_DATA_LIST, cliflService.getList(clifl));

        return success(result);
    }

    /**
     * (clientManager) query detail
     * 
     * @param cliCode
     * @param session
     * @return
     * @throws ApplicationException
     */
    @ResponseBody
    @RequestMapping(value = "getClifl.json")
    public Object getClifl(@RequestParam String cliCode, HttpSession session) throws ApplicationException {
        return success(cliflService.getOneBy(Clifl.DBStrCliCode, cliCode));
    }

    /**
     * (clientManager) add.
     * 
     * @param clifl
     * @param session
     * @return
     * @throws ApplicationException
     */
    @ResponseBody
    @RequestMapping(value = "addClientManager.json")
    public Object addClientManager(@RequestBody Clifl clifl, HttpSession session) throws ApplicationException {
        Stafl stafl = SessionManager.getUser(session);
        yusrgrpsecuService.authority(stafl.getStaUser(), ConstantContext.AUTHORITY_TYPE_ADD);
        if (StringUtils.isNotBlank(clifl.getCliCode())) {
            Long count = cliflService.getTotalCountBy(Criteria.newCriteria().addWhere(Clifl.DBStrCliCode, clifl.getCliCode()));
            if (count != null && count > 0) {
                throw new ApplicationException(SystemCode.CLICODE_ALREADY_EXISTS.getCode(), "{}[cliCode:{}]", SystemCode.CLICODE_ALREADY_EXISTS.getMessage(),
                        clifl.getCliCode());
            }
        } else {
            clifl.setCliCuser(stafl.getStaUser());
            clifl.setCliCdate(new Date());
            String cliCode = cliflService.getMaxBy(Criteria.newCriteria().setMaxField(Clifl.DBStrCliCode));
            if (StringUtils.isBlank(cliCode)) {
                cliCode = "A00000";
            }
            clifl.setCliCode(PrimaryKeyUtils.addOne(cliCode));
        }
        clifl.setCliAdate(new Date());
        clifl.setCliAuser(stafl.getStaUser());
        // 提供默认值
        clifl.setCliLock(0l);
        clifl.setCliAr("Y");
        clifl.setCliCapamt(0L);
        clifl.setCliAtnac(" ");
        clifl.setCliAtnclm(" ");
        clifl.setCliAtnuw(" ");
        clifl.setCliAtnfac(" ");
        clifl.setCliAtntty(" ");
        clifl.setCliCapccy(" ");
        clifl.setCliOffice(" ");
        clifl.setCliStaff(" ");
        cliflService.insert(clifl);

        return success(clifl);
    }

    /**
     * (clientManager) update.
     * 
     * @param clifl
     * @param session
     * @return
     * @throws ApplicationException
     */
    @ResponseBody
    @RequestMapping(value = "updateClientManager.json")
    public Object updateClientManager(@RequestBody Clifl clifl, HttpSession session) throws ApplicationException {
        Stafl stafl = SessionManager.getUser(session);
        yusrgrpsecuService.authority(stafl.getStaUser(), ConstantContext.AUTHORITY_TYPE_MODIFY);

        Assert.notNull(clifl, "The request parameter cannot be empty");
        Assert.hasLength(clifl.getCliCode(), "cliCode cannot be empty");
        clifl.setCliAdate(new Date());
        clifl.setCliAuser(stafl.getStaUser());
        int code = cliflService.updateBy(clifl, Criteria.newCriteria().addWhere(Clifl.DBStrCliCode, clifl.getCliCode()));
        if (code == 0) {
            throw new ApplicationException(SystemCode.REQUEST_PARAMETER_FAILURE.getCode(), "cliCode error![cliCode:{}]", clifl.getCliCode());
        }

        return success(clifl);
    }

    /**
     * Doc Type and File info query.
     * 
     * @param clafl
     * @param session
     * @return
     * @throws Exception
     * @throws ApplicationException
     */
    @ResponseBody
    @RequestMapping(value = "clientDownload.json")
    public void clientDownload(@RequestParam String cliLnameFrom, @RequestParam String cliLnameTo, @RequestParam String cliType, @RequestParam boolean online,
            final HttpServletResponse response, HttpSession session) throws Exception {
        Stafl stafl = SessionManager.getUser(session);
        yusrgrpsecuService.authority(stafl.getStaUser(), ConstantContext.AUTHORITY_TYPE_PRINT);

        Clifl clifl = new Clifl();
        clifl.setCliLnameFrom(cliLnameFrom);
        clifl.setCliLnameTo(cliLnameTo);
        clifl.setCliType(cliType);

        /**
         * 1.查询当前页数据
         */
        clifl.setCliLnameFrom(clifl.getCliLnameFrom().toUpperCase());
        clifl.setCliLnameTo(clifl.getCliLnameTo().toUpperCase());
        List<Clifl> list = cliflService.getReportList(clifl);

        /**
         * 2.生成本地report文件
         */
        String fileName = "client.pdf";
        byte[] fileBody = ClientReportUtil.getReport(list);
        if (fileBody == null) {
            return;
        }

        /**
         * 3.前端下载或预览
         */
        OutputStream outputStream = null;
        try {
            if (list != null) {
                fileName = URLEncoder.encode(fileName, "UTF-8");
                response.reset();
                if (online) {
                    String[] names = fileName.split("\\.");
                    response.setContentType(names[names.length - 1]);
                    response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
                } else {
                    response.addHeader("Content-Length", "" + fileBody.length);
                    response.setContentType("application/octet-stream;charset=UTF-8");
                    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
                }
                outputStream = new BufferedOutputStream(response.getOutputStream());
                outputStream.write(fileBody);
            }
        } finally {
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
        }
    }

    /**
     * Client Type query list
     * 
     * @param clifl
     * @param session
     * @return
     * @throws ApplicationException
     */
    @ResponseBody
    @RequestMapping(value = "getClientType.json")
    public Object getClientType(HttpSession session) throws ApplicationException {
        return success(cleflService.getDataBy(Criteria.newCriteria().addWhere(Clefl.DBStrCleBeused, "Y").addAscOrder(Clefl.DBStrCleName)));
    }

    /**
     * (Attentions) query list
     * 
     * @param clifl
     * @param session
     * @return
     * @throws ApplicationException
     */
    @ResponseBody
    @RequestMapping(value = "getAttentions.json")
    public Object getAttentions(@RequestParam String cliCode, HttpSession session) throws ApplicationException {
        return success(claflService.getDataBy(Clafl.DBStrClaCode, cliCode));
    }

    /**
     * (Attentions) query attention Info.
     * 
     * @param clafl
     * @param session
     * @return
     * @throws ApplicationException
     */
    @ResponseBody
    @RequestMapping(value = "getAttentionInfo.json")
    public Object getAttentionInfo(@RequestBody Clafl clafl, HttpSession session) throws ApplicationException {
        Assert.notNull(clafl, "The request parameter cannot be empty");
        Assert.hasLength(clafl.getClaCode(), "claCode cannot be empty");
        Assert.hasLength(clafl.getClaItem(), "claItem cannot be empty");
        return success(claflService
                .getOneBy(Criteria.newCriteria().addWhere(Clafl.DBStrClaCode, clafl.getClaCode()).addWhere(Clafl.DBStrClaItem, clafl.getClaItem())));
    }

    /**
     * (Attentions) add or update.
     * 
     * @param clafl
     * @param session
     * @return
     * @throws ApplicationException
     */
    @ResponseBody
    @RequestMapping(value = "addOrUpdateClafl.json")
    public Object addOrUpdateClafl(@RequestBody Clafl clafl, HttpSession session) throws ApplicationException {
        Assert.notNull(clafl, "The request parameter cannot be empty");
        Assert.hasLength(clafl.getClaCode(), "claCode cannot be empty");
        Stafl stafl = SessionManager.getUser(session);
        clafl.setClaAdate(new Date());
        clafl.setClaAuser(stafl.getStaUser());
        if (StringUtils.isNotBlank(clafl.getClaItem())) {
            claflService.updateBy(clafl,
                    Criteria.newCriteria().addWhere(Clafl.DBStrClaCode, clafl.getClaCode()).addWhere(Clafl.DBStrClaItem, clafl.getClaItem()));
        } else {
            // String claItem =
            // claflService.getMaxBy(Criteria.newCriteria().addWhere(Clafl.DBStrClaCode,
            // clafl.getClaCode()).setMaxField(Clafl.DBStrClaItem));
            // if (StringUtils.isBlank(claItem)) {
            // claItem = "001";
            // }
            // clafl.setClaItem(PrimaryKeyUtils.addOne(claItem));
            clafl.setClaCuser(stafl.getStaUser());
            clafl.setClaCdate(new Date());
            clafl.setClaLock(-999L);
            claflService.insert(clafl);
        }

        return success(clafl);
    }

    /**
     * (Statistics code) query
     * 
     * @param clifl
     * @param session
     * @return
     * @throws ApplicationException
     */
    @ResponseBody
    @RequestMapping(value = "getStatisticsCode.json")
    public Object getStatisticsCode(@RequestParam String cliCode, HttpSession session) throws ApplicationException {
        return success(k3uflService.getDataBy(K3ufl.DBStrK3uCliCode, cliCode));
    }

    /**
     * (Statistics code) batch add or update.
     * 
     * @param clafl
     * @param session
     * @return
     * @throws ApplicationException
     */
    @ResponseBody
    @RequestMapping(value = "batchK3ufl.json")
    public Object batchK3ufl(@RequestBody List<K3ufl> list, HttpSession session) throws ApplicationException {
        Stafl stafl = SessionManager.getUser(session);
        k3uflService.batch(list, stafl);

        return success();
    }

    /**
     * (Insured U/W Inquiry) query
     * 
     * @param cliCode
     * @param session
     * @return
     * @throws ApplicationException
     */
    @ResponseBody
    @RequestMapping(value = "getInsuredUWInquiry.json")
    public Object getInsuredUWInquiry(@RequestParam String cliCode, HttpSession session) throws ApplicationException {
        return success(polflService.getDataBy(Polfl.DBStrPolIsr, cliCode));
    }

    /**
     * (Status History) query
     * 
     * @param cliCode
     * @param session
     * @return
     * @throws ApplicationException
     */
    @ResponseBody
    @RequestMapping(value = "getStatusHistory.json")
    public Object getStatusHistory(@RequestParam String cliCode, HttpSession session) throws ApplicationException {
        return success(cllflService.getDataBy(Cllfl.DBStrCllCode, cliCode));
    }

    /**
     * Doc Type and File info query.
     * 
     * @param clafl
     * @param session
     * @return
     * @throws ApplicationException
     */
    @ResponseBody
    @RequestMapping(value = "getTchfl.json")
    public Object getTchfl(HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        result.put("docType", tchflService.getDataBy(Criteria.newCriteria().addWhere(Tchfl.DBStrTchId, "efs_doc").addAscOrder(Tchfl.DBStrTchDspval)));
        result.put("fileInfo", tchflService.getOneBy(Criteria.newCriteria().addWhere(Tchfl.DBStrTchId, "efs_size")));
        return success(result);
    }

    /**
     * Doc Type and File info query.
     * 
     * @param clafl
     * @param session
     * @return
     * @throws Exception
     * @throws ApplicationException
     */
    @ResponseBody
    @RequestMapping(value = "EFS/download.json")
    public void downloadEFS(@RequestParam String cliCode, @RequestParam String imgSeqno, @RequestParam boolean online, final HttpServletResponse response)
            throws Exception {
        Imgfl imgfl = imgflService.getOneBy(Criteria.newCriteria().addWhere(Imgfl.DBStrImgClicode, cliCode).addWhere(Imgfl.DBStrImgSeqno, imgSeqno));
        if (imgfl == null) {
            throw new ApplicationException(SystemCode.REQUEST_PARAMETER_FAILURE.getCode(), "cliCode and imgSeqno error![cliCode:{},imgSeqno:{}]", cliCode,
                    imgSeqno);
        }
        OutputStream outputStream = null;
        try {
            if (imgfl.getImgFileName() != null) {
                String fileName = imgfl.getImgFileName().toString();
                fileName = URLEncoder.encode(fileName, "UTF-8");
                response.reset();
                if (online) {
                    String[] names = fileName.split("\\.");
                    response.setContentType(names[names.length - 1]);
                    response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
                } else {
                    response.addHeader("Content-Length", "" + imgfl.getImgFileBlob().length);
                    response.setContentType("application/octet-stream;charset=UTF-8");
                    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
                }
                outputStream = new BufferedOutputStream(response.getOutputStream());
                outputStream.write(imgfl.getImgFileBlob());
            }
        } finally {
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
        }
    }

    /**
     * EFS query
     * 
     * @param clifl
     * @param session
     * @return
     * @throws ApplicationException
     */
    @ResponseBody
    @RequestMapping(value = "getEFSList.json")
    public Object getEFSList(@RequestParam String cliCode, HttpSession session) throws ApplicationException {
        List<Imgfl> list = imgflService.getDataBy(Imgfl.DBStrImgClicode, cliCode);
        for (Imgfl imgfl : list) {
            if (imgfl.getImgFileBlob() != null) {
                imgfl.setImgFileBase64(FileUtil.bytes2Base64(imgfl.getImgFileBlob()));
            }
            imgfl.setImgFile(null);
            imgfl.setImgFileBlob(null);
        }
        return success(list);
    }

    /**
     * EFS batch add or update.
     * 
     * @param clafl
     * @param session
     * @return
     * @throws ApplicationException
     */
    @ResponseBody
    @RequestMapping(value = "batchEFS.json")
    public Object batchEFS(@RequestBody List<Imgfl> imgflList, HttpSession session) throws Exception {
        Stafl stafl = SessionManager.getUser(session);
        imgflService.batch(imgflList, stafl);

        return success();
    }

    /**
     * Report Statistics query
     * 
     * @param startYear
     * @param endYear
     * @param session
     * @return
     * @throws ApplicationException
     */
    @ResponseBody
    @RequestMapping(value = "getReportStatistics.json")
    public Object getReportStatistics(@RequestParam int startYear, @RequestParam int endYear, HttpSession session) {
        return success(secflService.getReportStatistics(startYear, endYear));
    }

}
