<template>
    <div>
        <Row style="margin:0;" id="show-iframe-wrap">
            <iframe :src="src" id="show-iframe" frameborder="no" border="0"marginwidth="0" marginheight="0" scrolling="auto" width="100%" height="100%" ></iframe>
        </Row>
    </div>
</template>
<style>
    #show-iframe-wrap{
        width:100%;
        position: relative;
        overflow-x:hidden;
    }
    #show-iframe{
        width:100%;
        position: absolute;
        left:0;
        top:0;
        display: block;
        overflow:auto;
    }
</style>

<script>
    export default {
        name: 'ifream',
        data () {
            return {
                src: ''
            };
        },
        methods: {
            showUrl () {
                let pathName = this.$route.params.pathName;
                this.$store.state.app.menuList.filter(item => {
                    if (item.children.length === 1) {
                        this.src = item.path;
                    } else {
                        item.children.forEach(child => {
                            if (child.name === pathName) {
                                this.src = child.path;
                            }
                        });
                    }
                });
            },
            init () {
                this.showUrl();
                this.setPageParent();
            },
            resize (e) {
                // if (e.data.act === 'resize') {}
            },
            // 页面初始化 设置div：show-iframe-wrap 的宽高
            // div：show-iframe-wrap的宽度：最外层宽度 - 左边导航的宽度（270）
            // div：show-iframe-wrap的高度：最外层高度 - 上边导航的高度（100）
            setPageParent () {
                if (document.getElementById('leftNav') !== null) {
                    var leftNavWidth = document.getElementById('leftNav').style.width;
                    leftNavWidth = leftNavWidth.substr(0, leftNavWidth.length - 2);
                }
                var grandParentHeight = document.getElementById('grandParent').offsetHeight;
                var grandParentWidth = document.getElementById('grandParent').offsetWidth;
                document.getElementById('show-iframe-wrap').style.height = grandParentHeight - 100 + 'px';
                document.getElementById('show-iframe-wrap').style.width = grandParentWidth - leftNavWidth + 'px';
            },
            setIframe (e) {
                // if (e.data.act === 'top') {}
            }
        },
        watch: {
            '$route' (to) {
                this.showUrl();
            }
        },
        mounted () {
            this.init();
            window.addEventListener('message', this.resize);
            window.addEventListener('message', this.setIframe);
        },
        dispatch () {
            window.removeEventListener('message', this.resize);
            window.removeEventListener('message', this.setIframe);
        }
    };
</script>