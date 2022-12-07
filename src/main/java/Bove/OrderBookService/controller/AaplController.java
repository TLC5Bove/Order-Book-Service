package Bove.OrderBookService.controller;

import Bove.OrderBookService.model.*;
import Bove.OrderBookService.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AaplController {
    @Autowired
    AaplService aaplService;

    @Autowired
    IbmService ibmService;

    @Autowired
    AmznService amznService;

    @Autowired
    GooglService googlService;

    @Autowired
    MsftService msftService;

    @Autowired
    NflxService nflxService;

    @Autowired
    OrclService orclService;

    @Autowired
    TslaService tslaService;

    @GetMapping("/ibm/{side}")
    public List<Ibm> getIbm(@PathVariable("side") String side){
        return ibmService.findAllPageAndSortBySide(side, 10);
    }

    @GetMapping("/aapl/{side}")
    public List<Aapl> getAapl(@PathVariable("side") String side){
        return aaplService.findAllPageAndSortBySide(side, 10);
    }

    @GetMapping("/amzn/{side}")
    public List<Amzn> getAmzn(@PathVariable("side") String side) {
        return amznService.findAllPageAndSortBySide(side, 10);
    }

    @GetMapping("/googl/{side}")
    public List<Googl> getGoogl(@PathVariable("side") String side) {
        return googlService.findAllPageAndSortBySide(side, 10);
    }

    @GetMapping("/msft/{side}")
    public List<Msft> getMsft(@PathVariable("side") String side) {
        return msftService.findAllPageAndSortBySide(side, 10);
    }

    @GetMapping("/nflx/{side}")
    public List<Nflx> getNflx(@PathVariable("side") String side) {
        return nflxService.findAllPageAndSortBySide(side, 10);
    }

    @GetMapping("/orcl/{side}")
    public List<Orcl> getOrcl(@PathVariable("side") String side) {
        return orclService.findAllPageAndSortBySide(side, 10);
    }

    @GetMapping("/tsla/{side}")
    public List<Tsla> getTsla(@PathVariable("side") String side) {
        return tslaService.findAllPageAndSortBySide(side, 10);
    }


    //    @GetMapping(value = "/allAapl")
//    public List<Aapl> allaapl(){
//        Iterable<Aapl> aapl = aaplService.findAll();
//        List<Aapl> list = new ArrayList<>();
//        aapl.forEach(list::add);
//
//        return list;
//    }
}
