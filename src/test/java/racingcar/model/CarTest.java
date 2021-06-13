package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "fefsdf  s"
            ,"test123"
            ,"kim:aa"
    })
    @DisplayName("자동차 이름 검증 실패")
    void carNameExceptionTest(String carName){
        assertThatThrownBy(() -> new Car(carName))
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
        assertDoesNotThrow(() -> new Car(carName));
    }


    @Test
    void carMoveTest(){
        for (int i = 0; i < 100; i++) {
            Car car = new Car("bang");
            car.move(new Random().nextInt(2));
            assertThat(car.getPosition()).isLessThan(2);
        }

    }


}