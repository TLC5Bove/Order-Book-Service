package Bove.OrderBookService.config;

import Bove.OrderBookService.model.Ibm;
import Bove.OrderBookService.service.IbmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Configuration
@EnableScheduling
public class Config {
    @Autowired
    IbmService ibmService;

    @Scheduled(fixedDelay = 1000)
    public void getIBMEx1(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>I am running");
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
    public void print(){
        List<Ibm> res = ibmService.findAllPageAndSortBySide();
        for (Ibm ibm: res){
            System.out.println(ibm);
        }
    }
}
