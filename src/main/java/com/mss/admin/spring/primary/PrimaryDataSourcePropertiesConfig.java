package com.mss.admin.spring.primary;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PrimaryDataSourcePropertiesConfig {

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.primary")
	public DataSourceProperties primaryDataSourceProperties() {
		return new DataSourceProperties();
	}
}
