package com.vois.autotask;

import DataManipulation.Data_Manipulation_Sikuli;
import DataManipulation.Excel_Sheet_Manipulation;


public class Main {
    public static void main(String[] args) {

        //hello

        //Manipulate Excel using java
        Excel_Sheet_Manipulation excelSheetManipulation = new Excel_Sheet_Manipulation();

        excelSheetManipulation.readDataFromExcel("C:\\Users\\yraga\\Downloads\\TaskData.xlsx");

        //Manipulate Excel using Sikuli
        Data_Manipulation_Sikuli.sortAndRemoveDuplicate();
    }
}