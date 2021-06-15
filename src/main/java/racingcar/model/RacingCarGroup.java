package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingCarGroup implements Racing{
    private final int MOVE_BOUND = 2;

    private List<RacingCar> cars = new ArrayList<>();

    public RacingCarGroup(String[] inputNames){
        for (String name : inputNames) {
            this.cars.add(new RacingCar(name));
        }
    }

    @Override
    public void play() {
        this.cars.forEach(racingCar -> racingCar.move(this.getDistance()));
    }

    public int getDistance(){
        return new Random().nextInt(MOVE_BOUND);
    }

    public List<RacingCar> getCars() {
        return this.cars;
    }

    private int maxPosition(){
        return this.cars.stream()
                .map(RacingCar::getPosition)
                .mapToInt(Integer::valueOf)
                .max()
                .getAsInt();
    }

    public List<String> getWinnerList(){
        return this.cars.stream()
                .filter(racingCar -> racingCar.getPosition() == this.maxPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public String getGroupPlayResult(){
        StringBuilder sb = new StringBuilder();

        for (RacingCar car : this.cars) {
            sb.append(car.playResult() + System.lineSeparator());
        }

        return sb.toString();
    }
}
