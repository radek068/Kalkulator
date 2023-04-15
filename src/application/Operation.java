package application;

import java.time.LocalTime;
/**
 * 
 * @author Radosław Staniów
 * @version 15/04/2023
 */
public class Operation {
	
	double FirstNumber;
	double SecondNumber;
	int operation;
	double result;
	LocalTime time;// = LocalTime.now();
	boolean wasUsedPreviousResult;
	int previousOperationIndex;
	
	/**
	 * Constructor from Operation class. 
	 * @param FirstNumber
	 * @param SecondNumber
	 * @param operation
	 * @param result
	 * @param wasUsedPreviousResult
	 */
	public Operation(double FirstNumber, double SecondNumber, int operation, double result, boolean wasUsedPreviousResult) {
		
		this.FirstNumber = FirstNumber;
		this.SecondNumber = SecondNumber;
		this.operation = operation;
		this.result = result;
		this.time = LocalTime.now();
		this.wasUsedPreviousResult = wasUsedPreviousResult;
		this.previousOperationIndex = History.currentOperationIndex-1;
	}
	/**
	 * Prints detailed description about about the operation and if the result of the previous operation was used in it, recursively displays it as well.
	 */
	public void printDetailedDescription() {
		System.out.println("FirstNumber: "+ FirstNumber);
		System.out.println("SecondNumber: "+ SecondNumber);
		char operationSymbol = ' ';
		if (operation == 0) operationSymbol = '+';
        else if (operation == 1) operationSymbol = '-';
        else if (operation == 2) operationSymbol = '*';
        else if (operation == 3) operationSymbol = '/';
		System.out.println("Operation: "+ operationSymbol);
		System.out.println("Result: "+ result);
		System.out.println("Time: "+ time);
		if(wasUsedPreviousResult) {
			System.out.println("Previous result was used");
			System.out.println();
			System.out.println("Previous operation:");
			new History().getOperation(previousOperationIndex).printDetailedDescription();
		}

	}
	/**
	 * Prints short description about about the operation
	 */
	public void printShortDescription() {
		System.out.print(FirstNumber);
		char operationSymbol = ' ';
		if (operation == 0) operationSymbol = '+';
        else if (operation == 1) operationSymbol = '-';
        else if (operation == 2) operationSymbol = '*';
        else if (operation == 3) operationSymbol = '/';
		System.out.print(" " + operationSymbol+ " ");
		System.out.print(SecondNumber);
		System.out.print(" = "+ result);
		System.out.println();
	}
}
