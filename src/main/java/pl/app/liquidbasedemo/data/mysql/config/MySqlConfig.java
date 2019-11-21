package pl.app.liquidbasedemo.data.mysql.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = "pl.app.liquidbasedemo.data.mysql.repository",
        entityManagerFactoryRef = "mysqlEntityManagerFactory",
        transactionManagerRef = "mysqlTransactionManager")
@EnableTransactionManagement
public class MySqlConfig {

    @Value("${hibernate-mysql.dialect}")
    private String dialect;
    @Value("${hibernate-mysql.hbm2ddl.auto}")
    private String hbm2ddl;
    @Value("${hibernate-mysql.show_sql}")
    private String showSQL;
    @Value("${hibernate-mysql.format_sql}")
    private String formatSQL;

    @Bean(name = "mySqlDataSource")
    @ConfigurationProperties(prefix = "mysql")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(@Qualifier("mySqlDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setPackagesToScan("pl.app.liquidbasedemo.data.mysql.entity");
        entityManagerFactoryBean.setPersistenceUnitName("dogs");
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setJpaPropertyMap(
                Map.of("hibernate.dialect", dialect,
                        "hibernate.hbm2ddl.auto", hbm2ddl,
                        "hibernate.show_sql", showSQL,
                        "hibernate.format_sql", formatSQL));

        return entityManagerFactoryBean;
    }

    @Bean(name = "mysqlTransactionManager")
    public JpaTransactionManager mysqlTransactionManager(@Qualifier("mysqlEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
