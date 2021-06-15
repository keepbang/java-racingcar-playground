package racingcar;

import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {

    public static void main(String[] args){

        OutputView.inputCarNames();
        String carNames = InputView.inputCarNames();
        OutputView.inputRound();
        int round = InputView.inputRound();

        System.out.print(System.lineSeparator());

        RacingGame racingGame = new RacingGame(carNames, round);

        OutputView.gameResult();
        OutputView.gameRoundResult(racingGame.racingStart());
        OutputView.getWinner(racingGame.getWinner());

    }
}
