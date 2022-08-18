package com.company.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileController {
    public List<String> readFile() throws IOException {

    return Files.readAllLines(Paths.get("C:/Programowanie/Task1/Words.txt"));

    }
}
