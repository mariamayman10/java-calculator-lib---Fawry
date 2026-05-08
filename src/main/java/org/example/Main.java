package org.example;

import org.calculator.api.Calculator;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    private static int getChoice(){
        System.out.println("Please Enter your Choice: ");
        return scanner.nextInt();
    }
    private static void displayMenu(){
        System.out.println("""
                Welcome To Calculator
                    1- Add 2 Numbers
                    2- Subtract 2 Numbers
                    3- Multiply 2 Numbers
                    4- Divide 2 Numbers
                    5- Modulus 2 Numbers
                    6- Exit
                """);
    }
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        while (true){
            displayMenu();
            int choice = getChoice();
            if(choice == 6) break;
            if(choice < 1 || choice > 6) {
                System.out.println("Wrong Choice, try again...");
                continue;
            }
            System.out.println("Please Enter your first number (int or double): ");
            double a = scanner.nextDouble();
            System.out.println("Please Enter your second number (int or double): ");
            double b = scanner.nextDouble();
            try{
                double result = switch (choice) {
                    case 1 -> calculator.add(a, b);
                    case 2 -> calculator.subtract(a, b);
                    case 3 -> calculator.multiply(a, b);
                    case 4 -> calculator.divide(a, b);
                    case 5 -> calculator.mod(a, b);
                    default -> 0;
                };
                System.out.println("Result: " + result);
            }catch (IllegalArgumentException e){
                System.out.println(e.getLocalizedMessage());
            }
        }
    }

}