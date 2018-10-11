import {
    apiQueryTeamReviewProViewById,
    apiQueryTeamReviewProWork
} from '../../../../api/sale-team/team-review-progress/teamReviewProgressApi';
import config from '@/config';
import {formatDate} from '@/libs/util.js';

const teamReviewProView = {
    state: {
        teamReviewProViewData: [],
        teamReviewProViewResult: [],
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
                    commit('setTeamReviewProViewData', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelQueryTeamReviewProWork ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryTeamReviewProWork(formQueryData).then(res => {
                    commit('setTeamReviewViewWork', res);
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
        setTeamReviewProViewData (state, data) {
            state.teamReviewProViewData = data.result;
            state.teamReviewProViewData.createTime = formatDate(state.teamReviewProViewData.createTime, 'yyyy-MM-dd');
        },
        setTeamReviewViewWork (state, data) {
            // console.log(data)
            state.teamReviewProViewResult = data.rows;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default teamReviewProView;
