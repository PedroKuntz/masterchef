package com.ello.masterchef.commons.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DatabaseConfiguration {

  @Bean
  public DataSource dataSource() {
    SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
    try {
      dataSource.setDriver(new com.mysql.jdbc.Driver());
      dataSource.setUrl("jdbc:mysql://127.0.0.1/chef");
      dataSource.setUsername("root");
      dataSource.setPassword("padtec");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return dataSource;
  }

  @Bean
  @Autowired
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

}
