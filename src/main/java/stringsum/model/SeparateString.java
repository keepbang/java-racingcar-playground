package stringsum.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static stringsum.utils.Validation.isInteger;
import static stringsum.utils.Validation.isNegative;

public class SeparateString {
    private Numbers numbers;
    private final String SPLIT_REGEX = "//(.)\n(.*)";
    private final String DEFAULT_REGEX = ",|:";

    public SeparateString(String inputString){
        Matcher m = Pattern.compile(SPLIT_REGEX).matcher(inputString);

        String delimiter = DEFAULT_REGEX;
        String separated = inputString;

        if(m.find()){
            delimiter = "\\"+m.group(1);
            separated = m.group(2);
        }

        this.numbers = this.split(delimiter, separated);
    }

    public Numbers getNumbers(){
        return numbers;
    }

    private Numbers split(String delimiter, String numberListString){
        List<String> stringList = Arrays.asList(numberListString.split(delimiter));

        for (String numberString : stringList) {
            this.validSplitString(numberString);
        }

        return new Numbers(stringList
                .stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList())
        );
    }

    private void validSplitString(String numberString) {
        if(!isInteger(numberString) || !isNegative(numberString)){
            throw new RuntimeException("잘못된 숫자 입니다.");
        }
    }
}
