package practice.networking;

import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {
        
        classtest ct = new classtest();

        List<String> items = new ArrayList<>();

        items.add("happy");
        items.add("go");
        items.add("lucky");

        ct.setItems(items);

        for (int i = 0; i < ct.getItems().size(); i++){
            System.out.println(ct.getItems().get(i));
        }

        ct.delete("1");

        for (int i = 0; i < ct.getItems().size(); i++){
            System.out.println(ct.getItems().get(i));
        }
    }



}
