package com.xgdfin.rpc.base;


import com.xgdfin.rpc.IRpcServerApi;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class ServerBaseApp {
    public static void main( String[] args ) throws IOException {

        IRpcServerApi rpcServer = new RpcServerApiBaseImpl();
        RpcServerProxy serverProxy = new RpcServerProxy();
        System.out.println("Server start ... ");
        serverProxy.publisher(8083, rpcServer);

    }
}
