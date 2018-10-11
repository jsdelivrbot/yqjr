import { apiQueryTeamById, apiSubmitToReview, apiSelByUpd } from '../../../../api/stat-warning/warning-indicators/indicatorsApi.js';
import config from '@/config';
const indicatorEdit = {
    state: {
        teamEditData: [],
        teamEditMsg: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        isSuccess: true,
        msg: '',
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handelQueryTeamById ({ commit }, formData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryTeamById(formData).then(res => {
                    commit('sData', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelSelByUpd ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiSelByUpd(formQueryData).then(res => {
                    commit('setInU', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleTeamEditSubToRev ({ commit }, data) {
            // data.createTime = formatDate(new Date(), 'yyyy-MM-dd');
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiSubmitToReview(data).then(res => {
                    commit('setTeamMsg', res);
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
        sData (state, data) {
            state.teamEditData = data.result;
            state.teamEditMsg = data.msg;
        },
        setTeamMsg (state, data) {
            state.teamEditMsg = data.msg;
            state.isSuccess = data.isSuccess;
        },
        sendin (state) {
            state.loading = true;
        },
        setInU (state, data) {
            state.msg = data.msg;
            state.isSuccess = data.isSuccess;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default indicatorEdit;
