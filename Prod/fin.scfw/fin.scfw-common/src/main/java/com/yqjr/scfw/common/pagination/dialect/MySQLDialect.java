package com.yqjr.scfw.common.pagination.dialect;

import com.yqjr.scfw.common.pagination.model.PageBounds;
import org.apache.ibatis.mapping.MappedStatement;

/**
 * @author quangz
 */
public class MySQLDialect extends Dialect{

    public MySQLDialect(MappedStatement mappedStatement, Object parameterObject, PageBounds pageBounds) {
        super(mappedStatement, parameterObject, pageBounds);
    }
    
	@Override
    protected String getLimitString(String sql, String offsetName, int offset, String limitName, int limit) {
        StringBuilder buffer = new StringBuilder( sql.length()+20 ).append(sql);
        if (offset > 0) {
            buffer.append(" limit ?, ?");
            setPageParameter(offsetName, offset, Integer.class);
            setPageParameter(limitName, limit, Integer.class);
        } else {
            buffer.append(" limit ?");
            setPageParameter(limitName, limit, Integer.class);
        }
        return buffer.toString();
	}   
  
}
