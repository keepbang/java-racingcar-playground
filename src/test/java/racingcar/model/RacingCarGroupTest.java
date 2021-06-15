package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RacingCarGroupTest {

    @Test
    @DisplayName("게임에 참여할 자동차 등록 실패")
    void racingCarNameExceptionTest(){

        String[] inputString = {"kim", "test", "sfefs", "lkjkjs"};

        assertThatThrownBy(() -> new RacingCarGroup(inputString))
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

        RacingCarGroup racingCarGroup = new RacingCarGroup(splitString);

        assertThat(racingCarGroup.getCars().size()).isEqualTo(count);
    }

    @Test
    void showRacingResultTest(){
        String[] inputString = {"kim", "test", "sfefs", "lkjkj"};
        int moveDistance = 2;


        RacingCarGroup racingCarGroup = new RacingCarGroup(inputString){
            @Override
            public void play() {
                super.getCars().forEach(racingCar -> racingCar.move(moveDistance));
            }
        };

        racingCarGroup.play();

        for (int i = 0; i < inputString.length; i++) {
            assertThat(racingCarGroup.getCars().get(i).getPosition()).isEqualTo(moveDistance);
        }
    }
}