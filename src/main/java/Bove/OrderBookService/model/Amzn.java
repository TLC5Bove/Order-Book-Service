package Bove.OrderBookService.model;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "amzn")
public class Amzn extends Stock{
}
