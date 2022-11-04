public class MethodExemples {
    public static void main(String[] args) {
        int a [] = {11,22,33,44,55};
        int b [] = {11,22,33,44,5};
        printarr(a);
        System.out.println(FindIndex(a,33));
        System.out.println(judgecommon(a,b));
    }
/*    需求：
    设计一个方法用于输出任意整型数组的内容，要求输出成如下格式：
            “该数组内容为：[11, 22, 33, 44, 55]”*/
    public static void printarr(int a[]){
        System.out.print("“该数组的内容为:[");
        for (int i = 0; i <a.length ; i++) {
            System.out.print(a[i]);
            if(i!=a.length-1){
                System.out.print(",");
            }
        }
        System.out.print("]“");
    }

/*    需求：
    设计一个方法可以接收整型数组，和要查询的元素值；最终要返回元素在该数组中的索引，如果数组中不存在该元素则返回 -1。*/
    public static int FindIndex(int a [],int b) {
        int index = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b) {
                index =i;
            }
        }
        return index;
    }
//这些简单的判断都可以用三元运算符？：解决！
/* 需求：
 如果两个数组的类型，元素个数，元素顺序和内容是一样的我们就认为这2个数组是一模一样的。
 请使用方法完成：能够判断任意两个整型数组是否一样，并返回true或者false。*/
    public static boolean judgecommon(int a [],int b []){
        boolean flag =false;
        if(a.length==b.length){
            for (int i = 0; i < a.length; i++) {
                if(a[i]==b[i]){
                    flag = true;
                }
                else {
                    flag =false; break;
                }
            }
        }
        return flag;
    }

}
