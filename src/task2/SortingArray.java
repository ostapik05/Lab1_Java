package task2;

public class SortingArray {

    // Method for counting the number of capital letters in a line
    private static int countUpperCaseLetters(final String s) {
        int count = 0;
        for (final char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        return count;
    }

    public static void main(final String[] args) {
        final String[] data = {
                "CCCabc",
                "AAAAabc",
                "fgh",
                "abcd",
                "bСВef"};

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (countUpperCaseLetters(data[j]) < countUpperCaseLetters(data[j + 1])) {
                    String temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        //==================

        for (final String s : data) {
            System.out.println(s);

        }
    }
}

