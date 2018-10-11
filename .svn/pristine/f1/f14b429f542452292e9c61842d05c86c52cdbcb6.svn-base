package com.yqjr.fin.scfw.meta.services;

import com.yqjr.fin.scfw.meta.common.Constants;
import com.yqjr.fin.scfw.meta.condition.MenuCondition;
import com.yqjr.fin.scfw.meta.entity.Menu;
import com.yqjr.fin.scfw.meta.mapper.MenuMapper;
import com.yqjr.scfw.common.pagination.model.PageBounds;
import com.yqjr.scfw.common.service.BaseService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class MenuService extends BaseService<MenuMapper, Menu, Long> {
    public List<Menu> removeDuplicate(List<Menu> list)  {
		if (null!=list && !list.isEmpty()) {
			for (int i = 0; i < list.size() - 1; i++) {
				Menu tempMenu1 = list.get(i);
				Long tempId1 = tempMenu1.getId();
				for (int j = list.size() - 1; j > i; j--) {
					Menu tempMenu2 = list.get(j);
					Long tempId2 = tempMenu2.getId();
					if (tempId2.equals(tempId1)) {
						list.remove(j);
					}
				}
			}
		}
        return list;
    }
	private List<Menu> getChild(Long id, List<Menu> allMenu) {
	    // 子菜单
	    List<Menu> childList = new ArrayList<>();
	    for (Menu menu : allMenu) {
	        // 遍历所有节点，将父菜单id与传过来的id比较
	        if (null!=menu.getParentId() && !Constants.MENU_ROOT.equals(menu.getParentId())) {
	            if (id.equals(menu.getParentId())) {
	                childList.add(menu);
	            }
	        }
	    }
	    // 把子菜单的子菜单再循环一遍
	    for (Menu menu : childList) {// 没有url子菜单还有子菜单
	        if (StringUtils.isBlank(menu.getUrl()) || Constants.NO_URL.equals(menu.getUrl())) {
	        	menu.setUrl(Constants.NO_URL);
	        }
	        // 递归
            menu.setChildMenus(getChild(menu.getId(), allMenu));
	    } // 递归退出条件
	    if (childList.isEmpty()) {
	        return null;
	    }
	    return childList;
	}

    public List<Menu> selectMenuList(String roleIdList,Long sysId){
		List<Menu> allMenu=mapper.selectMenuList(roleIdList,sysId);
        allMenu = removeDuplicate(allMenu);
	    List<Menu> menuList = new ArrayList<Menu>();
		if (null!=allMenu && !allMenu.isEmpty()) {
		    // 先找到所有的一级菜单
		    for (Menu m:allMenu) {
		        // 一级菜单parentId=0
		        if (null!=m.getParentId() && Constants.MENU_ROOT.equals(m.getParentId())) {
		        	if(StringUtils.isBlank(m.getUrl())) {
		        		m.setUrl(Constants.NO_URL);
		        	}
		            menuList.add(m);
		        }
		    }
		    // 为一级菜单设置子菜单，getChild是递归调用的
		    for (Menu m : menuList) {
		        m.setChildMenus(getChild(m.getId(), allMenu));
		    }
		}
		return menuList;
	}

	public List<MenuCondition> selectMenu(String roleIdList,Long sysId){
		List<MenuCondition> menuList=mapper.selectMenUList(roleIdList,sysId);
		List<MenuCondition> menuList1=new ArrayList<>();
        for (MenuCondition menu :menuList){
        	if (menu.getParentId()==(long)0) {
				List<MenuCondition> list=new ArrayList<>();
				for (MenuCondition menu1 :menuList){
					if(menu.getId()==menu1.getParentId()){
						list.add(menu1);
					}
				}
				menu.setChildren(list);
				menuList1.add(menu);
			}

		}
    	return  menuList1;
	}


}