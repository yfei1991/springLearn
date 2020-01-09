package com.central.cms.commons.base.controller;
import com.central.cms.commons.base.controller.util.DateTypeEditor;
import com.central.cms.commons.exception.ApiException;
import com.central.cms.commons.util.ControllerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import java.util.Date;

@Slf4j
public abstract class BaseController<T>{

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;


    public boolean isAjax(){
        return ControllerUtil.isAjax(request);
    }


    public boolean isPost() {
        return ControllerUtil.isPost(request);
    }


    public  boolean isGet() {
        return ControllerUtil.isGet(request);
    }


    public String getDomain() {
       return ControllerUtil.getDomain(request);
    }


    public  String getHostIp() {
        return ControllerUtil.getHostIp();
    }


    public  String getClientIp() {
        return ControllerUtil.getClientIp(request);
    }


    public  boolean isMobile() {
        return ControllerUtil.isMobile(request);
    }


    public void downFile(File file,String fileName,boolean isDelete) {
        try {
            ControllerUtil.downFile(response,request,file,fileName,isDelete);
        } catch (Exception e) {
            throw new ApiException(e.getMessage(),e);
        }
    }


    public void hasErrors(BindingResult result) {
        if(result.hasErrors()){
            try {
                throw new MethodArgumentNotValidException(null,result);
            } catch (MethodArgumentNotValidException e) {
                e.printStackTrace();
                throw new ApiException(e);
            }
        }
    }


    protected Example getExample(Class<?> clazz){
        return new Example(clazz);
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new DateTypeEditor());
    }


}
