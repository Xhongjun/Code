package com.xgdfin.rpc.annotation;import org.springframework.context.annotation.Bean;import org.springframework.context.annotation.ComponentScan;import org.springframework.context.annotation.Configuration;/** Copyright (C) 2017  ShenZhen xinLianZhengXin Co.,Ltd All Rights Reserved.* 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.* 版权所有深圳市信联征信有限公司 http://www.credlink.com/*/@Configuration@ComponentScan(basePackages = "com.xgdfin.rpc")public class RpcServerConfig {    @Bean("rpcServerProxy")    public RpcServerProxy rpcServerProxy() {        return new RpcServerProxy(8083);    }}