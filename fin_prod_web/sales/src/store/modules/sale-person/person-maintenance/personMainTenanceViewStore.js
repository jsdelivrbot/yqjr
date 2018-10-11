import {apiQueryPersonById} from '../../../../api/sale-person/person-maintenance/personMaintenanceApi';
import {isEmpty} from '@/libs/util.js';
const personView = {
    state: {
        loading: false,
        personData: {
            personTeam: {},
            teamMain: {},
            personCity: {
                personCode: [],
                provinceCode: []
            },
            personBrand: {
                brandCode: []
            }
        }
    },
    actions: {
        handleQueryPersonById ({ commit }, personId) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryPersonById(personId).then((res) => {
                    commit('setPersonData', res);
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
        setPersonData (state, data) {
            for (var item in data.result) {
                state.personData[item] = data.result[item];
            }
            if (!isEmpty(data.result.personBrand) && !isEmpty(data.result.personBrand.brandCode)) {
                state.personData.personBrand.brandCode = data.result.personBrand.brandCode.split(',');
            } else {
                state.personData.personBrand.brandCode = [];
            }
            if (!isEmpty(data.result.personCity) && !isEmpty(data.result.personCity.cityCode)) {
                state.personData.personCity.cityCode = data.result.personCity.cityCode.split(',');
            } else {
                state.personData.personCity.cityCode = [];
            }
            if (!isEmpty(data.result.personCity) && !isEmpty(data.result.personCity.provinceCode)) {
                state.personData.personCity.provinceCode = data.result.personCity.provinceCode.split(',');
            } else {
                state.personData.personCity.provinceCode = [];
            }
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default personView;
