package org.mainacad.core;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class AppConfig {

    @Autowired
    DataSourceProperties dataSourceProperties;

    @Autowired
    JpaProperties jpaProperties;

    @Bean
    @ConfigurationProperties
    DataSource getDataSource() {
        DataSource dataSource = DataSourceBuilder
                .create(this.dataSourceProperties.getClassLoader())
                .url(this.dataSourceProperties.getUrl())
                .username(this.dataSourceProperties.getUsername())
                .password(this.dataSourceProperties.getPassword())
                .driverClassName(this.dataSourceProperties.getDriverClassName())
                .build();
        return dataSource;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setSessionFactory(sessionFactory);
        return htm;
    }

    @Bean
    @Autowired
    public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory) {
        HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
        return hibernateTemplate;
    }

    @Bean
    @ConfigurationProperties
    public LocalSessionFactoryBean getSessionFactory() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.putAll(jpaProperties.getHibernateProperties(getDataSource()));
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setPackagesToScan(new String[]{"com.mainacad"});
        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }
}
