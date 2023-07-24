package it.fabioformosa.quartzmanager.api.configuration;

import it.fabioformosa.quartzmanager.api.common.properties.QuartzModuleProperties;
import it.fabioformosa.quartzmanager.api.scheduler.AutowiringSpringBeanJobFactory;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

@Configuration
@ConditionalOnProperty(name = "quartz-manager.quartz.enabled", matchIfMissing = true)
public class SchedulerConfig {

  private final List<QuartzModuleProperties> quartzModuleProperties;

  @Autowired(required = false)
  public SchedulerConfig(List<QuartzModuleProperties> quartzModuleProperties) {
    this.quartzModuleProperties = quartzModuleProperties;
  }

  /**
   * Quartz Job을 생성하는 데 사용되는 JobFactory 빈을 생성합니다.
   * 스프링 애플리케이션 컨텍스트를 사용하여 Quartz Job에 의존성 주입을 가능하게 합니다.
   * @param applicationContext 스프링 애플리케이션 컨텍스트
   * @return JobFactory 빈
   */

  @Bean(name = "quartzJobFactory")
  public JobFactory jobFactory(ApplicationContext applicationContext) {
    AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
    jobFactory.setApplicationContext(applicationContext);
    return jobFactory;
  }

  /**
   * "managed-quartz.properties" 파일이 존재하는 경우 해당 프로퍼티 파일을 로드하여 Properties 빈을 생성합니다.
   * @return "managed-quartz.properties" 파일의 프로퍼티 객체
   * @throws IOException 파일 로드 중 예외 발생 시
   */

  @ConditionalOnResource(resources = {"managed-quartz.properties"})
  @Bean(name = "ManagedQuartzProperties")
  public Properties quartzProperties() throws IOException {
    PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
    propertiesFactoryBean.setLocation(new ClassPathResource("/managed-quartz.properties"));
    propertiesFactoryBean.afterPropertiesSet();
    return propertiesFactoryBean.getObject();
  }

  /**
   * Quartz Manager 스케줄러를 설정하는 SchedulerFactoryBean 빈을 생성합니다.
   * 스케줄러에 JobFactory를 설정하고, 사용자 정의 Quartz 프로퍼티와 외부에서 로드한 프로퍼티를 합칩니다.
   * @param jobFactory JobFactory 빈
   * @param quartzProperties "managed-quartz.properties" 파일의 프로퍼티 객체 (선택적)
   * @return SchedulerFactoryBean 빈
   */

  @Bean(name = "quartzManagerScheduler")
  public SchedulerFactoryBean schedulerFactoryBean(@Qualifier("quartzJobFactory") JobFactory jobFactory,
                                                   @Autowired(required = false) @Qualifier("ManagedQuartzProperties") Properties quartzProperties) {
    SchedulerFactoryBean factory = new SchedulerFactoryBean();
    factory.setJobFactory(jobFactory);
    Properties mergedProperties = new Properties();
    quartzModuleProperties.stream().forEach(prop -> mergedProperties.putAll(prop.getProperties()));
    if (quartzProperties != null && quartzProperties.size() > 0)
      mergedProperties.putAll(quartzProperties);
    factory.setQuartzProperties(mergedProperties);
    factory.setAutoStartup(false);
    return factory;
  }
}
