import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FulfillmentCenterContainer {
    private Map<String, FulfillmentCenter> fulfillmentCenters;

    public void addCenter(String name, int capacityOfContainer) {
        List<Item> products = new ArrayList<>();
        FulfillmentCenter fulfillmentCenter = new FulfillmentCenter(name, products, capacityOfContainer);
        fulfillmentCenters.put(fulfillmentCenter.getNameOfFulfillment(), fulfillmentCenter);
        capacityOfContainer += fulfillmentCenter.getMaxCapacity();

    }

    public void removeCenter(String name, int capacityOfContainer) {
        List<Item> products = new ArrayList<>();
        FulfillmentCenter fulfillmentCenter = new FulfillmentCenter(name, products, capacityOfContainer);
        fulfillmentCenters.remove(fulfillmentCenter.getNameOfFulfillment());
        capacityOfContainer -= fulfillmentCenter.getMaxCapacity();
        System.out.println("After remove");
    }

    public void fulfillmentByNameAndCapacity(String name, int maxCapacity) {
        List<Item> products = new ArrayList<>();
        FulfillmentCenter fulfillmentCenter = new FulfillmentCenter(name, products, maxCapacity);

    }

    public void findEmpty() { // todo
        for (Map.Entry<String, FulfillmentCenter> entry : fulfillmentCenters.entrySet()) {
//            if (entry.getKey()) {
//
//
//                //if (products.get(this.products.indexOf(item)).getAmount() - 1 > 0) {
//                System.out.println("aaa");
//            }
        }
    }

    public void summary() { //todo
        for (Map.Entry<String, FulfillmentCenter> entry : fulfillmentCenters.entrySet()) {
            System.out.println("nameOfContainer: " + entry.getKey() + ", full in "  ) ;
        }
        System.out.println();
    }

    public FulfillmentCenterContainer(Map<String, FulfillmentCenter> fulfillmentCenters) {
        this.fulfillmentCenters = fulfillmentCenters;
    }
}
