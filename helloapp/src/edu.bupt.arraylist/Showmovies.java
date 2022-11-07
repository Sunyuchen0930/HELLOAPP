import java.util.ArrayList;
import java.util.Scanner;

public class Showmovies {
    public static void main(String[] args) {
        ArrayList<Movie> showmovies = new ArrayList<>();
        showmovies.add(new Movie("鳄鱼",4,"zhong","fbb",1));
        showmovies.add(new Movie("鳄",4,"zh","fbb",2));
        showmovies.add(new Movie("鳄11111",4,"z","fbb",3));
        //匿名对象：没有名字，出生就进入集合
        for (int i = 0; i < showmovies.size(); i++) {

          Movie m1 =  showmovies.get(i);
            System.out.println("电影名："+m1.getName()+m1.getId());
        }
        //通过id查询的功能
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("input id:");
            int id = input.nextInt();
            Movie findmo = FindbyId(id,showmovies);
            if(findmo == null){
                System.out.println("找不到捏！");
            }
        }

    }
    //形参这里Arraylist一定要记得跟泛型！跟泛型！跟泛型！跟泛型！

    /**
     *
     * @param id
     * @param showmovies
     * @return
     */

    public static Movie FindbyId(int id, ArrayList<Movie> showmovies){
        for (int i = 0; i < showmovies.size(); i++) {
            Movie okms = showmovies.get(i);
            if(id == okms.getId()){

                System.out.println("movie found"+okms.getName());
                return okms;

            }

        }
        System.out.println("not found 404");
        return null;//在查询的地方我们需要进行判断
    }
}
