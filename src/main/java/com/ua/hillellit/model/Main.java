package com.ua.hillellit.model;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author Ludmila Litvinova on 15.12
 */
public class Main {
    public static void main(String[] args) {

        Reader reader = new Reader();
        Writer writer = new Writer();
        Calculation calculation = new Calculation();

        List<Order> l1 = reader.ordersReader("C:\\Users\\gf-mi\\IdeaProjects\\HW21\\src\\main\\resources\\order_1.csv");
        List<Order> l2 = reader.ordersReader("C:\\Users\\gf-mi\\IdeaProjects\\HW21\\src\\main\\resources\\order_2.csv");

        l1.addAll(l2);
        Map<String, List<String>> resultByStore = calculation.calculateResultByStore(l1);
        for (Map.Entry<String, List<String>> item : resultByStore.entrySet()) {
            File file = new File(item.getKey().toLowerCase() + "_res.csv");
            writer.writeText(file, "НАИМЕНОВАНИЕ;ЦЕНА;ШТ;");
            for (String text: item.getValue()) {
                writer.writeText(file, text);
            }


        }
    }
}