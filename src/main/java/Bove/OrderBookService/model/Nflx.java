package Bove.OrderBookService.model;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "nflx")
public class Nflx extends Stock{
}
