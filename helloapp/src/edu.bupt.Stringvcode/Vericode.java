import java.util.Random;

public class Vericode {
    public static void main(String[] args) {
        String data = "abcdefghijklmnopqrstuvwsxyABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int n =5;//位数
//        char c [] = new char [5];//错误2：不需要char数组
        String code = "";//错误2：在这里新建一个字符串里面什么都没
        for (int i = 0; i < n; i++) {
            //随机一个数，得到字符串长度的索引
            Random rand3 = new Random();
            int one = rand3.nextInt(data.length());//错误1：不要直接写63
//            c[i] = data.charAt(one);//错误2：不需要char数组
            code += data.charAt(one);

        }

        System.out.println(code);


    }
}
