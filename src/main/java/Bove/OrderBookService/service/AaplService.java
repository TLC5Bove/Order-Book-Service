package Bove.OrderBookService.service;

import Bove.OrderBookService.model.Aapl;
import Bove.OrderBookService.model.Ibm;
import Bove.OrderBookService.repo.AaplPageSortRepo;
import Bove.OrderBookService.repo.AaplSearchRepo;
import Bove.OrderBookService.repo.IbmPageSortRepo;
import Bove.OrderBookService.repo.IbmSearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AaplService {
    @Autowired
    AaplSearchRepo aaplSearchRepo;

    @Autowired
    AaplPageSortRepo aaplPageSortRepo;

    public void saveOrder(Aapl o) {
        aaplSearchRepo.save(o);
    }

    public Aapl findOrderById(String id){
        return aaplSearchRepo.findById(id).orElse(new Aapl());
    }

    public Iterable<Aapl> findAll() {
        return aaplSearchRepo.findAll();
    }

    public List<Aapl> findAllAndSort() {
        return (List<Aapl>) aaplPageSortRepo.findAll(Sort.by("price").ascending());
    }

    public void deleteAll(){
        aaplSearchRepo.deleteAll();
    }

    public List<Aapl> findAllPageAndSort () {
        Pageable p = PageRequest.of(1, 5, Sort.by("price").ascending());
        Page<Aapl> page = aaplPageSortRepo.findAll(p);

        if(page.hasContent())
            return page.getContent();
        else
            return new ArrayList<Aapl>();
    }

    public List<Aapl> findAllPageAndSortBySide () {
        Pageable p = PageRequest.of(1, 5, Sort.by("price").ascending());
        Page<Aapl> page = aaplPageSortRepo.findAllBySide("SELL", p);

        if(page.hasContent())
            return page.getContent();
        else
            return new ArrayList<Aapl>();
    }
}
