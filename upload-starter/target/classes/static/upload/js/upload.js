VUe.component(
    "upload",{
        props:["url","accept","width"],
        data(){
            return{
                resData:{}
            };
        },
        template:`
        <span>
        <input type="file" ref="file" style="display: none"
        @change="upload" :accept="accept">
        <button @clicke="$refs.file.click()">上传</button>
        <span v-if="resData.data">
         <img src="resData.data" v-if="accept.indexof('image')==0" :style={width:width}>
        <a href="resData.data" v-else>{{resData.data}}</a>
</span>
       
</span>`,
        method:{
            upload(){
                let fd=new FormData();
                for (let i = 0; i < this.$refs.file.files.length; i++) {
                    fd.append("file",this.$refs.file.files[i]);
                }
                // this.$refs.file.files.forEach(file=>{
                //     fd.append("file",file);
                // });
                axios.post(this.url,fd).then(res=>{
                    if(Array.isArray(res.data)){
                        //TODO 多文件上传
                    }else if(res.data.code){
                        alert("文件上传成功!=>"+res.data.data);
                        this.resData=res.data;
                    }else{
                        alert("文件上传失败");
                    }
                })
            }
        }
    }
)