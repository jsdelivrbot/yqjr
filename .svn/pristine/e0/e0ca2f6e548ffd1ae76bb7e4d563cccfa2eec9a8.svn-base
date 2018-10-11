package com.yqjr.fin.qcms.credit.entity;

import com.ritoinfo.framework.evo.sp.base.starter.entity.BaseMapperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "country", catalog = "evo_demo")
public class Country extends BaseMapperEntity<Long> {
	@Id
	@KeySql(useGeneratedKeys = true) // MySql Auto +1
	/*@KeySql(sql = "select SEQ_COUNTRY.nextval from dual", order = ORDER.BEFORE) // Oracle */
	private Long id;
	private String code;
	private String name;

	@Override
	public Long getId() {
		return null;
	}

	@Override
	public void setId(Long id) {

	}

}
