package Bove.OrderBookService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document(indexName = "exchange-1")
@Data
public class Ibm implements Stock{
    @Id
    private String id;

    @Field(type = FieldType.Text, name = "product")
    private String product;

    @Field(type = FieldType.Integer, name = "quantity")
    private int quantity;

    @Field(type = FieldType.Double, name = "price")
    private Double price;

    @Field(type = FieldType.Text, name = "side")
    private String side;

    private List<Executions> executions;

    @Field(type = FieldType.Text, name = "orderId")
    private String orderID;

    @Field(type = FieldType.Text, name = "orderType")
    private String orderType;

    @Field(type = FieldType.Text, name = "exchange")
    private String exchange;

    @Field(type = FieldType.Integer, name = "cumulatitiveQuantity")
    private int cumulatitiveQuantity;

    private double cumulatitivePrice;
}
