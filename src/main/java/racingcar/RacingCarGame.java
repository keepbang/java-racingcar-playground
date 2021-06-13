package racingcar;

import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {

    public static void main(String[] args) throws CloneNotSupportedException {

        OutputView.inputCarNames();
        String inputString = InputView.inputCarNames();
        OutputView.inputRound();
        int round = InputView.inputRound();

        System.out.println();

        RacingGame racingGame = new RacingGame(inputString, round);

        OutputView.run();
        OutputView.gameRoundResult(racingGame.racingStart());
        OutputView.getWinner(racingGame.getWinner());

    }
}
