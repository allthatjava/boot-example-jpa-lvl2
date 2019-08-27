package brian.example.boot.jpa.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "brian.template.boot.jpa.repository.hibernate", 
						entityManagerFactoryRef = "entityManager")
public class H2ConfigWithHibernate {

    @Autowired
    Environment env;

    @Profile("test")
//    @PersistenceContext(unitName = "primary")
    @Primary
    @Bean(name = "entityManager")
    public LocalContainerEntityManagerFactoryBean entityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] { "brian.template.boot.jpa.domain.hibernate" });

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", env.getProperty("hibernate.properties.hibernate.dialect"));
        properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show-sql"));
        properties.setProperty("hibernate.format_sql", env.getProperty("hibernate.properties.hibernate.format_sql"));
//        properties.setProperty("hibernate.naming-strategy", env.getProperty(".jpa.hibernate.naming-strategy"));
//        properties.setProperty("hibernate.hbm2ddl.auto", "update");

        em.setJpaProperties(properties);

        return em;
    }

//    @Profile("test")
    @Primary
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName( env.getProperty("hibernate.datasource.driver-class-name") );
        dataSource.setUrl( env.getProperty("hibernate.spring.datasource.url"));
        dataSource.setUsername(env.getProperty("hibernate.datasource.username"));
        dataSource.setPassword(env.getProperty("hibernate.datasource.password"));

        return dataSource;
    }

    /**
     * Transaction Manager
     *
     * @return
     */
    @Bean(name="transactionManager")
    @Primary
    public PlatformTransactionManager transactionManager() {

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManager().getObject());
        return transactionManager;
    }
}
