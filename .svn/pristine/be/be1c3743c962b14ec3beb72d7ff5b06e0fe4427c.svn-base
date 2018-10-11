import {apiQueryFeeReviewList} from '../../../../api/sale-fee/fee-review/feeReviewApi';
import config from '@/config';

const feeReviewList = {
    state: {
        feeReviewListData: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handleQueryFeeReviewList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryFeeReviewList(formQueryData).then(res => {
                    commit('setQueryFeeReviewList', res);
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
        setQueryFeeReviewList (state, data) {
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.feeReviewListData = data.rows;
            // console.log(state.feeReviewListData)
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default feeReviewList;
