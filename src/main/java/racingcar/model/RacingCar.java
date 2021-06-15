package racingcar.model;

import java.util.stream.IntStream;

public class RacingCar extends Car{
    private final int CAR_NAME_LENGTH = 5;
    private final String MOVE_STRING = "-";

    public RacingCar(String name) {
        super(name);
        this.validStringLength(name);
    }

    public String playResult(){
        return this.getName()
                + " : "
                + IntStream.range(0,this.getPosition())
                .mapToObj(String::valueOf)
                .reduce("",(a,b) -> a.concat(MOVE_STRING));
    }

    private void validStringLength(String carName) {
        if(carName.length() > this.CAR_NAME_LENGTH){
            throw new IllegalArgumentException("자동차의 이름이 5자를 초과합니다.");
        }
    }


}
