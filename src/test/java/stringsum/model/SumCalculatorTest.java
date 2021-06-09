package stringsum.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SumCalculatorTest {

    @ParameterizedTest
    @MethodSource("stringSumCalculation")
    void 문자열_덧셈_계산_검증(String inputString, int value){
        assertThat(
                new SumCalculator(inputString).calculation()
        ).isEqualTo(value);
    }

    private static Stream<Arguments> stringSumCalculation(){
        return Stream.of(
                Arguments.of("//;\n1;2;3",6)
                ,Arguments.of("//(\n1(2(3",6)
                ,Arguments.of("//|\n2|62|12|434",510)
                ,Arguments.of("//?\n8?7?4?5?97?122",243)
                ,Arguments.of("//!\n1!9!19",29)
                ,Arguments.of("1,2,3",6)
                ,Arguments.of("1,65:4",70)
                ,Arguments.of("2,3:7,9,2,453:34",510)
        );
    }


}