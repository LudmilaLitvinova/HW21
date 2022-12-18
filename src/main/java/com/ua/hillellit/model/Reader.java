package com.ua.hillellit.model;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.*;
import java.util.List;

/**
 * @author Ludmila Litvinova on 15.12
 */
public class Reader {

    public List<Order> ordersReader(String path) {
        List<Order> listOrders;
        File csvFile = new File(path);

        try {
            CsvMapper csvMapper = new CsvMapper();

            CsvSchema csvSchema = csvMapper
                    .typedSchemaFor(Order.class)
                    .withHeader()
                    .withColumnSeparator(';')
                    .withComments();

            MappingIterator<Order> complexUsersIter = csvMapper
                    .readerWithTypedSchemaFor(Order.class)
                    .with(csvSchema)
                    .readValues(csvFile);


            listOrders = complexUsersIter.readAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return listOrders;
    }

}