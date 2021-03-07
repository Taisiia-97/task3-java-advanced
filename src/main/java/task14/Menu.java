package task14;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Menu {
    private  List<MenuItem> menuItems;

    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void print() {
        menuItems.stream().forEach(element -> {
            System.out.println(element.getNumber() + " " + element.getLabel());
        });
    }

    public void process(int number) {
        menuItems.stream().filter(element -> element.getNumber() == number).forEach(element -> {
            try {
                element.process();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    public boolean verifyMenuItem(String input){
        int command;
        try{
          command =  Integer.parseInt(input);
            for (MenuItem menuItem : menuItems) {
                if(menuItem.getNumber()==command) return true;
            }
          }
        catch (Exception e){
            System.out.println("Musisz wpisać liczbę ");
            return false;
        }
        return false;
    }
}
