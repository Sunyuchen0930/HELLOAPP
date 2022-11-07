import java.util.Scanner;

public class Login3 {
    public static void main(String[] args) {
        //模拟用户登录功能最多3次机会
        String name = "syc";
        String passoword = "1234";
        Scanner input = new Scanner(System.in);
        int i ;
        for (i = 0; i < 3; i++) {
            //错误1：不应该一起写，用户名错了要写用户名，密码错了要写密码，先判断用户名，再写密码
            System.out.println("用户名");
            String unname = input.next();
            if(unname.equals(name)){
                System.out.println("密码");
                String unpass = input.next();
                if(unpass.equals(passoword)){
                    System.out.println("login!");
                    break;
                }
                else System.out.println("密码错误，还剩"+(2-i)+"次机会");
            }
            else System.out.println("用户名错误，还剩"+(2-i)+"次机会");

        }

        if(i==3){
            System.out.println("您使用完三次机会了，请稍后再来");
        }



    }
}
