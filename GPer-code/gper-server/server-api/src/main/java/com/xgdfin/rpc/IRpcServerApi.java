package com.xgdfin.rpc;/** Copyright (C) 2017  ShenZhen xinLianZhengXin Co.,Ltd All Rights Reserved.* 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.* 版权所有深圳市信联征信有限公司 http://www.credlink.com/*/import com.xgdfin.domain.User;/** * <p>远程服务接口</p> * * @author  xiehongjun * @date    15:02 2019/10/13 */public interface IRpcServerApi {    public String sayHello(String content);    public void adduser(User user);}