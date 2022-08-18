package com.company.model;

import java.util.Arrays;
import java.util.Scanner;

public class Position {
   private int column;
   private int row;
    Scanner scanner=new Scanner(System.in);
    Scanner scanner1=new Scanner(System.in);

   // Position position[][]=new Position[][];
   public int getColumn(){
        return this.column;
    }
   public int getRow(){
        return this.row;
    }

    public void userChoice(){
        System.out.println("Podaj kolumnę:");
        column = scanner.nextInt()-1;
        System.out.println("Podaj wiersz");
        row =scanner1.next().charAt(0)-65;

    }
}
