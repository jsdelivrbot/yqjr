import {apiTeamList, apiwarningDelete} from '../../../../api/stat-warning/warning-targettype/warningTargettypeApi';
import config from '@/config';

const warningList = {
    state: {
        warningList: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0, // 总页数
        msg: []
    },
    actions: {
        aTargettypeList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiTeamList(formQueryData).then(res => {
                    commit('setTeamList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        warningDeleteSto ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiwarningDelete(formQueryData).then(res => {
                    commit('setTeamDel', res);
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
        setTeamList (state, data) {
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.warningList = data.rows;
        },
        setTeamDel (state, data) {
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.warningList = data.rows;
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
export default warningList;
