package com.kou.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author JIAJUN KOU
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    /**
     * 处理异常的业务逻辑
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //获取到异常对象
        SysException sysException=null;
        if(e instanceof SysException){
            sysException=(SysException)e;
        }else {
            sysException=new SysException("系统正在维护。。。。。");
        }
        //创建modelandview对象
        ModelAndView mv=new ModelAndView();
        mv.addObject("errorMsg",sysException.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
