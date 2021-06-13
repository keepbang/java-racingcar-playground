package stringsum.model;

import java.util.List;

public class Numbers {
    private List<Integer> numberList;

    public Numbers(List<Integer> numberList){
        this.numberList = numberList;
    }

    public List<Integer> getNumberList(){
        return numberList;
    }
}
