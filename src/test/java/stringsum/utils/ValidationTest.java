package stringsum.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static stringsum.utils.Validation.isInteger;
import static stringsum.utils.Validation.isNegative;

class ValidationTest {

    @ParameterizedTest
    @CsvSource({
            "1,true"
            , "sdf 12,false"
            , "|12,false"
            , "ㅁㄴㅇㄹ3,false"
            , "1234,true"
    })
    @DisplayName("숫자/문자 체크")
    void isIntegerTest(String numberString, boolean bool){
        assertThat(isInteger(numberString)).isEqualTo(bool);
    }

    @ParameterizedTest
    @CsvSource({
            "6,true"
            , "-12,false"
            , "-1,false"
            , "123,true"
            , "0,true"
    })
    @DisplayName("음수 체크")
    void isNegativeTest(String numberString, boolean bool){
        assertThat(isNegative(numberString)).isEqualTo(bool);
    }

}