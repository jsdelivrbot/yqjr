import {
    apiQueryPersonReviewViewById
} from '../../../../api/sale-person/person-review/personReviewApi';
import {
    apiSubPersonReviewProgressData, apiValidatePersonReviewProNature
} from '../../../../api/sale-person/person-review-progress/personReviewProgressApi';
import {formatDate, isEmpty} from '@/libs/util.js';
const personReviewProgressEdit = {
    state: {
        personReviewProgressData: {
            personTeamReviewId: '',
            personCode: '', // 人员代码
            companyCode: '', // 公司代码
            teamCode: '', // 团队代码
            teamName: '', // 团队名称
            areaCode: '', // 区域代码
            areaName: '', // 区域名称
            personNature: '1', // 人员性质（0团队负责人，1销售经理）
            personLevel: '1', // 人员级别
            personStatus: '0', // 人员状态
            personCheckStart: '', // 考核开始时间
            personUptime: '', // 上岗时间
            personCorrectime: '', // 转正时间
            personTryStartime: '', // 试用期开始时间
            personTryEndtime: '', // 试用期结束时间
            personJointime: '', // 加入我司时间
            remark: '', // 备注
            personName: '', // 人员姓名
            personIdcard: '', // 身份证号
            personAge: '', // 年龄
            personEthnic: '', // 民族
            personMarr: '', // 婚姻状况
            personSchool: '', // 毕业学校
            personSubject: '', // 专业
            personEdu: '', // 最高学历
            personEdulevel: '', // 学位
            personWorktime: '', // 工龄
            personFirstworktime: '', // 参加工作时间
            personAddress: '', // 家庭住址
            personHomephone: '', // 家庭电话
            personWorkphone: '', // 工作电话
            personPhone: '', // 移动电话
            personEmail: '', // e-mail
            personBirth: '', // 出生日期
            reviewStatus: '', // 审核状态（00驳回,01提交审核,02待审核,03审核中,04审核通过）
            startTime: '', // 生效时间
            provinces: [], // 负责省份
            cities: [], // 负责城市
            brands: [], // 负责品牌
            TeamMain: '',
            teamMain: '', // 团队信息
            searchPerson: '', // 登录
            company: '',
            reviewType: ''
        },
        loading: false,
        msg: '成功',
        isSuccess: true
    },
    actions: {
        handleSubPersonReviewProgressData ({ commit }, data) {
            // 格式化UTC时间
            data.personCheckStart = formatDate(new Date(data.personCheckStart), 'yyyy-MM-dd');
            data.personUptime = formatDate(new Date(data.personUptime), 'yyyy-MM-dd');
            data.personCorrectime = formatDate(new Date(data.personCorrectime), 'yyyy-MM-dd');
            data.personTryStartime = formatDate(new Date(data.personTryStartime), 'yyyy-MM-dd');
            data.personTryEndtime = formatDate(new Date(data.personTryEndtime), 'yyyy-MM-dd');
            data.personJointime = formatDate(new Date(data.personJointime), 'yyyy-MM-dd');
            data.personFirstworktime = formatDate(new Date(data.personFirstworktime), 'yyyy-MM-dd');
            data.personBirth = formatDate(new Date(data.personBirth), 'yyyy-MM-dd');
            data.startTime = formatDate(new Date(data.startTime), 'yyyy-MM-dd');
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiSubPersonReviewProgressData(data).then((res) => {
                    commit('setSubPersonReviewProgressData', res);
                    commit('success');
                    resolve();
                }).catch((err) => {
                    commit('success');
                    reject(err);
                });
            });
        },
        // handleResetEditPersonData ({ commit }) {
        //     commit('resetEditPersonData');
        // },
        handleQueryPersonReviewProgressData ({ commit }, personCode) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryPersonReviewViewById(personCode).then((res) => {
                    commit('setPersonReviewProgressData', res);
                    commit('success');
                    resolve();
                }).catch((err) => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleValidatePersonReviewProNature ({ commit }, teamCode) {
            return new Promise((resolve, reject) => {
                apiValidatePersonReviewProNature(teamCode).then(res => {
                    commit('setValidatePersonNature', res);
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
        setSubPersonReviewProgressData: function (state, data) {
            state.msg = data.msg;
            state.isSuccess = data.isSuccess;
        },
        setPersonReviewProgressData: function (state, data) {
            state.personReviewProgressData = {
                // personReviewId: data.result.id,
                // personTeamId: data.result.personTeamReview.id,
                personTeamReviewId: data.result.personTeamReview.id,
                personCode: data.result.personCode, // 人员代码
                teamCode: data.result.personTeamReview.teamCode, // 团队代码
                teamName: data.result.teamMain.teamName, // 团队名称
                areaCode: data.result.personTeamReview.areaCode, // 区域代码
                areaName: data.result.teamMain.areaName, // 区域名称
                personNature: data.result.personTeamReview.personNature, // 人员性质（0团队负责人，1销售经理）
                personLevel: data.result.personTeamReview.personLevel, // 人员级别
                personStatus: data.result.personTeamReview.personStatus, // 人员状态
                personCheckStart: formatDate(new Date(data.result.personTeamReview.personCheckStart), 'yyyy-MM-dd'), // 考核开始时间
                personUptime: formatDate(new Date(data.result.personTeamReview.personUptime), 'yyyy-MM-dd'), // 上岗时间
                personCorrectime: formatDate(new Date(data.result.personTeamReview.personCorrectime), 'yyyy-MM-dd'), // 转正时间
                personTryStartime: formatDate(new Date(data.result.personTeamReview.personTryStartime), 'yyyy-MM-dd'), // 试用期开始时间
                personTryEndtime: formatDate(new Date(data.result.personTeamReview.personTryEndtime), 'yyyy-MM-dd'), // 试用期结束时间
                personJointime: formatDate(new Date(data.result.personTeamReview.personJointime), 'yyyy-MM-dd'), // 加入我司时间
                remark: data.result.remark, // 备注
                personName: data.result.personName, // 人员姓名
                personIdcard: data.result.personIdcard, // 身份证号
                personAge: data.result.personAge, // 年龄
                personEthnic: data.result.personEthnic, // 民族
                personMarr: data.result.personMarr, // 婚姻状况
                personSchool: data.result.personSchool, // 毕业学校
                personSubject: data.result.personSubject, // 专业
                personEdu: data.result.personEdu, // 最高学历
                personEdulevel: data.result.personEdulevel, // 学位
                personWorktime: data.result.personWorktime, // 工龄
                personFirstworktime: formatDate(new Date(data.result.personFirstworktime), 'yyyy-MM-dd'), // 参加工作时间
                personAddress: data.result.personAddress, // 家庭住址
                personHomephone: data.result.personHomephone, // 家庭电话
                personWorkphone: data.result.personWorkphone, // 工作电话
                personPhone: data.result.personPhone, // 移动电话
                personEmail: data.result.personEmail, // e-mail
                personBirth: formatDate(new Date(data.result.personBirth), 'yyyy-MM-dd'), // 出生日期
                startTime: data.result.startTime, // 生效时间
                provinces: [], // 负责省份
                cities: [], // 负责城市
                brands: [], // 负责品
                reviewType: data.result.personTeamReview.reviewType
            };
            if (!isEmpty(data.result.personBrandReview.brandCode)) {
                state.personReviewProgressData.brands = data.result.personBrandReview.brandCode.split(',');
            }
            if (!isEmpty(data.result.personCityReview.cityCode)) {
                state.personReviewProgressData.cities = data.result.personCityReview.cityCode.split(',');
            }
            if (!isEmpty(data.result.personCityReview.provinceCode)) {
                state.personReviewProgressData.provinces = data.result.personCityReview.provinceCode.split(',');
            }
        },
        setValidatePersonNature (state, data) {
            state.msg = data.msg;
            state.isSuccess = data.isSuccess;
        },
        sendin (state, reqParam) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default personReviewProgressEdit;
