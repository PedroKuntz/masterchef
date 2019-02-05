package com.ello.masterchef;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.UUID;

@SpringBootApplication
public class MasterchefApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterchefApplication.class, args);
	}

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

