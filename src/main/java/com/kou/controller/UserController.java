package com.kou.controller;

import com.kou.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author JIAJUN KOU
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws Exception{
        System.out.println("testException.......");

        try {
            int a=10/0;
        } catch (Exception e) {
            //打印异常信息
            e.printStackTrace();
            //抛出自定义的异常信息
            throw  new SysException("查询出问题了。。。。");
        }

        return "success";
    }
}
