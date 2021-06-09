package stringsum.model;

import stringsum.utils.StringUtils;

import java.util.List;

public class SumCalculator {

    private List<String> splitString;

    public SumCalculator(String inputString){
        this.splitString = StringUtils.stringSplit(inputString);
    }

    public int calculation(){
        return splitString.stream()
                .mapToInt(Integer::parseInt)
                .reduce((a,b) -> Integer.sum(a,b))
                .getAsInt();
    }

}
