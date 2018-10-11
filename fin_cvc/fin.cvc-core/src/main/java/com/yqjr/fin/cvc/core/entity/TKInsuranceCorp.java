package com.yqjr.fin.cvc.core.entity;

import com.ritoinfo.framework.evo.sp.base.starter.entity.BaseMapperEntity;
import lombok.Data;
import lombok.ToString;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@ToString
@Table(name = "pd_insurancecorp")
public class TKInsuranceCorp extends BaseMapperEntity<Long> {

    @Id
    @KeySql(sql = "select SEQ_pd_insurancecorp.nextval from dual", order = ORDER.BEFORE)
    private Long id;

    private String name;



}
