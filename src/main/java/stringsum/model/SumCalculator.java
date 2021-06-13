package stringsum.model;

public class SumCalculator {

    private SeparateString splitString;


    public SumCalculator(String inputString){
        this.splitString = new SeparateString(inputString);
    }

    public Integer calculation(){
        return splitString.getNumbers()
                .getNumberList()
                .stream()
                .reduce(Integer::sum)
                .orElse(0);
    }

}
