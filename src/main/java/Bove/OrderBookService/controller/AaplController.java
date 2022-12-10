package Bove.OrderBookService.controller;

import Bove.OrderBookService.model.Aapl;
import Bove.OrderBookService.model.Ibm;
import Bove.OrderBookService.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AaplController {
    @Autowired
    AaplService aaplService;

    @Autowired
    IbmService ibmService;

    @GetMapping(value = "/")
    public List<Aapl> home(){
        Iterable<Aapl> aapl = aaplService.findAllPageAndSortBySide("SELL", 10);
        List<Aapl> list = new ArrayList<>();
        aapl.forEach(list::add);

        return list;
    }

    @DeleteMapping("/")
    public void delete(){
        aaplService.deleteAll();
    }
}
