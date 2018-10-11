package com.yqjr.fin.mkmm.sales.services;

import com.yqjr.fin.mkmm.sales.common.BeanUtil;
import com.yqjr.fin.mkmm.sales.condition.CommodityBaseCondition;
import com.yqjr.fin.mkmm.sales.entity.CommodityAcceptance;
import com.yqjr.fin.mkmm.sales.entity.CommodityBaseHis;
import com.yqjr.fin.mkmm.sales.rest.vo.SelectCodeVo;
import com.yqjr.fin.mkmm.sales.rest.vo.SelectMenuVo;
import com.yqjr.scfw.common.exception.ValidationException;
import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.mkmm.sales.entity.CommodityBase;
import com.yqjr.fin.mkmm.sales.mapper.CommodityBaseMapper;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class CommodityBaseService extends BaseService<CommodityBaseMapper, CommodityBase, Long> {

    @Autowired
    private CommodityAcceptanceService commodityAcceptanceService;
    @Autowired
    private CommodityBaseHisService commodityBaseHisService;
    @Autowired
    private CommodityBaseMapper commodityBaseMapper;

    /**
     * 物料添加
     * create by fannaian on 20180903
     * @param commodityBase
     */
    @Transactional
    public void insertCommodity(CommodityBase commodityBase) {
        UserContext userContext = SessionHolder.getUserContext();
        commodityBase.setCompany(userContext.getComCode());

        CommodityBaseCondition commodityBaseCondition = new CommodityBaseCondition();
        commodityBaseCondition.setCommodityName(commodityBase.getCommodityName());
        commodityBaseCondition.setCompany(commodityBase.getCompany());
        //校验物料名称是否重复
        Long number =  this.selectCount(commodityBaseCondition);
        if (number>0) {
            throw new ValidationException("该物料已存在!");
        }
        //生成物料编码
        String commodityCode = makeCommodityCode(userContext.getComCode());
        commodityBase.setCommodityCode(commodityCode);
        //插入分类名称
        setCommodityName(commodityBase);
        this.insert(commodityBase);
    }

    /**
     * 物料删除
     * create by fannaian on 20180903
     * @param id
     */
    @Transactional
    public void deleteCommodity (Long id) {
        CommodityBase commodityBase = this.selectById(id);
        //先校验物料是否被使用
        Long number = commodityAcceptanceService.selectCommodityDataByName(commodityBase);
        if (number>0) {
            throw new ValidationException("该物料已入库，无法删除!");
        }
        //记录轨迹
        CommodityBaseHis commodityBaseHis = new CommodityBaseHis();
        BeanUtil.copyProperties(commodityBaseHis,commodityBase);
        commodityBaseHisService.insert(commodityBaseHis);
        this.deleteById(id);
    }

    /**
     * 查询所有物料
     * @return
     */
    @Transactional
    public List<SelectCodeVo> selectCommodityBaseAll(String code) {
        UserContext userContext = SessionHolder.getUserContext();
        CommodityBaseCondition commodityBaseCondition = new CommodityBaseCondition();
        commodityBaseCondition.setCompany(userContext.getComCode());
        commodityBaseCondition.setCommodityTypeCode(code);
        List<CommodityBase> commodityBases = this.selectList(commodityBaseCondition);

        List<SelectCodeVo> selectCodeVos = new ArrayList<>();

        for(CommodityBase commodityBase : commodityBases) {
            SelectCodeVo selectCodeVo = new SelectCodeVo();
            selectCodeVo.setHeadLetter("");
            selectCodeVo.setLabel(commodityBase.getCommodityName());
            selectCodeVo.setValue(commodityBase.getCommodityCode());
            selectCodeVos.add(selectCodeVo);
        }
        return selectCodeVos;
    }

    /**
     * 生成物料编码
     * @param company
     * @return
     */
    public String makeCommodityCode(String company){
        CommodityBaseCondition cbc = new CommodityBaseCondition();
        cbc.setCompany(company);
        int count = commodityBaseMapper.selectCount(cbc);
        String maxCommodityCode = "1";
        if(count>0) {
            maxCommodityCode = commodityBaseMapper.queryMax(company);
            maxCommodityCode = (Integer.parseInt(maxCommodityCode)+1)+"";
        }
        //生成规则为： WL+公司+流水号（6位）
        String commodityCode = "WL"+company+String.format("%06d",Integer.parseInt(maxCommodityCode));
        return commodityCode;

    }

    /**
     * 插入分类名称
     */
    public void setCommodityName(CommodityBase commodityBase) {
        String type = commodityBase.getCommodityTypeCode();
        if("00".equals(type)) {
            commodityBase.setCommodityTypeName("促销物料");
        } else if("01".equals(type)) {
            commodityBase.setCommodityTypeName("广宣物料");
        } else {
            commodityBase.setCommodityTypeName("品牌物料");
        }
    }

    /**
     * 菜单查询物料
     */
    public List<SelectMenuVo> selectCommodityMenu() {
        List<SelectMenuVo> selectMenuVos = new ArrayList<>();
        //查促销物料
        SelectMenuVo selectCXMenuVo = setCXCommodity();
        //查广宣物料
        SelectMenuVo selectGXMenuVo = setGXCommodity();
        //查品牌物料
        SelectMenuVo selectPPMenuVo = setPPCommodity();

        selectMenuVos.add(selectCXMenuVo);
        selectMenuVos.add(selectGXMenuVo);
        selectMenuVos.add(selectPPMenuVo);
        return selectMenuVos;
    }

    /**
     * 查促销物料
     * @return
     */
    public SelectMenuVo setCXCommodity() {
        UserContext userContext = SessionHolder.getUserContext();
        CommodityBaseCondition commodityBaseCondition = new CommodityBaseCondition();
        commodityBaseCondition.setCompany(userContext.getComCode());
        commodityBaseCondition.setCommodityTypeCode("00");
        List<CommodityBase> commodityBases = this.selectList(commodityBaseCondition);

        SelectMenuVo selectMenuVo = new SelectMenuVo();
        if(commodityBases.size()>0) {
            List<SelectMenuVo> selectMenuVos = new ArrayList<>();
            for (CommodityBase commodityBase : commodityBases) {
                SelectMenuVo selectMenu = new SelectMenuVo();
                selectMenu.setTitle(commodityBase.getCommodityName());
                selectMenu.setValue(commodityBase.getCommodityCode());
                selectMenu.setId("11");
                selectMenuVos.add(selectMenu);
            }
            selectMenuVo.setId("11");
            selectMenuVo.setValue("00");
            selectMenuVo.setTitle("促销物料");
            selectMenuVo.setChildren(selectMenuVos);
        }
        return selectMenuVo;
    }

    /**
     * 查广宣物料
     * @return
     */
    public SelectMenuVo setGXCommodity() {
        UserContext userContext = SessionHolder.getUserContext();
        CommodityBaseCondition commodityBaseCondition = new CommodityBaseCondition();
        commodityBaseCondition.setCompany(userContext.getComCode());
        commodityBaseCondition.setCommodityTypeCode("01");
        List<CommodityBase> commodityBases = this.selectList(commodityBaseCondition);

        SelectMenuVo selectMenuVo = new SelectMenuVo();
        if(commodityBases.size()>0) {
            List<SelectMenuVo> selectMenuVos = new ArrayList<>();
            for (CommodityBase commodityBase : commodityBases) {
                SelectMenuVo selectMenu = new SelectMenuVo();
                selectMenu.setTitle(commodityBase.getCommodityName());
                selectMenu.setValue(commodityBase.getCommodityCode());
                selectMenu.setId("22");
                selectMenuVos.add(selectMenu);
            }
            selectMenuVo.setId("22");
            selectMenuVo.setValue("01");
            selectMenuVo.setTitle("广宣物料");
            selectMenuVo.setChildren(selectMenuVos);
        }
        return selectMenuVo;
    }

    /**
     * 查品牌物料
     * @return
     */
    public SelectMenuVo setPPCommodity() {
        UserContext userContext = SessionHolder.getUserContext();
        CommodityBaseCondition commodityBaseCondition = new CommodityBaseCondition();
        commodityBaseCondition.setCompany(userContext.getComCode());
        commodityBaseCondition.setCommodityTypeCode("02");
        List<CommodityBase> commodityBases = this.selectList(commodityBaseCondition);

        SelectMenuVo selectMenuVo = new SelectMenuVo();
        if(commodityBases.size()>0) {
            List<SelectMenuVo> selectMenuVos = new ArrayList<>();
            for (CommodityBase commodityBase : commodityBases) {
                SelectMenuVo selectMenu = new SelectMenuVo();
                selectMenu.setTitle(commodityBase.getCommodityName());
                selectMenu.setValue(commodityBase.getCommodityCode());
                selectMenu.setId("33");
                selectMenuVos.add(selectMenu);
            }
            selectMenuVo.setId("33");
            selectMenuVo.setValue("02");
            selectMenuVo.setTitle("品牌物料");
            selectMenuVo.setChildren(selectMenuVos);
        }
        return selectMenuVo;
    }

    /**
     * 根据物料code查询名称
     * @param commodityCode
     * @return
     */
    public String getCommodityName(String commodityCode) {
        UserContext userContext = SessionHolder.getUserContext();
        CommodityBaseCondition commodityBaseCondition = new CommodityBaseCondition();
        commodityBaseCondition.setCompany(userContext.getComCode());
        commodityBaseCondition.setCommodityCode(commodityCode);
        List<CommodityBase> commodityBases = this.selectList(commodityBaseCondition);

        if(commodityBases.size()>0) {
            return commodityBases.get(0).getCommodityName();
        } else {
            return "";
        }
    }
}