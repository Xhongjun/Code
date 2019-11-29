package com.xgdfin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动程序
 * 
 * @author ruoyi
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@ComponentScan({"com.xgdfin.workflow", "com.xgdfin.modules"})
@MapperScan(basePackages={"com.xgdfin.workflow.*.mapper", "com.xgdfin.modules.*.mapper"})
public class WorkFlowApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(WorkFlowApplication.class, args);
        System.out.println(" **********************************************");
        System.out.println(" ****                                     ****");
        System.out.println("              信联征信作业系统启动成功           ");
        System.out.println(" ****                                     ****");
        System.out.println(" **********************************************");
    }
}