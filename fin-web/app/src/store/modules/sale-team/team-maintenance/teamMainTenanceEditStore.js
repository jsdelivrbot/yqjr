import {
    apiQueryTeamById,
    apiSubmitToReview,
    apiValidateTeamName
} from '../../../../api/sale-team/team-maintenance/teamMainTenanceApi';
import config from '@/config';
import {formatDate} from '@/libs/util.js';

const teamEdit = {
    state: {
        teamEditData: {},
        teamName: '',
        teamEditMsg: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        isSuccess: true,
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handelQueryTeamById ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryTeamById(formQueryData).then(res => {
                    commit('setTeamData', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleTeamEditSubToRev ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiSubmitToReview(formQueryData).then(res => {
                    commit('setTeamMsg', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleValidateTeamNameEdit ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiValidateTeamName(formQueryData).then(res => {
                    commit('setValidateTeamName', res);
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
        setTeamData (state, data) {
            state.teamEditData = data.rows[0];
            state.teamEditData.createTime = formatDate(state.teamEditData.createTime, 'yyyy-MM-dd');
            state.teamName = state.teamEditData.teamName;
        },
        setTeamMsg (state, data) {
            state.teamEditMsg = data.msg;
            state.isSuccess = data.isSuccess;
        },
        setValidateTeamName (state, data) {
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
export default teamEdit;
