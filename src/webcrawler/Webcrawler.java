
package webcrawler;

import java.io.IOException;
import javax.swing.*;

public class Webcrawler
{

    public static void main(String[] args) throws Exception 
    {   
        JFrame frame = new JFrame("Input Dialog");
        String url_to_extract_emails_from = (String)JOptionPane.showInputDialog
                                                 (
                                                    frame, 
                                                    "Enter the website (url) to extract emails from: ", 
                                                    "Extract Email Addresses", 
                                                    JOptionPane.QUESTION_MESSAGE,
                                                    null,null,"http://docs.davidwachira.com/extractemails"
                                                 );
     
        ExtractEmailAddress Obj_ExtractEmails = new ExtractEmailAddress(); 
        Obj_ExtractEmails.ExtractEmailAddress(url_to_extract_emails_from);
    }
    
}
