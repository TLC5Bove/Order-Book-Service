package Bove.OrderBookService.service;

import Bove.OrderBookService.model.Nflx;
import Bove.OrderBookService.repo.NflxPageSortRepo;
import Bove.OrderBookService.repo.NflxSearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NflxService {
    @Autowired
    NflxSearchRepo nflxSearchRepo;

    @Autowired
    NflxPageSortRepo nflxPageSortRepo;

    public void saveMany(List<Nflx> l) { nflxSearchRepo.saveAll(l); }

    public void deleteAll(){ nflxSearchRepo.deleteAll(); }

    public List<Nflx> findAllPageAndSortBySide (String side, int size) {
        Pageable p = PageRequest.of(0, size, Sort.by("price").ascending());
        Page<Nflx> page = nflxPageSortRepo.findAllBySideAndOrderType(side, "LIMIT", p);

        if(page.hasContent())
            return page.getContent();
        else
            return new ArrayList<Nflx>();
    }
}
