import { apiQueryTeamReviewProViewById, apiTeamReviewProToSubmit } from '../../../../api/sale-team/team-review-progress/teamReviewProgressApi';
import config from '@/config';
import {formatDate} from '@/libs/util.js';

const teamReviewProEdit = {
    state: {
        teamReviewProEditData: {},
        teamReviewProMsg: [],
        isSuccess: true,
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handelQueryTeamReviewProViewById ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryTeamReviewProViewById(formQueryData).then(res => {
                    commit('setTeamReviewProEditData', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelTeamReviewProToSubmit ({ commit }, formQueryData) {
            commit('sendin');
            formQueryData.startTime = formatDate(formQueryData.startTime, 'yyyy-MM-dd');
            return new Promise((resolve, reject) => {
                apiTeamReviewProToSubmit(formQueryData).then(res => {
                    commit('setTeamReviewProMsg', res);
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
        setTeamReviewProEditData (state, data) {
            state.teamReviewProEditData = data.result;
            state.isSuccess = data.isSuccess;
            state.teamReviewProEditData.createTime = formatDate(state.teamReviewProEditData.createTime, 'yyyy-MM-dd');
        },
        setTeamReviewProMsg (state, data) {
            state.teamReviewProMsg = data.msg;
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
export default teamReviewProEdit;
