package com.yqjr.fin.pvc.core.rest;

import com.ritoinfo.framework.evo.sp.base.model.ServiceResponse;
import com.ritoinfo.framework.evo.sp.base.starter.rest.BaseRest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yqjr.fin.pvc.core.dto.TempTabale1Dto;
import com.yqjr.fin.pvc.core.bizz.TempTabale1Bizz;

import java.util.List;


@Slf4j
@RestController
@RequestMapping(value = "/tempTabale1s")

public class TempTabale1Rest extends BaseRest<TempTabale1Bizz, Long,TempTabale1Dto> {

    @GetMapping("/idtest/{id}")
    public ServiceResponse<TempTabale1Dto> getTestId(@PathVariable Long id) {

        TempTabale1Dto ttt = bizz.getTestId(id);

        return ServiceResponse.ok(ttt);
    }

    @GetMapping("/idtest1/{id}")
    public String  test(@PathVariable Long id) {
        //test
        return "hey "+id;


    }

}