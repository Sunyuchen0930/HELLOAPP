
/*
定义方法实现随机产生一个指定位数的验证码，每位可能是数字、大写、小写字母
*/

/*
分析：
        定义一个方法，生成验证码返回：返回值类型是String，需要形参接收位数。
        在方法内部使用for循环依次生成每位随机字符，并连接起来。
        把连接好的随机字符作为一组验证码返回。
*/
/*
随机验证码的核心实现逻辑是如何进行的？
        定义一个String类型的变量存储验证码字符。
        定义一个for循环，循环5次。
        随机生成0|1|2的数据，依次代表当前位置要生成数字|大写字母|小写字母。
        把0、1、2交给switch生成对应类型的随机字符，把字符交给String变量。
        循环结束后，返回String类型的变量即是所求的验证码结果。*/

import java.util.Random;
import java.util.Scanner;

public class VerificationCode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入随机验证码位数：");
        int count = input.nextInt();
        String code = createcode(count);
        System.out.println(count+"位验证码是："+code);
    }
    public static String createcode(int count){
        String s = "";
        Random rand1 = new Random();
        //不要在这里写个r不然都一样了
        for (int i = 0; i < count; i++) {
            int r = rand1.nextInt(3);
            switch(r){//r是对的，r就是case的取值输入
                case 0:
                    //英文大写（A 65 - Z 65+25=90，因为A已经占了一个所以25，random强制类型转换
                    char ch1 = (char)(rand1.nextInt(26)+65);
//                    code += ch1;这样就能连起来了，那么小写字符怎么办呢
                    s += ch1;
                    break;
                case 1:
                    //英文小写(a 97 - z 97+25=112，因为a已经占了一个所以25
                    char ch2 = (char)(rand1.nextInt(26)+97);
                    s += ch2;
                    break;
                case 2:
                    //数字（0-9）
                 //不要类型转换！！！！
                    s += rand1.nextInt(10);
                    break;
            }

        }
        return s;
    }

}
