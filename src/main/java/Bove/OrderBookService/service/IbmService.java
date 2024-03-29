package Bove.OrderBookService.service;

import Bove.OrderBookService.model.Ibm;
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
public class IbmService {
    @Autowired
    IbmSearchRepo ibmSearchRepo;

    @Autowired
    IbmPageSortRepo ibmPageSortRepo;

    public void saveMany(List<Ibm> l) { ibmSearchRepo.saveAll(l); }

    public void deleteAll(){
        ibmSearchRepo.deleteAll();
    }

    public List<Ibm> findAllPageAndSortBySide (String side, int size) {
        Pageable p = PageRequest.of(0, size, Sort.by("price").ascending());
        Page<Ibm> page = ibmPageSortRepo.findAllBySideAndOrderType(side, "LIMIT", p);

        if(page.hasContent()) {
            return page.getContent();
        }
        else
            return new ArrayList<Ibm>();
    }
}
