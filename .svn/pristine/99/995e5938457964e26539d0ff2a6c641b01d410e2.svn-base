/* eslint-disable no-undef,no-unused-vars,no-console */
import Cookies from 'js-cookie';
import { login } from '@/api/user';
import config from '../../config';
import { setToken, getToken, setUser } from '@/libs/util';
const user = {
    state: {
        token: getToken()
    },
    // 只修改state
    mutations: {
        logout (state, vm) {
            Cookies.remove('user');
            Cookies.remove('token');
            Cookies.remove('access');
            Cookies.remove('date');
            // 恢复默认样式
            let themeLink = document.querySelector('link[name="theme"]');
            themeLink.setAttribute('href', '');
            // 清空打开的页面等数据，但是保存主题数据
            let theme = '';
            if (localStorage.theme) {
                theme = localStorage.theme;
            }
            localStorage.clear();
            if (theme) {
                localStorage.theme = theme;
            }
        },
        setToken (state, token) {
            state.token = token;
            setToken(token);
        }
    },
    actions: {
        // 登录
        handleLogin: function ({commit}, {loginName, password}) {
            return new Promise((resolve, reject) => {
                login({
                    loginName,
                    password
                }).then(res => {
                    if (res.code === '0000') {
                        Cookies.remove('date');
                        Cookies.set('user', res.result.user);
                        Cookies.set('token', res.result.token);
                        // setUser(res.result.user);
                        var date = new Date();
                        date.setTime(date.getTime() + 3 * 60 * 60 * 1000);
                        Cookies.set('date', Number(date));
                        commit('setToken', res.result.token);
                    }

                    resolve();
                }).catch(err => {
                    reject(err);
                });
            });
        }
    }
};

export default user;
