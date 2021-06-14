package racingcar.model;

public class CompetitionInfo {
    private String carNames;
    private int round;

    public CompetitionInfo(String carNames, int round){
        this.carNames = carNames;
        this.round = round;
    }

    public String getCarNames() {
        return this.carNames;
    }

    public int getRound() {
        return this.round;
    }
}
