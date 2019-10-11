package com.reinfo.ipoly.module.mappers;

import com.reinfo.ipoly.module.models.IlfQuotPlan;
import com.reinfo.ipoly.module.models.ProdCovLine;
import com.reinfo.ipoly.module.models.ProdCovTab;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/***
 * SpringBoot 热加载、基本計劃
 * @author Jerry
 *
 */
@Mapper
public interface ProdCovInitMapper {


	// ---  基本計劃(code对应名称，带条件，=N属于基本类别，=Y属于定期、危疾)
	@Select("select cov_line_code as covLineCode,cov_line_name as covLineName from prod_cov_line where cov_term_rider_ind=#{riderind}")
	List<ProdCovLine> covLineList(@Param("riderind") String riderind);


	//---  附加的等额定期、危机       跟據 cov_code_disp 取值 cov_code
	@Select("select cov_code as covCode,cov_code_disp as covCodeDisp from prod_cov_tab where cov_code_disp=#{cov_code_disp} ")
	ProdCovTab  covTabList(String cov_code_disp);

	/*等額定期/危疾*/
	@Select("SELECT  product_line,p1.quplan_plan_code as quplanPlanCode,p1.quplan_rider_code as quplanRiderCode, p1.quplan_rider_class as quplanRiderClass  ,p1.quplan_rider_class_desc as  quplanRiderClassDesc, p1.quplan_rider_code_desc as quplanRiderCodeDesc,p1.quplan_sum_insured as quplanSumInsured,p1.quplan_ann_premium as quplanAnnPremium   FROM ilf_quot_plan p1,prod_cov_tab p2  where quplan_no=#{quplanNo} and quplan_plan_code=#{quplanPlanCode} and quplan_rider_code=cov_code and product_line in ('LTR','DD')")
	List<IlfQuotPlan>  getIlfQuotPlanDQ(@Param("quplanNo") String quplanNo, @Param("quplanPlanCode") String quplanPlanCode);

	/*基本*/
	@Select("SELECT  product_line,p1.quplan_plan_code as quplanPlanCode,p1.quplan_rider_code as quplanRiderCode, p1.quplan_rider_class as quplanRiderClass  ,p1.quplan_rider_class_desc as  quplanRiderClassDesc, p1.quplan_rider_code_desc as quplanRiderCodeDesc,p1.quplan_sum_insured as quplanSumInsured,p1.quplan_ann_premium as quplanAnnPremium   FROM ilf_quot_plan p1,prod_cov_tab p2  where quplan_no=#{quplanNo} and quplan_plan_code=#{quplanPlanCode} and quplan_rider_code=cov_code and product_line  not in ('LTR','DD','WP')")
	List<IlfQuotPlan>  getIlfQuotPlanJB(@Param("quplanNo") String quplanNo, @Param("quplanPlanCode") String quplanPlanCode);

	/*豁免*/
	@Select("SELECT  product_line,p1.quplan_plan_code as quplanPlanCode,p1.quplan_rider_code as quplanRiderCode, p1.quplan_rider_class as quplanRiderClass  ,p1.quplan_rider_class_desc as  quplanRiderClassDesc, p1.quplan_rider_code_desc as quplanRiderCodeDesc,p1.quplan_sum_insured as quplanSumInsured,p1.quplan_ann_premium as quplanAnnPremium   FROM ilf_quot_plan p1,prod_cov_tab p2  where quplan_no=#{quplanNo} and quplan_plan_code=#{quplanPlanCode} and quplan_rider_code=cov_code and product_line    in (#{product_line})")
	List<IlfQuotPlan>  getIlfQuotPlanhm(@Param("quplanNo") String quplanNo, @Param("quplanPlanCode") String quplanPlanCode, @Param("product_line") String product_line);

	@Select("select product_line as productLine ,plan_ind as planInd ,sum_ind as sumInd  from  prod_cov_tab where   cov_code=#{cov_code}")
	ProdCovTab getProductLine(@Param("cov_code") String cov_code);




}
