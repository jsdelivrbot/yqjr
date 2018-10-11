import { apiQueryPersonEventById } from '../../../../api/sale-person/person-event/personEventApi';

const personEventView = {
    state: {
        personEventViewData: {},
        loading: false
    },
    actions: {
        handelQueryPersonEventById ({ commit }, queryPersonEventView) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryPersonEventById(queryPersonEventView).then(res => {
                    commit('setPersonEventView', res);
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
        setPersonEventView (state, data) {
            state.personEventViewData = data.rows[0];
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default personEventView;
