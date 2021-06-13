package stringsum.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class SeparateStringTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "//;\n1a;2 ㅇ;3"
            , "//(\n1;2(3"
            , "//|\n2,62|12|434"
            , "//?\n8|ㅁ7?4?5?97?122"
            , "1,2w,3df"
            , "1,65as:4-"
    })
    @DisplayName("문자열 나눈 후 검증 실패")
    void stringSplitValidationFailure(String inputString) {
        assertThatThrownBy(() -> new SeparateString(inputString))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("잘못된 숫자 입니다.");
    }

    @ParameterizedTest
    @CsvSource({
            "'//;\n1;2;3',3"
            , "'//(\n1(2(3',3"
            , "'//|\n2|62|12|434',4"
            , "'//?\n8?7?4?5?97?122',6"
            , "'1,2,3',3"
            , "'1,65:4',3"
    })
    @DisplayName("문자열 나눈 후 검증 성공")
    void stringSplitValidationSuccess(String inputString, int listSize) {

        SeparateString separateString = new SeparateString(inputString);

        assertThat(separateString.getNumbers().getNumberList().size()).isEqualTo(listSize);
    }

}