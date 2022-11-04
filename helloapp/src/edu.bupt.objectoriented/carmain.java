public class carmain {
    public static void main(String[] args) {
        //这里直接调用ooptest的车车
        ooptest o = new ooptest();//先创建对象
        o.run();
        System.out.println(o);//对象变量名确实是内存地址
    }
}
