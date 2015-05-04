/*
 * Web Crawlers In Java:Extracting Email From a Website 
 * http://docs.davidwachira.com/crawler
 */
package webcrawler;

import java.util.regex.*;
import java.net.*;
import java.util.*;
import java.io.*;
import javax.swing.*;

public class ExtractEmailAddress 
{
    List<String> my_List_of_emails = new ArrayList<String>();
    String extracted_email;
    
    public void ExtractEmailAddress(String website_url) throws Exception
    {
        URL url = new URL(website_url);
        try (BufferedReader bufferreader = new BufferedReader( new InputStreamReader(url.openStream()))) 
        {
            String someString;
            while ((someString= bufferreader .readLine()) != null)
                
                CheckEitherEmailOrNot(someString);
         
        }
         catch (Exception e) 
         { 
            System.out.println("Error --> "+ e);
         } 
        
        
        showMessage();
        System.exit(0);
    }


public void CheckEitherEmailOrNot(String p )
{

     Pattern pattern = Pattern.compile("[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})");
             
      Matcher matchs = pattern.matcher(p);
      if (matchs.find()) 
      {

              extracted_email = "" + p.substring( matchs.start(), matchs.end());
              my_List_of_emails.add(extracted_email);
      }
   
}

private void showMessage()
   {
      String details = "";
      for (int i=0;i<my_List_of_emails.size();i++)
        {
            details +=  my_List_of_emails.get(i) + "\n";
        }
      
      if (!(my_List_of_emails.isEmpty()))
            JOptionPane.showMessageDialog(null, details, "The email addresses extracted are", JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Unable to extract any email address from the URL provided");
   }
}
