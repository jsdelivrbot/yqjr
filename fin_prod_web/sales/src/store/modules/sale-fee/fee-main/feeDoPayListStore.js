import {apiQueryFeeDoPayList} from '../../../../api/sale-fee/fee-main/feeMainApi';
import config from '@/config';
import {formatDate} from '@/libs/util.js';

const feeDoPayList = {
    state: {
        feeDoPayListData: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handleQueryFeeDoPayList ({ commit }, formQueryData) {
            if (formQueryData.activeStartime !== '') {
                formQueryData.activeStartime = formatDate(formQueryData.activeStartime, 'yyyy-MM-dd');
            }
            if (formQueryData.activeEndtime !== '') {
                formQueryData.activeEndtime = formatDate(formQueryData.activeEndtime, 'yyyy-MM-dd');
            }
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryFeeDoPayList(formQueryData).then(res => {
                    commit('setQueryFeeDoPayList', res);
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
        setQueryFeeDoPayList (state, data) {
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.feeDoPayListData = data.rows;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default feeDoPayList;
