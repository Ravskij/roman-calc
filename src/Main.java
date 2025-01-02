import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите римское число: "); // MMMDCXLII
        String input = scanner.next();
        char[] romanChars = input.toCharArray();
        int[] humanNum = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            humanNum[i] = ConvertRomanToHuman.romanConverter(romanChars[i]);
        }
        System.out.println(ConvertRomanToHuman.romanCalc(humanNum));
    }
}

class ConvertRomanToHuman {
    static char[] romanNums = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    static int[] humanNums = {1, 5, 10, 50, 100, 500, 1000};

    public static int romanConverter(char inputRomanNum) {
        for (int i = 0; i < 7; i++) {
            if (inputRomanNum == romanNums[i]) {
                return humanNums[i];

            }
        }
        return 0;
    }

    public static int romanCalc(int[] inputNum) {
        int sum = 0;
        if (inputNum.length == 1) {
            sum += inputNum[0];
        } else {
            for (int i = 0; i < inputNum.length; i++) {
                if (i + 1 < inputNum.length && inputNum[i] < inputNum[i + 1]) {
                    sum = sum + (inputNum[i + 1] - inputNum[i]);
                    i++;
                } else {
                    sum += inputNum[i];
                }
            }
        }
        return sum;
    }
}