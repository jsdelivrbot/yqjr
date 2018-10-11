package com.yqjr.fin.mkmm.sales.services;

import com.yqjr.fin.mkmm.sales.common.BeanUtil;
import com.yqjr.fin.mkmm.sales.condition.DealerAreaCondition;
import com.yqjr.fin.mkmm.sales.condition.DealerBrandsCondition;
import com.yqjr.fin.mkmm.sales.rest.vo.*;
import com.yqjr.fin.mkmm.sales.rest.vo.DealerAreaVo;
import com.yqjr.fin.mkmm.sales.condition.DealerAreaCondition;
import com.yqjr.fin.mkmm.sales.rest.vo.DealerAreaVo;
import com.yqjr.fin.mkmm.sales.rest.vo.SelectMenuVo;
import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.mkmm.sales.entity.DealerArea;
import com.yqjr.fin.mkmm.sales.mapper.DealerAreaMapper;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class DealerAreaService extends BaseService<DealerAreaMapper, DealerArea, Long> {

    @Autowired
    DealerAreaMapper dealerAreaMapper;
    /**
     * 将查询到的业务存入对应的表中
     */
    @Transactional(rollbackFor = {Exception.class})
    public void traverseInformation(){
        List<DealerAreaVo> dealerAreaVos =  dealerAreaMapper.traverseInformation();
        DealerAreaVo dealerAreaVo = null;
        DealerArea dealerArea = new DealerArea();
        for(int i=0;i<dealerAreaVos.size();i++){
            dealerAreaVo = dealerAreaVos.get(i);
            BeanUtil.copyProperties(dealerArea,dealerAreaVo);
            this.insert(dealerArea);
        }
    }

    /**
     * 清除全部数据
     */
    @Transactional(rollbackFor = {Exception.class})
    public void cleanTable(){
        dealerAreaMapper.deleteAll();
    }

    /**
     * 取得区域经销商树结构数据
     * @return
     */
    public List<SelectMenuVo> selectTreeMsg(){
        UserContext userContext = SessionHolder.getUserContext();
        String company = userContext.getComCode();
        //查询区域信息
        List<AreaMsgVo> areaMsgVos = dealerAreaMapper.selectAreaMsg(company);
        for(int i=0;i<areaMsgVos.size();i++){
            areaMsgVos.get(i).setId(i+"");
        }
//        //区域经销商树
        List<SelectMenuVo> selectMenuVos = selectDealerArea(areaMsgVos);
        return selectMenuVos;
    }

    /**
     * 区域经销商信息树
     * @param areaMsgVos
     * @return
     */
    public List<SelectMenuVo> selectDealerArea(List<AreaMsgVo> areaMsgVos){
        UserContext userContext = SessionHolder.getUserContext();
        String company = userContext.getComCode();
        DealerAreaCondition dealerAreaCondition = new DealerAreaCondition();
        AreaMsgVo areaMsgVo = null;
        List<SelectMenuVo> selectMenuVos1 = new ArrayList<SelectMenuVo>();
        for(int i=0;i<areaMsgVos.size();i++){
            SelectMenuVo selectMenuVo = new SelectMenuVo();
            areaMsgVo = areaMsgVos.get(i);
            dealerAreaCondition.setCompany(company);
            dealerAreaCondition.setAreaCode(areaMsgVo.getValueI());
            List<DealerArea> dealerAreas = this.selectList(dealerAreaCondition);
            //存储经销商信息对象
            //存储经销商信息集合
            List<SelectMenuVo> selectMenuVos = new ArrayList<SelectMenuVo>();
            for(int j=0;j<dealerAreas.size();j++){
                SelectMenuVo selectMenuVo1 = new SelectMenuVo();
                //经销商与区域信息
                selectMenuVo1.setValue(dealerAreas.get(j).getDealerCode());
                selectMenuVo1.setTitle(dealerAreas.get(j).getDealerName());
                selectMenuVo1.setId(areaMsgVo.getId());
                selectMenuVos.add(selectMenuVo1);
            }
            selectMenuVo.setId(areaMsgVo.getId());
            selectMenuVo.setValue(areaMsgVo.getValueI());
            selectMenuVo.setTitle(areaMsgVo.getTitle());
            selectMenuVo.setChildren(selectMenuVos);
            selectMenuVos1.add(selectMenuVo);
        }
        return selectMenuVos1;
    }


    /**
     * 物料出库查询经销商
     */
    @Transactional
    public List<SelectMenuVo> selectDealerTree() {
        UserContext userContext = SessionHolder.getUserContext();
        String areaCode = userContext.getAreaCode();
        String company = userContext.getComCode();
        String areaName = userContext.getAreaName();
        DealerAreaCondition dealerAreaCondition = new DealerAreaCondition();
        dealerAreaCondition.setCompany(company);
        dealerAreaCondition.setAreaCode(areaCode);
        //查出这个区域所有经销商
        List<DealerArea> dealerAreas = this.selectList(dealerAreaCondition);
        //生成树状结构
        List<SelectMenuVo> selectMenuVos = dealerTree(dealerAreas, areaName, areaCode);
        return selectMenuVos;
    }

    /**
     * 生成树状结构
     * @param dealerAreas
     */
    @Transactional
    public List<SelectMenuVo> dealerTree(List<DealerArea> dealerAreas, String areaName, String areaCode) {
        List<SelectMenuVo> menuVos = new ArrayList<>();
        SelectMenuVo selectMenuVo = new SelectMenuVo();

        List<SelectMenuVo> selectMenuVos = new ArrayList<>();
        for (DealerArea dealerArea : dealerAreas) {
            SelectMenuVo menuVo = new SelectMenuVo();
            menuVo.setValue(dealerArea.getDealerCode());
            menuVo.setTitle(dealerArea.getDealerName());
            menuVo.setId(areaCode);
            selectMenuVos.add(menuVo);
        }
        selectMenuVo.setTitle(areaName);
        selectMenuVo.setValue(areaCode);
        selectMenuVo.setId(areaCode);
        selectMenuVo.setChildren(selectMenuVos);

        menuVos.add(selectMenuVo);
        return menuVos;
    }

    /**
     * 根据区域编码查询经销商
     * @param code
     * @return
     */
    public List<SelectMenuVo> selectDealerByCode(String code){
        DealerAreaCondition dealerAreaCondition = new DealerAreaCondition();
        UserContext userContext = SessionHolder.getUserContext();
        dealerAreaCondition.setCompany(userContext.getComCode());
        dealerAreaCondition.setAreaCode(code);
        List<DealerArea> dealerAreas = this.selectList(dealerAreaCondition);
        DealerArea area = null;
        List<SelectMenuVo> selectMenuVos = new ArrayList<>();
        for (int i=0;i<dealerAreas.size();i++) {
            area = dealerAreas.get(i);
            SelectMenuVo selectMenuVo = new SelectMenuVo();
            selectMenuVo.setId(code);
            selectMenuVo.setValue(area.getDealerCode());
            selectMenuVo.setTitle(area.getDealerName());
            selectMenuVos.add(selectMenuVo);
        }
        return selectMenuVos;
    }
}