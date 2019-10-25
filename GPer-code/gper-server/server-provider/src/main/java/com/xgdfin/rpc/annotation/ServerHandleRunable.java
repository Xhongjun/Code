package com.xgdfin.rpc.annotation;import com.xgdfin.rpc.RpcRequest;import org.springframework.util.StringUtils;import java.io.IOException;import java.io.ObjectInputStream;import java.io.ObjectOutputStream;import java.lang.reflect.InvocationTargetException;import java.lang.reflect.Method;import java.net.Socket;import java.util.HashMap;/* * Copyright (C) 2017  ShenZhen xinLianZhengXin Co.,Ltd All Rights Reserved. * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件. * 版权所有深圳市信联征信有限公司 http://www.credlink.com/ *//** * <p>服务调用</p> * * @author  xiehongjun * @date    14:59 2019/10/14 */public class ServerHandleRunable implements Runnable {    private Socket socket;    private HashMap<String, Object> handleServiceMap;    public ServerHandleRunable(Socket socket, HashMap<String, Object> handleServiceMap) {        this.socket = socket;        this.handleServiceMap = handleServiceMap;    }    @Override    public void run() {        ObjectInputStream inputStream = null;        ObjectOutputStream outputStream = null;        try {            // 获得客户端流信息            inputStream = new ObjectInputStream(socket.getInputStream());            // 反序列化            RpcRequest request = (RpcRequest) inputStream.readObject();            // 调用服务方法            Object methodReturn = invoke(request);            // 服务端信息返回            outputStream = new ObjectOutputStream(socket.getOutputStream());            // 流信息写出            outputStream.writeObject(methodReturn);            outputStream.flush();        } catch (IOException | ClassNotFoundException                | NoSuchMethodException | InvocationTargetException                | IllegalAccessException e) {            e.printStackTrace();        } finally {            try {                if (inputStream != null) {                    inputStream.close();                }            } catch (IOException e) {                e.printStackTrace();            }            try {                if (outputStream != null) {                    outputStream.close();                }            } catch (IOException e) {                e.printStackTrace();            }        }    }    private Object invoke(RpcRequest request)            throws ClassNotFoundException, NoSuchMethodException,            InvocationTargetException, IllegalAccessException {        String serviceName = request.getClassName();        String version = request.getVersion();        if (!StringUtils.isEmpty(version)) {            serviceName = serviceName + "-" + version;        }        // 获得容器中的实现类        Object serviceImpl = handleServiceMap.get(serviceName);        if (serviceImpl==null) {            throw new RuntimeException("service is no found: "+serviceName);        }        // 反射获得服务实现类        final Class<?> serverClass = Class.forName(request.getClassName());        // 获得方法参数类型        Class<?>[] argesClass = null;        Object argesTypes[] = request.getParamesType();        if (argesTypes!=null) {            argesClass= new Class[argesTypes.length];            for (int i = 0; i < argesClass.length; i++) {                argesClass[i] = argesTypes[i].getClass();            }        }        // 获得服务方法        Method serverMethod = serverClass.getMethod(request.getMethodName(), argesClass);        // 执行方法        Object methodReturn = serverMethod.invoke(serviceImpl, argesTypes);        return methodReturn;    }}