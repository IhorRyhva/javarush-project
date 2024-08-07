package com.javarush.task.task18.task1815;

import java.util.Collections;
import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface{

        private TableInterface tableInterface;
        private String newHeaderText;
        public TableInterfaceWrapper(TableInterface tableInterface){
            this.tableInterface = tableInterface;
        }
        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            tableInterface.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return tableInterface.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            this.newHeaderText = newHeaderText;
            tableInterface.setHeaderText(newHeaderText);
        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}