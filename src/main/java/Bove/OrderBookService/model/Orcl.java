package Bove.OrderBookService.model;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "orcl")
public class Orcl extends Stock{
}
