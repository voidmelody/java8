public class Coffee {
    private String name;
    private int price;
    private boolean sail;

    public Coffee(String name, int price, boolean sail) {
        this.name = name;
        this.price = price;
        this.sail = sail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isSail() {
        return sail;
    }

    public void setSail(boolean sail) {
        this.sail = sail;
    }
}
