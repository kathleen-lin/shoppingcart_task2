package practice.networking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
        br.close();

    }

    public String list(){
        String list = "";

        if (this.items.isEmpty()){
            list += "Your cart is empty"; 
        } else {
            for (int i = 0; i < this.items.size(); i++){
                list = list + String.valueOf(i + 1) + ". " + this.items.get(i) + "\n";
            }
        }
        return list;
    }

    
    public String add (String addition, File f) {
        
        String[] additionItem = addition.split(" ");

        for (int i = 0; i < additionItem.length; i++){
            items.add(additionItem[i]);
        } return addition + " added to cart";
        /*return the updated list
        String list = "";
        for (int j = 0; j < this.items.size(); j++){
            list = list + String.valueOf(j+1) + ". " + this.items.get(j) + "\n";
        } return list; */
    }

    public String delete (String removal){
        String toDelete = items.get(Integer.parseInt(removal) - 1 );
        System.out.println("index to delete is: " + Integer.parseInt(removal) + 1);
        for (int i = 0; i < items.size(); i++){
            if (items.get(i).equals(toDelete)){
                items.remove(toDelete);
            }
        } return toDelete + " removed from cart";
    }

    public void save (File f, String userName) throws IOException{
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < this.items.size(); i++){
            bw.write(items.get(i) + "\n");
            
        } bw.close();

    }
     


    
}
