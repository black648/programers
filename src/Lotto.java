
//입출력 예
//        lottos	            win_nums	                result
//        [44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]	    [3, 5]
//        [0, 0, 0, 0, 0, 0]	[38, 19, 20, 40, 15, 25]	[1, 6]
//        [45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]	    [1, 1]
//        입출력 예 설명


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] lank = new int[] {6,5,4,3,2,1};
        List<Integer> lottoList = Arrays.stream(lottos).boxed().collect(Collectors.toList());
        List<Integer> winNumList = Arrays.stream(win_nums).boxed().collect(Collectors.toList());

        //로또 리스트 0갯수
        int duplicationCount  = Collections.frequency(lottoList, 0);

        //0값 제거
        while (lottoList.remove(Integer.valueOf(0))) {};

        int rightConut = 0;
        for (Integer list : lottoList) {
            if (winNumList.contains(list)) rightConut ++;
        }

       duplicationCount = rightConut + duplicationCount - 1;

        answer[0] = lank[duplicationCount < 0 ? 0 : duplicationCount];
        answer[1] = rightConut == 0 ? 6 : lank[rightConut - 1];
        return answer;
    }


    public static void main(String[] args) {
        int[] lottos = new int[] {44, 1, 0, 0, 31, 25};
        int[] win_nums = new int[]{31, 10, 45, 1, 6, 19};

        Lotto lotto = new Lotto();
        System.out.println(Arrays.toString(lotto.solution(lottos, win_nums)));
    }

    /*

    public int[] solution(int[] lottos, int[] winNums) {
        return LongStream.of(
                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l) || l == 0).count(),
                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l)).count()
        )
                .mapToInt(op -> (int) (op > 6 ? op - 1 : op))
                .toArray();
    }
     */
}
