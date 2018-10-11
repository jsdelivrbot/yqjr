import config from '@/config';
import {apiPersonList} from '../../../../api/sale-person/person-maintenance/personMaintenanceApi';

const personList = {
    state: {
        personList: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handlePersonList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiPersonList(formQueryData).then((res) => {
                    commit('setPersonList', res);
                    commit('success');
                    resolve();
                }).catch((err) => {
                    commit('success');
                    reject(err);
                });
            });
        }
    },
    mutations: {
        setPersonList (state, data) {
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.personList = data.rows;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default personList;
