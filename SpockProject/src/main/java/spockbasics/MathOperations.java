package spockbasics;

import spockbasics.exceptions.NumberFormatException;

import java.util.logging.Logger;

/**
 * Created by lakshay on 20/11/16.
 */
public class MathOperations {

    Logger logger = Logger.getLogger("Math Operations");

    public int getModulusResult(int a, int b) {
        logger.info("Math modulus operation");
        return a%b;
    }

    public int getSubtractionResult(int a, int b) {
        logger.info("Math subtraction operation");
        return a-b;
    }

    public long getDivideResult(int a, int b) throws NumberFormatException {

        logger.info("Checking if denominator is 0");
        if (b == 0) {
            logger.info("Division Unsuccessful");
            throw new NumberFormatException("Can not divide when denominator is 0");
        } else {
            logger.info("Dividing the two given numbers");
            return a/b;
        }
    }
}
