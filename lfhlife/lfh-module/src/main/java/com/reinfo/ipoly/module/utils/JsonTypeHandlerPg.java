package com.reinfo.ipoly.module.utils;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.codehaus.jackson.map.ObjectMapper;
import org.postgresql.util.PGobject;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yl1794 on 2018/8/21. 版权声明：本文为CSDN博主「Mr_EvanChen」的原创文章，遵循 CC 4.0
 * BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/Mr_EvanChen/article/details/81986791
 */
@MappedTypes(Object.class)
public class JsonTypeHandlerPg extends BaseTypeHandler<Object> {	

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType)
			throws SQLException {
		PGobject jsonObject = new PGobject();
		jsonObject.setType("json");
		try {
			jsonObject.setValue(new ObjectMapper().writeValueAsString(parameter)); // java对象转化成json字符串
		} catch (IOException e) {
			e.printStackTrace();
		}
		ps.setObject(i, jsonObject);
	}

	@Override
	public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return rs.getString(columnName); // 返回String
	}

	@Override
	public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return rs.getString(columnIndex);
	}

	@Override
	public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return cs.getString(columnIndex);
	}

}
