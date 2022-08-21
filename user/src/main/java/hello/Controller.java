package hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class Controller {
    private final WebClient.Builder loadBalancedWebClientBuilder;

    public Controller(WebClient.Builder loadBalancedWebClientBuilder) {
        this.loadBalancedWebClientBuilder = loadBalancedWebClientBuilder;
    }

    @RequestMapping("/hi/{queryString}")
    public Mono<String> hi(@RequestParam(value = "name", defaultValue = "Mary") String name,
                           @PathVariable String queryString) {
        return loadBalancedWebClientBuilder.build().get().uri("http://say-hello/" + queryString)
                .retrieve().bodyToMono(String.class)
                .map(greeting -> String.format("%s, %s!", greeting, name));
    }
}
