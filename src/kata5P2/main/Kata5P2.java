package kata5P2.main;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import kata5P2.view.HistogramDisplay;
import kata5P2.model.Histogram;
import kata5P2.model.Mail;
import kata5P2.view.MailHistogramBuilder;
import kata5P2.view.MailListReader;
import kata5P2.view.MailListReaderDDBB;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author usuario
 */
public class Kata5P2 {

    /**
     * @param args the command line arguments
     */
    ArrayList<String> arrayMail;
    private String filename;
    private List<Mail> mailList;
    private Histogram<String> histogram;
    private HistogramDisplay histoDisplay;
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
        Kata5P2 kata5 = new Kata5P2();
        kata5.execute();  
    }

    public Kata5P2() throws ClassNotFoundException, SQLException {
        this.arrayMail = MailListReaderDDBB.readDDBB();
    }
    
    private void execute()throws Exception{
        input();
        process();
        output();
    }
    
    private void input() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
        filename = "C:/Users/usuario/Documents/NetBeansProjects/kata5/src/kata5P2/main/emails.txt";
        arrayMail=MailListReaderDDBB.readDDBB();
    }
    
    private void process(){
        histogram = MailHistogramBuilder.build(mailList);
    }
    
    private void output(){
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute(); 
    }
}
