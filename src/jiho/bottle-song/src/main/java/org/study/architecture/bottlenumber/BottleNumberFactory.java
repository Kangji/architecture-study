package org.study.architecture.bottlenumber;

public class BottleNumberFactory {
    private BottleNumberFactory() {}

    public static BottleNumber of(int number) {
        if (number == 0)        return new BottleNumberZero();
        else if (number == 1)   return new BottleNumberOne();
        else if (number == 6)   return new BottleNumberSix();
        else                    return new BottleNumber(number);
    }
}
