public class BreakandContinue {
    public static void main(String[] args) {
//        罚你洗碗5天，洗到第三天心软了不用洗了
        for (int i = 1; i < 6; i++) {

            if(i==3){
                System.out.println("老婆心软啦,今天不用洗");
                continue;//立即跳出档次执行，但是下次还得洗
//                break;记仇，第三天不用洗了，但是4/5天都要洗
            }
            System.out.println("洗碗第"+i+"天");
        }
    }
}
