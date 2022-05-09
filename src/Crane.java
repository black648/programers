import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Crane {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int target;
        List<Integer> list = new ArrayList<>();

        for (int move : moves) {
            move--;
            for (int i = 0; i < board.length; i++) {
                target = board[i][move];
                if (move >= 0 && target > 0) {
                    if (list.size() > 0 && target == list.get(list.size() - 1)) {
                        list.remove(list.size() - 1);
                        answer += 2;
                    } else {
                        list.add(target);
                    }

                    board[i][move] = 0;
                    break;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Crane crane = new Crane();
        System.out.println(crane.solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[] {1,5,3,5,1,2,1,4}));
    }
}
