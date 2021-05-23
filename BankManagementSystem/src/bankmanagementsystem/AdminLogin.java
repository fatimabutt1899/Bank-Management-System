package bankmanagementsystem;


import java.sql.*;
import javax.swing.JOptionPane;
public class AdminLogin {
    ConnectionToDB con = new ConnectionToDB();
    Connection con_obj = con.EstabConnec();
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet res = null;
    String name, password, email, address, phone, dateOfBirth ;
    public boolean addAdmin(String name, String password, String email,String address, String Phone, String dateOfBirth) 
    {
        boolean b = false;
        String sql ="insert into Admin(FullName, Password, Email, Phone, Address, DOB)values('"+name+"','"+password+"','"+email+"','"+address+"','"+Phone+"','"+dateOfBirth+"')";
        try
        {
            stmt = con_obj.createStatement();
            
            int res =stmt.executeUpdate(sql);
            if(res>0)
            {
//                JOptionPane.showMessageDialog(null, "Insterted");
                b = true;
            }
            else
            {
//                JOptionPane.showMessageDialog(null, "Error");
                b = false;
              
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        return b;
    }
    public boolean addCustomer(String name, String email,String address, String Phone, String dateOfBirth) 
    {
        boolean b = false;
        String sql ="insert into Customer(FullName, Email, Phone, Address, DOB)values('"+name+"','"+email+"','"+address+"','"+Phone+"','"+dateOfBirth+"')";
        try
        {
            stmt = con_obj.createStatement();
            
            int res =stmt.executeUpdate(sql);
            if(res>0)
            {
//                JOptionPane.showMessageDialog(null, "Insterted");
                b = true;
            }
            else
            {
//                JOptionPane.showMessageDialog(null, "Error");
                b = false;
              
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        return b;
    }
    
    public boolean LoginUser(String id, String password)
    {
        String loginString = "Select * from Admin where ID ='"+id+"' and Password ='"+password+"' ";
        boolean b;
        try
        {
            pstmt = con_obj.prepareStatement(loginString);
            res = pstmt.executeQuery();
            if (res.next())
            {
                b = true;
            }
            else 
            {
                b = false;
            }
        }
        
        catch(Exception ex)        
        {
            JOptionPane.showMessageDialog(null, ex);
            b = false;
        }
        return b;
    }
}
