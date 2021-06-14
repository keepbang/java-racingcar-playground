package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionInfoTest {

    @Test
    void 대회_정보_생성_테스트(){
        String carNames = "kim, park, kong";
        int round = 5;
        CompetitionInfo competitionInfo = new CompetitionInfo(carNames, round);

        assertEquals(competitionInfo.getCarNames(),carNames);
        assertEquals(competitionInfo.getRound(), round);


    }

}