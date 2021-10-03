package org.study.architecture;

import org.codehaus.plexus.util.StringUtils;
import org.study.architecture.bottlenumber.BottleNumber;
import org.study.architecture.bottlenumber.BottleNumberFactory;

public class Bottles {
    public String verse(int number) {
        BottleNumber bottleNumber = BottleNumberFactory.of(number);
        BottleNumber nextBottleNumber = bottleNumber.successor();

        return StringUtils.capitalise(bottleNumber + " of beer on the wall, ") +
            bottleNumber + " of beer.\n" +
            bottleNumber.action() + ", " +
            nextBottleNumber + " of beer on the wall.\n";
    }
}
