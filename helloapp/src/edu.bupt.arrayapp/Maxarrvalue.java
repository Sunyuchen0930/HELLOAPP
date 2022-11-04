import java.util.Random;
import java.util.Scanner;

public class Maxarrvalue {
    public static void main(String[] args) {

//        数组元素求最大值
        int facescore[] = new int[]{15, 9000, 10000, 20000, 9500, -5};
        int max = facescore[0];//最大值，这个变量建议默认存储第一个元素值作为参照。
        for (int i = 1; i < facescore.length; i++) {//i<6不太好，写length
//            if (facescore[i-1] < facescore[i]) {
//                int temp = facescore[i];
//                max =temp;
//            }
            if (facescore[i] > max)
                max = facescore[i];//两行就ok
        }
        System.out.println(max);


    }
}
