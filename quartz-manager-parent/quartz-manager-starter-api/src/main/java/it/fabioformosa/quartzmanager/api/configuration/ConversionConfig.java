package it.fabioformosa.quartzmanager.api.configuration;

import it.fabioformosa.metamorphosis.core.EnableMetamorphosisConversions;
import org.springframework.context.annotation.Configuration;

/**
 * 애플리케이션의 Quartz Manager와 관련된 변환 설정을 위한 구성 클래스입니다.
 * "Metamorphosis" 변환 기능을 활성화하고, 패키지 "it.fabioformosa.quartzmanager"에 있는 클래스들에 대한 변환을 수행합니다.
 * 변환은 서로 다른 자바 객체 간의 자동 매핑을 제공하며, 이를 통해 간단하고 편리한 데이터 변환을 가능하게 합니다.
 */
@Configuration
@EnableMetamorphosisConversions(basePackages = { "it.fabioformosa.quartzmanager" })
public class ConversionConfig {
}
