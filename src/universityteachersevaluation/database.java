    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityteachersevaluation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author kk
 */
public class database {

    /**
     * @param args the command line arguments
     */
    Connection conn = null;
    public static Connection connDB()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/universityevaluation", "root", "");
            return conn;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please start wamp server and restart this application");
            return null;
        }
    }
    
    static void insert(Connection conn, String name, int age, String dept){
        try {
            String sql="INSERT INTO teachers(name,age,dept) VALUES(?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, name);
            pst.setInt(2, age);
            pst.setString(3, dept);
            
            pst.executeUpdate();
           
            ResultSet rs = pst.getGeneratedKeys();
            
            if (rs.next())
                JOptionPane.showMessageDialog(null, "Inserterd ID = "+rs.getInt(1));
            else
                JOptionPane.showMessageDialog(null, "There is some error");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    static void update(Connection conn, int id, String name, int age, String dept){
        try {
            String sql="UPDATE some SET name = ?, age = ?, dept = ? WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setInt(2, age);
            pst.setString(3, dept);            
            pst.setInt(4, id);
            
            int result = pst.executeUpdate();
            
            if (result > 0)
                JOptionPane.showMessageDialog(null, "Successfully updated");
            else
                JOptionPane.showMessageDialog(null, "There is some error");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    static void delete(Connection conn, int id){
        try {
            String sql="DELETE FROM some WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            
            int result = pst.executeUpdate();
            
            if (result > 0)
                JOptionPane.showMessageDialog(null, "Successfully deleted");
            else
                JOptionPane.showMessageDialog(null, "There is some error");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    static void select(Connection conn)
    {
        try{
            String sql = "SELECT * FROM some";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            System.out.println("ID\tName\tAge\tDept");
            System.out.println("--\t----\t---\t----");
            while(rs.next()){
                System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+ rs.getString(3)+"\t"+ rs.getString(4));
            }
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}