package racingcar.model;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @CsvSource({
            "bang,1,0,0,1",
            "kim,1,1,0,2",
            "test,0,0,0,0",
    })
    void carMoveTest(String carName, int move1, int move2, int move3, int position){
        Car car = new Car(carName);
        car.move(move1);
        car.move(move2);
        car.move(move3);
        assertThat(car.getName()).isEqualTo(carName);
        assertThat(car.getPosition()).isEqualTo(position);
    }

}