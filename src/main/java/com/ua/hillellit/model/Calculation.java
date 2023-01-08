package com.ua.hillellit.model;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Ludmila Litvinova on 15.12
 */
public class Calculation {
    public Map<String, List<String>> calculateResultByStore(List<Order> list) {

        Map<String, List<String>> resultByStore = new HashMap<>();
        Set<String> storeNames = list.stream().map(Order::getStoreName).collect(Collectors.toSet());

        for (String name : storeNames) {

            List<String> productsList = new ArrayList<>();

            List<Order> curList = list.stream().filter(o ->
                    o.getStoreName().equals(name)).collect(Collectors.toList());

            Map<String, Integer> countsByProduct = curList.stream().collect(
                    Collectors.groupingBy(
                            Order::getProductName,
                            Collectors.summingInt(Order::getCountOfProduct)));
            Map<String, Double> avgPriceByProduct = curList.stream().collect(
                    Collectors.groupingBy(
                            Order::getProductName,
                            Collectors.averagingDouble(Order::getProductPrice)));
            for (Map.Entry<String, Double> item : avgPriceByProduct.entrySet()) {
                String text = item.getKey() + ";" + String.format("%.2f", item.getValue()) + ";"
                        + countsByProduct.get(item.getKey()) + ";";
                productsList.add(text);
            }
            resultByStore.put(name, productsList);
        }
        return resultByStore;
    }
}
