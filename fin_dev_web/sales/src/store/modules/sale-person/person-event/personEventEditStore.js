import { apiQueryPersonEventById, apiPersonEventEditSubToRev } from '../../../../api/sale-person/person-event/personEventApi';

const personEventEdit = {
    state: {
        personEventEditData: [],
        isSuccess: false,
        msg: '失败'
    },
    actions: {
        handelQueryPersonEventById ({ commit }, queryPersonEventEdit) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryPersonEventById(queryPersonEventEdit).then(res => {
                    commit('setPersonEventEdit', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handlePersonEventEditSubToRev ({ commit }, subPersonEventEdit) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiPersonEventEditSubToRev(subPersonEventEdit).then(res => {
                    commit('setPersonEventMsg', res);
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
        setPersonEventEdit (state, data) {
            state.personEventEditData = data.rows[0];
            state.msg = data.msg;
            state.isSuccess = data.isSuccess;
        },
        setPersonEventMsg (state, data) {
            state.msg = data.msg;
            state.isSuccess = data.isSuccess;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default personEventEdit;
