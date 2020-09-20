import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class letterCombination {
    public static void main(String[] args) {
        System.out.println(letterCombinations(convertListToString(Arrays.asList(2, 3))));
        System.out.println(letterCombinations(convertListToString(Arrays.asList(9, 9))));
        System.out.println(letterCombinations(convertListToString(Arrays.asList(9))));
        System.out.println(letterCombinations(convertListToString(Arrays.asList(2, 3, 4))));
        System.out.println(letterCombinations(convertListToString(Arrays.asList(2, 1, 3, 4, 5))));
        System.out.println(letterCombinations(convertListToString(Arrays.asList(1, 0))));
        System.out.println(letterCombinations(convertListToString(Arrays.asList(2, 3, 1))));
        System.out.println(letterCombinations(convertListToString(Arrays.asList(2, 1, 3))));
    }

    private static String[] lettersArr = new String[]{"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
    private static StringBuilder stringBuilder = new StringBuilder();

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return null;
        }
        List<String> combinedString = new ArrayList<String>();

        combination(digits, 0, combinedString);
        return combinedString;
    }

    private static void combination(String digits, int n, List<String> combinedString) {
        if (n == digits.length()) {
            combinedString.add(stringBuilder.toString().toLowerCase());
            return;
        }
        if (lettersArr[digits.charAt(n) - '0'].equals("")) {
            combination(digits, n + 1, combinedString);
        } else {
            for (int i = 0; i < lettersArr[digits.charAt(n) - '0'].length(); i++) {
                stringBuilder.append(lettersArr[digits.charAt(n) - '0'].charAt(i));
                combination(digits, n + 1, combinedString);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }

    private static String convertListToString(List<Integer> integerList) {
        StringBuilder stringBd = new StringBuilder();
        for (Integer d : integerList) {
            if (d != null && !"".equals(d)) {
                stringBd.append(d);
            }
        }
        return stringBd.toString();
    }
}