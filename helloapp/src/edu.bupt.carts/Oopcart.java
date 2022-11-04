import java.util.Scanner;

public class Oopcart {
    public static void main(String[] args) {

        Shopgoods[] Shopcart = new Shopgoods[100];//数组有规定大小，不适合做购物车

        Scanner input = new Scanner(System.in);
        //Scanner类，input对象，可以传下去

        addshopgoods(Shopcart,input);


    }

    public static void addshopgoods( Shopgoods[] Shopcart,Scanner input){
        System.out.println("请输入名称,个数，价格，id");
        Shopgoods g = new Shopgoods(input.next(),input.nextInt(),input.nextDouble(),input.nextInt());

        for (int i=0;i< Shopcart.length;i++){
            if (Shopcart[i] == null){
                Shopcart[i] = g;
                return;
            }
        }
        System.out.println(Shopcart);

        System.out.println("购物车已满");

    }

}
