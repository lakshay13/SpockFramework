package spockbasics;

import spockbasics.exceptions.NumberFormatException;

import java.util.logging.Logger;

/**
 * Created by lakshay on 20/11/16.
 */
public class MathOperations {

    Logger logger = Logger.getLogger("Math Operations");

    /**
     * Method that gets the modulus of two values
     * @param a input value 1
     * @param b input value 2
     * @return the modulus value
     */
    public int getModulusResult(int a, int b) {
        logger.info("Math modulus operation");
        return a%b;
    }

    /**
     * Method that gets the subtraction of two values
     * @param a input value 1
     * @param b input value 2
     * @return the subtracted result
     */
    public int getSubtractionResult(int a, int b) {
        logger.info("Math subtraction operation");
        return a-b;
    }

    /**
     * Method that gets the division of two values
     * @param a numerator of the division
     * @param b denominator of the division
     * @return the divided result
     * @throws NumberFormatException if the denominator is 0
     */
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
