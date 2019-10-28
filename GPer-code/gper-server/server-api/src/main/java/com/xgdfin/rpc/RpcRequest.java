package com.xgdfin.rpc;/** Copyright (C) 2017  ShenZhen xinLianZhengXin Co.,Ltd All Rights Reserved.* 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.* 版权所有深圳市信联征信有限公司 http://www.credlink.com/*/import lombok.Data;import lombok.ToString;import java.io.Serializable;/** * <p>远程服务调用请求</p> * * @author  xiehongjun * @date    15:31 2019/10/13 */@Data@ToStringpublic class RpcRequest implements Serializable {    private static final long serialVersionUID = -7290363739843072971L;    // 版本号    private String version="";    // 远程服务全类名    private String className;    // 远程服务方法名    private String methodName;    // 方法参数类型    private Object[] paramesType;}