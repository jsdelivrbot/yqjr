import {apiQueryTeamReviewList} from '../../../../api/sale-team/team-review/teamReviewApi';
import config from '@/config';
import {isEmpty, formatDate} from '@/libs/util.js';
const teamReviewList = {
    state: {
        teamReviewListData: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0 // 总页数
    },
    actions: {
        handleQueryTeamReviewList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryTeamReviewList(formQueryData).then(res => {
                    commit('setQueryTeamReviewList', res);
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
        setQueryTeamReviewList (state, data) {
            if (!isEmpty(data)) {
                state.teamReviewListData = data.rows;
                state.teamReviewListData.createTime = formatDate(state.teamReviewListData.createTime, 'yyyy-MM-dd');
                state.pageNo = data.page;
                state.total = data.records;
                state.pages = data.total;
            } else {
                state.teamReviewListData = [];
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
export default teamReviewList;
