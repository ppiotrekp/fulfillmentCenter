import java.util.*;

public class FulfillmentCenter {
    private String nameOfMagazine;
    private List<Item> products;
    private int maxCapacity;
    private double massInCenter;
    private int amountOfProducts;

    public void addProduct(Item item) {
        //jezeli juz jest item o takiej nazwie to sprawdizc czy taka sama masa jak item ktory chce dodac
        //jak jest inna to komunikat
        if ((massInCenter + item.getMass() * item.getAmount()) < maxCapacity) {
            if (this.products.contains(item)) {
                this.products.get(this.products.indexOf(item)).increaseAmount(item.getAmount());
                // zwiekszanie ilosci itemu2
            } else {
                products.add(item);
            }
            amountOfProducts += item.getAmount();
            massInCenter += item.getMass() * item.getAmount();
        } else {
            System.err.println("Mass is overruned");
        }
        fulfillmentPrint();
    }

    public int howMuchProductsIs(Item item) {
        System.out.println(item.getAmount());
        return item.getAmount();
    }

    public void getProduct(Item item) {
        if (products.contains(item)) {
            if (products.get(this.products.indexOf(item)).getAmount() - 1 > 0) {
                this.products.get(this.products.indexOf(item)).decreaseAmount(item.getAmount());
                massInCenter -= item.getMass();
                amountOfProducts--;
                fulfillmentPrint();
            } else {
                removeProduct(item);
            }
        } else {
            System.out.println("Product isn't in your shop, you can't get it ");
        }
        System.out.println();
    }

    public void removeProduct(Item item) {
        if (products.contains(item)) {
            products.remove(item);
            massInCenter -= item.getAmount() * item.getMass();
            amountOfProducts -= item.getAmount();
            fulfillmentPrint();
        } else {
            System.out.println("Product isn't in your shop, you can't remove it");
            System.out.println();
        }
    }

    public String search(String s) {
        int cnt = 0;
        for (Item items : products) {
            if (items.getName() == s) {
                System.out.println("There is " + s);
                cnt++;
            }
        }
        if (cnt == 0) {
            System.out.println("There isn't any " + s + "in the shop");
        }
        return s;
    }

    public void searchPartial(String name) {
        //TODO nie dziala dobrze bo nie wyszukuje z poczatku
        for (Item items : products) {
            if (items.getName().contains(name)) {
                items.print();
            } else {
                System.out.println("There aren't any product which contains this substr");
            }
        }
    }

    public void countByCondition(ItemCondition itemCondition) {
        int cnt = 0;
        for (Item items : products) {
            if (items.getItemCondition() == itemCondition) {
                cnt += items.getAmount();
            }
        }
        System.out.println(cnt);
    }

    public FulfillmentCenter(String nameOfMagazine, List<Item> products, int maxCapacity) {
        this.nameOfMagazine = nameOfMagazine;
        this.products = products;
        this.maxCapacity = maxCapacity;
    }

    public void fulfillmentPrint() {
        System.out.println("products: " + products.toString());
        System.out.println("massInCenter: " + this.massInCenter);
        System.out.println("amountOfProducts: " + this.amountOfProducts);
        System.out.println("fulfillment full in " + (this.massInCenter / this.maxCapacity));
        System.out.println();
    }

    public void summary() {
        for (Item items : products) {
            System.out.println();
            items.print();
        }
    }

    public void sortByName() {
        System.out.println("sortByName:");
        for (Item items : products) {
            Arrays.asList(items);
        }
        Collections.sort(products, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return item1.getName().compareTo(item2.getName());
            }
        });

        for (Item items : products) {
            System.out.println(items.getName());
        }
        System.out.println();
    }

    public void sortByAmount() {
        System.out.println("sortByAmount:");
        for (Item items : products) {
            Arrays.asList(items);
        }
        Collections.sort(products, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return item1.getAmount() - item2.getAmount();
            }
        });

        for (Item items : products) {
            System.out.println(items.getName() + ": " + items.getAmount());
        }
        System.out.println();
    }

    public void max() {
        // TODO zrobic liste amountow
        List<Integer> maxAmounts = new ArrayList<>();
        for (Item items : products) {
            for (int i = 0; i < amountOfProducts; i++) {
                maxAmounts.add(items.getAmount());
            }
        }
        System.out.println("Max amount is: " + Collections.max(maxAmounts));
    }

    public double percentage() {
        return amountOfProducts / maxCapacity;
    }

    public String getNameOfFulfillment() {
        return nameOfMagazine;
    }

    public List<Item> getProducts() {
        return products;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public double getMassInCenter() {
        return massInCenter;
    }

    public void setMassInCenter(double massInCenter) {
        this.massInCenter = massInCenter;
    }

    public int getAmountOfProducts() {
        return amountOfProducts;
    }

    public void setAmountOfProducts(int amountOfProducts) {
        this.amountOfProducts = amountOfProducts;
    }
}
