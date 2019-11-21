package pl.app.liquidbasedemo.data.mssql.config;

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
        basePackages = "pl.app.liquidbasedemo.data.mssql.repository",
        entityManagerFactoryRef = "msSqlEntityManagerFactory",
        transactionManagerRef = "msSqlTransactionManager"
)
@EnableTransactionManagement
public class MSSql {

    @Value("${hibernate-mssql.dialect}")
    private String dialect;
    @Value("${hibernate-mssql.hbm2ddl.auto}")
    private String hbm2ddl;
    @Value("${hibernate-mssql.show_sql}")
    private String showSQL;
    @Value("${hibernate-mssql.format_sql}")
    private String formatSQL;

    @Bean(name = "msSqlDataSource")
    @ConfigurationProperties(prefix = "mssql")
    public DataSource mssqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "msSqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(@Qualifier("msSqlDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setPackagesToScan("pl.app.liquidbasedemo.data.mssql.entity");
        entityManagerFactoryBean.setPersistenceUnitName("bird");
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setJpaPropertyMap(
                Map.of("hibernate.dialect", dialect,
                        "hibernate.hbm2ddl.auto", hbm2ddl,
                        "hibernate.show_sql", showSQL,
                        "hibernate.format_sql", formatSQL));

        return entityManagerFactoryBean;
    }

    @Bean(name = "msSqlTransactionManager")
    public JpaTransactionManager mysqlTransactionManager(@Qualifier("msSqlEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
