package it.fabioformosa.quartzmanager.api.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@ComponentScan(basePackages = {"it.fabioformosa.quartzmanager.api.websockets"})
@EnableWebSocketMessageBroker
public class WebsocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

  /**
   * WebSocket 메시징 브로커를 구성하는 메서드입니다.
   * "/topic" 브로커를 활성화하고, 클라이언트로부터 받은 메시지의 애플리케이션 목적지(prefix)를 "/job"으로 설정합니다.
   * @param config MessageBrokerRegistry 객체
   */
  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
    config.enableSimpleBroker("/topic");
    config.setApplicationDestinationPrefixes("/job");
  }

  /**
   * STOMP 엔드포인트를 등록하는 메서드입니다.
   * "/quartz-manager/logs"와 "/quartz-manager/progress" 엔드포인트를 등록하고, 모든 오리진으로부터 접속을 허용합니다.
   * SockJS를 통해 브라우저가 웹소켓을 지원하지 않을 경우 대체 기술을 사용할 수 있도록 설정합니다.
   * @param registry StompEndpointRegistry 객체
   */
  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/quartz-manager/logs").setAllowedOrigins("/**").withSockJS();
    registry.addEndpoint("/quartz-manager/progress").setAllowedOrigins("/**").withSockJS();
  }

}
