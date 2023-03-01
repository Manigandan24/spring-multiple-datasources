package com.mss.admin.spring.primary;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.mss.admin.spring.primary", entityManagerFactoryRef = "primaryEntityManagerFactory", transactionManagerRef = "primaryTransactionManager")
public class EmployeeJpaConfig {

	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
			@Qualifier("primaryDataSource") DataSource dataSource, EntityManagerFactoryBuilder builder) {
		
		Map<String, String> primaryJpaProperties = new HashMap<>();
        primaryJpaProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        primaryJpaProperties.put("hibernate.hbm2ddl.auto", "create");
		
		return builder.dataSource(dataSource)
				.packages("com.mss.admin.spring.primary")
				.persistenceUnit("primaryDataSource")
				.properties(primaryJpaProperties)
				.build();
	}
	
	@Bean
	@Primary
	public PlatformTransactionManager primaryTransactionManager(@Qualifier("primaryEntityManagerFactory") EntityManagerFactory primaryManagerFact) {
		return new JpaTransactionManager(primaryManagerFact);
	}
}
