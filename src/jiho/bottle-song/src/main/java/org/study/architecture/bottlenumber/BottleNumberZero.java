package org.study.architecture.bottlenumber;

public class BottleNumberZero extends BottleNumber {
    BottleNumberZero() {
        super(0);
    }

    protected String amount() {
        return "no more";
    }

    public String action() {
        return "Go to the store and buy some more";
    }

    public BottleNumber successor() {
        return BottleNumberFactory.of(99);
    }
}
