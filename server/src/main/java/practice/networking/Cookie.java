package practice.networking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Cookie {
    
    private List<String> cookieQuotes;

    public List<String> getCookieQuotes() {
        return cookieQuotes;
    }

    public void setCookieQuotes(List<String> cookieQuotes) {
        this.cookieQuotes = cookieQuotes;
    }

    
    //java provides default constructors

    public String pickCookie(){

        List<String> cookieQuotes = new ArrayList<>();
        File f = new File("./cookie.txt");
        
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String quotes = "";
            
            while ((quotes= br.readLine()) != null){
                cookieQuotes.add(quotes);
            }
            
            br.close();

        } catch (Exception e) {
            
        }

        Random rand = new Random();
        int index = rand.nextInt(cookieQuotes.size());

        String yourCookie = cookieQuotes.get(index);
    
        return yourCookie;

        
        
    }


    
}
