package ${basePackage}.${entityPackage};
import java.io.Serializable;

public class ${className} implements Serializable, Cloneable {
  <#list table.columns as column>
	private ${column.simpleJavaType} ${column.javaProperty?uncap_first};
  </#list>

	<#list table.columns as column>
	public void set${column.javaProperty?cap_first}(${column.simpleJavaType} ${column.javaProperty?uncap_first}) {
		this.${column.javaProperty?uncap_first} = ${column.javaProperty?uncap_first};
	}
	public ${column.simpleJavaType} get${column.javaProperty?cap_first}() {
		return ${column.javaProperty?uncap_first};
	}
	</#list>
  
	private static final String Table = "${table.sqlName}";
	private static final String Alias = "${table_alias_prefix}${table.sqlName}";
	private static final long serialVersionUID = 16454654984465L;
 
  <#list table.columns as column>
	public static final String DBStr${column.javaProperty?cap_first} = Alias+".${column.sqlName}";
  </#list>
	
	@Override
	public ${className} clone() {
		${className} o = null;
		try{
			o = (${className})super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return o;
	}
}

	