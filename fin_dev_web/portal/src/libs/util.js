import axios from 'axios';
import semver from 'semver';
import packjson from '../../package.json';
import Cookies from 'js-cookie';
import config from '@/config';
let util = {

};
export const TOKEN_KEY = 'token';

export const setToken = (token) => {
    Cookies.set(TOKEN_KEY, token, {expires: config.cookieExpires});
};
export const setUser = user => {
    Cookies.set('user', user, {expires: config.cookieExpires});
};

export const getToken = () => {
    const token = Cookies.get(TOKEN_KEY);
    if (token) return token;
    else return false;
};
/**
 * @param {String} url
 * @description 从URL中解析参数
 */
export const getParams = url => {
    const keyValueArr = url.split('?')[1].split('&');
    let paramObj = {};
    keyValueArr.forEach(item => {
        const keyValue = item.split('=');
        paramObj[keyValue[0]] = keyValue[1];
    });
    return paramObj;
};

util.title = function (title) {
    title = title || '一汽金融';
    window.document.title = title;
};

util.inOf = function (arr, targetArr) {
    let res = true;
    arr.forEach(item => {
        if (targetArr.indexOf(item) < 0) {
            res = false;
        }
    });
    return res;
};

util.oneOf = function (ele, targetArr) {
    if (targetArr.indexOf(ele) >= 0) {
        return true;
    } else {
        return false;
    }
};

util.showThisRoute = function (itAccess, currentAccess) {
    if (typeof itAccess === 'object' && Array.isArray(itAccess)) {
        return util.oneOf(currentAccess, itAccess);
    } else {
        return itAccess === currentAccess;
    }
};

util.getRouterObjByName = function (routers, name) {
    if (!name || !routers || !routers.length) {
        return null;
    }
    // debugger;
    let routerObj = null;
    for (let item of routers) {
        if (item.name === name) {
            return item;
        }
        routerObj = util.getRouterObjByName(item.children, name);
        if (routerObj) {
            return routerObj;
        }
    }
    return null;
};

util.handleTitle = function (vm, item) {
    if (typeof item.title === 'object') {
        return vm.$t(item.title.i18n);
    } else {
        return item.title;
    }
};

util.setCurrentPath = function (vm, name) {
    let title = '';
    let isOtherRouter = false;
    let pathName = '';
    // 判断当前路由是否为Ifream
    if (vm.$route.name === 'work_iframe') {
        pathName = vm.$route.params.pathName;
        vm.$store.state.app.menuList.forEach(item => {
            if (item.children.length === 0) {
                title = item.title;
            } else {
                item.children.forEach(child => {
                    if (child.name === pathName) {
                        title = child.title;
                    }
                });
            }
        });
    } else {
        vm.$store.state.app.routers.forEach(item => {
            if (item.children.length === 0) {
                if (item.children[0].name === name) {
                    title = util.handleTitle(vm, item);
                    if (item.name === 'otherRouter') {
                        isOtherRouter = true;
                    }
                }
            } else {
                item.children.forEach(child => {
                    if (child.name === name) {
                        title = util.handleTitle(vm, child);
                        if (item.name === 'otherRouter') {
                            isOtherRouter = true;
                        }
                    }
                });
            }
        });
    }
    let currentPathArr = [];
    if (name === 'home_index') {
        currentPathArr = [
            {
                title: util.handleTitle(vm, util.getRouterObjByName(vm.$store.state.app.routers, 'home_index')),
                path: '',
                name: 'home_index'
            }
        ];
    } else if ((name.indexOf('_index') >= 0 || isOtherRouter) && name !== 'home_index') {
        currentPathArr = [
            {
                title: util.handleTitle(vm, util.getRouterObjByName(vm.$store.state.app.routers, 'home_index')),
                path: '/home',
                name: 'home_index'
            },
            {
                title: title,
                path: '',
                name: name
            }
        ];
    } else {
        let currentPathObj;
        if (vm.$route.name === 'work_iframe') {
            currentPathObj = vm.$store.state.app.menuList.filter(item => {
                if (item.children.length <= 0) {
                    return item.children[0].name === pathName;
                } else {
                    let i = 0;
                    let childArr = item.children;
                    let len = childArr.length;
                    while (i < len) {
                        if (childArr[i].name === pathName) {
                            return true;
                        }
                        i++;
                    }
                    return false;
                }
            })[0];
        } else {
            currentPathObj = vm.$store.state.app.routers.filter(item => {
                if (item.children.length <= 1) {
                    return item.children[0].name === name;
                } else {
                    let i = 0;
                    let childArr = item.children;
                    let len = childArr.length;
                    while (i < len) {
                        if (childArr[i].name === name) {
                            return true;
                        }
                        i++;
                    }
                    return false;
                }
            })[0];
        }

        if (currentPathObj.children.length <= 0 && currentPathObj.name === 'home') {
            currentPathArr = [
                {
                    title: '首页',
                    path: '',
                    name: 'home_index'
                }
            ];
        } else if (currentPathObj.children.length <= 0 && currentPathObj.name !== 'home') {
            currentPathArr = [
                {
                    title: '首页',
                    path: '/home',
                    name: 'home_index'
                },
                {
                    title: currentPathObj.title,
                    path: '',
                    name: name
                }
            ];
        } else {
            let childObj;
            if (vm.$route.name === 'work_iframe') {
                childObj = currentPathObj.children.filter((child) => {
                    return child.name === pathName;
                })[0];
            } else {
                childObj = currentPathObj.children.filter((child) => {
                    return child.name === name;
                })[0];
            }
            currentPathArr = [
                {
                    title: '首页',
                    path: '/home',
                    name: 'home_index'
                },
                {
                    title: currentPathObj.title,
                    path: '',
                    name: currentPathObj.name
                }
            ];
            if (vm.$route.name === 'work_iframe') {
                currentPathArr.push({title: childObj.title, path: '', name: pathName});
            } else {
                // currentPathArr.push({title: childObj.title,path: currentPathObj.path + '/' + childObj.path,name: name})
                currentPathArr.push({title: childObj.title, path: '', name: name});
            }
        }
    }
    vm.$store.commit('setCurrentPath', currentPathArr);

    return currentPathArr;
};

util.openNewPage = function (vm, name, argu, query) {
    let pageOpenedList = vm.$store.state.app.pageOpenedList;
    let openedPageLen = pageOpenedList.length;
    let i = 0;
    let tagHasOpened = false;
    if (name === 'work_iframe') {
        name = vm.$route.params.pathName;
    }
    while (i < openedPageLen) {
        if (name === pageOpenedList[i].name) { // 页面已经打开
            vm.$store.commit('pageOpenedList', {
                index: i,
                argu: argu,
                query: query
            });
            tagHasOpened = true;
            break;
        }
        i++;
    }

    if (!tagHasOpened) {
        let tag = vm.$store.state.app.tagsList.filter((item) => {
            if (item.children) {
                return name === item.children[0].name;
            } else {
                return name === item.name;
            }
        });
        tag = tag[0];

        if (tag) {
            tag = tag.children ? tag.children[0] : tag;
            if (argu) {
                tag.argu = argu;
            }
            if (query) {
                tag.query = query;
            }
            vm.$store.commit('increateTag', tag);
        }
    }
    vm.$store.commit('setCurrentPageName', name);
};

util.toDefaultPage = function (routers, name, route, next) {
    let len = routers.length;
    let i = 0;
    let notHandle = true;
    while (i < len) {
        if (routers[i].name === name && routers[i].children && routers[i].redirect === undefined) {
            route.replace({
                name: routers[i].children[0].name
            });
            notHandle = false;
            next();
            break;
        }
        i++;
    }
    if (notHandle) {
        next();
    }
};

util.fullscreenEvent = function (vm) {
    vm.$store.commit('initCachepage');
    // 权限菜单过滤相关
    vm.$store.commit('updateMenulist');
    // 全屏相关
};

util.checkUpdate = function (vm) {
    // axios.get('https://api.github.com/repos/iview/iview-admin/releases/latest').then(res => {
    //     // let version = res.data.tag_name;
    //     vm.$Notice.config({
    //         duration: 0
    //     });
    //     if (semver.lt(packjson.version, version)) {
    //         vm.$Notice.info({
    //             title: 'iview-admin更新啦',
    //             desc: '<p>iView-admin更新到了' + version + '了，去看看有哪些变化吧</p><a style="font-size:13px;" href="https://github.com/iview/iview-admin/releases" target="_blank">前往github查看</a>'
    //         });
    //     }
    // });
};

export default util;
