package hendisantika.config;

import hendisantika.domain.data.Domain;
import hendisantika.domain.data.DomainRepository;
import hendisantika.domain.data.OtherDomain;
import hendisantika.domain.data.OtherDomainRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@Configuration
@ComponentScan(basePackageClasses = Domain.class)
public class AppConfig {

  @Bean
  public EmbeddedServletContainerCustomizer containerCustomizer() {
    return container -> container.addErrorPages(new ErrorPage(NOT_FOUND, "/"));
  }

  @Bean
  @Transactional
  public CommandLineRunner testData(
      DomainRepository domainRepository,
      OtherDomainRepository otherDomainRepository) {

    if (domainRepository.count() > 0) return args -> log.info("skipping test data.");

    return args -> Stream.of(1, 2, 3)
        .map(String::valueOf)
        .map("test"::concat)
        .map(n -> new Domain()
            .setUsername(n)
            .setLastName(n)
            .setFirstName(n)
            .setOtherDomain(otherDomainRepository.save(new OtherDomain().setTest(n))))
        .forEach(domainRepository::save);
  }
}
