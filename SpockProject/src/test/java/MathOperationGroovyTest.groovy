import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll
import spockbasics.MathOperations
import spockbasics.exceptions.NumberFormatException

/**
 * Created by lakshay on 20/11/16.
 */
public class MathOperationGroovyTest extends Specification {

    /**
     * Addition with usage of when, then and where.
     * @param input1 input parameter 1
     * @param input2 input parameter 2
     * @param modulusOutput the result of modulus
     * @return the modulus result
     */
    def "Test modulus operation" (int input1, int input2, int modulusOutput) {

        given: "Initialize the class"
        MathOperations mathOperations = new MathOperations();

        when: "Call the method"
        modulusOutput = mathOperations.getModulusResult(input1, input2);

        then: "The following results"
        modulusOutput == 0;

        where: "The inputs and outputs are:"
        input1 | input2 | modulusOutput
          5    |   5    |      0
    }

    /**
     * Subtraction with usage of expect and data table.
     * @param input1 input parameter 1
     * @param input2 input parameter 2
     * @param subtractionResult the result of subtraction
     * @return the subtracted result
     */
    @Unroll
    def "Test subtraction result" (int input1, int input2, int subtractionResult) {

        given: "Initialize the class"
        MathOperations mathOperations = new MathOperations();

        expect: "The following results"
        subtractionResult == mathOperations.getSubtractionResult(input1, input2);

        where: "The inputs and outputs are:"
        input1 | input2 | subtractionResult
        5    |   5    |      0
        7    |   3    |      4
        8    |   2    |      6
        5    |   7    |     -2
    }

    /**
     * Division with usage of when and then and how to throw exceptions
     * with Spocks framework
     * @return
     */
    def "Test Division operation" () {

        given: "Initialize the class"
        MathOperations mathOperations = new MathOperations();

        when: "Call the division method"
        divisionOutput = mathOperations.getDivideResult(5, 0);

        then: "Number format exception should occur"
        final NumberFormatException nfe = thrown();
        nfe.message == "Can not divide when denominator is 0";
    }

    /**
     * Division with usage of unroll, expect and data table
     * @return
     */
    @Unroll
    def "Test Normal division operation" () {

        given: "Initialize the class"
        MathOperations mathOperations = new MathOperations();

        expect: "Call the division method"
        divisionResult == mathOperations.getDivideResult(input1, input2);

        where: "The inputs and outputs are:"
        input1 | input2 | divisionResult
        5      |   5    |      1
        7      |   3    |      2.0
        8      |   2    |      4
        5      |   7    |      0.0
    }

    /**
     * Division with usage of unroll, expect and data pipes
     * @return
     */
    @Unroll
    def "Test normal division operation" () {

        given: "Initialize the class"
        MathOperations mathOperations = new MathOperations();

        expect: "Call the division method"
        divisionResult == mathOperations.getDivideResult(input1, input2);

        where: "The inputs and outputs are:"
        input1 << [7, 7, 15, 5];
        input2 << [7, 3, 15, 7];
        divisionResult << [1, 2.0, 1, 0.0];
    }

    @Ignore("Need to verify the mock functionality")
    def "Mocking subtract operations" () {

        given: "Create a mock"
        def mathOperations = new MathOperations();
        def mockedMathOperations = Mock(MathOperations);
        // MathOperations mockedMathOperations = Mock(); // preferred
        // MathOperations mockedMathOperations = Mock(MathOperations);

        when: "subtraction method invocation"
        mathOperations.getSubtractionResult(7, 5);

        then: "Call mocked method and obtain the results"
        0*mockedMathOperations.getSubtractionResult(7, 5);
    }
}
