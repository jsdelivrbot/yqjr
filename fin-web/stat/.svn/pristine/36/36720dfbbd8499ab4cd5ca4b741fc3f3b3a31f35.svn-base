import {apiquerycomwarningByEventid} from '../../../../api/stat-warning/warning-warningAuditing/warningAuditingApi.js';

const warningAuditingTabList = {
    state: {
        cTabList: [],
        loading: false
    },
    actions: {
        querycomwarningByEventidSto ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiquerycomwarningByEventid(formQueryData).then(res => {
                    commit('setList', res);
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
        setList (state, data) {
            state.cTabList = data.rows;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }

};
export default warningAuditingTabList;
