import java.util.Scanner;

public class Cartgood {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Goods  cart [] = new Goods[50];
        int counts = 0;
        double sums = 0.0;
        while(true){
            System.out.println(
                    "\n/----------\n添加商品：add\n" +
                            "查看商品：query\n" +
                            "修改数量：update\n" +
                            "结算价格：pay\n" +
                            "退出系统：exit\n---------/\n"+
                            "\n请问您要操作的功能是：");
            String options = input.next();
            switch (options){
                case "add":
                    //传入对象数组，这里是调用，不是定义形参，不需要类型，直接写数组名
                    addshopcart(cart,counts);
                    counts++;
                    break;
                case "query":
                    //传入对象数组，这里是调用，不是定义形参，不需要类型，直接写数组名
                    queryshopcart(cart);
                    break;
                case "update":
                    //传入对象数组，这里是调用，不是定义形参，不需要类型，直接写数组名
                    updateshopcart(cart);
                    break;
                case "pay":
                    //传入对象数组，这里是调用，不是定义形参，不需要类型，直接写数组名
                    payshopcart(cart);
                    break;
            }
        }
    }

    private static void updateshopcart(Goods[] cart) {//在这里才需要写类型
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您想修改的商品编号");
        String userwant = input.next();
        for (int i = 0; i < cart.length; i++) {
            if(cart[i].id.equals(userwant)){
                System.out.println("您原来加入了"+cart[i].count+"个商品");
                System.out.println("请输入您需要的修改的个数");
                int modifiedcount = input.nextInt();
                cart[i].count = modifiedcount;
                System.out.println("您成功修改个数为"+ cart[i].count);
                break;
            }
            else System.out.println("您还没加入这个商品~");
        }
    }

    private static void payshopcart(Goods[] cart) {//在这里才需要写类型
        double sums = 0.0;
        for (int i = 0; i < cart.length; i++) {
            if(cart[i]!=null){
                System.out.println("您添加的"+cart[i].name+"商品共"+cart[i].count+"件,"+"放在购物车第"+(i+1)+"个,共计"+cart[i].price*cart[i].count+"元");
                sums += cart[i].price*cart[i].count;
            }
        }
        System.out.println("您一共消费了"+sums+"元，请支付~~");
    }

    private static void queryshopcart(Goods[] cart) {//在这里才需要写类型
        for (int i = 0; i < cart.length; i++) {
            if(cart[i]!=null){
                System.out.println("您添加的"+cart[i].name+"商品共"+cart[i].count+"件,"+"放在购物车第"+(i+1)+"个");
            }
        }
    }

    private static void addshopcart(Goods[] cart,int counts) {//在这里才需要写类型
        Scanner input = new Scanner(System.in);
        Goods good1 = new Goods();
        cart[counts] = good1;
        System.out.println("请输入新商品名");
        good1.name = input.next();
        while(true){
            boolean flag =true;
            System.out.println("请输入新商品id编号,不可以重复哦");
            String temp = input.next();
            for (int i = 0; i < counts; i++) {
                if(counts==0) break;
                else if(cart[i]!=null){
                    if(temp.equals(cart[i].id)){
                        System.out.println("有重复重新输入哦！");
                        good1.id = temp;
                        flag =false;
                        break;
                    }
                }
            }
            if(flag) break;
        }

        System.out.println("请输入你需要购买的个数");
        good1.count = input.nextInt();
        System.out.println("请输入商品原价");
        good1.price = input.nextInt();
        System.out.println("您成功添加了"+good1.count+"个"+good1.name+"商品，id是"+good1.id+",单价是"+good1.price+"元，总共"+good1.price*good1.count+"元");

        System.out.println("您添加的"+good1.name+"商品共"+good1.count+"件,"+"放在购物车第"+(counts+1)+"个");

    }


}
