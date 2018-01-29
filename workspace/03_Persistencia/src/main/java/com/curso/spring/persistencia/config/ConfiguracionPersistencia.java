package com.curso.spring.persistencia.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@ComponentScan("com.curso.spring.persistencia.dao")
public class ConfiguracionPersistencia {

	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}

	@Bean
	@Autowired
	public void sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();

		localSessionFactoryBean.setDataSource(dataSource);
		localSessionFactoryBean.setAnnotatedPackages("com.curso.spring.persistencia.entidades");
		Properties hibernateProperties = new Properties();

		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyDialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.format_sql", "true");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create");// validate
																			// |
																			// update
																			// |
																			// create
																			// |
																			// create-drop

		localSessionFactoryBean.setHibernateProperties(hibernateProperties);

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
