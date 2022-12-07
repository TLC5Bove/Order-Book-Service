package Bove.OrderBookService.config;

import Bove.OrderBookService.model.Aapl;
import Bove.OrderBookService.model.Ibm;
import Bove.OrderBookService.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableScheduling
public class Config implements SchedulingConfigurer {
    @Autowired
    IbmService ibmService;

    @Autowired
    AaplService aaplService;

    @Scheduled(fixedDelay = 1000)
    public void getIBMEx1(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Exchange 1 is running");
        WebClient client = WebClient.create("https://exchange.matraining.com/orderbook");

        Mono<List<Ibm>> response = client.get()
                .uri("/IBM/open")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Ibm>>() {
                });

        List<Ibm> results = response.block();

        ibmService.deleteAll();

        assert results != null;

        results.forEach(res -> {
            res.setExchange("exchange");
            ibmService.saveOrder(res);
        });
    }

    @Scheduled(fixedDelay = 1000)
    public void getAaplEx1(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Exchange 2 is running");
        WebClient client = WebClient.create("https://exchange.matraining.com/orderbook");

        Mono<List<Aapl>> response = client.get()
                .uri("/AAPL/open")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Aapl>>() {
                });

        List<Aapl> results = response.block();

        ibmService.deleteAll();

        assert results != null;

        results.forEach(res -> {
            res.setExchange("exchange");
            aaplService.saveOrder(res);
        });
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean(destroyMethod = "shutdown")
    public Executor taskExecutor(){
        return Executors.newScheduledThreadPool(10);
    }
}
