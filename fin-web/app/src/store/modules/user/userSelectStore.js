import {apiUserList, apiDelUser} from '../../../api/user/userApi';
import config from '@/config';

const userList = {
    state: {
        userList: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handleUserList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiUserList(formQueryData).then(res => {
                    commit('setUserList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleDelUser ({ commit }, delTeamEventData) {
            commit('setDel');
            return new Promise((resolve, reject) => {
                apiDelUser(delTeamEventData).then(res => {
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        }
    },
    mutations: {
        setUserList (state, data) {
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.userList = data.rows;
        },
        setDel (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default userList;
