package practice.networking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<String> items;

    //getters and setters
    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    //no constructor -- java default constructor

    //methods
    public void load(File f) throws IOException{
        //read memory from file and add them to this.items
        List<String> toAdd = new ArrayList<>();
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        while ((line = br.readLine()) != null){
            toAdd.add(line);
        }
        this.items = toAdd;

    }

    public String list(){
        String list = "";
        for (int i = 0; i < this.items.size(); i++){
            list = list + String.valueOf(i + 1) + ". " + this.items.get(i) + "\n";
        }
        return list;
    }
    


    
}
