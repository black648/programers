import java.util.HashMap;
import java.util.Map;

public class WanJu {

    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> participantMap = new HashMap<>();
        for (String str : participant) {
            str = str.toLowerCase();
            participantMap.put(str, participantMap.getOrDefault(str, 0) +1);
        }

        for (String str : completion) {
            str = str.toLowerCase();
            participantMap.put(str, participantMap.get(str) - 1);

            if (participantMap.get(str) <= 0) {
                participantMap.remove(str);
            }
        }
        return participantMap.keySet().stream().findFirst().get();
    }

    public static void main(String[] args) {

        String[] participant = new String[] {"mislav", "stanko", "mislav", "ana"};
        String[] completion = new String[] {"stanko", "ana", "mislav"};

        WanJu wanJu = new WanJu();
        System.out.println(wanJu.solution(participant, completion));
    }
}
