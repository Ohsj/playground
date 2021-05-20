package com.osj4532.playground.config;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Objects;

/**
 * 210520 | osj4532 | created
 */

@Configuration
@EnableJpaRepositories(basePackages = {"com.osj4532.playground.domain.repo"},
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager"
)
public class JpaConfig {

    private final Logger logger = (Logger)LoggerFactory.getLogger(this.getClass());

    /**
     * spring.jpa 에 설정한 jpa 관련 설정을 읽어 jpa 설정을 한다.
     */
    @Primary
    @Bean(name = "jpaProperties")
    @ConfigurationProperties(prefix = "spring.jpa")
    public JpaProperties jpaProperties() {
        return new JpaProperties();
    }

    /**
     * dataSoruce와 jpaProperties를 가져와 entityManager를 만드는 entityManagerFactory 빈을 구성한다.
     */
    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
            @Qualifier("datasource") DataSource dataSource,
            @Qualifier("jpaProperties") JpaProperties properties
            ) {
        return builder
                .dataSource(dataSource)
                .properties(properties.getProperties())
                .packages("com.osj4532.playground.domain.entity")
                .persistenceUnit("default")
                .build();
    }

    /**
     * entityManagerFactory를 이용하여 트랜잭션 처리에 이용되는 transactionManager 빈을 만든다.
     */
    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("entityManagerFactory") LocalContainerEntityManagerFactoryBean entityManagerFactory
    ) {
        JpaTransactionManager transactionManager = new JpaTransactionManager(Objects.requireNonNull(entityManagerFactory.getObject()));
        transactionManager.setNestedTransactionAllowed(true);
        return transactionManager;
    }
}
