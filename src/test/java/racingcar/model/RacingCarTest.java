package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "fefsdf  s"
            ,"test123"
            ,"kim:aa"
    })
    @DisplayName("자동차 이름 검증 실패")
    void carNameExceptionTest(String carName){
        assertThatThrownBy(() -> new RacingCar(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름이 5자를 초과합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "kim"
            ,"chae"
            ,"A"
            ,"test1"
    })
    @DisplayName("자동차 생성 성공")
    void carNameSuccessTest(String carName){
        assertDoesNotThrow(() -> new RacingCar(carName));
    }


}