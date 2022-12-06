package Bove.OrderBookService.controller;

import Bove.OrderBookService.model.Ibm;
import Bove.OrderBookService.repo.IbmSearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class Exchange1Controller {
}
