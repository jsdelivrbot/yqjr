package com.yqjr.fin.cvc.core.dto;

import com.ritoinfo.framework.evo.sp.base.starter.validate.group.CreateGroup;
import com.ritoinfo.framework.evo.sp.base.starter.validate.group.UpdateGroup;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ToString
public class TKInsuranceCorpDto {

    @NotNull(groups=UpdateGroup.class)
    private Long id;

    /**
     * 保险公司名称
     */
    @Size(min = 0, max = 200,groups=CreateGroup.class)
    private String name;
}
