alter table prod_cov_tab add product_type varchar(100);
update prod_cov_tab set product_type='BASIC_PLAN' where plan_ind='B';
update prod_cov_tab set product_type='LEVEL_TERM' where plan_ind='R' and product_line='LTR';
update prod_cov_tab set product_type='ACCIDENTAL_DEATH_AND_DISMEMBERMENT_PROTECTION_PLAN' where plan_ind='R' and cov_code='AD';
update prod_cov_tab set product_type='ACCIDENTAL_DEATH_BENEFIT' where plan_ind='R' and cov_code='ADB';
update prod_cov_tab set product_type='ACCIDENTAL_INDEMNITY_PROTECTION_PLAN' where plan_ind='R' and cov_code='AI';
update prod_cov_tab set product_type='DREAD_DISEASE_COVERAGE' where plan_ind='R' and product_line='DD';
update prod_cov_tab set product_type='HOSPITAL_INCOME_BENEFIT' where plan_ind='R' and product_line='HI';
update prod_cov_tab set product_type='HOSPITAL_INCOME_BENEFIT' where plan_ind='R' and product_line='HI';
update prod_cov_tab set product_type='HOSPITAL_AND_SURGICAL_BENEFIT' where plan_ind='R' and product_line='HS';
update prod_cov_tab set product_type='PAYER_BENEFIT' where plan_ind='R' and product_line='PB';
update prod_cov_tab set product_type='BASIC_PLAN_WAIVER_OF_PREMIUM' where plan_ind='R' and cov_code like 'W%' and cov_code not like 'WT%';
update prod_cov_tab set product_type='LEVEL_TERM_WAIVER_OF_PREMIUM' where plan_ind='R' and cov_code like 'WT%';
update prod_cov_tab set product_type='FREE_LEVEL_TERM' where plan_ind='R' and cov_code like '%TF%';

--sort 20190930 andy
alter table ilf_quplan_plan add quplan_seqno int;
alter table prod_cov_line add cov_term_rider_ind varchar(1);
alter table ilf_quot add quot_status varchar(1);
alter table ilf_quot alter column quot_years type varchar(200);

--Annie
update prod_cov_tab set product_line ='JEND' where cov_code_disp ='JEND'; --product_line ='ENDJ'
update prod_cov_tab set product_line ='LM10' where cov_code_disp ='LM10'; --product_line ='LM'
update prod_cov_tab set product_line ='WLDD' where cov_code_disp ='WLDD'; --product_line ='WLP'
update prod_cov_tab set product_line ='LTS' where cov_code_disp like '%LTS%'; --product_line ='LTBS'
update prod_cov_line set cov_line_code ='MSH' where cov_line_code = 'SMSH'; 
update prod_cov_line set cov_line_code ='MSD' where cov_line_code = 'SMSD'; 
update prod_cov_tab set product_line ='MSD' where cov_code_disp like '4D%S' and product_line ='MSH'; --product_line ='MSD'

--other
update prod_cov_line set cov_line_code ='MSF' where cov_line_code = 'SMSF'; 
----==execute all on 2019/10/09====-----------------