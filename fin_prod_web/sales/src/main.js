import Vue from 'vue';
import iView from 'iview';
import {router} from './router/index';
import {appRouter} from './router/router';
import store from './store';
import App from './app.vue';
import '@/locale';
import 'iview/dist/styles/iview.css';
import VueI18n from 'vue-i18n';
import util from './libs/util';
import env from '../build/env'
if (env === 'development') require('@/mock')

Vue.use(VueI18n);
Vue.use(iView);

new Vue({
    el: '#app',
    router: router,
    store: store,
    render: h => h(App),
    data: {
        currentPageName: ''
    },
    methods: {
        reload (e) {
            if (e.data.act === 'reload') {
                window.location.reload(true);
            }
        }
    },
    mounted () {
        window.addEventListener('message', this.reload);
    },
    created () {
    },
    dispatch () {
        window.removeEventListener('message', this.reload);
    }
});
