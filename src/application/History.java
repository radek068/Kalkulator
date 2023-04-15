package application;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Radosław Staniów
 * @version 15/04/2023
 */
public class History {
	
	public static double previousResult = 0; 
	public static boolean isPreviousResultPresent = false;
	public static int currentOperationIndex = 0;
	
	private static List<Operation> operationList = new ArrayList<>();
	
	/**
	 * Adds new operation to be stored in history.
	 * @param operation
	 */
	public void addOperation(Operation operation) {
		operationList.add(operation);
		currentOperationIndex++;
	}
	
	/**
	 * Returns operations with the given index.
	 * @param index
	 * @return
	 */
	public Operation getOperation(int index) {
		return operationList.get(index);
	}
	
	/**
	 * Prints a brief description of all operations stored in the history.
	 */
	public void printHistory() {
		for (int i = 0; i < operationList.size(); i++) {
			System.out.println("Operation nr: "+(i+1));
		    operationList.get(i).printShortDescription();
		}
	}
	
	/**
	 * Prints detailed information about a given operation and if the result of the previous operation was used in it, recursively displays it as well.
	 * @param index
	 */
	public void printOperationDetailedDescription(int index) {
		index--;
		System.out.println();
		if(index < 0 || index > operationList.size()-1) {
			System.out.println("There is no operation with the given index.");
		} else {
			operationList.get(index).printDetailedDescription();
		}
	}
}
