package racingcar.view;


public class OutputView {
    public static void inputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void inputRound(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void run() {
        System.out.println("실행 결과");
    }

    public static void gameRoundResult(String resultString){
        System.out.println(resultString);
    }

    public static void getWinner(String winner) {
        System.out.println(winner + "가 최종 우승했습니다.");
    }
}
