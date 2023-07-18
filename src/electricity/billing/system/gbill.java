/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;

/**
 *
 * @author DELL
 */
public class gbill {
    
}

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
 
class TableUsingModel{
   public static void main(String args[]){
      JFrame frame = new JFrame();
      JTable table = new JTable(new MyTableModel());
 
      frame.add(table);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(400,400);
      frame.setLocationRelativeTo(null);  
      frame.setVisible(true);
   }
}
 
class MyTableModel extends AbstractTableModel {
   String[] columnNames = {"Name", "Age", "Location"};
 
      Object[][] data = {
       {"Ken", new Integer(25), "Nairobi"},
       {"Tom", new Integer(31), "Geneva"},
       {"Sheila", new Integer(29), "Paris"},
       {"Mark",new Integer(20), "Cairo"},
       {"Jessie", new Integer(18), "Miami"}
   };
 
   public int getRowCount() {
       return data.length;
   }
 
   public int getColumnCount() {
       return columnNames.length;
   }
  
   public Object getValueAt(int row, int col) {
       return data[row][col];
   }
 
}