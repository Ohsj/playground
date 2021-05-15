package com.osj4532.playground.config;

import ch.qos.logback.classic.Logger;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * 210515 | osj4532 | created
 * 여러개의 Datasource 중 postgres(docker)로 만들기 위해 설정
 */

@Configuration
@Profile("!h2")
public class PostgresDataSourceConfig {
    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @Value("${spring.db.datasource.postgres.driver-class-name}")
    private String driverClassName;
    @Value("${spring.db.datasource.postgres.url}")
    private String url;
    @Value("${spring.db.datasource.postgres.username}")
    private String userName;
    @Value("${spring.db.datasource.postgres.password}")
    private String password;

    @Bean("datasource")
    public DataSource postgresDataSource() {
        logger.info("Postgres Datasource Setting Start ===============================================================");
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driverClassName);
        config.setJdbcUrl(url);
        config.setUsername(userName);
        config.setPassword(password);
        logger.info("Postgres Datasource Setting End   ===============================================================");

        return new HikariDataSource(config);
    }
}
