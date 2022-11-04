
/*
需求
        模拟购物车模块的功能，需要实现添加商品到购物车中去,
        同时需要提供修改商品的购买数量，结算商品价格功能（请使用面向对象编程来解决）。
*/
//学到了什么：
//首先，需要定义商品类
//然后，购物车也是一个对象，可以用数组对象代表他。购物车是容器，放商品对象
//其实不应该用数组，因为商品加进来呢没有上线。
import java.util.Scanner;

public class Cart{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Goods  cart [] = new Goods[50];
        int counts = 0;
        double sums = 0.0;
        OUT:
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
                //错就错在不该把函数全部写在main里面，而是应该传入购物车数组
                // 。
                case "add":
                    Goods good2 = new Goods();
                    good2 = good2.add();
                    cart[counts] = good2;
                    System.out.println("您添加的"+good2.name+"商品共"+good2.count+"件,"+"放在购物车第"+(counts+1)+"个");
                    counts++;
                    break;
                case "query" :
                    for (int i = 0; i < cart.length; i++) {
                        if(cart[i]!=null){
                            System.out.println("您添加的"+cart[i].name+"商品共"+cart[i].count+"件,"+"放在购物车第"+(i+1)+"个");
                        }
                        }
                    break;
                case "update" :
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
                    break;
                case "exit":
                    break OUT;
                case "pay" :
                    for (int i = 0; i < cart.length; i++) {
                        if(cart[i]!=null){
                            System.out.println("您添加的"+cart[i].name+"商品共"+cart[i].count+"件,"+"放在购物车第"+(i+1)+"个,共计"+cart[i].price*cart[i].count+"元");
                            sums += cart[i].price*cart[i].count;
                        }
                    }
                    System.out.println("您一共消费了"+sums+"元，请支付~~");
                    break;
                default:
                    System.out.println("exit");
            }
            //Goods商品类也是类，也是数据类型
        }
        System.out.println("感谢您使用购物车系统，祝您生活愉快~~");
    }
}
