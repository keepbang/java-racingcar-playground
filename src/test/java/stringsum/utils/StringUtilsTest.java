package stringsum.utils;


import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class StringUtilsTest {


    @ParameterizedTest
    @ValueSource(strings = {
            "//;\n1a;2 ㅇ;3"
            , "//(\n1;2(3"
            , "//|\n2,62|12|434"
            , "//?\n8|ㅁ7?4?5?97?122"
            , "1,2w,3df"
            , "1,65as:4-"
            , "-2,3,7,9,2,453,34"
    })
    @DisplayName("문자열 나눈 후 숫자 검증")
    void stringSplitValidation(String value){
        assertThatThrownBy(() -> StringUtils.validSplitList(StringUtils.stringSplit(value)))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("잘못된 숫자 입니다.");
    }

    @ParameterizedTest
    @MethodSource("stringInputTest")
    @DisplayName("문자열 나누기 성공")
    void stringSplit(String inputString, int size){
        assertThat(StringUtils.stringSplit(inputString).size()).isEqualTo(size);
    }

    private static Stream<Arguments> stringInputTest(){
        return Stream.of(
                Arguments.of("//;\n1;2;3",3)
                ,Arguments.of("//(\n1(2(3",3)
                ,Arguments.of("//|\n2|62|12|434",4)
                ,Arguments.of("//?\n8?7?4?5?97?122",6)
                ,Arguments.of("1,2,3",3)
                ,Arguments.of("35,2,75,234:553,298:234",7)
                ,Arguments.of("2,3,7,9,2,453,34:2343,21:12",10)
        );
    }


}