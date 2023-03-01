package com.mss.admin.spring.secondary;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class SecondaryJdbcTemplateConfig {

	@Bean
	public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSourceConfig") DataSource dataSource) {
		return new JdbcTemplate(dataSource); 
	}
}
