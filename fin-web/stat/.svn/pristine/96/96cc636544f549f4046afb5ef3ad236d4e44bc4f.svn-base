import config from '@/config';
import {apiSearchDateList} from '../../../../api/sale-active/active-review/activeReviewListApi';

const activeReviewList = {
    state: {
        loading: false,
        pageNo: 1,
        pageSize: config.pageSize,
        activeReviewListData: [],
        total: 0, // 总页数
        records: 0 // 总记录数
    },
    actions: {
        /**
         * 分页查询
         * @param commit
         * @param data
         * @returns {Promise<any>}
         */
        handleActiveReviewList ({commit}, data) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiSearchDateList(data).then(res => {
                    commit('setDataList', res);
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
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        },
        setDataList (state, res) {
            state.pageNo = res.page;
            state.activeReviewListData = res.rows;
            state.records = res.records;
            state.total = res.total;
        }
    }
};
export default activeReviewList;
