import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Item item = new Item("odkurzacz", ItemCondition.NEW, 5, 1);
        Item item1 = new Item("koszula", ItemCondition.NEW, 1, 2);
        Item item2 = new Item("koszula", ItemCondition.NEW, 1, 2); //obiekty musza miec ta sama mase
        Item item3 = new Item("koszulka", ItemCondition.NEW, 1, 2);
        Item item4 = new Item("czajnik", ItemCondition.NEW, 1, 2);
        Item item5 = new Item("kawa", ItemCondition.NEW, 200, 5);

        List<Item> products = new ArrayList<>();
        System.out.println();

        FulfillmentCenter fulfillmentCenter = new FulfillmentCenter("magazyn", products, 100);
        FulfillmentCenter fulfillmentCenter1 = new FulfillmentCenter("magazyn1", products, 200);

        System.out.println("adding");
        fulfillmentCenter.addProduct(item);
        fulfillmentCenter.addProduct(item1);
        fulfillmentCenter.addProduct(item2);
        fulfillmentCenter.addProduct(item3);
        fulfillmentCenter.addProduct(item4);
        fulfillmentCenter.addProduct(item5);
        //fulfillmentCenter.getProduct(item);
        fulfillmentCenter.getProduct(item5);
        fulfillmentCenter.removeProduct(item5);
        fulfillmentCenter.sortByAmount();
        fulfillmentCenter.sortByName();
        fulfillmentCenter.max();
        System.out.println();
        fulfillmentCenter.searchPartial("cz");
        fulfillmentCenter.search("czajnik");


        fulfillmentCenter.countByCondition(ItemCondition.USED);
        fulfillmentCenter.summary();
        System.out.println(item1.getMass() * item1.getAmount());

//
//        Map<String, FulfillmentCenter> fulfillmentCenterMap = new HashMap<>();
//
//        FulfillmentCenterContainer fulfillmentCenterContainer =
//                new FulfillmentCenterContainer(fulfillmentCenterMap);
//
//        fulfillmentCenterContainer.addCenter("magazyn", 100);
//        fulfillmentCenterContainer.addCenter("magazyn1", 200);
//        fulfillmentCenterContainer.summary();
//        fulfillmentCenterContainer.removeCenter("magazyn", 100);
//        //fulfillmentCenterContainer.summary();
//        System.out.println();
//        fulfillmentCenterContainer.findEmpty();
//

        //fulfillmentCenter.howMuchProductsIs(item2);
    }
}
