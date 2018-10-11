import {apiQueryPersonReviewProgressList} from '../../../../api/sale-person/person-review-progress/personReviewProgressApi';
import config from '@/config';
const personReviewProgressList = {
    state: {
        personReviewProgressData: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0 // 总页数
    },
    actions: {
        handleQueryPersonReviewProgressList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryPersonReviewProgressList(formQueryData).then(res => {
                    commit('setQueryPersonReviewProgressList', res);
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
        setQueryPersonReviewProgressList (state, data) {
            state.personReviewProgressData = data.rows;
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default personReviewProgressList;
