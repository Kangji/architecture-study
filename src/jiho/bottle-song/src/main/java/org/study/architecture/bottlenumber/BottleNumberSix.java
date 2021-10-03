package org.study.architecture.bottlenumber;

public class BottleNumberSix extends BottleNumber {
    BottleNumberSix() {
        super(6);
    }

    protected String amount() {
        return "1";
    }

    protected String unit() {
        return "six-pack";
    }
}
