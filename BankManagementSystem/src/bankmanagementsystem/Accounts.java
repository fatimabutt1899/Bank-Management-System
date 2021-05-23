package bankmanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Accounts {
    
    ConnectionToDB ConToDB=new ConnectionToDB();
    Connection con = ConToDB.EstabConnec(); 
    Statement stat=null; // insert, update, delete
    PreparedStatement pstat=null; // select            
    ResultSet res = null;
    
    int ID, AddBal ;
    float PrevBal;
    String AccType;
    public boolean AddBalance(int ID, float bal)
    {
        this.ID=ID;
        boolean b=false;
        float ba =BalCheck(bal);
        String sql="update Customer set Balance = '"+ba+"' where ID='"+this.ID+"'";
        try
        {
            stat=con.createStatement(); // convert a statement into query
            int res=stat.executeUpdate(sql); // if that query is executed, means if data is entered then int will greater than 0 else it will be 0
            if(res>0)
            {
                b = true;
            }
            else
            {
                b=false;
            }
            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        return b;
    }
    
    
    public float BalCheck(float bal)
    {
        float newBal = 0;
         String FetchQuery= "Select * from Customer where ID='"+this.ID+"'";
         
         
         try
        {
           pstat=con.prepareStatement(FetchQuery);
           res=pstat.executeQuery(); 
         
            while(res.next())
            {   
                AccType=res.getString("AccountType");
                PrevBal=res.getFloat("Balance");
            }
           Current c = new Current();
           Savings s = new Savings();
           
           if(AccType.equals("Current"))
           {
               newBal=c.balCal(bal);
           }
           else 
           {
              newBal= s.balCal(bal);
           }
            
            
            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        } 
        return newBal+PrevBal;
    }
    
    public float balCal(float bal)
    {
        PrevBal +=bal; 
        
        if(PrevBal<=5000000)
        {
            return PrevBal;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Limit Reached");
        }
        return 0;
    }
}
