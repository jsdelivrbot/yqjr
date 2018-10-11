package com.yqjr.fin.scfw.isomer.common;

import com.yqjr.fin.scfw.isomer.api.response.ResponseModel;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * 发送接口类
 * Created by THINK on 2018/6/8.
 */
public interface BaseCommand {

    /**
     * 调用CXF接口
     * @return
     */
    public ResponseModel commandToOuterCxf(T t ,List<T> list);

    /**
     * 调用HTTP接口
     * @return
     */
    public String commandToOuteHttp();

    /**
     * 调用Rest接口
     * @return
     */
    public String commandToOuteRest();
}
