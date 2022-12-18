package com.ua.hillellit.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Ludmila Litvinova on 15.12
 */
@AllArgsConstructor
@Data
@JsonPropertyOrder({"storeName", "productName", "productPrice", "countOfProduct"})
public class Order {

    private String storeName;
    private String productName;
    private double productPrice;
    private int countOfProduct;

}
