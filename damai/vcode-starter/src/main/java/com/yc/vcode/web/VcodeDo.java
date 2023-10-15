package com.yc.vcode.web;

import com.yc.vcode.bean.Result;
import com.yc.vcode.bean.VcodeProperties;
import com.yc.vcode.util.VerifyCodeUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("vcode")
public class VcodeDo {

    @Resource
    VcodeProperties properties;

    @RequestMapping({"","/"})
    VcodeProperties properties(){
        return properties;
    }

    @RequestMapping(path = "image",
        produces = MediaType.IMAGE_JPEG_VALUE)
    public void image(HttpServletResponse resp,
                      HttpSession session) throws IOException {
        final String vcode = VerifyCodeUtils.outputImage(resp);
        session.setAttribute("vcode", vcode);
    }

    @RequestMapping("email")
    public Result email(String toEmail,HttpSession session){
        final String vcode = VerifyCodeUtils.generateVerifyCode(4);
        session.setAttribute("vcode", vcode);
        sendSimpleMail(toEmail,"验证码", "yc平台xxx业务验证码: " + vcode);
        return new Result(1, "验证码已经发送至: " + toEmail, null);
    }

    @Resource
    private JavaMailSender mailSender;

    @Value("${mail.fromMail.addr}")
    private String from;

    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }
}
