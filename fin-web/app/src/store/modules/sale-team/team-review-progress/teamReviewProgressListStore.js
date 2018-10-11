import {apiQueryTeamReviewProList} from '../../../../api/sale-team/team-review-progress/teamReviewProgressApi';
import config from '@/config';
import {isEmpty} from '@/libs/util.js';
const teamReviewProList = {
    state: {
        teamReviewProListData: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0 // 总页数
    },
    actions: {
        handleQueryTeamReviewProList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryTeamReviewProList(formQueryData).then(res => {
                    commit('setQueryTeamReviewProList', res);
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
        setQueryTeamReviewProList (state, data) {
            if (!isEmpty(data)) {
                state.teamReviewProListData = data.rows;
                state.pageNo = data.page;
                state.total = data.records;
                state.pages = data.total;
            } else {
                state.teamReviewProListData = [];
                state.pageNo = data.page;
                state.total = data.records;
                state.pages = data.total;
            }
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default teamReviewProList;
