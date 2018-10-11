import {apiPersonMainQueryList} from '../../../../api/sale-person/person-main-query/personMainQueryApi';
import config from '@/config';

const personMainList = {
    state: {
        personMainQueryList: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0, // 总页数
        isSuccess: false,
        msg: '失败'
    },
    actions: {
        handlePersonMainQueryList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiPersonMainQueryList(formQueryData).then(res => {
                    commit('setPersonMainQueryList', res);
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
        setPersonMainQueryList (state, data) {
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.personMainQueryList = data.rows;
            state.isSuccess = data.isSuccess;
            state.msg = data.msg;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default personMainList;
