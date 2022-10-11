public class NestedLoop {
    public static void main(String[] args) {
        //打印4行100列矩阵
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 100; j++) {
//                System.out.println("*");
//                每次打印一个星星就换行了怎么办
                System.out.print("*");
//                你要是不换，就是一条横线
            }
            System.out.println('\t');
//            \t只换行、、\n还空行
        }
    }
}
