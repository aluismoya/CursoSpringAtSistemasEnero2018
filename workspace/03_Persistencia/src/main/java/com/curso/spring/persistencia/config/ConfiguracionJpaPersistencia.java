package com.curso.spring.persistencia.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//s@Configuration
@ComponentScan("com.curso.spring.persistencia.dao.jpa")
//Anotacion encargada de inteerpretar las configuraciones de las transacciones declarativas con las anotaciones @Transactional
@EnableTransactionManagement
public class ConfiguracionJpaPersistencia {

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

	@Bean
	@Autowired
	public LocalContainerEntityManagerFactoryBean sessionFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean localEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		localEntityManagerFactoryBean.setDataSource(dataSource);
		localEntityManagerFactoryBean.setPackagesToScan("com.curso.spring.persistencia.entidades");
		localEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		Properties jpaProperties = new Properties();

		jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyDialect");
		jpaProperties.setProperty("hibernate.show_sql", "true");
		jpaProperties.setProperty("hibernate.format_sql", "true");
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create");// validate
																			// |
																			// update
																			// |
																			// create
																			// |
																			// create-drop

		localEntityManagerFactoryBean.setJpaProperties(jpaProperties);

		return localEntityManagerFactoryBean;
		
	}

	// @Bean
	// public DataSource dataSource() {
	// BasicDataSource ds = new BasicDataSource();
	// ds.setUrl("jdbc:derby://localhost:1527/jndi");
	// ds.setUsername("admin");
	// ds.setPassword("admin");
	// ds.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
	// return ds;
	// }

	// Buscamos en el arbol de recursos JNDI un recurso con path =
	// jdbc/MyLocalDB y lo introducimos como bean de Spring
	@Bean
	@Resource(name = "jdbc/MyLocalDB")
	// public DataSource dataSource(@Value("${db.jndi}") String jndiName) {
	public DataSource dataSource() {
		JndiDataSourceLookup lookup = new JndiDataSourceLookup();
		lookup.setResourceRef(true);
		return lookup.getDataSource("jdbc/MyLocalDB");
	}

}
