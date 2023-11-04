package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.util.LottoConstant.*;

public class NumberGenerator {

    private List<Integer> NumberGenerator() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER.getValue(),
                LOTTO_MAX_NUMBER.getValue(),
                LOTTO_NUMBER_COUNT.getValue());
    }

    private Lotto createLottoNumber() {
        List<Integer> numbers = NumberGenerator();

        return new Lotto(numbers);
    }

}
