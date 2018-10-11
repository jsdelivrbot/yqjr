package com.yqjr.fin.mkmm.sales.services;


import com.yqjr.fin.mkmm.sales.common.BeanUtil;
import com.yqjr.fin.mkmm.sales.condition.MaterialBaseCondition;
import com.yqjr.fin.mkmm.sales.condition.MaterialDealerCondition;
import com.yqjr.fin.mkmm.sales.condition.MaterialOutCondition;
import com.yqjr.fin.mkmm.sales.entity.*;
import com.yqjr.fin.mkmm.sales.rest.vo.*;
import com.yqjr.scfw.common.exception.ValidationException;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import com.yqjr.scfw.common.service.BaseService;
import com.yqjr.fin.mkmm.sales.mapper.MaterialOutMapper;
import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MaterialOutService extends BaseService<MaterialOutMapper, MaterialOut, Long> {


    @Autowired
    MaterialBaseService materialBaseService;
    @Autowired
    SelectCodeService selectCodeService;
    @Autowired
    MaterialInService materialInService;
    @Autowired
    MaterialOutMapper materialOutMapper;
    @Autowired
    MaterialDealerService materialDealerService;

    public MaterialIn selectMessage(Long id){
       return materialInService.selectMessage(id);
    }

    /**
     * 将推送信息分别插入对应的表中
     * @param condition
     */
    @Transactional(rollbackFor = { Exception.class })
    public synchronized void insertToMaterialOut(MaterialOutVo condition){
        List<MaterialDealer> materialDealers = condition.getMaterialDealers();
        if(materialDealers == null || materialDealers.size() == 0){
            throw new ValidationException("请添加经销商信息");
        }
        MaterialOut materialOut = new MaterialOut();
        BeanUtil.copyProperties(materialOut,condition);
        UserContext userContext = SessionHolder.getUserContext();
        materialOut.setCompany(userContext.getComCode());
        materialOut.setUploader(userContext.getName());
        materialOut.setReceiveStatus("0");
        materialOut.setInId(condition.getId());
        this.insert(materialOut);
        MaterialDealer materialDealer = null;
        MaterialDealer materialDe = new MaterialDealer();
        for(int i=0;i<materialDealers.size();i++){
            materialDealer = materialDealers.get(i);
            BeanUtil.copyProperties(materialDe,materialDealer);
            materialDe.setCompany(userContext.getComCode());
            materialDe.setMaterialCode(materialOut.getMaterialCode());
            materialDe.setMaterialOutId(materialOut.getId());
            materialDe.setReceiveStatus("0");
            materialDealerService.insert(materialDe);
        }
    }

    /**
     * 通过id查询推送信息
     * @param id
     * @return
     */
    public MaterialOutVo selectOutMesById(Long id){
        MaterialOut materialOut = this.selectById(id);
        MaterialOutVo materialOutVo = new MaterialOutVo();
        MaterialDealer materialDealer = new MaterialDealer();
        materialDealer.setCompany(materialOut.getCompany());
        materialDealer.setMaterialOutId(id);
        List<MaterialDealer> materialDealers = materialDealerService.selectByMaterialOutId(materialDealer);
        BeanUtil.copyProperties(materialOutVo,materialOut);
        materialOutVo.setMaterialDealers(materialDealers);
        return materialOutVo;
    }

    /**
     * 导出List页面信息
     */
    public void exportList(MaterialInVo condition,HttpServletResponse response) throws IOException {
        UserContext userContext = SessionHolder.getUserContext();
        condition.setCompany(userContext.getComCode());
        //查询数据
        List<MaterialIn> materials = materialInService.selectDataList(condition);
        createExcel(materials,response);

    }

    /**
     * 创建excel
     * @param materials
     * @param response
     */
    public void createExcel(List<MaterialIn> materials, HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("素材推送记录");
        String [] cellValues = {"素材类型","适用品牌","素材主题", "素材来源", "创建人", "创建时间"};
        //创建表头
        createTitle(sheet,cellValues);
        //写数据
        writeMessage(materials, sheet);

        String fileName = "MaterialOut.xls";
        //新增数据行，并且设置单元格数据
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }
    /***
     * 创建表头
     * @param sheet
     */
    private void createTitle(HSSFSheet sheet, String [] cellValues) {
        HSSFRow row = sheet.createRow(0);
        //设置列宽
        for(int i = 0; i<cellValues.length ;i++) {
            sheet.setColumnWidth(i, 15*256);
        }
        HSSFCell cell;
        for(int i = 0; i<cellValues.length ;i++) {
            cell = row.createCell(i);
            cell.setCellValue(cellValues[i]);
        }
    }

    /**
     * 写数据
     */
    public void writeMessage(List<MaterialIn> materials,HSSFSheet sheet){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        MaterialIn material = null;
        for(int i=0;i<materials.size();i++){
            material = materials.get(i);
            HSSFRow row =  sheet.createRow(i+1);
            //查询素材名称
            MaterialBaseCondition materialBaseCondition = new MaterialBaseCondition();
            materialBaseCondition.setMaterialCode(material.getMaterialCode());
            List<MaterialBase> materialBases = materialBaseService.selectList(materialBaseCondition);
            //查询品牌名称
            String brandsCode = material.getBrandsCode();
            List<SelectCodeVo> selectCodeVos = selectCodeService.translateCode("CarBrand", brandsCode);
            row.createCell(0).setCellValue(materialBases.get(0).getMaterialName());
            row.createCell(1).setCellValue(selectCodeVos.get(0).getLabel());
            row.createCell(2).setCellValue(material.getMaterialTheme());
            row.createCell(3).setCellValue(material.getMaterialSource());
            row.createCell(4).setCellValue(material.getUploader());
            row.createCell(5).setCellValue(sdf.format(material.getCreateTime()));
        }
    }
    /**
     * 推送信息查询
     * @param condition
     * @param pageBounds
     * @return
     */
    public List<MaterialOutHisExport> selectMsg(MaterialOutCondition condition, PageBounds... pageBounds){
        return materialOutMapper.selectMsg(condition,pageBounds);
    }


    /**
     * 导出view页面信息
     */
    public void exportView(List<MaterialDealer> materialDealers,MaterialOut materialOut,HttpServletResponse response) throws IOException {
        //处理数据
        List<ExportViewVo> exportViewVos = dataProcess(materialDealers,materialOut);
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("素材推送记录");
        String [] cellValues = {"素材类型","素材主题","适用品牌","有效期","推送范围","推送时间","接收状态","接收时间","经销商意见"};
        //创建表头
        createTitle(sheet,cellValues);
        //写数据
        writeMessageView(exportViewVos, sheet);

        String fileName = "MaterialOut.xls";
        //新增数据行，并且设置单元格数据
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }

    /**
     * 处理数据
     * @param
     */
    public List<ExportViewVo> dataProcess(List<MaterialDealer> materialDealers,MaterialOut materialOut){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        MaterialDealer materialDealer = null;
        List<ExportViewVo> exportViewVos = new ArrayList<ExportViewVo>();
        for(int i=0;i<materialDealers.size();i++){
            ExportViewVo exportViewVo = new ExportViewVo();
            materialDealer = materialDealers.get(i);
            exportViewVo.setMaterialName(materialOut.getMaterialName());
            exportViewVo.setMaterialCode(materialOut.getMaterialCode());
            exportViewVo.setMaterialTheme(materialOut.getMaterialTheme());
            exportViewVo.setBrandsName(materialOut.getBrandsName());
            exportViewVo.setBrandsCode(materialOut.getBrandsCode());
            exportViewVo.setEffectiveStartTime(materialOut.getEffectiveStartTime());
            exportViewVo.setEffectiveEndTime(materialOut.getEffectiveEndTime());
            exportViewVo.setOutTime(materialOut.getCreateTime());
            exportViewVo.setDealerCode(materialDealer.getDealerCode());
            exportViewVo.setDealerName(materialDealer.getDealerName());
            exportViewVo.setReceiveStatus(materialDealer.getReceiveStatus());
            exportViewVo.setReceiveTime(materialDealer.getReceiveTime());
            exportViewVo.setOpinion(materialDealer.getOpinion());
            exportViewVos.add(exportViewVo);
        }
        return exportViewVos;
    }

    /**
     * 将信息写入excel
     * @param exportViewVos
     * @param sheet
     */
    public void writeMessageView(List<ExportViewVo> exportViewVos,HSSFSheet sheet){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ExportViewVo exportViewVo = null;
        for(int i=0;i<exportViewVos.size();i++){
            exportViewVo = exportViewVos.get(i);
            HSSFRow row =  sheet.createRow(i+1);
            row.createCell(0).setCellValue(exportViewVo.getMaterialName());
            row.createCell(1).setCellValue(exportViewVo.getMaterialTheme());
            row.createCell(2).setCellValue(exportViewVo.getBrandsName());
            if (!"".equals(exportViewVo.getEffectiveStartTime()) && exportViewVo.getEffectiveStartTime() != null && !"".equals(exportViewVo.getEffectiveEndTime()) && exportViewVo.getEffectiveEndTime() != null) {
                row.createCell(3).setCellValue(sdf.format(exportViewVo.getEffectiveStartTime()) + "-" + sdf.format(exportViewVo.getEffectiveEndTime()));
            }
            row.createCell(4).setCellValue(exportViewVo.getDealerName());
            row.createCell(5).setCellValue(sdf.format(exportViewVo.getOutTime()));
            if("1".equals(exportViewVo.getReceiveStatus())){
                row.createCell(6).setCellValue("已接收");
            }else if("0".equals(exportViewVo.getReceiveStatus())){
                row.createCell(6).setCellValue("未接收");
            }
            if (!"".equals(exportViewVo.getReceiveTime()) && exportViewVo.getReceiveTime() != null) {
                row.createCell(7).setCellValue(sdf1.format(exportViewVo.getReceiveTime()));
            }
            if (!"".equals(exportViewVo.getOpinion()) && exportViewVo.getOpinion() != null) {
                row.createCell(8).setCellValue(exportViewVo.getOpinion());
            }
        }
    }

    /**
     * 推送记录查询页面数据导出
     * @param id
     * @param response
     * @throws IOException
     */
    public void exportViewMsg (Long id,HttpServletResponse response) throws IOException {
        MaterialOut materialOut = this.selectById(id);
        UserContext userContext = SessionHolder.getUserContext();
        MaterialDealerCondition materialDealerCondition = new MaterialDealerCondition();
        materialDealerCondition.setMaterialOutId(id);
        materialDealerCondition.setCompany(userContext.getComCode());
        List<MaterialDealer> materialDealers = materialDealerService.selectList(materialDealerCondition);
        // 创建excel
        exportView(materialDealers,materialOut,response);
    }
}