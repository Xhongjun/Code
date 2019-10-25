package com.xgdfin.rpc.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class ServerAnnApp {
    public static void main( String[] args ) throws IOException {

        ApplicationContext context = new AnnotationConfigApplicationContext(RpcAnnServerConfig.class);
        ((AnnotationConfigApplicationContext) context).start();
    }
}
