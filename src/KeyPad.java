
public class KeyPad {
    public String solution(int[] numbers, String hand) {
        int leftHand = 10;
        int rightHand = 12;
        String finger = hand.equals("right") ? "R" : "L";

        String answer = "";
        for (int number : numbers) {
            switch (number) {
                case 1 : case 4 : case 7 : {
                    answer += "L";
                    leftHand = number;
                    break;
                } case 3 : case 6 : case 9 : {
                    answer += "R";
                    rightHand = number;
                    break;
                } default: {
                    if (number == 0) number = 11;
                    int left = Math.abs((number-1)/3 - (leftHand-1)/3) + Math.abs((number-1)%3 - (leftHand-1)%3);
                    int right = Math.abs((number-1)/3 - (rightHand-1)/3) + Math.abs((number-1)%3 - (rightHand-1)%3);

                    if (left == right) {
                        if (hand.equals("right")) {
                            finger = "R";
                            rightHand = number;
                        } else {
                            finger = "L";
                            leftHand = number;
                        }
                    } else if (left < right) {
                        finger = "L";
                        leftHand = number;
                    } else if (right < left) {
                        finger = "R";
                        rightHand = number;
                    }
                    answer += finger;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        KeyPad keyPad = new KeyPad();
//        int[] numbers = new int [] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        int[] numbers = new int [] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand ="right";

        System.out.println(keyPad.solution(new int [] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right") +" / " + "LRLLLRLLRRL");
        System.out.println(keyPad.solution(new int [] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left") +" / " + "LRLLRRLLLRR");
        System.out.println(keyPad.solution(new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right") +" / " + "LLRLLRLLRL");
    }

}
