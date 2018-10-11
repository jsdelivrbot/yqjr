import {apiUploadExcel} from '../../../../api/sale-plan/sale-plan-upload/salePlanUploadAddApi';

const salePlanUploadAdd = {
    state: {
        loading: false,
        returnMsg: '',
        isSuccess: true
    },
    actions: {
        handleUploadExcel ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiUploadExcel(formQueryData).then(res => {
                    commit('setUploadExcel', res);
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
        setUploadExcel (state, data) {
            state.returnMsg = data.code;
            state.isSuccess = data.isSuccess;
        }
    }
};
export default salePlanUploadAdd;
