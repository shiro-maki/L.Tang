package com.yc.damai.web;

import com.yc.damai.entity.User;
import com.yc.damai.util.QRCodeUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.awt.*;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@RestController
@ServerEndpoint("/qc/{id}")
public class QrcodeDo {
    //二维码容器
    private static Map<String,CodeState> qrcodeMap=new HashMap<>();
    //PC端的会话容器
    private static Map<String, HttpSession> sessionMap=new HashMap<>();
    @RequestMapping(value = "qrcode",produces = MediaType.IMAGE_JPEG_VALUE)
    public void qrcode(String text, OutputStream out) throws Exception {
        QRCodeUtil.encode(text, "D:/myfiles/壁纸/4.jpg",out,true);
    }

    @RequestMapping(value = "loginCode",produces = MediaType.IMAGE_JPEG_VALUE)
    public void qrcodeForLogin(HttpSession session, OutputStream out) throws Exception {
        String uuid= UUID.randomUUID().toString();
      String url="http://10.205.43.20//user/scanCode?qrcode="+uuid;
        System.out.println("url="+url);
      //将二维码保存到容器中
        qrcodeMap.put(uuid, new CodeState());
        //将会话保存到会话容器
        sessionMap.put(uuid,session);
      qrcode(url, out);
    }
    @RequestMapping("scanCode")
    public ModelAndView scanCode(String qrcode, ModelAndView mav){
        mav.setViewName("appLogin.html?qrcode="+qrcode);
        return mav;
    }
    //修改扫码状态
    @RequestMapping("modifyCodeState")
    public String modifyCodeState(String qrcode, @RequestBody User user){
        final CodeState codeState = qrcodeMap.get(qrcode);
        codeState.status=1;
        //手机端浏览器向服务器发送用户信息
        System.out.println("user="+user);
        final HttpSession session = sessionMap.get(qrcode);
        //将用户对象存入到PC端的会话中
        session.setAttribute("loginedUser", user);
        System.out.println(session.getId());
        return "OK";
    }
    //扫码状态
    private static class CodeState{
        int status;
    }

//    Session session;
//
//    @OnOpen
//    public void onOpen(@PathParam("id") String id, Session session){
//        this.session=session;
//    }
}
