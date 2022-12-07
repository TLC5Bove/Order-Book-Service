package Bove.OrderBookService.service;

import Bove.OrderBookService.model.Googl;
import Bove.OrderBookService.repo.GooglPageSortRepo;
import Bove.OrderBookService.repo.GooglSearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GooglService {
    @Autowired
    GooglSearchRepo googlSearchRepo;

    @Autowired
    GooglPageSortRepo googlPageSortRepo;

    public void saveMany(List<Googl> l) { googlSearchRepo.saveAll(l); }

    public void deleteAll(){
        googlSearchRepo.deleteAll();
    }

    public List<Googl> findAllPageAndSortBySide (String side, int size) {
        Pageable p = PageRequest.of(0, size, Sort.by("price").ascending());
        Page<Googl> page = googlPageSortRepo.findAllBySideAndOrderType(side, "LIMIT", p);

        if(page.hasContent())
            return page.getContent();
        else
            return new ArrayList<Googl>();
    }
}
