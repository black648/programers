import java.util.Arrays;

public class NoNumberPlus {
    public int solution(int[] numbers) {
        int answer = 0;
        for (int i=0; i<10; i++) {
            int target = i;
            if (Arrays.stream(numbers).noneMatch(j -> j == target)) {
                answer += target;
            }
        }
        return answer;
        //return IntStream.range(0, 10).filter(i -> Arrays.stream(numbers).noneMatch(num -> i == num)).sum();

    }

    public static void main(String[] args) {
        NoNumberPlus noNumberPlus = new NoNumberPlus();
        System.out.println(noNumberPlus.solution(new int[] {1,2,3,4,6,7,8,0}));
    }
}
