package Bove.OrderBookService.service;

import Bove.OrderBookService.model.Tsla;
import Bove.OrderBookService.repo.TslaPageSortRepo;
import Bove.OrderBookService.repo.TslaSearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TslaService {
    @Autowired
    TslaSearchRepo tslaSearchRepo;

    @Autowired
    TslaPageSortRepo tslaPageSortRepo;

    public void saveMany(List<Tsla> l) { tslaSearchRepo.saveAll(l); }

    public void deleteAll(){ tslaSearchRepo.deleteAll(); }

    public List<Tsla> findAllPageAndSortBySide (String side, int size) {
        Pageable p = PageRequest.of(0, size, Sort.by("price").ascending());
        Page<Tsla> page = tslaPageSortRepo.findAllBySideAndOrderType(side, "LIMIT", p);

        if(page.hasContent())
            return page.getContent();
        else
            return new ArrayList<Tsla>();
    }
}
