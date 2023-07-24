package it.fabioformosa.quartzmanager.api.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import it.fabioformosa.quartzmanager.api.common.config.QuartzManagerPaths;
import lombok.Generated;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;


@Slf4j
@Configuration
@Generated
public class OpenApiConfig {

  /**
   * Quartz Manager API의 Swagger(OpenAPI) 설정을 만들어주는 빈입니다.
   * "quartz-manager.oas.enabled" 속성이 true로 설정된 경우에만 동작합니다.
   * 기본적인 API 정보와 라이선스 정보를 포함하여 Swagger 문서를 생성합니다.
   * @return 생성된 OpenAPI 객체
   */

  @ConditionalOnProperty(name = "quartz-manager.oas.enabled")
  @ConditionalOnMissingBean
  @Bean
  public OpenAPI quartzManagerOpenAPI() {
    log.info("No OpenAPI found! Quart Manager is creating it...");
    return new OpenAPI().info(new Info()
      .title("QUARTZ MANAGER API")
      .description("Quartz Manager - REST API")
      .version("1.0.0")
      .license(new License()
        .name("Apache License 2.0")
        .url("https://github.com/fabioformosa/quartz-manager/blob/master/LICENSE")));
  }

  /**
   * Quartz Manager API에 대한 Swagger(OpenAPI) 설정을 그룹화하여 생성합니다.
   * "quartz-manager.oas.enabled" 속성이 true로 설정된 경우에만 동작합니다.
   * Quartz Manager API의 경로를 패턴으로 지정하여 그룹을 만들고, 설정된 OpenApiCustomiser를 추가합니다.
   * @param openApiCustomiser Quartz Manager API에 대한 사용자 지정 설정 객체 (선택적)
   * @return 그룹화된 OpenApi 객체
   */

  @ConditionalOnProperty(name = "quartz-manager.oas.enabled")
  @Bean
  public GroupedOpenApi quartzManagerStoreOpenApi(@Autowired(required = false) @Qualifier("quartzManagerOpenApiCustomiser") Optional<OpenApiCustomiser> openApiCustomiser) {
    String[] paths = {QuartzManagerPaths.QUARTZ_MANAGER_BASE_CONTEXT_PATH + "/**"};
    GroupedOpenApi.Builder groupedOpenApiBuilder = GroupedOpenApi.builder().group("quartz-manager").pathsToMatch(paths);
    openApiCustomiser.ifPresent(groupedOpenApiBuilder::addOpenApiCustomiser);
    return groupedOpenApiBuilder.build();
  }



}
