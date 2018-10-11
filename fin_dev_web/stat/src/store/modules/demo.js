import { apiDemoList } from '@/api/demo';
import config from '@/config';

const demo = {
    state: {
        demoList: [],
        loading: false,
        pageNum: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handleDemoList ({ commit }, formQueryData, pageNum, pageSize) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiDemoList(formQueryData, pageNum, pageSize).then(res => {
                    commit('setDemoList', res);
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
        setDemoList (state, data) {
            state.pageNum = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.demoList = data.rows;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default demo;
