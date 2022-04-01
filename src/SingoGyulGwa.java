
import java.util.*;

public class SingoGyulGwa {
    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        //신고내역 중복제거
        HashSet<String> distinctList = new HashSet<>(Arrays.asList(report));

        String value = "";
        int blank;

        //신고내역 담기!
        Map<String, Integer> repostMap = new HashMap<>();
        for (String singo : distinctList) {
            value = singo.substring(singo.indexOf(" ") + 1);
            repostMap.put(value, repostMap.containsKey(value) ? repostMap.get(value) + 1 : 1);
        }

        //사용자별 신고내역 조회
        for (int i=0; i < id_list.length; i++) {
            answer[i] = 0;
            for (String singo : distinctList) {
                blank = singo.indexOf(" ");
                value = singo.substring(blank + 1);

                if (id_list[i].equals(singo.substring(0, blank))) {
                    if (repostMap.containsKey(value) && repostMap.get(value) >= k) {
                        answer[i]++;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = new String[] {"muzi", "apeach", "frodo", "neo"};
        String[] report = new String[] {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        SingoGyulGwa singo = new SingoGyulGwa();
        int[] solution = singo.solution(id_list, report, k);  // [2,1,1,0]
        System.out.println(Arrays.toString(solution));
    }
}
