
//需求
//        模拟购物车模块的功能，需要实现添加商品到购物车中去,
//        同时需要提供修改商品的购买数量，结算商品价格功能（请使用面向对象编程来解决）。

import java.util.Scanner;

public class Goods {
    double price;
    String name;
    String id;//还是需要id编号
    int count;//数量还是要

    Scanner input = new Scanner(System.in);

    public Goods add(){
        Goods good1 = new Goods();
        System.out.println("请输入新商品名,不要重复哦");
        good1.name = input.next();
        System.out.println("请输入新商品id编号");
        good1.id = input.next();
        System.out.println("请输入你需要购买的个数");
        good1.count = input.nextInt();
        System.out.println("请输入商品原价");
        good1.price = input.nextInt();
        System.out.println("您成功添加了"+good1.count+"个"+good1.name+"商品，id是"+good1.id+",单价是"+good1.price+"元，总共"+good1.price*good1.count+"元");
        return good1;
    }
}
