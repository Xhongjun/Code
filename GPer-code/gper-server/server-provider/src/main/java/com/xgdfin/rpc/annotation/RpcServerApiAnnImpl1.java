package com.xgdfin.rpc.annotation;import com.xgdfin.domain.User;import com.xgdfin.rpc.IRpcServerApi;import java.text.SimpleDateFormat;import java.util.Date;/** Copyright (C) 2017  ShenZhen xinLianZhengXin Co.,Ltd All Rights Reserved.* 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.* 版权所有深圳市信联征信有限公司 http://www.credlink.com/*/@RpcServiceAnn(value = IRpcServerApi.class, version = "v1.0")public class RpcServerApiAnnImpl1 implements IRpcServerApi {    @Override    public String sayHello(String content) {        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD HH:mm:sss");        String dateFormat = format.format(new Date());        String ret = "[v1.0] annotation server: " + content;        System.out.println(ret);        return "[v1.0] rpc annotation server get message at " + dateFormat;    }    @Override    public void adduser(User user) {    }}