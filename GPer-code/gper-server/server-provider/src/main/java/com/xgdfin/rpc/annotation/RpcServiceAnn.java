package com.xgdfin.rpc.annotation;/* * Copyright (C) 2017  ShenZhen xinLianZhengXin Co.,Ltd All Rights Reserved. * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件. * 版权所有深圳市信联征信有限公司 http://www.credlink.com/ */import org.springframework.stereotype.Component;import java.lang.annotation.ElementType;import java.lang.annotation.Retention;import java.lang.annotation.RetentionPolicy;import java.lang.annotation.Target;@Target(ElementType.TYPE)@Retention(RetentionPolicy.RUNTIME)@Componentpublic @interface RpcServiceAnn {    Class<?> value();    String version() default "";}