public class Shopgoods {
    String name;
    int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    double price;
    int id;

    public Shopgoods(){}
    public Shopgoods(String name,int count, double price, int id){
        this.count = count;
        this.id = id;
        this.price =price;
        this.name = name;
    }
}
