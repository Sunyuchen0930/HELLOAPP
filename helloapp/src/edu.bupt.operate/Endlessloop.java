import java.util.Scanner;

public class Endlessloop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);//别忘了new！

        while (true){//使用while死循环让用户不断输入数据
            String password = input.next();
//            错误是因为字符串比较不可以这样比，比较特殊
//            int password = input.nextInt();

            if(password.equals("520")){//与密码比对,
                System.out.println("欢迎进入系统，成功登录啦~");
                break;//成功则break

            }
            else {
                System.out.println("密码错误，请重新输入！");

            }
        }

    }
}
