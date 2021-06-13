package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RacingCars{
    private List<Car> cars = new ArrayList<>();

    public RacingCars(String[] inputNames){
        for (String name : inputNames) {
            this.cars.add(new Car(name));
        }
    }

    public void play() {
        cars.forEach(car -> car.move(new Random().nextInt(2)));
    }

    public List<Car> getCars() {
        return cars;
    }

    public String showRacingResult(){
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName()
                    + " : "
                    + IntStream.range(0,car.getPosition())
                    .mapToObj(String::valueOf)
                    .reduce("",(a,b) -> a+"-"));
            sb.append("\n");
        }

        return sb.toString();
    }
}
