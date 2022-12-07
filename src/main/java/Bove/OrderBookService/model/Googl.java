package Bove.OrderBookService.model;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "googl")
public class Googl extends Stock{
}
