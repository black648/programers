import java.util.Arrays;

public class NaJeock {
    public static void main(String[] args) {
        NaJeock naJeock = new NaJeock();
        System.out.println(naJeock.solution(new int[]{1,2,3,4,}, new int[]{-3,-1,0,2}));
    }


    /*
        [1,2,3,4]	[-3,-1,0,2]	3
        [-1,0,1]	[1,0,-1]	-2
     */

    public int solution(int[] a, int[] b) {

        // 일반 forEach
        int answer = 0;
        for (int i=0; i<a.length; i++) {
            answer += a[i]*b[i];
        }
        return answer;

        // 람다식 표현
        // return IntStream.range(0, a.length).map(index -> a[index] * b[index]).sum();
    }
}
