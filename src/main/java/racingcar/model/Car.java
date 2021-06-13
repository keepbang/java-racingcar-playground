package racingcar.model;

public class Car {
    private static final int CAR_NAME_LENGTH = 5;

    private String name;
    private int position;

    public Car(String name){
        this.name = validStringLength(name);
        this.position = 0;
    }

    public void move(int distance){
        this.position += distance;
    }

    public int getPosition(){
        return this.position;
    }

    public String getName(){
        return this.name;
    }

    private String validStringLength(String carName) {
        if(carName.length() > CAR_NAME_LENGTH){
            throw new IllegalArgumentException("자동차의 이름이 5자를 초과합니다.");
        }
        return carName;
    }
}
