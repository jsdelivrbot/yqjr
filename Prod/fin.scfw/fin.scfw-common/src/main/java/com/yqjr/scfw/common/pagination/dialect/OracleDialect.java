package com.yqjr.scfw.common.pagination.dialect;

import com.yqjr.scfw.common.pagination.model.PageBounds;
import org.apache.ibatis.mapping.MappedStatement;

/**
 * @author quangz
 */
public class OracleDialect extends Dialect{

    public OracleDialect(MappedStatement mappedStatement, Object parameterObject, PageBounds pageBounds) {
        super(mappedStatement, parameterObject, pageBounds);
    }

    @Override
	protected String getLimitString(String sql, String offsetName, int offset, String limitName, int limit) {
		sql = sql.trim();
		boolean isForUpdate = false;
		if ( sql.toLowerCase().endsWith(" for update") ) {
			sql = sql.substring( 0, sql.length()-11 );
			isForUpdate = true;
		}
		
		StringBuilder pagingSelect = new StringBuilder( sql.length()+100 );
		if (offset > 0) {
			pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");
		}
		else {
			pagingSelect.append("select * from ( ");
		}
		pagingSelect.append(sql);
		if (offset > 0) {
			pagingSelect.append(" ) row_ ) where rownum_ <= ? and rownum_ > ?");
            setPageParameter("__offsetEnd",offset+limit,Integer.class);
            setPageParameter(offsetName,offset,Integer.class);
		}
		else {
			pagingSelect.append(" ) where rownum <= ?");
            setPageParameter(limitName,limit,Integer.class);
		}

		if ( isForUpdate ) {
			pagingSelect.append( " for update" );
		}
		
		return pagingSelect.toString();
	}

}
