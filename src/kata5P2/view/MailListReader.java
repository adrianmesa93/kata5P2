/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5P2.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kata5P2.model.Mail;

/**
 *
 * @author usuario
 */
public class MailListReader {
    
    public static List<Mail> read(String fileName) throws FileNotFoundException, IOException{
        List<Mail> mailList = new ArrayList<Mail>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
        String mail;
        while((mail = reader.readLine()) != null){
            if(mail.contains("@")){
                mailList.add(new Mail(mail));
            }
        }
        reader.close();
        return mailList;
    }
}
