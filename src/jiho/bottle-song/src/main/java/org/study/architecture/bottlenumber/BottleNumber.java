package org.study.architecture.bottlenumber;

public class BottleNumber {
    private final int number;

    BottleNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return amount() + " " + unit();
    }

    protected String amount() {
        return Integer.toString(number);
    }

    protected String unit() {
        return "bottles";
    }

    protected String pronoun() {
        return "one";
    }

    public String action() {
        return "Take " + pronoun() + " down and pass it around";
    }

    public BottleNumber successor() {
        return BottleNumberFactory.of(number - 1);
    }
}
