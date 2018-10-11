package com.yqjr.fin.mkmm.sales.common;

import com.yqjr.scfw.common.session.SessionHolder;
import com.yqjr.scfw.common.session.UserContext;

import java.util.Map;

/**
 * Created by zhouchong on 2018/6/10.
 */
public class UserRoleHelp {
    /**
     * 判断当前用户是否为管理员
     * @return
     */
	
    public static boolean isAdmin(){
    	UserContext uc= SessionHolder.getUserContext();
        return uc.getRoleCodeList().indexOf("0000")>-1?true:false;
    }
    /**
     * 判断当前用户是否为销售经理
     * @return
     */
    public static boolean isSalesManager(){
    	UserContext uc= SessionHolder.getUserContext();
        return uc.getRoleCodeList().indexOf("0004")>-1?true:false;
    }
    /**
     * 判断当前用户是否为市场部人员
     * @return
     */
    public static boolean isMarketingWorkers(){
    	UserContext uc= SessionHolder.getUserContext();
        return uc.getRoleCodeList().indexOf("0002")>-1?true:false;
    }
    /**
     * 判断当前用户是否为市场部经理
     * @return
     */
    public static boolean isMarketingManager(){
    	UserContext uc= SessionHolder.getUserContext();
        return uc.getRoleCodeList().indexOf("0001")>-1?true:false;
    }
    
    /**
     * 判断当前用户是否为区域负责人
     * @return
     */
    public static boolean isRegionalLeaders(){
    	UserContext uc= SessionHolder.getUserContext();
        return uc.getRoleCodeList().indexOf("0003")>-1?true:false;
    }

    /**
     * 根据用户名角色返回审核级别
     * @return
     */
    public static String getReviewLevel(){
        String level="";
        if (UserRoleHelp.isAdmin()){
            level="0";
        }else {
            if (UserRoleHelp.isMarketingManager()){
                level="2";
            }else if (UserRoleHelp.isMarketingWorkers() || UserRoleHelp.isRegionalLeaders()){
                level="1";
            }else {
                level="0";
            }
        }
            return level;
    }

    /**
     * 获取用户名Session 下的区域编码
     * @return
     */
    public  static String getAreaCode(){
        if (!UserRoleHelp.isAdmin()&&!UserRoleHelp.isMarketingWorkers()){
            UserContext userContext=SessionHolder.getUserContext();
            return  userContext.getAreaCode();
        }else {
            return null;
        }
    }

    /**
     * 获取用户名的公司编码
     * lzc
     * @return
     */
    public  static  String getCompanyCode(){
        UserContext userContext=SessionHolder.getUserContext();
        return  userContext.getComCode();
    }


}
