package com.mss.admin.spring.secondary;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecondaryDataSourcePropertiesConfig {

	@Bean
	@ConfigurationProperties("spring.datasource.secondary")
	public DataSourceProperties secondaryDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	
}
