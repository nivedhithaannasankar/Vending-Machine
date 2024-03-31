import vendingmachine.*;
import coin.Coin;
import item.*;

public class App {
    public static void main(String[] args) throws Exception {
        VendingMachine vendingMachine = new VendingMachine();

        System.out.println(" | Fill the Inventory | ");
        fillInventory(vendingMachine);
        
        System.out.println("Display the Inventory");
        displayInventory(vendingMachine);
        
        VendingMachineState vendingMachineState = vendingMachine.getVendingMachineState();
        vendingMachineState.insertCoin(vendingMachine,Coin.FIFTY);
        vendingMachineState.insertCoin(vendingMachine, Coin.TWENTY);

        vendingMachineState.chooseProduct(vendingMachine, 102);
        displayInventory(vendingMachine);

    }
 
    private static void fillInventory(VendingMachine vendingMachine){
        ItemShelf[] itemShelfSlots = vendingMachine.getInventory().getInventory();
        for(int i=0;i<itemShelfSlots.length;i++){
            Item item = new Item();
            if(i==0 || i==8){
                item.setItemType("OREO");
                item.setprice(30);
            }
            else if(i == 1 || i == 9){
                item.setItemType("MAAZA");
                item.setprice(40);
            }
            else if(i==2){
                item.setItemType("COKE");
                item.setprice(45);
            }
            else if(i==3){
                item.setItemType("SODA");
                item.setprice(20);
            }
            else if(i==4){
                item.setItemType("CHIPS");
                item.setprice(20);
            }
            else if(i==5){
                item.setItemType("CHOCOLATE");
                item.setprice(60);
            }
            else if(i==6){
                item.setItemType("CANDY");
                item.setprice(5);
            }
            else if(i==7){
                item.setItemType("GUM");
                item.setprice(5);
            }
            itemShelfSlots[i].setItem(item);
            itemShelfSlots[i].setsoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine) {
        ItemShelf[] itemShelfSlots = vendingMachine.getInventory().getInventory();
        System.out.println(itemShelfSlots.length);
        for(ItemShelf shelf: itemShelfSlots) {
            System.out.println("Item Code: " + shelf.getItemCode() + " Item: " + shelf.getItem().getType() +" Price: " + shelf.getItem().getPrice() + 
            " isAvailable:" + !shelf.issoldOut());
        }
    }
}
