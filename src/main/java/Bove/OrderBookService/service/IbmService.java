package Bove.OrderBookService.service;

import Bove.OrderBookService.model.Ibm;
import Bove.OrderBookService.repo.IbmPageSortRepo;
import Bove.OrderBookService.repo.IbmSearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class IbmService {
    @Autowired
    IbmSearchRepo exchange1SearchRepo;

    @Autowired
    IbmPageSortRepo exchange1PageAndSort;

    public void saveOrder(Ibm o) {
        exchange1SearchRepo.save(o);
    }

    public Ibm findOrderById(String id){
        return exchange1SearchRepo.findById(id).orElse(new Ibm());
    }

    public Iterable<Ibm> findAll() {
        return exchange1SearchRepo.findAll();
    }

    public List<Ibm> findAllAndSort() {
        return (List<Ibm>) exchange1PageAndSort.findAll(Sort.by("price").ascending());
    }

    public void deleteAll(){
        exchange1SearchRepo.deleteAll();
    }

    public List<Ibm> findAllPageAndSort () {
        Pageable p = PageRequest.of(1, 5, Sort.by("price").ascending());
        Page<Ibm> page = exchange1PageAndSort.findAll(p);

        if(page.hasContent())
            return page.getContent();
        else
            return new ArrayList<Ibm>();
    }

    public List<Ibm> findAllPageAndSortBySide () {
        Pageable p = PageRequest.of(1, 5, Sort.by("price").ascending());
        Page<Ibm> page = exchange1PageAndSort.findAllBySide("SELL", p);

        if(page.hasContent())
            return page.getContent();
        else
            return new ArrayList<Ibm>();
    }
}
