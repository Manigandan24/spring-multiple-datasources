package com.mss.admin.spring.secondary;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecondaryDataSource {

	@Bean
	public DataSource secondaryDataSourceConfig(@Qualifier("secondaryDataSourceProperties") DataSourceProperties dataSourceProp) {
		return dataSourceProp
				.initializeDataSourceBuilder().build();
	}
}
