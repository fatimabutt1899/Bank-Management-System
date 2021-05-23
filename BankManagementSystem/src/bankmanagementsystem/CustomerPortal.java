
package bankmanagementsystem;
import java.sql.*;
import javax.swing.JOptionPane;

public class CustomerPortal {

    ConnectionToDB ConToDB=new ConnectionToDB();
    Connection con = ConToDB.EstabConnec(); 
    Statement stat=null; // insert, update, delete
    PreparedStatement pstat=null; // select            
    ResultSet res = null;
    
    int ID,AccNumbwe;
    String AccType;
    
    public boolean AddAccount(int ID ,int AccNum, String AccType)
    {
        boolean b=false;
        String sql="update Customer set (AccountNumber,AccountType)=('"+AccNum+"','"+AccType+"') where ID='"+ID+"'";
        try
        {
            stat=con.createStatement(); // convert a statement into query
            int res=stat.executeUpdate(sql); // if that query is executed, means if data is entered then int will greater than 0 else it will be 0
            if(res>0)
            {
               // JOptionPane.showMessageDialog(null, "Data Inserted");
                b = true;
            }
            else
            {
                b=false;
                //JOptionPane.showMessageDialog(null, "Error");
            }
            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        return b;
    }
}
