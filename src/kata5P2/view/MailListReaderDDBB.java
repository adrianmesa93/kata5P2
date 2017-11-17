/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5P2.view;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class MailListReaderDDBB {
    
    public static ArrayList<String> readDDBB() throws ClassNotFoundException, SQLException{
        ArrayList<String> mailList = new ArrayList<>();
        
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/usuario/Downloads/SQLiteDatabaseBrowserPortable/Data/katas.db");
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT mail FROM MAIL");
        
        while(rs.next()){
            String mail = rs.getString("mail");
            if(!mail.contains("@"))continue;
            mailList.add(mail);
        }
        return mailList;
    }
}
