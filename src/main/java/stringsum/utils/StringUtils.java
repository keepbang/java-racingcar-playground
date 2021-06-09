package stringsum.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static void validSplitList(List<String> list) {
        list.forEach(StringUtils::isInteger);
    }

    private static boolean isInteger(String numberString) {
        if(!numberString.chars().allMatch(Character::isDigit)){
            throw new RuntimeException("잘못된 숫자 입니다.");
        }

        return true;
    }

    public static List<String> stringSplit(String inputString) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputString);
        if(m.find()){
            String delimiter = m.group(1);
            return Arrays.asList(m.group(2).split("\\"+delimiter));
        }
        return Arrays.asList(inputString.split(",|:"));
    }
}
