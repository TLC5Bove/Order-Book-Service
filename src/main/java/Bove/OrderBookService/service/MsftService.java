package Bove.OrderBookService.service;

import Bove.OrderBookService.model.Msft;
import Bove.OrderBookService.repo.MsftPageSortRepo;
import Bove.OrderBookService.repo.MsftSearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MsftService {
    @Autowired
    MsftSearchRepo msftSearchRepo;

    @Autowired
    MsftPageSortRepo msftPageSortRepo;

    public void saveMany(List<Msft> l) { msftSearchRepo.saveAll(l); }

    public void deleteAll(){ msftSearchRepo.deleteAll(); }

    public List<Msft> findAllPageAndSortBySide (String side, int size) {
        Pageable p = PageRequest.of(0, size, Sort.by("price").ascending());
        Page<Msft> page = msftPageSortRepo.findAllBySideAndOrderType(side, "LIMIT", p);

        if(page.hasContent())
            return page.getContent();
        else
            return new ArrayList<Msft>();
    }
}
