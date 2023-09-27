package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
        List<LocalDate> testList = new ArrayList<>();
        testList.add(LocalDate.of(2004,7,1));
        testList.add(LocalDate.of(2005,1,2));
        testList.add(LocalDate.of(2007,1,1));
        testList.add(LocalDate.of(2032, 5,3));
        //testList.add(LocalDate.of(2007,1,8));
        System.out.println("before " + testList);
        System.out.println("after " + new DateSorter().sortDates(testList));
    }
}