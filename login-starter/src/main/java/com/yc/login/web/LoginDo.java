package com.yc.login.web;

import com.yc.login.bean.BizException;
import com.yc.login.bean.LoginProperties;
import com.yc.login.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("login")
public class LoginDo {
    @Resource
    LoginProperties properties;
    @GetMapping("props")
    LoginProperties getProperties(){
        return properties;
    }
    @Resource
    JdbcTemplate jdbcTemplate;

    @RequestMapping("login")
    Result login(String name, String pwd, HttpSession session) throws BizException{
        if(name==null||name.trim().isEmpty()){
            throw new BizException("请填写用户名");
        }
        if(pwd==null||pwd.trim().isEmpty()){
            throw new BizException("请填写密码");
        }

        String sql="select * from %s where %s=? and %s=?";
        sql=String.format(sql, properties.getTableUser(),properties.getColumnName(),properties.getColumnPwd());
        Class cls;
        try {
            cls=Class.forName(properties.getUserClassName());
        } catch (ClassNotFoundException e) {
            throw new BizException("用户类路径配置错误"+properties.getUserClassName());
        }
        final List list=jdbcTemplate.query(sql,new BeanPropertyRowMapper(cls),name,pwd);
        if(list==null||list.isEmpty()){
            throw new BizException("用户名或密码错误");
        }else if(list.size()>1){
            throw new BizException("用户表数据错误，请联系管理员！！");
        }else {
            session.setAttribute("loginedUser",list.get(0));
            return new Result(1, "登陆成功",list.get(0));
        }
    }

    @RequestMapping("logout")
    Result logout(HttpSession session){
        session.invalidate();
        return new Result(1, "退出成功",null);
    }

    @RequestMapping("myinfo")
    Result myinfo(HttpSession session){
        final Object loginedUser = session.getAttribute("loginedUser");
        if(loginedUser==null){
           return new Result(0, "未登录",loginedUser);
        }else{
            return new Result(1, "已登陆",loginedUser);
        }
    }

    @RequestMapping("")
    public ModelAndView toLoginIndex(ModelAndView modelAndView){
        modelAndView.setViewName("redirect:/login/index.html");
        return  modelAndView;
    }
    @ExceptionHandler(BizException.class)
    Result handleBizException(BizException e){
        return new Result(0, e.getMessage(), null);
    }
}
