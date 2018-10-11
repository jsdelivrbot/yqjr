<style lang="less">
    @import '../../../styles/common.less';
</style>
<template>
    <div style="height: 100%; background: #fff">
        <Row>
            <Form :label-width="100" >
                <Card >
                    <p slot="title">
                        <Icon type="edit"></Icon>
                        销售计划上传
                    </p>
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="计划上传:" enctype="multipart/form-data">
                                <Upload :before-upload="handleUpload"
                                        :on-success="uploadSuccess"
                                        :on-error="uploadError"
                                        :show-upload-list="false" action="/mkmm/sales/personPlans/fileUpload">
                                    <Button type="ghost" icon="ios-cloud-upload-outline">请选择上传</Button>
                                </Upload>
                                <div v-if="file !== null && file.name.endsWith('.xls')">文件名称: {{ file.name }} <Button type="text"  :loading="loadingStatus">{{ loadingStatus ? '上传中' : '上传中...' }}</Button></div>
                                <div v-else-if="file !== null && !file.name.endsWith('.xls')"><span style="color: red">文件类型错误</span></div>
                            </FormItem>
                        </Col>
                        <Col span="4">
                            <Button icon="button" @click="downloadTemplet">模板下载</Button>
                        </Col>
                    </Row>
                </Card>
            </Form>
        </Row>
    </div>
</template>

<script>
    import {mapActions, mapState} from 'vuex';
    export default {
        name: 'salePlanUploadAdd',
        data () {
            return {
                file: null,
                loadingStatus: false
            };
        },
        computed: {
            ...mapState({
                loading: ({salePlanUploadAdd}) => salePlanUploadAdd.loading,
                isSuccess: ({salePlanUploadAdd}) => salePlanUploadAdd.isSuccess,
                uploadMsg: ({salePlanUploadAdd}) => salePlanUploadAdd.returnMsg
            })
        },
        methods: {
            ...mapActions([
                'handleUploadExcel'
            ]),
            handleUpload (file) {
                this.file = file;
                return true;
            },
            uploadSuccess (response, file) {
                // alert(11111);
                this.file = null;

                if (response.isSuccess) {
                    this.$Modal.success({
                        title: '上传',
                        content: '上传成功',
                        onOk: () => {
                            window.location.reload();
                        }
                    });
                } else {
                    this.$Modal.error({
                        title: '上传',
                        content: response.msg,
                        onOk: () => {
                            window.location.reload();
                        }
                    });
                }
            },
            uploadError () {
                this.$Modal.warning({
                    title: '上传',
                    content: '上传失败',
                    onOk: () => {
                        window.location.reload();
                    }
                });
            },
            // upload () {
            //     this.handleUploadExcel(this.file).then(res => {
            //         if (this.isSuccess) {
            //             this.loadingStatus = true;
            //         }
            //     });
            //     // setTimeout(() => {
            //     //     this.file = null;
            //     //     this.loadingStatus = false;
            //     //     this.$Message.success('Success');
            //     // }, 1500);
            // },
            downloadTemplet () {
                window.location = '/mkmm/sales/personPlans/createTemplate';
            }
        }
    };
</script>

<style scoped>

</style>