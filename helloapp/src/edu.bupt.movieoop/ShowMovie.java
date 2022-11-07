public class ShowMovie {
    public static void main(String[] args) {
        //模拟展示电影界面
        Movie[] Showmovie = new Movie[3] ; //别忘了movie后面也要中括号

        for (int i = 0; i < Showmovie.length; i++) {
            String name = "武则天";
            int score = 4;
            String country = "China";
            String actors = "范冰冰";//以后换成动态数据
            int id = 1;
            //输入或者直接贴进去
            Showmovie[i] = new Movie(name,score,country,actors,id);
            System.out.println(Showmovie[i].getName());
        }
        System.out.println(Showmovie[1]);//第二个电影对象的地址
        System.out.println(Showmovie[0]);//因为对象名称里存的就是对象的堆地址
        System.out.println(Showmovie);


    }
}
