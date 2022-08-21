package hello;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * This class has one role:
 * create a load-balanced WebClient builder to make remote requests.
 * Notice that our annotation uses a pseudo name for the service.
 */

@Configuration
@LoadBalancerClient(name = "say-hello", configuration = DemoServerInstanceConfiguration.class)
public class WebClientConfig {

    @LoadBalanced
    @Bean
    WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

}
