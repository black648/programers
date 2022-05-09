public class EumYangPlus {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i=0; i<absolutes.length; i++) {
            answer = signs[i] ? answer + absolutes[i] : answer - absolutes[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        EumYangPlus eumYangPlus = new EumYangPlus();
        System.out.println(eumYangPlus.solution(new int[]{4,7,12}, new boolean[]{true, false, true}));
    }
}
