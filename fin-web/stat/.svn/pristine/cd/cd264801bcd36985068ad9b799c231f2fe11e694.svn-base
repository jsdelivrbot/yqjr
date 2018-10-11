/* eslint-disable no-console,no-unused-vars */
import {apiList, apiDelete, apiPause, apiResume, apiRunOnce} from '../../../../api/stat-systemManagement/timeSettingApi';
import config from '@/config';

const timeSettingList = {
    state: {
        timeSettingList: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0, // 总页数
        msg: []
    },

    actions: {
        getTimeSettingList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiList(formQueryData).then(res => {
                    commit('setList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        delTimeSetting ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiDelete(formQueryData).then(res => {
                    commit('setTeamDel', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        pauseTimeSetting ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiPause(formQueryData).then(res => {
                    commit('setTeamDel', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        resumeTimeSetting ({ commit }, formQueryData) {
            console.log('+-++++');
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiResume(formQueryData).then(res => {
                    commit('setTeamDel', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        runOnceTimeSetting ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiRunOnce(formQueryData).then(res => {
                    commit('setTeamDel', res);
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
        setList (state, data) {
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.timeSettingList = data.rows;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default timeSettingList;
