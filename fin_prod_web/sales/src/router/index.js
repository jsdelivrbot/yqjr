import Vue from 'vue';
import iView from 'iview';
import Util from '../libs/util';
import VueRouter from 'vue-router';
import {routers} from './router';
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
    Util.toDefaultPage([...routers], to.name, router, next);
});

router.afterEach((to) => {
    iView.LoadingBar.finish();
    window.parent.parent.postMessage({
        act: 'top',
        msg: {
            size: 0
        }
    }, '*');
    window.parent.postMessage({
        act: 'top',
        msg: {
            size: 0
        }
    }, '*');
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
    window.scrollTo(0, 0);
});
