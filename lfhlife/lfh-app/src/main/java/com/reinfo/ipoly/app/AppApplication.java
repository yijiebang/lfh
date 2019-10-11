package com.reinfo.ipoly.app;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.reinfo.ipoly.common.config.IpolyConfig;


/**
 * @author zeyi_li
 * @since 1.0 Date 18-12-4
 */
@MapperScan(basePackages = {"com.reinfo.ipoly.module.mappers"})
@SpringBootApplication(scanBasePackages = {"com.reinfo.ipoly"})
@EnableScheduling
@EnableTransactionManagement
public class AppApplication {
    public static final Logger logger = LoggerFactory.getLogger(AppApplication.class);

    public static void main(String[] args) throws Exception {
        logger.info("Service start......");
        ConfigurableApplicationContext applicationContext = SpringApplication.run(AppApplication.class, args);
        // mybatis所需要spring 上下文对象
        IpolyConfig.getInstance().setApplicationContext(applicationContext);
        logger.info("Service started successfully，server.context-path[{}], serverPort[{}]", applicationContext.getEnvironment().getProperty("server.servlet.context-path"),
                applicationContext.getEnvironment().getProperty("server.port"));

    }

}
