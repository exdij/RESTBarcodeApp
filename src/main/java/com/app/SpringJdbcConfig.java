package com.app;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class SpringJdbcConfig {
    @Bean
    public DataSource mysqlDataSource() {
        Properties prop = new Properties();
        prop.put("serverTimezone", "UTC");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/shop");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setConnectionProperties(prop);

        return dataSource;
    }
}
