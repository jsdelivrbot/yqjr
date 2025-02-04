/* eslint-disable no-console,no-console,no-undef,no-unused-vars */
import {otherRouter, appRouter} from '@/router/router';
import Util from '@/libs/util';
import Cookies from 'js-cookie';
import Vue from 'vue';
import { gettextMenu } from '@/api/app';

const app = {
    state: {
        cachePage: [],
        lang: '',
        isFullScreen: false,
        openedSubmenuArr: [], // 要展开的菜单数组
        menuTheme: 'light', // 主题
        themeColor: '',
        pageOpenedList: [{
            title: '首页',
            path: '',
            name: 'home_index'
        }],
        currentPageName: '',
        currentPath: [
            {
                title: '首页',
                path: '',
                name: 'home_index'
            }
        ], // 面包屑数组
        menuList: [],
        routers: [
            otherRouter,
            ...appRouter
        ],
        tagsList: [...otherRouter.children],
        messageCount: 0,
        dontCache: ['text-editor', 'artical-publish'] // 在这里定义你不想要缓存的页面的name属性值(参见路由配置router.js)
    },
    mutations: {
        setTagsList (state, list) {
            state.tagsList.push(...list);
        },
        setMenuList (state, data) {
            state.menuList = data;
            // state.pageOpenedList = [{ title: '首页', path: '', name: 'home_index' }];
            localStorage.menuList = JSON.stringify(state.menuList);
        },
        // 菜单获取
        updateMenulist (state) {
            let accessCode = parseInt(Cookies.get('access'));
            let menuList = [];
            appRouter.forEach((item, index) => {
                if (item.access !== undefined) {
                    if (Util.showThisRoute(item.access, accessCode)) {
                        if (item.children.length === 0) {
                            menuList.push(item);
                        } else {
                            let len = menuList.push(item);
                            let childrenArr = [];
                            childrenArr = item.children.filter(child => {
                                if (child.access !== undefined) {
                                    if (child.access === accessCode) {
                                        return child;
                                    }
                                } else {
                                    return child;
                                }
                            });
                            menuList[len - 1].children = childrenArr;
                        }
                    }
                } else {
                    if (item.children.length === 0) {
                        menuList.push(item);
                    } else {
                        let len = menuList.push(item);
                        let childrenArr = [];
                        childrenArr = item.children.filter(child => {
                            if (child.access !== undefined) {
                                if (Util.showThisRoute(child.access, accessCode)) {
                                    return child;
                                }
                            } else {
                                return child;
                            }
                        });
                        if (childrenArr === undefined || childrenArr.length === 0) {
                            menuList.splice(len - 1, 1);
                        } else {
                            let handledItem = JSON.parse(JSON.stringify(menuList[len - 1]));
                            handledItem.children = childrenArr;
                            menuList.splice(len - 1, 1, handledItem);
                        }
                    }
                }
            });
            var textMenu = [
                {icon: 'person-stalker',
                    name: 'team',
                    path: '',
                    title: '销售团队管理',
                    children: [
                        {icon: 'fireball', name: 'teamMainTenanceList', path: 'http://localhost:8081/#/teamMainTenanceList', title: '销售团队维护'},
                        {icon: 'fireball', name: 'teamEventList', path: 'http://localhost:8081/#/teamEventList', title: '销售团队重大事项维护'},
                        {icon: 'fireball', name: 'teamMainQueryList', path: 'http://localhost:8081/#/teamMainQueryList', title: '销售团队综合信息查询与管理'},
                        {icon: 'fireball', name: 'teamPlanTrackList', path: 'http://localhost:8081/#/teamPlanTrackList', title: '销售团队预算任务与计划跟踪'},
                        // {icon: 'fireball', name: 'access_index46', path: 'http://localhost:8088/#/demoList', title: '销售团队异动'},
                        {icon: 'fireball', name: 'teamReviewList', path: 'http://localhost:8081/#/teamReviewList', title: '销售团队审核'},
                        {icon: 'fireball', name: 'teamReviewProgressList', path: 'http://localhost:8081/#/teamReviewProgressList', title: '销售团队审核进度处理'}]},
                {icon: 'person-add',
                    name: 'person',
                    path: '/person',
                    title: '销售人员管理',
                    children: [
                        {icon: 'fireball', name: 'personList', path: 'http://localhost:8081/#/personList', title: '销售人员维护'},
                        {icon: 'fireball', name: 'personEventList', path: 'http://localhost:8081/#/personEventList', title: '销售人员重大事项维护'},
                        {icon: 'fireball', name: 'personMainQueryList', path: 'http://localhost:8081/#/personMainQueryList', title: '销售人员综合信息查询与管理'},
                        {icon: 'fireball', name: 'personPlanTrackList', path: 'http://localhost:8081/#/personPlanTrackList', title: '销售人员预算任务与计划跟踪'},
                        // {icon: 'fireball', name: 'access_index53', path: 'http://localhost:8081/#/demoList', title: '销售人员异动'},
                        {icon: 'fireball', name: 'personReviewList', path: 'http://localhost:8081/#/personReviewList', title: '销售人员审核'},
                        {icon: 'fireball', name: 'personReviewProgressList', path: 'http://localhost:8081/#/personReviewProgressList', title: '销售人员审核进度处理'}]},
                {icon: 'pie-graph',
                    name: 'plan',
                    path: '/plan',
                    title: '销售计划管理',
                    children: [
                        {icon: 'fireball', name: 'salePlanSearchList', path: 'http://localhost:8081/#/salePlanSearchList', title: '销售计划查询'},
                        {icon: 'fireball', name: 'salePlanUploadAdd', path: 'http://localhost:8081/#/salePlanUploadAdd', title: '销售计划上传'},
                        {icon: 'fireball', name: 'salePlanTrackList', path: 'http://localhost:8081/#/salePlanTrackList', title: '销售计划跟踪'}]},
                {icon: 'arrow-graph-up-right',
                    name: 'active',
                    path: '/active',
                    title: '促销活动管理',
                    children: [
                        {icon: 'fireball', name: 'activeMainList', path: 'http://localhost:8081/#/activeMainList', title: '促销活动制定'},
                        {icon: 'fireball', name: 'activeMainQueryList', path: 'http://localhost:8081/#/activeMainQueryList', title: '促销活动综合查询'},
                        {icon: 'fireball', name: 'activeMatchDetailList', path: 'http://localhost:8081/#/activeMatchDetailList', title: '促销活动业务明细查询'},
                        {icon: 'fireball', name: 'activeReviewList', path: 'http://localhost:8081/#/activeReviewList', title: '促销活动审核'},
                        {icon: 'fireball', name: 'activeReviewProgressList', path: 'http://localhost:8081/#/activeReviewProgressList', title: '促销活动审核进度处理'}]},
                {icon: 'social-usd',
                    name: 'free',
                    path: '/free',
                    title: '费用管理',
                    children: [
                        {icon: 'fireball', name: 'feeDoPayList', path: 'http://localhost:8081/#/feeDoPayList', title: '促销活动费用结算'},
                        {icon: 'fireball', name: 'feeReviewList', path: 'http://localhost:8081/#/feeReviewList', title: '促销活动费用动支审核'},
                        {icon: 'fireball', name: 'feeReviewProgressList', path: 'http://localhost:8081/#/feeReviewProgressList', title: '费用动支审核进度处理'}]},
                {icon: 'fireball',
                    name: 'ddddd222',
                    path: '/work',
                    title: '促销活动管理demo',
                    children: [
                        {icon: 'fireball', name: 'access_index3', path: 'http://localhost:8081/#/demoList', title: '促销活动制定'},
                        {icon: 'key', name: 'access_index4', path: 'index2', title: '促销活动菜单2'}]},
                {icon: 'key',
                    name: 'ddddd',
                    path: '/work2',
                    title: '测试菜单',
                    children: [
                        {icon: 'key', name: 'access_index5', path: 'index3', title: '测试5'},
                        {icon: 'key', name: 'access_index6', path: 'indezx2', title: '测试6'}]}
            ];
            state.menuList = textMenu;
            if (localStorage.menuList) {
                state.menuList = JSON.parse(localStorage.menuList);
            }
            state.menuList.map((item) => {
                if (item.children.length <= 0) {
                    state.tagsList.push(item.children[0]);
                } else {
                    state.tagsList.push(...item.children);
                }
            });
        },
        changeMenuTheme (state, theme) {
            state.menuTheme = theme;
        },
        changeMainTheme (state, mainTheme) {
            state.themeColor = mainTheme;
        },
        addOpenSubmenu (state, name) {
            let hasThisName = false;
            let isEmpty = false;
            if (name.length === 0) {
                isEmpty = true;
            }
            if (state.openedSubmenuArr.indexOf(name) > -1) {
                hasThisName = true;
            }
            if (!hasThisName && !isEmpty) {
                state.openedSubmenuArr.push(name);
            }
        },
        closePage (state, name) {
            state.cachePage.forEach((item, index) => {
                if (item === name) {
                    state.cachePage.splice(index, 1);
                }
            });
        },
        initCachepage (state) {
            if (localStorage.cachePage) {
                state.cachePage = JSON.parse(localStorage.cachePage);
            }
        },
        removeTag (state, name) {
            state.pageOpenedList.map((item, index) => {
                if (item.name === name) {
                    state.pageOpenedList.splice(index, 1);
                }
            });
        },
        pageOpenedList (state, get) {
            let openedPage = state.pageOpenedList[get.index];
            if (get.argu) {
                openedPage.argu = get.argu;
            }
            if (get.query) {
                openedPage.query = get.query;
            }
            state.pageOpenedList.splice(get.index, 1, openedPage);
            localStorage.pageOpenedList = JSON.stringify(state.pageOpenedList);
        },
        clearAllTags (state) {
            state.pageOpenedList.splice(1);
            state.cachePage.length = 0;
            localStorage.pageOpenedList = JSON.stringify(state.pageOpenedList);
        },
        clearOtherTags (state, vm) {
            let currentName = vm.currentPageName;
            let currentIndex = 0;
            state.pageOpenedList.forEach((item, index) => {
                if (item.name === currentName) {
                    currentIndex = index;
                }
            });
            if (currentIndex === 0) {
                state.pageOpenedList.splice(1);
            } else {
                state.pageOpenedList.splice(currentIndex + 1);
                state.pageOpenedList.splice(1, currentIndex - 1);
            }
            let newCachepage = state.cachePage.filter(item => {
                return item === currentName;
            });
            state.cachePage = newCachepage;
            localStorage.pageOpenedList = JSON.stringify(state.pageOpenedList);
        },
        setOpenedList (state) {
            state.pageOpenedList = localStorage.pageOpenedList ? JSON.parse(localStorage.pageOpenedList) : [otherRouter.children[0]];
        },
        setCurrentPath (state, pathArr) {
            state.currentPath = pathArr;
        },
        setCurrentPageName (state, name) {
            state.currentPageName = name;
        },
        setAvator (state, path) {
            localStorage.avatorImgPath = path;
        },
        switchLang (state, lang) {
            state.lang = lang;
            Vue.config.lang = lang;
        },
        clearOpenedSubmenu (state) {
            state.openedSubmenuArr.length = 0;
            state.pageOpenedList = [{ title: '首页', path: '', name: 'home_index' }];
            localStorage.menuList = '';
        },
        setMessageCount (state, count) {
            state.messageCount = count;
        },
        increateTag (state, tagObj) {
            if (!Util.oneOf(tagObj.name, state.dontCache)) {
                state.cachePage.push(tagObj.name);
                localStorage.cachePage = JSON.stringify(state.cachePage);
            }
            state.pageOpenedList.push(tagObj);
            localStorage.pageOpenedList = JSON.stringify(state.pageOpenedList);
        }
    },
    actions: {
        // 获取菜单
        handlegettextMenu ({ commit }, {systemId}) {
            return new Promise((resolve, reject) => {
                gettextMenu({
                    systemId
                }).then(res => {
                    commit('setMenuList', res.result);
                    resolve();
                }).catch(err => {
                    reject(err);
                });
            });
        }
    }
};

export default app;
