package stringsum;

import stringsum.model.SumCalculator;
import stringsum.view.InputView;

public class StringSumMain {
    public static void main(String[] args) {
        SumCalculator calculator = new SumCalculator(InputView.inputString());

        System.out.println(calculator.calculation());
    }
}
