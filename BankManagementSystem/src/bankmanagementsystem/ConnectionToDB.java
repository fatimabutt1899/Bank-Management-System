
package bankmanagementsystem;


 import java.sql.*;
import javax.swing.JOptionPane;
 
public class ConnectionToDB {
    Connection ConToDB=null; // connect with DB
    
    
    public Connection EstabConnec()
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            ConToDB=DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Zaka\\Desktop\\Assignment\\Sem2\\OOP Lab\\Bank-Management-System_035_037_096\\DB_BMS.accdb");
           // JOptionPane.showMessageDialog(null, "Connected");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        return ConToDB;
    }
    
}
