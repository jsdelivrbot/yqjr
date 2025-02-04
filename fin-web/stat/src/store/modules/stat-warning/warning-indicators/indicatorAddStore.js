import { apiTeamAddToReview, apiITy, apiSelIndicator, apiCom } from '../../../../api/stat-warning/warning-indicators/indicatorsApi.js';
import config from '@/config';
import {formatDate} from '@/libs/util.js';

const indicatorAdd = {
    state: {
        teamAddData: [],
        itypes: [],
        com: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize:
        config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0, // 总页数
        isSuccess: true,
        msg: ''
    },
    actions: {
        handleTeamAddToRev ({ commit }, formQueryData) {
            commit('sendin');
            // formQueryData.startTime = formatDate(formQueryData.startTime, 'yyyy-MM-dd');
            // console.log(formQueryData.startTime);
            return new Promise((resolve, reject) => {
                apiTeamAddToReview(formQueryData).then(res => {
                    commit('setTeamAddData', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelSelIndicator ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiSelIndicator(formQueryData).then(res => {
                    commit('setIn', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleITy ({ commit }) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiITy().then(res => {
                    commit('setityps', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelCom ({ commit }, f) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiCom(f).then(res => {
                    commit('setCom', res);
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
        setityps (state, data) {
            state.itypes = data;
        },
        setCom (state, data) {
            state.com = data.result;
        },
        setIn (state, data) {
            state.msg = data.msg;
            state.isSuccess = data.isSuccess;
        },
        setTeamAddData (state, data) {
            state.teamAddData = data.msg;
            state.isSuccess = data.isSuccess;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default indicatorAdd;
