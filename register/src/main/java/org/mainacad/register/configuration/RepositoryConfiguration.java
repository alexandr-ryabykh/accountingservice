package org.mainacad.register.configuration;

/**
 * Created by Геныч on 14.03.2017.
 */
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"org.mainacad.register.domain"})
@EnableJpaRepositories(basePackages = {"org.mainacad.register.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
