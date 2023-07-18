
package electricity.billing.system;

import java.sql.*;

// 1.Register the Driver Class 
// 2.Creating the onnection with sql
// 3.Creating a statement
// 4.execute mysql Queries    
//  5. Closing the Connection   
public class Conn {
    Connection c;
    Statement s;
    Conn(){
        //Class.forName(""); // register sql driver Class
        // It Register the Automatically
        
        // 2.Creating the onnection with sql
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs","root","root");
            s = c.createStatement() ;
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
