package ${basePackage}.${daoPackage};
import org.springframework.stereotype.Repository;

import ${baseDaoPackage}.BaseMapperImpl;
import ${basePackage}.${entityPackage}.${className};

@Repository("${className?uncap_first}Dao")
public class ${className}Mapper extends BaseMapperImpl<${className}, ${pkJavaType}> {
}
