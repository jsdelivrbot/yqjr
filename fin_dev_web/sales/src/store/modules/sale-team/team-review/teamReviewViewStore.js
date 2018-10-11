import {
    apiQueryTeamReviewEditWork,
    apiQueryTeamReviewViewById
} from '../../../../api/sale-team/team-review/teamReviewApi';
import config from '@/config';
import {formatDate} from '@/libs/util.js';

const teamReviewView = {
    state: {
        teamReviewViewData: [],
        teamReviewViewResult: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handelQueryTeamReviewViewById ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryTeamReviewViewById(formQueryData).then(res => {
                    commit('teamReviewViewData', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelQueryTeamReviewEditWork ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryTeamReviewEditWork(formQueryData).then(res => {
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
        teamReviewViewData (state, data) {
            state.teamReviewViewData = data.result;
            state.teamReviewViewData.createTime = formatDate(state.teamReviewViewData.createTime, 'yyyy-MM-dd');
            state.teamReviewViewData.startTime = formatDate(state.teamReviewViewData.startTime, 'yyyy-MM-dd');
        },
        setTeamReviewViewWork (state, data) {
            // console.log(data)
            state.teamReviewViewResult = data.rows;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default teamReviewView;
