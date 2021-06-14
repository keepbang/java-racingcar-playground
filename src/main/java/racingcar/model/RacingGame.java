package racingcar.model;

import java.util.stream.Collectors;

public class RacingGame {
    private RacingCarGroup racingCarGroup;
    private int round;

    public RacingGame(CompetitionInfo info){
        this.racingCarGroup = new RacingCarGroup(info.getCarNames()
                .split(","));
        this.round = info.getRound();
    }

    public String racingStart(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.round; i++) {
            this.racingCarGroup.play();
            sb.append(this.getRoundPlayResult());
        }
        return sb.toString();
    }

    private String getRoundPlayResult() {
        return racingCarGroup.getGroupPlayResult() + System.lineSeparator();
    }

    public String getWinner(){
        return racingCarGroup.getWinnerList()
                .stream()
                .collect(Collectors.joining(","));
    }
}
