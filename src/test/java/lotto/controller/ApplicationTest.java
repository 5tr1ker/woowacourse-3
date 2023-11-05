package lotto.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 수익률_100() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "1,2,13,31,32,33", "4");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[7, 8, 9, 10, 11, 12]",
                            "[13, 14, 15, 16, 17, 18]",
                            "[19, 20, 21, 22, 23, 24]",
                            "[25, 26, 27, 28, 29, 30]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 100.0%입니다."
                    );
                },
                List.of(1,2,3,4,5,6),
                List.of(7,8,9,10,11,12),
                List.of(13,14,15,16,17,18),
                List.of(19,20,21,22,23,24),
                List.of(25,26,27,28,29,30)
        );
    }

    @Test
    void 로또게임_1등_당첨() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "1,2,3,4,5,6", "16");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[7, 8, 9, 10, 11, 12]",
                            "[13, 14, 15, 16, 17, 18]",
                            "[19, 20, 21, 22, 23, 24]",
                            "[25, 26, 27, 28, 29, 30]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 40000000.0%입니다."
                    );
                },
                List.of(1,2,3,4,5,6),
                List.of(7,8,9,10,11,12),
                List.of(13,14,15,16,17,18),
                List.of(19,20,21,22,23,24),
                List.of(25,26,27,28,29,30)
        );
    }

    @Test
    void 로또게임_당첨_아무것도_안됐을때() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "11,45,44,43,42,41", "40");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[7, 8, 9, 10, 11, 12]",
                            "[13, 14, 15, 16, 17, 18]",
                            "[19, 20, 21, 22, 23, 24]",
                            "[25, 26, 27, 28, 29, 30]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 0.0%입니다."
                    );
                },
                List.of(1,2,3,4,5,6),
                List.of(7,8,9,10,11,12),
                List.of(13,14,15,16,17,18),
                List.of(19,20,21,22,23,24),
                List.of(25,26,27,28,29,30)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}