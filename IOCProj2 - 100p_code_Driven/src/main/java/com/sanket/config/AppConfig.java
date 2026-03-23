package com.sanket.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = "com.sanket")
@ImportResource("ApplicationContext.xml")
@PropertySource("Info.properties")
public class AppConfig {

//    @Value("${jdbc.driver}")
//    private String driver;
//    @Value("${jdbc.url}")
//    private String url;
//    @Value("${jdbc.username}")
//    private String username;
//    @Value("${jdbc.password}")
//    private String password;

    @Autowired
    private Environment env;

    @Bean(name = "hkds")
    public HikariDataSource createDs()
    {

        HikariDataSource hkds = new HikariDataSource();
//        hkds.setDriverClassName(driver);
//        hkds.setJdbcUrl(url);
//        hkds.setUsername(username);
//        hkds.setPassword(password);

        hkds.setDriverClassName(env.getProperty("jdbc.driver"));
        hkds.setJdbcUrl(env.getRequiredProperty("jdbc.url"));
        hkds.setUsername(env.getRequiredProperty("jdbc.username"));
        hkds.setPassword(env.getRequiredProperty("jdbc.password"));



        return hkds;
    }
}
