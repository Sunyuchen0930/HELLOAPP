
public class hello {
    public static void main(String[] args) {
        int i = 0B01100001;
        System.out.println('i');
        System.out.println(i);
        int j = 0X61;
        System.out.println(j);
        int k = 0141;
        System.out.println(k);//二进制、十六进制、八进制
        char z = '中';
        char z1 = '国';
//        char z2 = '中国';报错，超过2B，中文一个字2B，英文一字母1B
        boolean flag = true;
        
        System.out.println("引用数据类型：");

        String name = "西门庆";
        int a = 55 ;
        long b = a;
        char z2 = '0';
        int c  = z2;
        System.out.println(c);//输出50是因为字符2的ascii码为50
        byte d = (byte)a;
        System.out.println(d);
        System.out.println(a+b+c);//int+long+int类型a+b+c是为最高的级别long
        double rs = a + b + 2.5 ;
        System.out.println(rs);//确实是double类默认小数
        double score = 92.59;
        int del = (int) score ;
        System.out.println(del);

    }



}






















