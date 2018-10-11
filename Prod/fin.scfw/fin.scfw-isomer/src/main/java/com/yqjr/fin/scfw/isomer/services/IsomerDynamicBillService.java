package com.yqjr.fin.scfw.isomer.services;

import com.yqjr.fin.scfw.isomer.api.request.BillStatusModel;
import com.yqjr.fin.scfw.isomer.api.request.DynamicBillRequestModel;
import com.yqjr.fin.scfw.isomer.api.request.FyafDynamicBillDetailModel;
import com.yqjr.fin.scfw.isomer.api.request.FyzlDynamicBillDetailModel;
import com.yqjr.fin.scfw.isomer.common.BeanUtil;
import com.yqjr.fin.scfw.isomer.condition.IsomerDynamicBillCondition;
import com.yqjr.fin.scfw.isomer.entity.IsomerDynamicBill;
import com.yqjr.fin.scfw.isomer.mapper.IsomerDynamicBillMapper;
import com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.fyafdynamicbillservice.FyafDynamicBillDetailVO;
import com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.fyafdynamicbillservice.FyafDynamicBillMainVO;
import com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.fyzldynamicbillservice.FyzlDynamicBillDetailVO;
import com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.fyzldynamicbillservice.FyzlDynamicBillMainVO;
import com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.selectbillcreatestatusimpl.BillStatusVO;
import com.yqjr.fin.scfw.isomer.services.cxf.gx.custom.selectbillcreatestatusimpl.RequestCommon;
import com.yqjr.scfw.common.service.BaseService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class IsomerDynamicBillService extends BaseService<IsomerDynamicBillMapper, IsomerDynamicBill, Long> {

    @Autowired
    IsomerDynamicBillMapper isomerDynamicBillMapper;

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 通过类型获取调用共享的url
     */
    public String getUrl(String type){
        logger.info("start type = " + type);
        String requestUrl = "";
        IsomerDynamicBillCondition isomerDynamicBill = new IsomerDynamicBillCondition();
        isomerDynamicBill.setType(type);
        List<IsomerDynamicBill> list = isomerDynamicBillMapper.select(isomerDynamicBill);
        if(null != list && list.size()>0){
            requestUrl = list.get(0).getRequestUrl();
        }
        logger.info("end url = " + requestUrl);
        return  requestUrl;
    }

    /**
     * 将异构定义的汽车金融主数据转换成对应的共享平台需要的model
     */
    public FyafDynamicBillMainVO getFyafMainVo(DynamicBillRequestModel requestModel){
        FyafDynamicBillMainVO fyafDynamicBillMainVO = new FyafDynamicBillMainVO();
        BeanUtil.copyProperties(fyafDynamicBillMainVO,requestModel.getFyafDynamicBillMain());
        return  fyafDynamicBillMainVO;
    }


    /**
     * 将异构定义的汽车金融详细数据转换成对应的共享平台需要的model
     */
    public FyzlDynamicBillMainVO getFyzlMainVo(DynamicBillRequestModel requestModel){
        FyzlDynamicBillMainVO fyzlDynamicBillMainVO = new FyzlDynamicBillMainVO();
        BeanUtil.copyProperties(fyzlDynamicBillMainVO,requestModel.getFyzlDynamicBillMain());
        return  fyzlDynamicBillMainVO;
    }

    /**
     * 将异构定义的租赁公司主数据转换成对应的共享平台需要的model
     */
    public List<FyafDynamicBillDetailVO> getFyafDetailVoList(DynamicBillRequestModel requestModel){
        List<FyafDynamicBillDetailVO> paramList = new ArrayList<>();
        FyafDynamicBillDetailVO fyafDynamicBillDetailVO = new FyafDynamicBillDetailVO();
        List<FyafDynamicBillDetailModel> detailModels = requestModel.getFyafdetailList();
        if (null != detailModels && detailModels.size() > 0) {
            BeanUtil.copyProperties(fyafDynamicBillDetailVO, detailModels.get(0));
            paramList.add(fyafDynamicBillDetailVO);
        }
        return paramList;
    }

    /**
     * 将异构定义的租赁公司详细数据转换成对应的共享平台需要的
     */
    public List<FyzlDynamicBillDetailVO> getFyzlDetailVoList(DynamicBillRequestModel requestModel){
        List<FyzlDynamicBillDetailVO> paramList = new ArrayList<>();
        FyzlDynamicBillDetailVO fyzlDynamicBillDetailVO = new FyzlDynamicBillDetailVO();
        List<FyzlDynamicBillDetailModel> detailModels = requestModel.getFyzldetailList();
        if (null != detailModels && detailModels.size() > 0) {
            BeanUtil.copyProperties(fyzlDynamicBillDetailVO, detailModels.get(0));
            paramList.add(fyzlDynamicBillDetailVO);
        }
        return paramList;
    }

    /**
     * 将异构定义的租赁公司状态查询公共请求数据转换成对应的共享平台需要的model
     */
    public RequestCommon getBillStatusRequest(DynamicBillRequestModel requestModel){
        RequestCommon requestCommon = new RequestCommon();
        BeanUtil.copyProperties(requestCommon,requestModel.getBillStatusReuqest());
        return requestCommon;
    }

    /**
     * 将异构定义的租赁公司状态查询数据转换成对应的共享平台需要的model
     */
    public List<BillStatusVO> getBillStatusVoList(DynamicBillRequestModel requestModel){
        List<BillStatusVO> paramList = new ArrayList<>();
        BillStatusVO billStatusVO = new BillStatusVO();
        List<BillStatusModel> detailModels = requestModel.getBillStatusList();
        if (null != detailModels && detailModels.size() > 0) {
            BeanUtil.copyProperties(billStatusVO, detailModels.get(0));
            paramList.add(billStatusVO);
        }
        return paramList;
    }


}
