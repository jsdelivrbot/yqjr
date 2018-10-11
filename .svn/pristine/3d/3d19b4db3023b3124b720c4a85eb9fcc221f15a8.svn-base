import {apiQueryTeamReviewEditById, apiTeamReviewToSubmit} from '../../../../api/sale-team/team-review/teamReviewApi';
import config from '@/config';
import {formatDate} from '@/libs/util.js';

const teamReviewEdit = {
    state: {
        teamReviewEditData: {},
        teamReviewEditMsg: {},
        isSuccess: true,
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handelQueryTeamReviewEditById ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryTeamReviewEditById(formQueryData).then(res => {
                    commit('setTeamReviewEditData', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelTeamReviewToSubmit ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiTeamReviewToSubmit(formQueryData).then(res => {
                    commit('setTeamReviewToSubmit', res);
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
        setTeamReviewEditData (state, data) {
            if (data.isSuccess) {
                state.teamReviewEditData = data.result;
                state.teamReviewEditData.createTime = formatDate(state.teamReviewEditData.createTime, 'yyyy-MM-dd');
                state.teamReviewEditData.reviewStatus = '04';
                state.teamReviewEditData.opinion = '同意';
            } else {
                state.teamReviewEditMsg = data.msg;
                state.isSuccess = data.isSuccess;
            }
        },
        setTeamReviewToSubmit (state, data) {
            state.teamReviewEditMsg = data.msg;
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
export default teamReviewEdit;
