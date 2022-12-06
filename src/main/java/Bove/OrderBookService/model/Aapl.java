package Bove.OrderBookService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

public class Aapl {
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
    private String orderId;

    @Field(type = FieldType.Text, name = "orderType")
    private String orderType;

    @Field(type = FieldType.Integer, name = "cumulatitiveQuantity")
    private int cumulatitiveQuantity;

    private double cumulatitivePrice;
}
