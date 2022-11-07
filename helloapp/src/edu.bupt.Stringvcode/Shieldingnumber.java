import java.util.Scanner;

public class Shieldingnumber {
    public static void main(String[] args) {
        //字符串接收一个手机号，中间四位屏蔽
        Scanner input =new Scanner(System.in);
        String num = input.next();
        // String news = num.replace(num.substring(3,7),"****");
        // 3-7包前不包后
        // 错误1：替换会把所有一样的字符串全部换掉，如果4-8位和9-13位重复，就全部被替换了。
        // 所以我们需要截取前三位，后四位，跟星号拼接,0到3包前不包后，7到11是因为，10是11位手机号最大的index
        // 如果7，10，不包括10，所以7，11是index的7到10
        String news = num.substring(0,3)+"****"+num.substring(7,11);
        System.out.println(news);
    }
}
