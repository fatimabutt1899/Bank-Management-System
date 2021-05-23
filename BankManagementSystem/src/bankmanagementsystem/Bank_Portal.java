
package bankmanagementsystem;
import java.sql.*;
import javax.swing.JOptionPane;

public class Bank_Portal {
    ConnectionToDB ConToDB=new ConnectionToDB();
    Connection con = ConToDB.EstabConnec(); 
    Statement stat=null; // insert, update, delete
    PreparedStatement pstat=null; // select            
    ResultSet res = null;
    
    int id,accNum,balance;
    String fullName,email,phone,address,DOB,accType; 
    
     public boolean DeleteUser(int UID)
    {
        boolean b=false;
        String sql="Delete from Customer where ID='"+UID+"'";
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
     
     public boolean FetchUser(int UID)
      {
         boolean b=false;
        String FetchString= "Select * from Customer where ID='"+UID+"'";
          try
          {
            pstat=con.prepareStatement(FetchString);
            res=pstat.executeQuery(); 
            this.id=UID;
            while(res.next())
            {   
                this.fullName=res.getString("FullName");
                this.email=res.getString("Email");
                this.phone=res.getString("Phone");
                this.address=res.getString("Address");
                this.DOB=res.getString("DOB");
                this.accNum=res.getInt("AccountNumber");
                this.DOB=res.getString("DOB");
                this.accType=res.getString("AccountType");
                this.balance=res.getInt("Balance");
                
                b= true;
                
            }
            
          }catch(Exception ex)
          {
            JOptionPane.showMessageDialog(null, ex);
            b= false;
          }
        return b;
      }
     
     public boolean UpdateUser(int UID, String FName, String email, String phone, String address,String dob)//, int accNum, String accType, int balance)
      {
          boolean b=false;
          String updatUser = "update Customer set (FullName,Email,Phone,Address,DOB) = ('"+FName+"','"+email+"','"+phone+"','"+address+"','"+dob+"') where ID ='"+UID+"' " ;
         
          try
          {
            stat=con.createStatement();
            
            int result = stat.executeUpdate(updatUser);
            
            if(result>0)
            {   
                b= true;
            }
            
          }
          catch(SQLException ex)
          {
           JOptionPane.showMessageDialog(null, ex);
            b= false;
          }
        return b;
      }
}
