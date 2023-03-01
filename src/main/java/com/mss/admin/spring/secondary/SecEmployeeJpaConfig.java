package com.mss.admin.spring.secondary;

import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.mss.admin.spring.secondary", entityManagerFactoryRef = "secondaryEntityManagerFactory", transactionManagerRef = "secondaryTransactionManager")
public class SecEmployeeJpaConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(
			@Qualifier("secondaryDataSourceConfig") DataSource dataSource, EntityManagerFactoryBuilder builder) {
		return builder.dataSource(dataSource).packages("com.mss.admin.spring.secondary").build();
	}
	
	@Bean
	public PlatformTransactionManager secondaryTransactionManager(@Qualifier("secondaryEntityManagerFactory") LocalContainerEntityManagerFactoryBean secondaryManagerFact) {
		return new JpaTransactionManager(Objects.requireNonNull(secondaryManagerFact.getObject()));
	}
}
