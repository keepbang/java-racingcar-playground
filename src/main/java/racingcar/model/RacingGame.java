package racingcar.model;
import java.util.stream.Collectors;

public class RacingGame {
    private RacingCars racingCars;
    private int round;

    public RacingGame(String carNames,int round){
        this.racingCars = new RacingCars(carNames.split(","));
        this.round = round;
    }

    public String racingStart(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < round; i++) {
            racingCars.play();
            sb.append(racingCars.showRacingResult());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getWinner(){

        return racingCars.getCars().stream().filter(car ->
            car.getPosition() == racingCars.getCars()
                    .stream()
                    .map(Car::getPosition)
                    .mapToInt(Integer::valueOf)
                    .max().getAsInt()
        ).map(Car::getName)
                .collect(Collectors.joining(","));


    }
}
