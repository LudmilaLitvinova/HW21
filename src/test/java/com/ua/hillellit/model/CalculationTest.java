package com.ua.hillellit.model;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ludmila Litvinova on 15.12
 */

public class CalculationTest {
    static List<Order> orderList = new ArrayList<>();

    @BeforeAll
    public static void testPreparation() {

        orderList.add(new Order("Сільпо", "Гречка", 50.3, 56));
        orderList.add(new Order("АТБ", "Вівсянка", 40.5, 32));
        orderList.add(new Order("Сільпо", "Гречка", 51.7, 45));
        orderList.add(new Order("АТБ", "Вівсянка", 41.5, 78));
    }

    @Test
    public void testReader() {

        Reader reader = Mockito.mock(Reader.class);
        Mockito.when(reader.ordersReader("")).thenReturn(orderList);

        Assertions.assertEquals(orderList, reader.ordersReader(""));

    }

    @Test
    public void testCalculation() {
        Map<String, List<String>> expectedResult = new HashMap<>();
        Calculation calculation = new Calculation();
        expectedResult.put("Сільпо", Lists.newArrayList("Гречка;51,00;101;"));
        expectedResult.put("АТБ", Lists.newArrayList("Вівсянка;41,00;110;"));

        Assertions.assertEquals(expectedResult, calculation.calculateResultByStore(orderList));
    }
}
