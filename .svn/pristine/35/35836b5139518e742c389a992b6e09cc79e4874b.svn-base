import {apiQueryFeeReviewProgressList} from '../../../../api/sale-fee/fee-review-progress/feeReviewProgressApi';
import config from '@/config';

const feeReviewProgressList = {
    state: {
        feeReviewListProData: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handleQueryFeeReviewProgressList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryFeeReviewProgressList(formQueryData).then(res => {
                    commit('setQueryFeeReviewProgressList', res);
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
        setQueryFeeReviewProgressList (state, data) {
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.feeReviewListProData = data.rows;
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
export default feeReviewProgressList;
