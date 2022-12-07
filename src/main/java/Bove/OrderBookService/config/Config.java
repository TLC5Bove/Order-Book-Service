package Bove.OrderBookService.config;

import Bove.OrderBookService.model.*;
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
    AaplService aaplService;

    @Autowired
    IbmService ibmService;

    @Autowired
    AmznService amznService;

    @Autowired
    GooglService googlService;

    @Autowired
    MsftService msftService;

    @Autowired
    NflxService nflxService;

    @Autowired
    OrclService orclService;

    @Autowired
    TslaService tslaService;

    @Scheduled(fixedDelay = 1000)
    public void getAapl(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>AAPL is running");
        WebClient client = WebClient.create("https://exchange.matraining.com/orderbook");

        WebClient client2 = WebClient.create("https://exchange2.matraining.com/orderbook");

        Mono<List<Aapl>> response = client.get()
                .uri("/AAPL/open")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Aapl>>() {
                });
        Mono<List<Aapl>> response2 = client.get()
                .uri("/AAPL/open")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Aapl>>() {
                });

        List<Aapl> results = response.block();
        List<Aapl> results2 = response2.block();

        aaplService.deleteAll();

        assert results != null;
        assert results2 != null;

        results.forEach(r -> r.setExchange("exchange"));
        results2.forEach(r -> r.setExchange("exchange2"));

        aaplService.saveMany(results);
        aaplService.saveMany(results2);
    }

    @Scheduled(fixedDelay = 1000)
    public void getAmzn(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>AMZN is running");
        WebClient client = WebClient.create("https://exchange.matraining.com/orderbook");

        WebClient client2 = WebClient.create("https://exchange2.matraining.com/orderbook");

        Mono<List<Amzn>> response = client.get()
                .uri("/AMZN/open")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Amzn>>() {
                });
        Mono<List<Amzn>> response2 = client.get()
                .uri("/AMZN/open")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Amzn>>() {
                });

        List<Amzn> results = response.block();
        List<Amzn> results2 = response2.block();

        amznService.deleteAll();

        assert results != null;
        assert results2 != null;

        results.forEach(r -> r.setExchange("exchange"));
        results2.forEach(r -> r.setExchange("exchange2"));

        amznService.saveMany(results);
        amznService.saveMany(results2);
    }

    @Scheduled(fixedDelay = 1000)
    public void getGoogl(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>GOOGL is running");
        WebClient client = WebClient.create("https://exchange.matraining.com/orderbook");

        WebClient client2 = WebClient.create("https://exchange2.matraining.com/orderbook");

        Mono<List<Googl>> response = client.get()
                .uri("/GOOGL/open")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Googl>>() {
                });
        Mono<List<Googl>> response2 = client.get()
                .uri("/GOOGL/open")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Googl>>() {
                });

        List<Googl> results = response.block();
        List<Googl> results2 = response2.block();

        googlService.deleteAll();

        assert results != null;
        assert results2 != null;

        results.forEach(r -> r.setExchange("exchange"));
        results2.forEach(r -> r.setExchange("exchange2"));

        googlService.saveMany(results);
        googlService.saveMany(results2);
    }

    @Scheduled(fixedDelay = 1000)
    public void getIBM(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>IBM is running");
        WebClient client = WebClient.create("https://exchange.matraining.com/orderbook");

        WebClient client2 = WebClient.create("https://exchange2.matraining.com/orderbook");

        Mono<List<Ibm>> response = client.get()
                .uri("/IBM/open")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Ibm>>() {
                });

        Mono<List<Ibm>> response2 = client2.get()
                .uri("/IBM/open")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Ibm>>() {
                });

        List<Ibm> results = response.block();
        List<Ibm> results2 = response2.block();

        ibmService.deleteAll();

        assert results != null;
        assert results2 != null;

        results.forEach(r -> r.setExchange("exchange"));
        results2.forEach(r -> r.setExchange("exchange2"));

        ibmService.saveMany(results);
        ibmService.saveMany(results2);
    }

    @Scheduled(fixedDelay = 1000)
    public void getMsft(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>MSFT is running");
        WebClient client = WebClient.create("https://exchange.matraining.com/orderbook");

        WebClient client2 = WebClient.create("https://exchange2.matraining.com/orderbook");

        Mono<List<Msft>> response = client.get()
                .uri("/MSFT/open")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Msft>>() {
                });

        Mono<List<Msft>> response2 = client2.get()
                .uri("/MSFT/open")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Msft>>() {
                });

        List<Msft> results = response.block();
        List<Msft> results2 = response2.block();

        msftService.deleteAll();

        assert results != null;
        assert results2 != null;

        results.forEach(r -> r.setExchange("exchange"));
        results2.forEach(r -> r.setExchange("exchange2"));

        msftService.saveMany(results);
        msftService.saveMany(results2);
    }

    @Scheduled(fixedDelay = 1000)
    public void getNflx(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>NFLX is running");
        WebClient client = WebClient.create("https://exchange.matraining.com/orderbook");

        WebClient client2 = WebClient.create("https://exchange2.matraining.com/orderbook");

        Mono<List<Nflx>> response = client.get()
                .uri("/NFLX/open")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Nflx>>() {
                });

        Mono<List<Nflx>> response2 = client2.get()
                .uri("/NFLX/open")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Nflx>>() {
                });

        List<Nflx> results = response.block();
        List<Nflx> results2 = response2.block();

        nflxService.deleteAll();

        assert results != null;
        assert results2 != null;

        results.forEach(r -> r.setExchange("exchange"));
        results2.forEach(r -> r.setExchange("exchange2"));

        nflxService.saveMany(results);
        nflxService.saveMany(results2);
    }

    @Scheduled(fixedDelay = 1000)
    public void getOrcl(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Orcl is running");
        WebClient client = WebClient.create("https://exchange.matraining.com/orderbook");

        WebClient client2 = WebClient.create("https://exchange2.matraining.com/orderbook");

        Mono<List<Orcl>> response = client.get()
                .uri("/ORCL/open")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Orcl>>() {
                });

        Mono<List<Orcl>> response2 = client2.get()
                .uri("/ORCL/open")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Orcl>>() {
                });

        List<Orcl> results = response.block();
        List<Orcl> results2 = response2.block();

        orclService.deleteAll();

        assert results != null;
        assert results2 != null;

        results.forEach(r -> r.setExchange("exchange"));
        results2.forEach(r -> r.setExchange("exchange2"));

        orclService.saveMany(results);
        orclService.saveMany(results2);
    }

    @Scheduled(fixedDelay = 1000)
    public void getTsla(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>TSLA is running");
        WebClient client = WebClient.create("https://exchange.matraining.com/orderbook");

        WebClient client2 = WebClient.create("https://exchange2.matraining.com/orderbook");

        Mono<List<Tsla>> response = client.get()
                .uri("/TSLA/open")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Tsla>>() {
                });

        Mono<List<Tsla>> response2 = client2.get()
                .uri("/TSLA/open")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Tsla>>() {
                });

        List<Tsla> results = response.block();
        List<Tsla> results2 = response2.block();

        tslaService.deleteAll();

        assert results != null;
        assert results2 != null;

        results.forEach(r -> r.setExchange("exchange"));
        results2.forEach(r -> r.setExchange("exchange2"));

        tslaService.saveMany(results);
        tslaService.saveMany(results2);
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean(destroyMethod = "shutdown")
    public Executor taskExecutor(){
        return Executors.newScheduledThreadPool(8);
    }
}
