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

}

