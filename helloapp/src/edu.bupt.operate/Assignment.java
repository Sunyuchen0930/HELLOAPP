public class Assignment {
    public static void main(String[] args) {
//        赋值
        int a =10;
        int b = 200;
//        a = (int)(a+b)
        a += b;

        byte i = 100;
        byte j = 101;
        i += j;//不会报错但是会出错，因为强制类型转换了i = (byte) (i+j);
//        等同于以下句子
        System.out.println(i);
        i = (byte) (i+j);
        System.out.println(i);
//        -55+101确实是46....

        boolean s = a==b;
        System.out.println(s);
        System.out.println(a!=b);


    }
}
