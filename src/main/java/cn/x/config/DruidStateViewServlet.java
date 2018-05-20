package cn.x.config;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/druid/*",initParams = {
        //@WebInitParam(name = "allow",value = "127.0.0.1,192.168.1.142"),
        @WebInitParam(name = "deny",value = "126.12.22.1"),
        @WebInitParam(name="loginUsername",value="admin"),
        @WebInitParam(name="loginPassword",value="123456"),
        @WebInitParam(name="resetEnable",value="false")


})


public class DruidStateViewServlet extends StatViewServlet {
}