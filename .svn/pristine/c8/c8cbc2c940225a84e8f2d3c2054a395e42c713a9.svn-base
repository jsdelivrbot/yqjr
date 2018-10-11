package com.yqjr.fin.qcms.credit.bizz;

import com.yqjr.fin.qcms.credit.dto.EigenvalueDto;
import com.yqjr.fin.qcms.credit.dto.ScoreMatchResultDto;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
* 评分模型模块Bizz
* @Author:         zxd
* @CreateDate:     2018/9/7 9:56
*/
@Service
public class ScoreModelModularBizz {
    /**
     * 评分卡验证传入值是否匹配
     * @param param
     * @param matchValue
     * @return
     */
    public Boolean isMatch(String param, String matchValue){
        BigDecimal minLimit = null;
        BigDecimal maxLimit = null;
        BigDecimal bigDecimal = null;
        //匹配值数组 保留完整数据（-1）
        /**
         * 评分卡的范围值规则要求 为包含下限不包含上限
         * 若为 [x,y) 格式的字符串
         * 拆分后数组长度为4位
         * 首尾 为 “”
         */
        String[] value = matchValue.split("\\[|,|\\)",-1);
        //是否为范围型
        if(matchValue.startsWith("[") && matchValue.endsWith(")")){
            bigDecimal = new BigDecimal(param);
            minLimit = new BigDecimal(value[1]);
            maxLimit = new BigDecimal(value[2]);
            //最小值比传入值大，退出 >=
            if(minLimit.compareTo(bigDecimal) == 1){
                return false;
            }
            //最大值不比传入值大，退出 <
            if(maxLimit.compareTo(bigDecimal) != -1){
                return false;
            }
        }else{
            //没有匹配到传入参数
            if(!Arrays.asList(value).contains(param)){
                return false;
            }
        }
        return true;
    }

    /**
     * 根据验证数据及特征值列表，计算该验证数据的结果
     * 返回基础总分和各项详情
     * @param businessVerifyData
     * @param eigenvalueDtos
     * @return
     */
    public ScoreMatchResultDto matchScore(String businessVerifyData , List<EigenvalueDto> eigenvalueDtos){

        double basicSum = 0.0;
        StringBuffer matchResult = new StringBuffer("");
        ScoreMatchResultDto scoreMatchResultDto = new ScoreMatchResultDto();

        String[] k_y = businessVerifyData.split(",",-1);

        evenParam:
        for(int i=0;i< k_y.length;i++){
            /**
             * 标识该因子是否已经匹配到参数值
             * 并初始化
             */
            Boolean endFlag = false;
            //将每一个属性拆为 code ： value ； 0，1
            String[] atom = k_y[i].split(":",-1);
            //若该参数无数值，记为0分
            if("".equals(atom[1])){
                matchResult.append(atom[0]+":0,");
                continue;
            }
            /**
             * 用属性名称与特征值表中的规则因子名称匹配
             */
            for(EigenvalueDto eigenvalueDto : eigenvalueDtos){
                if(atom[0].equals(eigenvalueDto.getRuleFactorName())){
                    endFlag = isMatch(atom[1],eigenvalueDto.getMatchValue());
                    if (endFlag){
                        matchResult.append(atom[0]+":"+eigenvalueDto.getScore().toString()+",");
                        //合计基础分
                        basicSum += eigenvalueDto.getScore();
                        //跳到下一个参数进行匹配
                        continue evenParam;
                    }
                }
            }
            if(!endFlag){
                matchResult.append(atom[0]+":0,");
            }
        }
        //移除拼接好字符串的最后一个逗号
        matchResult.deleteCharAt(matchResult.lastIndexOf(","));

        scoreMatchResultDto.setBasicSum(basicSum);
        scoreMatchResultDto.setMatchResult(matchResult.toString());

        return scoreMatchResultDto;
    }
     
}
