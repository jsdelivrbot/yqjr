import {apiQueryPersonReviewList} from '../../../../api/sale-person/person-review/personReviewApi';
import config from '@/config';
import {isEmpty} from '@/libs/util.js';
const personReviewList = {
    state: {
        personReviewListData: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0 // 总页数
    },
    actions: {
        handleQueryPersonReviewList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryPersonReviewList(formQueryData).then(res => {
                    commit('setQueryPersonReviewList', res);
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
        setQueryPersonReviewList (state, data) {
            if (!isEmpty(data)) {
                state.personReviewListData = data.rows;
                state.pageNo = data.page;
                state.total = data.records;
                state.pages = data.total;
            } else {
                state.personReviewListData = [];
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
export default personReviewList;
