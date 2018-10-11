import {apiQueryActiveDetailsByCode} from '../../../../api/sale-fee/fee-main/feeMainApi';
import config from '@/config';

const activeDetailsList = {
    state: {
        activeDetailsListData: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handleQueryActiveDetailsByCode ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryActiveDetailsByCode(formQueryData).then(res => {
                    commit('setActiveDetailsList', res);
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
        setActiveDetailsList (state, data) {
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.activeDetailsListData = data.rows;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default activeDetailsList;
