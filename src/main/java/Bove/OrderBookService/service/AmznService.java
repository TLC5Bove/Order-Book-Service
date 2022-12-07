package Bove.OrderBookService.service;

import Bove.OrderBookService.model.Amzn;
import Bove.OrderBookService.repo.AmznPageSortRepo;
import Bove.OrderBookService.repo.AmznSearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmznService {
    @Autowired
    AmznSearchRepo amznSearchRepo;

    @Autowired
    AmznPageSortRepo amznPageSortRepo;

    public void saveMany(List<Amzn> l) { amznSearchRepo.saveAll(l); }

    public void deleteAll(){
        amznSearchRepo.deleteAll();
    }

    public List<Amzn> findAllPageAndSortBySide (String side, int size) {
        Pageable p = PageRequest.of(0, size, Sort.by("price").ascending());
        Page<Amzn> page = amznPageSortRepo.findAllBySideAndOrderType(side, "LIMIT", p);

        if(page.hasContent())
            return page.getContent();
        else
            return new ArrayList<Amzn>();
    }

}
