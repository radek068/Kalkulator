package application;

import java.util.Scanner;
/**
 * 
 * @author Radosław Staniów
 * @version 14/04/2023
 */
public class Main {
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		Parameters par = new Parameters(args);
		int operation = par.getOperation();
		double FirstNumber = par.getFirstNumber();
		double SecondNumber = par.getSecondNumber();
		
		System.out.println("Welcome to the calculator program made by Radoslaw Staniow!"); // TODO dokonczyc wprowadzenie
		System.out.println("To get started, you can enter a mathematical operation or type 'help' for a brief introduction and list of available commands.");
		
		Calculator calculator = new Calculator();
		
		if(operation != -1) {
			char operationSymbol = ' ';
			if (operation == 0) operationSymbol = '+';
	        else if (operation == 1) operationSymbol = '-';
	        else if (operation == 2) operationSymbol = '*';
	        else if (operation == 3) operationSymbol = '/';
			System.out.println(FirstNumber +" "+ operationSymbol +" " +SecondNumber);
			double result = calculator.calculate(operation,FirstNumber,SecondNumber);
			History.previousResult = result;
			History.isPreviousResultPresent = true;
			Operation opertation = new Operation(FirstNumber,SecondNumber,operation,result,false);
			new History().addOperation(opertation);
		}
		
		Scanner input = new Scanner(System.in);
		
		while(true) {
			String userInput = input.nextLine();
			
			if (userInput.equals("help")) {
				System.out.println("Available commands:");
				System.out.println("help - prints a list of commands with a brief description");
				System.out.println("history - lists all successful operations performed in the current session");
				System.out.println("history-detailed - prints a detailed informations for a specific operation from the list displayed using the history comment. after entering the command, the user is asked to enter the operation number");
				System.out.println("exit - closes the program");
				System.out.println();
				System.out.println("Available operations:");
				System.out.println("- Addition (+)");
				System.out.println("- Subtraction (-)");
				System.out.println("- Multiplication (*)");
				System.out.println("- Division (/)");
				System.out.println();
				System.out.println("Note: if you want to use decimal numbers, use a period (.) as the decimal separator, not a comma (,).");
				System.out.println();
				System.out.println("To perform an operation, enter the entire expression in one line as a single input, with the format: \"<number> <operator> <number>\"");
				System.out.println();
				System.out.println("Example expressions:");
				System.out.println("1 + 2.5");
				System.out.println("3.5 * 4");
				System.out.println("8 / 2");
				System.out.println();
				System.out.println("To use the previous result as the first number in the expression, simply skip the first number.");
				System.out.println();
				System.out.println("Example expressions using the previous result:");
				System.out.println();
				System.out.println("+ 5");
				System.out.println("- 7.5");
				System.out.println("/ 6");
				System.out.println();
            } else if(userInput.equals("history")) {
            	System.out.println("use command \"history-detailed\" to display detailed information about the operation");
                new History().printHistory();
            } else if(userInput.equals("history-detailed")) {
            	System.out.print("Enter an index: ");
            	try {
                	int index = input.nextInt();
                    new History().printOperationDetailedDescription(index);
            	}	catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. The program expected a number.");
                }
                input.nextLine();
            } else if(userInput.equals("exit")) {
            	input.close();
            	System.out.println("thank you for using the program, goodbye!");
            	System.exit(0);
            } else {
            	calculator.parseUserInput(userInput);
            }	
		}
	}
}