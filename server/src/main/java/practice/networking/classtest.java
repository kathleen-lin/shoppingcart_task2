package practice.networking;

import java.util.List;

public class classtest {

    private List<String> items;

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }




    public String delete (String removal){
        String toDelete = items.get(Integer.parseInt(removal) + 1 );
        for (int i = 0; i < items.size(); i++){
            if (items.get(i).equals(toDelete)){
                items.remove(toDelete);
            }
        } return toDelete + " removed from cart";
    }

}




    