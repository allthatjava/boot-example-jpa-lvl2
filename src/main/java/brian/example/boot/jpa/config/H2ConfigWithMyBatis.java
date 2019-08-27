package brian.example.boot.jpa.config;

import java.util.HashMap;

import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
////@PropertySource({ "classpath:persistence-multiple-db.properties" })
@EnableJpaRepositories(basePackages = "brian.template.boot.jpa.repository.mybatis", 
						entityManagerFactoryRef = "mybatisEntityManager", 
						transactionManagerRef = "mybatisTransactionManager")
public class H2ConfigWithMyBatis {
    @Autowired
    private Environment env;

    /**
     * Entity Manager
     *
     * @return
     */
    @PersistenceContext(unitName = "secondary")
    @Bean(name = "mybatisEntityManager")
    public LocalContainerEntityManagerFactoryBean entityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan( new String[] { "brian.template.boot.jpa.domain.mybatis" });

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean(name="mybatisDatasource")
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName( env.getProperty("mybatis.datasource.driver-class-name") );
        dataSource.setUrl( env.getProperty("mybatis.spring.datasource.url"));
        dataSource.setUsername(env.getProperty("mybatis.datasource.username"));
        dataSource.setPassword(env.getProperty("mybatis.datasource.password"));

        return dataSource;
    }

    /**
     * Transaction Manager
     *
     * @return
     */
    @Bean(name = "mybatisTransactionManager")
    public PlatformTransactionManager productTransactionManager() {

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManager().getObject());
        return transactionManager;
    }
}
