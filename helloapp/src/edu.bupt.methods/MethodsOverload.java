import java.util.Scanner;

public class MethodsOverload {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("输入1，默认；输入2，输入指定地区；输入3，输入指定地区和武器数量");
        int case1 = input.nextInt();
        switch(case1){
            case 1:
                System.out.println("输入1，默认");
                arms();
                break;
            case 2:
                System.out.println("输入指定地区");
                String place = input.next();
                arms(place);
                break;
            case 3 :
                System.out.println("输入指定地区");
                String place2 = input.next();
                System.out.println("输入武器数量");
                int c = input.nextInt();
                arms(place2,c);
                break;
        }
    }
//    开发武器系统，功能需求如下：
//    可以默认发一枚武器。
//    可以指定地区发射一枚武器。
//    可以指定地区发射多枚武器
    public static void arms(){
        System.out.println("default one arm");
    }
    public static void arms(String place){
        System.out.println("向"+place+"发射一枚武器");
    }
    public static void arms(String place,int a){
        System.out.println("向"+place+"发射"+a+"个武器");
    }
}
