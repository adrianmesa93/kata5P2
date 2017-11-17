package kata5P2.main;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import kata5P2.view.HistogramDisplay;
import kata5P2.model.Histogram;
import kata5P2.model.Mail;
import kata5P2.view.MailHistogramBuilder;
import kata5P2.view.MailListReader;

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
    
    private String filename;
    private List<Mail> mailList;
    private Histogram<String> histogram;
    private HistogramDisplay histoDisplay;
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
        Kata5P2 kata4 = new Kata5P2();
        kata4.execute();  
    }
    
    private void execute()throws Exception{
        input();
        process();
        output();
    }
    
    private void input() throws FileNotFoundException, IOException{
        filename = "C:/Users/usuario/Documents/NetBeansProjects/kata5/src/kata5P2/main/emails.txt";
        mailList=MailListReader.read(filename);
    }
    
    private void process(){
        histogram = MailHistogramBuilder.build(mailList);
    }
    
    private void output(){
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute(); 
    }
}
