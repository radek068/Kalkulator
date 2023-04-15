package application;

import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

/**
 * 
 * @author Radosław Staniów
 * @version 14/04/2023
 */
public class Parameters {
	
	@Parameter(names = {"-a", "--add"}, description = "Addition operation +")
    private boolean add;
    
    @Parameter(names = {"-s", "--subtract"}, description = "Subtraction operation -")
    private boolean subtract;
    
    @Parameter(names = {"-m", "--multiply"}, description = "Multiplication operation *")
    private boolean multiply;
    
    @Parameter(names = {"-d", "--divide"}, description = "Division operation /")
    private boolean divide;
    
    @Parameter(description = "Numbers")
    private List<Double> numbers = new ArrayList<>();
    
    /**
     * Constructor for the validation and argument parsing class
     * @param args
     */
    public Parameters(String[] args) {
    	JCommander.newBuilder()
    	  .addObject(this)
    	  .build()
    	  .parse(args);
    	
    	validate();
    }
    /**
     * Checks if the arguments provided by the user are valid and throws ParameterException if they are not.
     */
    public void validate() {
    	int nrOfOperations = (add ? 1 : 0) + (subtract ? 1 : 0) + (multiply ? 1 : 0) + (divide ? 1 : 0);
        if (nrOfOperations > 1) {
            throw new ParameterException("A maximum of one operation -a, -s, -m, or -d should be specified");
        } else {
        	if(nrOfOperations == 0 && !numbers.isEmpty()) {
        		throw new ParameterException("Operation should be specified to perform operation on numbers");
        	}
        }
        if (nrOfOperations == 1 && numbers.size() != 2) {
            throw new ParameterException("Please enter exactly two numbers in the parameters.");
        }
        if(divide && numbers.get(1) == 0) {
        	throw new ParameterException("Division by zero is not allowed.");
        }
    }
    /**
     * Checks if the operation was specified in the arguments and returns
     * the corresponding integer value.
     * @return 0 for add,1 for subtract,2 for multiply,3 for divide,-1 if no operation was specified.
     */
    public int getOperation() {
    	if (add) return 0;
        else if (subtract) return 1;
        else if (multiply) return 2;
        else if (divide) return 3;
        else return -1;
    }
    /**
     * Returns first number used in mathematical operation.
     * @return first number
     */
    public double getFirstNumber() {
    	if(numbers.size() == 2) {
        	return numbers.get(0);
    	}
    	return 0;
    }
    /**
     * Returns second number used in mathematical operation.
     * @return second number
     */
    public double getSecondNumber() {
    	if(numbers.size() == 2) {
        	return numbers.get(1);
    	}
    	return 0;
    }
}
