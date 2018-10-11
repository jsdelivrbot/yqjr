package com.yqjr.fin.mkmm.sales.services;

import com.yqjr.fin.mkmm.sales.condition.CommodityBaseCondition;
import com.yqjr.fin.mkmm.sales.condition.MaterialBaseCondition;
import com.yqjr.fin.mkmm.sales.condition.ProjectBaseCondition;
import com.yqjr.fin.mkmm.sales.entity.*;
import com.yqjr.fin.mkmm.sales.mapper.ProjectBaseHisMapper;
import com.yqjr.fin.mkmm.sales.rest.vo.SelectCodeVo;
import com.yqjr.fin.mkmm.sales.rest.vo.SelectMenuVo;
import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.mkmm.sales.mapper.ProjectBaseMapper;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;
import com.yqjr.scfw.common.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class ProjectBaseService extends BaseService<ProjectBaseMapper, ProjectBase, Long> {

    @Autowired
    ProjectBaseMapper projectBaseMapper;
    @Autowired
    ProjectBaseHisMapper projectBaseHisMapper;
    @Autowired
    private CommodityBaseService commodityBaseService;
    @Autowired
    private MaterialBaseService materialBaseService;

    public ProjectBase selectByProjectName(ProjectBase projectBase){
        return projectBaseMapper.selectByProjectName(projectBase);
    }
    @Transactional(rollbackFor = { Exception.class })
    public void insertToHis(Long id){
        ProjectBase projectBase = this.selectById(id);
        ProjectBaseHis projectBaseHis = new ProjectBaseHis();
        BeanUtils.copyProperties(projectBaseHis,projectBase);
        projectBaseHisMapper.insert(projectBaseHis);
    }


    /**
     * 查询所有项目
     * @return
     */
    public List<SelectCodeVo> selectProjectBaseAll() {
        UserContext userContext = SessionHolder.getUserContext();
        ProjectBaseCondition projectBaseCondition = new ProjectBaseCondition();
        projectBaseCondition.setCompany(userContext.getComCode());
        List<ProjectBase> projectBases = this.selectList(projectBaseCondition);

        List<SelectCodeVo> selectCodeVos = new ArrayList<>();

        for(ProjectBase projectBase : projectBases) {
            SelectCodeVo selectCodeVo = new SelectCodeVo();
            selectCodeVo.setHeadLetter("");
            selectCodeVo.setLabel(projectBase.getProjectName());
            selectCodeVo.setValue(projectBase.getProjectCode());
            selectCodeVos.add(selectCodeVo);
        }
        return selectCodeVos;
    }

    /**
     * 生成项目编码
     * @param company
     * @return
     */
    public String makeProjectCode(String company){
        ProjectBaseCondition pbc = new ProjectBaseCondition();
        pbc.setAreaCode(company);
        int count = projectBaseMapper.selectCount(pbc);
        String maxProjectCode = "1";
        if(count>0) {
            maxProjectCode = projectBaseMapper.queryMax(company);
            maxProjectCode = (Integer.parseInt(maxProjectCode)+1)+"";
        }
        //生成规则为： XM+公司+流水号（6位）
        String projectCode = "XM"+company+String.format("%06d",Integer.parseInt(maxProjectCode));
        return projectCode;

    }

    /**
     * 根据code查名称
     * @param projectCode
     * @return
     */
    public String getProjectName (String projectCode){
        UserContext userContext = SessionHolder.getUserContext();
        ProjectBaseCondition projectBaseCondition = new ProjectBaseCondition();
        projectBaseCondition.setCompany(userContext.getComCode());
        projectBaseCondition.setProjectCode(projectCode);
        List<ProjectBase> projectBases = this.selectList(projectBaseCondition);
        if(projectBases.size()>0) {
            return projectBases.get(0).getProjectName();
        } else {
            return "";
        }

    }

}