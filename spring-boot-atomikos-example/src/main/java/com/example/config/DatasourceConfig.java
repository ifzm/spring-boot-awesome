package com.example.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.druid.db.default")
    public DataSource dataSource(){
        System.out.println(DruidDataSourceBuilder.create().build());
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.db.mysql")
    public DataSource dataSourceMysql(){
        return DruidDataSourceBuilder.create().build();
    }

    @Primary
    @Bean
    public JdbcTemplate jdbcTemplate(@Qualifier("dataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean
    public JdbcTemplate jdbcTemplateMysql(@Qualifier("dataSourceMysql") DataSource ds) {
        return new JdbcTemplate(ds);
    }

}
