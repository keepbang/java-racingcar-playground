package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarsTest {

    @Test
    @DisplayName("게임에 참여할 자동차 등록 실패")
    void racingCarNameExceptionTest(){

        String[] inputString = {"kim", "test", "sfefs", "lkjkjs"};

        assertThatThrownBy(() -> new RacingCars(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름이 5자를 초과합니다.");
    }

    @ParameterizedTest
    @CsvSource({
            "'kim,abc,A',3"
            , "'Easy,bang,jingo,poi',4"
            , "'Valer',1"
    })
    @DisplayName("게임에 참여할 자동차 등록 성공")
    void racingCarNameSuccessTest(String inputString,int count){

        String[] splitString = inputString.split(",");

        RacingCars racingCars = new RacingCars(splitString);

        assertThat(racingCars.getCars().size()).isEqualTo(count);
    }

    @Test
    void showRacingResultTest(){
        String[] inputString = {"kim", "test", "sfefs", "lkjkj"};

        RacingCars racingCars = new RacingCars(inputString);

        System.out.println(racingCars.showRacingResult());

        racingCars.play();

        System.out.println(racingCars.showRacingResult());
    }
}