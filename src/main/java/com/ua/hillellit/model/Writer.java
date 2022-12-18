package com.ua.hillellit.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Ludmila Litvinova on 15.12
 */
public class Writer {

    public void writeText(File file, String text) {
        try (BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferWriter.write(text + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
