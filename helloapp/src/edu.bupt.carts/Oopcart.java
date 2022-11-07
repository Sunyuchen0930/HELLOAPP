import java.util.Scanner;

public class Oopcart {
    public static void main(String[] args) {

        Shopgoods[] Shopcart = new Shopgoods[100];//数组有规定大小，不适合做购物车

        Scanner input = new Scanner(System.in);
        //Scanner类，input对象，可以传下去

        System.out.println(Shopcart[1]);

        while (true) {
            addshopgoods(Shopcart,input);
            querybyid(Shopcart,input);
        }


    }

    public static void addshopgoods( Shopgoods[] Shopcart,Scanner input){
        System.out.println("请输入\t\t名称\t\t个数\t\t价格\t\tid\t\t");
        Shopgoods g = new Shopgoods(input.next(),input.nextInt(),input.nextDouble(),input.nextInt());
        //好像不能这样输入
        System.out.println(g.name+g.count+g.id+g.price);
        System.out.println(Shopcart[0]);
        //shopcar.fori
        for (int i=0;i< Shopcart.length;i++){
            if (Shopcart[i] == null){
                Shopcart[i] = g;
                break;
            }

        }

    }

    public static Shopgoods querybyid(Shopgoods[] Shopcart,Scanner input){
        System.out.println("输入你需要查询的商品id");
        //死循环：如果没有他输入的这个id的商品
        while (true) {

            for (int i = 0; i < Shopcart.length; i++) {
                if (Shopcart[i]!=null) {
                    if(Shopcart[i].id == input.nextInt()){
                        System.out.println("找到啦");
                        return Shopcart[i];
                    }
                }
            }
            System.out.println("没找到，重新输入");
//            break;
        }

    }

    //如何修改商品的数量1、通过id找到对象g；2、修改g对象的count值；

}
