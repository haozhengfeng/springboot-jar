package com;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:applicationContext-tx.xml","classpath:applicationContext-mybatis.xml","classpath:mybatis-config.xml"})
public class SpringBootConfig {

}
