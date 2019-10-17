package com.xgdfin.rpc.annotation;import java.lang.reflect.Proxy;/** Copyright (C) 2017  ShenZhen xinLianZhengXin Co.,Ltd All Rights Reserved.* 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.* 版权所有深圳市信联征信有限公司 http://www.credlink.com/*/public class RpcClientProxy {    /** 服务代理 */    public <T> T clientProxy(Class interfaceClass, String host, Integer port) {        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(),                new Class<?>[]{interfaceClass},                new RpcClientInvocationHandler(host, port));    }}