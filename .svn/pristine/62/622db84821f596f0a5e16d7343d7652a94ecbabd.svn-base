import { apiPersonEventList, apiDelPersonEventList } from '../../../../api/sale-person/person-event/personEventApi';
import config from '@/config';

const personEventList = {
    state: {
        personEventListData: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handlePersonEventList ({ commit }, queryPersonEventData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiPersonEventList(queryPersonEventData).then(res => {
                    commit('setPersonEventList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleDelPersonEventList ({ commit }, delTeamEventData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiDelPersonEventList(delTeamEventData).then(res => {
                    commit('setPersonEventDel', res);
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
        setPersonEventList (state, data) {
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.personEventListData = data.rows;
        },
        setPersonEventDel (state, data) {
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.personEventListData = data.rows;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default personEventList;
