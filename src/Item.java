import java.util.Objects;

public class Item implements Comparable<Item> {
    private String name;
    private Enum itemCondition;
    private double mass;
    private int amount;

    public Item(String name, Enum itemCondition, double mass, int amount) {
        this.name = name;
        this.itemCondition = itemCondition;
        this.mass = mass;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public Enum getItemCondition() {
        return itemCondition;
    }

    public double getMass() {
        return mass;
    }

    public int getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItemCondition(Enum itemCondition) {
        this.itemCondition = itemCondition;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public int setAmount(int amount) {
        this.amount = amount;
        return amount;
    }

    public void increaseAmount(int i) {
        this.amount = this.amount + i;
    }

    public void decreaseAmount(int i) {
        this.amount = this.amount - i;
    }

    public void increaseMass(double m) {
        this.mass = this.mass + m;
    }

    public void decreaseMass(double m) {
        this.mass = this.mass - m;
    }

    public void print() {
        System.out.println("name: " + getName());
        System.out.println("itemCondition: " + getItemCondition());
        System.out.println("mass: " + getMass());
        System.out.println("amount: " + getAmount());
    }

    @Override
    public int compareTo(Item o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(getName(), item.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
