package com.example.cloudindex.web.remote;

import com.example.cloudindex.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

@Component
public class UserDoImpl implements UserDo {
    @Override
    public String user() {
        return "Feign 降级方法 user";
    }

    @Override
    public String hello(String name) {
        return "降级方法 : 你好 " + name;
    }

    @Override
    public Date castDate(String date) {
        return null;
    }

    @Override
    public String week(String dateStr) {
        return null;
    }

    @Override
    public User myinfo(User user) {
        return null;
    }

    @Override
    public User myinfo1(User user) {
        return null;
    }

    @Override
    public User myinfo2(User user, String newName) {
        return null;
    }

    @Override
    public User myinfo3(User user, String newName, String newAge) {
        return null;
    }

    public static void main(String[] args) {
        // 动态代理 远程接口
        // Proxy  InvocationHandler
        final UserDo userDo = (UserDo) Proxy.newProxyInstance(
                UserDo.class.getClassLoader(),
                new Class[]{UserDo.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        final FeignClient feignClient = UserDo.class.getAnnotation(FeignClient.class);
                        final String serviceName = feignClient.value();
                        String host = getHostByServiceNameWithEureka(serviceName);
                        final RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                        final String path = requestMapping.value()[0];
                        String url = "http://" + host + "/" + path;
                        RestTemplate restTemplate = new RestTemplate();
                        if(method.getParameters().length == 0){
                            // 无参数 方法
                            return restTemplate.getForObject(url, method.getReturnType());
                        } else {
                            // 有参数方法
                            // TODO 提取方法参数值, 扩展实现
                        }

                        return null;
                    }

                    private String getHostByServiceNameWithEureka(String serviceName) {
                        if ("cloud-user".equalsIgnoreCase(serviceName)) {
                            return "127.0.0.1:8002";
                        } else if ("cloud-order".equalsIgnoreCase(serviceName)) {
                            return "127.0.0.1:8001";
                        } else {
                            return null;
                        }
                    }
                }
        );

        System.out.println("userDo.user() = " + userDo.user());
        System.out.println("userDo.hello(\"张三\") = " + userDo.hello("张三"));
    }
}
