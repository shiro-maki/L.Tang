Vue.component("login",{
    props:{
        prefix : {
            type : String,
            default: ""
        },
    },
    data(){
        return {
            dialogFormVisible: false,
            formLabelWidth: 100,
            form:{ name:'', pwd:''},
            user: null,
            props: null,
            vcode: null
        }
    },
    template:`
        <div>
            <span v-if="user">
                <span>欢迎{{user[props.columnName]}}</span>
                <a href="">修改密码</a>
                <a href="" @click.prevent="logout">退出</a>
            </span>
            <span v-else>
                <a href="" @click.prevent="dialogFormVisible = true">登录</a>
                <a href="">注册</a>
            </span>
            <el-dialog title="登录窗口" :visible.sync="dialogFormVisible">
              <el-form :model="form">
                <el-form-item label="账号" :label-width="formLabelWidth">
                  <el-input v-model="form.name" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="密码" :label-width="formLabelWidth">
                  <el-input v-model="form.pwd" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="验证码" :label-width="formLabelWidth">
                  <el-input v-model="form.vcode" autocomplete="off"></el-input>
                  <img src="/vcode/image" alt="">
                </el-form-item>
              </el-form>
              <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="login">登 录</el-button>
              </div>
            </el-dialog>
        </div>
    `,
    created(){
        axios.get(this.prefix + "/login/props").then(res=>{
            this.props = res.data;
            axios.get(this.prefix + "/login/myinfo").then(res=>{
                if(res.data.code){
                    this.user = res.data.data;
                } else {
                    this.user = null;
                }
                this.$emit("change", this.user);
            });
        });
    },
    methods:{
        login(){
            var p = new URLSearchParams();
            p.append("name",this.form.name);
            p.append("pwd", this.form.pwd);
            p.append("vcode", this.form.vcode);
            axios.post(this.prefix + "/login/login", p).then(res=>{
                if(res.data.code){
                    this.user = res.data.data;
                    this.$message(res.data.msg);
                    this.dialogFormVisible = false;
                } else {
                    this.$alert(res.data.msg);
                }
            })
        },
        logout(){
            axios.get(this.prefix + "/login/logout").then(res=>{
                this.$message(res.data.msg);
                this.user = null;
            });
        }
    }
})