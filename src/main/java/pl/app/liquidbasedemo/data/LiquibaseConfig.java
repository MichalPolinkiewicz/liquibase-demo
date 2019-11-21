package pl.app.liquidbasedemo.data;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class LiquibaseConfig {

    @ConfigurationProperties(prefix = "liquibase-mysql")
    @Bean(name = "mysqlLiquibaseProperties")
    public LiquibaseProperties mysqlLiquibaseProperties() {
        return new LiquibaseProperties();
    }

    @ConfigurationProperties(prefix = "liquibase-mssql")
    @Bean(name = "mssqlLiquibaseProperties")
    public LiquibaseProperties mssqlLiquibaseProperties() {
        return new LiquibaseProperties();
    }

    @Bean
    private static SpringLiquibase mysqlSpringLiquibase(@Qualifier("mySqlDataSource") DataSource dataSource, @Qualifier("mysqlLiquibaseProperties") LiquibaseProperties properties) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog(properties.getChangeLog());

        return liquibase;
    }

    @Bean
    private static SpringLiquibase mssqlSpringLiquibase(@Qualifier("msSqlDataSource") DataSource dataSource, @Qualifier("mssqlLiquibaseProperties") LiquibaseProperties properties) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog(properties.getChangeLog());

        return liquibase;
    }
}
