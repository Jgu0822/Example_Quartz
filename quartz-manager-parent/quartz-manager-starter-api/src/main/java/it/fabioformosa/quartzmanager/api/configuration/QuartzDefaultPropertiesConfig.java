package it.fabioformosa.quartzmanager.api.configuration;

import it.fabioformosa.quartzmanager.api.common.properties.QuartzModuleProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "quartz-manager.quartz.enabled", matchIfMissing = true)
public class QuartzDefaultPropertiesConfig {

  // 기본 Quartz 스케줄러 이름
  protected static final String QUARTZ_MANAGER_SCHEDULER_DEFAULT_NAME = "quartz-manager-scheduler";

  /**
   * Quartz Manager 의 기본 속성을 설정하는 빈입니다.
   * "quartz-manager.quartz.enabled" 속성이 설정되어 있고, true로 설정된 경우에만 동작합니다.
   * 기본적으로 스케줄러 인스턴스 이름과 스레드 풀의 스레드 수를 설정합니다.
   * @return Quartz 모듈 속성 객체
   */
  @Bean("quartzDefaultProperties")
  public QuartzModuleProperties defaultApiQuartzProps() {
    QuartzModuleProperties quartzModuleProperties = new QuartzModuleProperties();
    quartzModuleProperties.getProperties().setProperty("org.quartz.scheduler.instanceName", QUARTZ_MANAGER_SCHEDULER_DEFAULT_NAME);
    quartzModuleProperties.getProperties().setProperty("org.quartz.threadPool.threadCount", "1");
    return quartzModuleProperties;
  }

}
