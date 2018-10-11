/* eslint-disable no-unused-vars */
import Vue from 'vue';
import iView from 'iview';
import Util from '../libs/util';
import VueRouter from 'vue-router';
import Cookies from 'js-cookie';
import {routers, otherRouter, appRouter} from './router';

Vue.use(VueRouter);

// 路由配置
const RouterConfig = {
    // mode: 'history',
    routes: routers
};

export const router = new VueRouter(RouterConfig);

router.beforeEach((to, from, next) => {
    iView.LoadingBar.start();
    Util.title(to.meta.title);
    if (Cookies.get('locking') === '1' && to.name !== 'locking') { // 判断当前是否是锁定状态
        next({
            replace: true,
            name: 'locking'
        });
    } else if (Cookies.get('locking') === '0' && to.name === 'locking') {
        next(false);
    } else {
        if (!Cookies.get('user') && to.name !== 'login') { // 判断是否已经登录且前往的页面不是登录页
            next({
                name: 'login'
            });
        } else if (Cookies.get('user') && to.name === 'login') { // 判断是否已经登录且前往的是登录页
            Util.title();
            next({
                name: 'home_index'
            });
        } else {
            Util.toDefaultPage([...routers], to.name, router, next);
        }
    }
});

router.afterEach((to) => {
    Util.openNewPage(router.app, to.name, to.params, to.query);
    iView.LoadingBar.finish();
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
    window.scrollTo(0, 0);
    // 路由跳转后 获取左边导航的宽度 重新设置页面自适应宽高
    if (document.getElementById('grandParent') !== null) {
        var grandParentHeight = document.getElementById('grandParent').offsetHeight;
        var grandParentWidth = document.getElementById('grandParent').offsetWidth;
        if (document.getElementById('leftNav') !== null) {
            var leftNavWidth = document.getElementById('leftNav').style.width; // 左导航宽度
            leftNavWidth = leftNavWidth.substr(0, leftNavWidth.length - 2); // 左导航宽度去掉px
        }
        if (document.getElementById('show-iframe-wrap') === null) {
            // 其他页面的父亲页面
            document.getElementById('mainPage').style.height = grandParentHeight - 100 + 'px';
            document.getElementById('mainPage').style.width = grandParentWidth - leftNavWidth + 'px';
        } else if (document.getElementById('mainPage') === null) {
            // iframe的父亲页面
            document.getElementById('show-iframe-wrap').style.height = grandParentHeight - 100 + 'px';
            document.getElementById('show-iframe-wrap').style.width = grandParentWidth - leftNavWidth + 'px';
        }
    }
});
