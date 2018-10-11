import {
    apiQueryTeamEventById3,
    apiw,
    apiQuery5,
    apiData9,
    apiSelByUp
} from '../../../../api/stat-warning/warning-indicatorRanges/indicatorRangesApi.js';
import config from '@/config';
const indicatorRangesEdit = {
    state: {
        tah: [],
        hData: [],
        gData: [],
        gData1: [],
        teamMsg: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        isSuccess: true,
        msg: '',
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handelQueryEventById ({ commit }, queryView) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryTeamEventById3(queryView).then(res => {
                    commit('setVi', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelQuery5 ({ commit }, f) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQuery5(f).then(res => {
                    commit('setTView5', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelData9 ({ commit }, f) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiData9(f).then(res => {
                    commit('setTView9', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelSelByUp ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiSelByUp(formQueryData).then(res => {
                    commit('setIntUp', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleEditS ({ commit }, formQueryData) {
            // data.createTime = formatDate(new Date(), 'yyyy-MM-dd');
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiw(formQueryData).then(res => {
                    commit('setMsg', res);
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
        setTView9 (state, data) {
            state.gData1 = data.result;
        },
        setTView5 (state, data) {
            state.gData = data.result;
        },
        setVi (state, data) {
            state.tah = data.result;
            state.teamEventEditMsg = data.msg;
        },

        setMsg (state, data) {
            state.teamMsg = data.msg;
            state.isSuccess = data.isSuccess;
        },
        sendin (state) {
            state.loading = true;
        },
        setIntUp (state, data) {
            state.msg = data.msg;
            state.isSuccess = data.isSuccess;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default indicatorRangesEdit;
