package stringsum.utils;

public class Validation {

    public static boolean isNegative(String numberString) {
        if(Integer.parseInt(numberString) < 0){
            return false;
        }
        return true;
    }

    public static boolean isInteger(String numberString) {
        if(!numberString.chars().allMatch(Character::isDigit)){
            return false;
        }
        return true;
    }
}
