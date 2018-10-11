import config from '@/config';
import {apiQueryActiveReviewProList, apiActiveReviewProBrandsList, apiActiveReviewProAreaList} from '../../../../api/sale-active/active-review-progress/activeReviewProgressApi';
const activeReviewProList = {
    state: {
        activeReviewProListData: [],
        activeReviewProListBrandsListData: [],
        activeReviewProListAreaListData: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0 // 总页数
    },
    actions: {
        handleQueryActiveReviewProList ({commit}, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryActiveReviewProList(formQueryData).then(res => {
                    commit('setQueryActiveReviewProList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelActiveReviewProAreaList ({commit}, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveReviewProAreaList(formQueryData).then(res => {
                    commit('setActiveReviewProListAreaList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelActiveReviewProBrandsList ({commit}, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveReviewProBrandsList(formQueryData).then(res => {
                    commit('setActiveReviewProListBrandsList', res);
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
        setQueryActiveReviewProList (state, data) {
            state.activeReviewProListData = data.rows;
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
        },
        setActiveReviewProListAreaList (state, data) {
            state.activeReviewProListAreaListData = data.result;
            state.activeReviewProListAreaListData.splice(1, 1);
        },
        setActiveReviewProListBrandsList (state, data) {
            data.result.unshift({
                'headLetter': '',
                'label': ' 全部',
                'value': ''
            });
            state.activeReviewProListBrandsListData = data.result;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default activeReviewProList;
