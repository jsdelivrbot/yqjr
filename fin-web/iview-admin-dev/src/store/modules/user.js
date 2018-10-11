/* eslint-disable no-undef */
import Cookies from 'js-cookie';
import { login } from '@/api/user';
import { setToken, getToken, setUser } from '@/libs/util';
const user = {
    state: {
        token: getToken()
    },
    // 只修改state
    mutations: {
        logout (state, vm) {
            Cookies.remove('user');
            Cookies.remove('password');
            Cookies.remove('access');
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
        handleLogin ({ commit }, {loginName, password}) {
            return new Promise((resolve, reject) => {
                login({
                    loginName,
                    password
                }).then(res => {
                    const data = res.data;
                    Cookies.set('user', res.result.user);
                    Cookies.set('token', res.result.token);
                    // setUser(res.result.user);
                    commit('setToken', res.result.token);
                    resolve();
                }).catch(err => {
                    reject(err);
                });
            });
        }
    }
};

export default user;
