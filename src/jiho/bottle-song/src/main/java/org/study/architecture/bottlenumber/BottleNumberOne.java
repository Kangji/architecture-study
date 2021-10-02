package org.study.architecture.bottlenumber;

public class BottleNumberOne extends BottleNumber {
    BottleNumberOne() {
        super(1);
    }

    protected String unit() {
        return "bottle";
    }

    protected String pronoun() {
        return "it";
    }
}
