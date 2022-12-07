package Bove.OrderBookService.service;

import Bove.OrderBookService.model.Msft;
import Bove.OrderBookService.model.Orcl;
import Bove.OrderBookService.repo.OrclPageSortRepo;
import Bove.OrderBookService.repo.OrclSearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrclService {
    @Autowired
    OrclSearchRepo orclSearchRepo;

    @Autowired
    OrclPageSortRepo orclPageSortRepo;

    public void saveMany(List<Orcl> l) { orclSearchRepo.saveAll(l); }

    public void deleteAll(){ orclSearchRepo.deleteAll(); }

    public List<Orcl> findAllPageAndSortBySide (String side, int size) {
        Pageable p = PageRequest.of(0, size, Sort.by("price").ascending());
        Page<Orcl> page = orclPageSortRepo.findAllBySideAndOrderType(side, "LIMIT", p);

        if(page.hasContent())
            return page.getContent();
        else
            return new ArrayList<Orcl>();
    }
}
