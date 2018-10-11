import {apiActiveMainList} from '../../../../api/sale-active/active-main/activeMainApi';
import config from '@/config';

const activeMainList = {
    state: {
        activeMainListData: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handleActiveMainList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiActiveMainList(formQueryData).then(res => {
                    commit('setActiveMainList', res);
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
        setActiveMainList (state, data) {
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.activeMainListData = data.rows;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default activeMainList;
