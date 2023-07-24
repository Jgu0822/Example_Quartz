package it.fabioformosa.quartzmanager.api.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Quartz Manager API 구성 설정 클래스입니다.
 * "it.fabioformosa.quartzmanager.api" 패키지를 스캔하여 해당 패키지에 있는 컴포넌트들을 등록합니다.
 * 이렇게 등록된 컴포넌트들은 스프링 애플리케이션에서 자동으로 빈으로 사용할 수 있게 됩니다.
 */
@ComponentScan(basePackages = {"it.fabioformosa.quartzmanager.api"})
@Configuration
public class QuartzManagerApiConfig {
}
