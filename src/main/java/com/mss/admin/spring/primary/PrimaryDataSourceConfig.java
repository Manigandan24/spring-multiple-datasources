package com.mss.admin.spring.primary;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class PrimaryDataSourceConfig {

	@Bean(name="primaryDataSource")
	@Primary
	public DataSource primaryDataSource(@Qualifier("primaryDataSourceProperties") DataSourceProperties dataSourceProp) {
		
		  return dataSourceProp.
		  initializeDataSourceBuilder() .type(HikariDataSource.class) .build();
		 
		
		/*
		 * DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		 * dataSourceBuilder.driverClassName("org.postgresql.Driver");
		 * dataSourceBuilder.url("jdbc:postgresql://localhost:5432/postgres");
		 * dataSourceBuilder.username("postgres"); dataSourceBuilder.password("post");
		 * return dataSourceBuilder.build();
		 */
	}
}
