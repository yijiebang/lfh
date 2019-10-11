package com.reinfo.ipoly.module.controllers;

import com.reinfo.ipoly.module.utils.ProdUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.reinfo.ipoly.common.config.SystemCode;
import com.reinfo.ipoly.common.exception.ApplicationException;
import com.reinfo.ipoly.module.base.controllers.BaseWebController;
import com.reinfo.ipoly.module.models.Calculation;
import com.reinfo.ipoly.module.models.ProdCovLim;
import com.reinfo.ipoly.module.models.ProdPremLimt;
import com.reinfo.ipoly.module.services.ProdCovLimService;
import com.reinfo.ipoly.module.services.ProdPremLimtService;

@RestController
@RequestMapping(value = "calculation")
public class CalculationController extends BaseWebController {

    @Autowired
    ProdCovLimService prodCovLimService;

    @Autowired
    ProdPremLimtService prodPremLimtService;

    @ResponseBody
    @RequestMapping(value = "insuredamount.json")
    public Map<String, Object> insuredAmount(@RequestBody List<Calculation> calculationList) throws ApplicationException {

        List<String> buffer = new ArrayList<String>();//存放錯誤信息
        int code = 1000;

        for (Calculation cal : calculationList) {

            ProdCovLim covprod = new ProdCovLim();
            covprod.setGroups(cal.getPlan());
            covprod.setCcy(cal.getCcy());
            ProdCovLim cov = prodCovLimService.getOne(covprod);

            if (cal.getAmount() != null) {
                if (cov != null) {
                    if (cov.getMinSumIns() != null) {
                        if (cov.getMinSumIns().doubleValue() > cal.getAmount().doubleValue()) {//當前保額小於數據庫查詢的最小金額，那麽報錯
                            buffer.add(cal.getPlanDesc() + " - 最低投保額 : " + cal.getCcy() + "$" + ProdUtil.formatDECIMAL(cov.getMinSumIns().intValue()));
                            code = 1001;
                        }
                    }
                    if (cov.getMaxSumIns() != null) {
                        if (cov.getMaxSumIns().doubleValue() < cal.getAmount().doubleValue()) {
                            buffer.add(cal.getPlanDesc() + " - 最高投保額 : " + cal.getCcy() + "$" + ProdUtil.formatDECIMAL(cov.getMaxSumIns().intValue()));
                            code = 1001;
                        }
                    }
                }else{
                    System.out.println(cal.getPlanDesc());
                }
            } else {
                throw new ApplicationException(SystemCode.AMOUNT_INSURED_IS_EMPTY.getCode(), SystemCode.AMOUNT_INSURED_IS_EMPTY.getMessage(), "");
            }
        }
        ;

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("amount", 0);
        body.put("desc", buffer);
        return this.success("", body, code);
    }

    @ResponseBody
    @RequestMapping(value = "premiumamount.json")
    public Map<String, Object> premiumAmount(@RequestBody Calculation cal) throws ApplicationException {
        ProdPremLimt preprod = new ProdPremLimt();
        preprod.setCovCode(cal.getCode());
        preprod.setPayMode(cal.getMode());
        preprod.setCcy(cal.getCcy());
        ProdPremLimt pre = prodPremLimtService.getOne(preprod);

        int num = 0;
        int code = 1000;
        String message = "";
        if (pre != null) {
            if (pre.getMinPolPrem() != null) {
                if (pre.getMinPolPrem().doubleValue() > cal.getAmount().doubleValue()) {
                    num = (int) pre.getMinPolPrem().doubleValue();
                    code = SystemCode.AMOUNT_PREMIUM_MIN_NOTGT.getCode();
                    message = "Amount Premium can't less than " + num;
                }
            }
            if (pre.getMaxPolPrem() != null) {
                if (pre.getMaxPolPrem().doubleValue() < cal.getAmount().doubleValue()) {
                    num = (int) pre.getMaxPolPrem().doubleValue();
                    code = SystemCode.AMOUNT_PREMIUM_MAX_NOTGT.getCode();
                    message = "Amount Premium can't greater than " + num;
                }
            }
        } else {
          //  code = SystemCode.NO_DATA.getCode();
            message = "query no data. ";
        }
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("amount", num);
        return this.success(message, body, code);
    }


}
