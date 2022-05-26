
import com.sun.tools.javac.util.StringUtils;

import java.util.*;

public class OpenChatingRoom {


    /*

record ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
result ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]


다음은 record에 담긴 문자열에 대한 설명이다.
모든 유저는 [유저 아이디]로 구분한다.
[유저 아이디] 사용자가 [닉네임]으로 채팅방에 입장 - "Enter [유저 아이디] [닉네임]" (ex. "Enter uid1234 Muzi")
[유저 아이디] 사용자가 채팅방에서 퇴장 - "Leave [유저 아이디]" (ex. "Leave uid1234")
[유저 아이디] 사용자가 닉네임을 [닉네임]으로 변경 - "Change [유저 아이디] [닉네임]" (ex. "Change uid1234 Muzi")
첫 단어는 Enter, Leave, Change 중 하나이다.
각 단어는 공백으로 구분되어 있으며, 알파벳 대문자, 소문자, 숫자로만 이루어져있다.
유저 아이디와 닉네임은 알파벳 대문자, 소문자를 구별한다.
유저 아이디와 닉네임의 길이는 1 이상 10 이하이다.
채팅방에서 나간 유저가 닉네임을 변경하는 등 잘못 된 입력은 주어지지 않는다.
     */







    public static final String ENTER  = "Enter";
    public static final String CHANGE = "Change";
    public static final String LEAVE  = "Leave";


    public static void main(String[] args) {
        OpenChatingRoom openChatingRoom = new OpenChatingRoom();
        String[] strs = openChatingRoom.solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
        Arrays.stream(strs).forEach(s -> System.out.println(s));
    }









//    record ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
//    result ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]


    public String[] solution(String[] record) {

        StringTokenizer stringTokenizer;
        String type, id, nickName;
        List<String> list = new ArrayList<>();
        Map<String,String> map = new HashMap<>();

        //닉네임 보정
        for (String str : record) {
            stringTokenizer = new StringTokenizer(str);
            type = stringTokenizer.nextToken();
            if (ENTER.equals(type) || CHANGE.equals(type)) {
                map.put(stringTokenizer.nextToken(), stringTokenizer.nextToken());
            }
        }

        for (String str : record) {
            stringTokenizer = new StringTokenizer(str);
            type = stringTokenizer.nextToken();
            id = stringTokenizer.nextToken();

            if (ENTER.equals(type)) {
                list.add(map.get(id)+"님이 들어왔습니다.");
            } else if (LEAVE.equals(type)) {
                list.add(map.get(id)+"님이 나갔습니다.");
            }
        }

        return list.toArray(new String[list.size()]);
    }


}
