package application;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * @author Radosław Staniów
 * @version 14/04/2023
 */
public class Calculator {
	
	/**
	 * Reads the needed operation stored in int and calculates the result of the operation.
	 * @param operation
	 * @param FirstNumber
	 * @param SecondNumber
	 * @return the result of the operation specified in the parameters
	 */
	public double calculate(int operation, double FirstNumber, double SecondNumber) {
		
		double result = 0;
		if(operation != -1 && operation < 4) {
			
			if (operation == 0) result = FirstNumber + SecondNumber;
            else if (operation == 1) result = FirstNumber - SecondNumber;
            else if (operation == 2) result = FirstNumber * SecondNumber;
            else if (operation == 3) result = FirstNumber / SecondNumber;
		
			System.out.println("= "+result);
			
		} else {
			System.out.println("The requested operation is invalid.");
		}
		return result;
    }
	/**
	 * parses the user's input and if valid, execute the calculate method.
	 * @param input
	 * @return true if input was correct, false if not
	 * @throws ArithmeticException
	 */
	public boolean parseUserInput(String input) throws ArithmeticException {
		
		Pattern pattern = Pattern.compile("[+\\-\\*\\/]");
		Matcher matcher = pattern.matcher(input);
		
		int count = 0;

		while (matcher.find()) {
		    count++;
		    if (count > 1) {
		    	System.out.println("The given expression has too many operations.");
		        return false;
		    }
		}
		if(count == 0) {
	    	System.out.println("The given expression no specified operation.");
	        return false;
		}
		
		double FirstNumber;
		double SecondNumber;
		
		if(input.indexOf('+') != -1) {
			int index = input.indexOf('+');
			boolean wasUsedPreviousResult = false;
			
			try {
				String subString = input.substring(0, index);
				if (subString.trim().isEmpty() && History.isPreviousResultPresent) {
					FirstNumber = History.previousResult;
					wasUsedPreviousResult = true;
				} else {
					FirstNumber = Double.parseDouble(input.substring(0, index));	
				}
				SecondNumber = Double.parseDouble(input.substring(index+1));
			} catch (NumberFormatException e) {
			    System.out.println("The given expression contains undesirable characters make sure you use . instead of , and the expression does not contain any letters.");
			    return false;
			}
			
			double result = calculate(0,FirstNumber,SecondNumber);
			History.previousResult = result;
			History.isPreviousResultPresent = true;
			new History().addOperation(new Operation(FirstNumber,SecondNumber,0,result,wasUsedPreviousResult));
			
		} else if(input.indexOf('-') != -1) {
			int index = input.indexOf('-');
			boolean wasUsedPreviousResult = false;
			
			try {
				String subString = input.substring(0, index);
				if (subString.trim().isEmpty() && History.isPreviousResultPresent) {
					FirstNumber = History.previousResult;
					wasUsedPreviousResult = true;
				} else {
					FirstNumber = Double.parseDouble(input.substring(0, index));	
				}
				SecondNumber = Double.parseDouble(input.substring(index+1));
			} catch (NumberFormatException e) {
			    System.out.println("The given expression contains undesirable characters make sure you use . instead of , and the expression does not contain any letters.");
			    return false;
			}
			
			double result = calculate(1,FirstNumber,SecondNumber);
			History.previousResult = result;
			History.isPreviousResultPresent = true;
			new History().addOperation(new Operation(FirstNumber,SecondNumber,1,result,wasUsedPreviousResult));
			
		} else if(input.indexOf('*') != -1) {
			int index = input.indexOf('*');
			boolean wasUsedPreviousResult = false;
			
			try {
				String subString = input.substring(0, index);
				if (subString.trim().isEmpty() && History.isPreviousResultPresent) {
					FirstNumber = History.previousResult;
					wasUsedPreviousResult = true;
				} else {
					FirstNumber = Double.parseDouble(input.substring(0, index));	
				}
				SecondNumber = Double.parseDouble(input.substring(index+1));
			} catch (NumberFormatException e) {
			    System.out.println("The given expression contains undesirable characters make sure you use . instead of , and the expression does not contain any letters.");
			    return false;
			}
			
			double result = calculate(2,FirstNumber,SecondNumber);
			History.previousResult = result;
			History.isPreviousResultPresent = true;
			new History().addOperation(new Operation(FirstNumber,SecondNumber,2,result,wasUsedPreviousResult));
			
		} else if(input.indexOf('/') != -1) {
			int index = input.indexOf('/');
			boolean wasUsedPreviousResult = false;
			
			try {
				String subString = input.substring(0, index);
				if (subString.trim().isEmpty() && History.isPreviousResultPresent) {
					FirstNumber = History.previousResult;
					wasUsedPreviousResult = true;
				} else {
					FirstNumber = Double.parseDouble(input.substring(0, index));	
				}
				SecondNumber = Double.parseDouble(input.substring(index+1));
			} catch (NumberFormatException e) {
			    System.out.println("The given expression contains undesirable characters make sure you use . instead of , and the expression does not contain any letters.");
			    return false;
			}
			if(SecondNumber == 0) {
				System.out.println("Division by zero is not allowed.");
				return false;
			}
			
			double result = calculate(3,FirstNumber,SecondNumber);
			History.previousResult = result;
			History.isPreviousResultPresent = true;
			new History().addOperation(new Operation(FirstNumber,SecondNumber,3,result,wasUsedPreviousResult));
			
		}
		return true;
    }
}
