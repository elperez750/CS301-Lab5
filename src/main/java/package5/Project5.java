/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


/*

Elliott Perez Ramos
 Hours to complete: 5 Hours
I pledge that this is my own work and that I did not plagarize my work
*/


package package5;
import java.util.ArrayDeque;
import java.util.Deque;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.EmptyStackException;
/**
 *
 * @author elper
 */
public class Project5 {
    
    
    public static int getTotal(String filename) {
        
        // Define stack. This will only contain our integers, not operators
        Deque<Integer> stack = new ArrayDeque(); 
        
        // Define a list that will keep possible operators
        List<String> operators = new ArrayList<>();
        
        // Add operators to list
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        
        
        
        try {
            // Dynamically read from filename provided
            File expressions = new File("src/" + filename);
            
            // This will read our line
            Scanner fileReader = new Scanner(expressions);
            
            
            /*
            Check while we still have a ling
            There might be a better way to do this since we will only have one line,
            but this works nontheless.
           
            */
            while (fileReader.hasNextLine()) {
                
                
                // We created a reader for the line so that we can scan numbers and operators
                Scanner lineReader = new Scanner(fileReader.nextLine());
                
                
                // loops while we have a number or operator
                while (lineReader.hasNext()) {
                    
                    // Saves input as string at first
                    String currentInput = lineReader.next();
                    
                    // We check if the current input is a operator
                    if(operators.contains(currentInput)) {
                        
                        
                        // We wrap this in a try-catch in case we try to pop an empty stack
                        try {
                            // Pop last two numbers inserted to stack
                            int numOne = stack.pop();
                            int numTwo = stack.pop();
                        
                           // This is to check what operation we will perform
                          switch(currentInput) {
                            case "+" -> stack.addFirst(numOne + numTwo);
                            case "-" -> stack.addFirst(numTwo - numOne);
                            case "*" -> stack.addFirst(numOne * numTwo);
                            case "/" -> {
                                    /*
                                    We check that the divisor is not 0. If it is 
                                    then we throw an ArithmeticException
                                     */
                                    if (numOne == 0) {
                                        throw new ArithmeticException("Cannot divide by zero");
                                    } else {
                                        // If divisor is not zero, divide normally
                                        stack.addFirst(numTwo / numOne);
                                    }
                                }
                            }
                        }
                        
                        /*
                        The reason this means there are too many operators 
                        is that you pop two elements per operator, so having
                        an empty stack means the line had too many operators
                        
                        */
                        
                        catch(EmptyStackException e) {
                            System.out.println("Too many operators");
                        }
                      
                    }
                    /*
                    If the input is not a operator, we just add it 
                     to the top of the stack, converting it to an integer first
                        
                   */
                    
                    else {
                      stack.addFirst(Integer.valueOf(currentInput));

                    }
                    
                }
               lineReader.close();

             
            }
            
              
        fileReader.close();
            
        }
        
        // This is in case our program cannot read the file or it does not exist
        catch (FileNotFoundException e) {
               System.out.println("This file was not found");
        }
        
        
        /*
        If we had more than 1 element in our stack, that means that the operands
        outnumbered the operators, meaning that we could not get a proper result
        */
      
       
        if (stack.size() > 1) {
             throw new IllegalArgumentException("Too many operands");
            
        }
        
        if (stack.isEmpty()) {
             throw new IllegalArgumentException("Something went wrong");
        }
        /*
        If all is well, then we return the only element in the stack which is 
        the result
       */
        
        return stack.pop();
        
         
    }
        
    

    public static void main(String[] args) {
        
        System.out.println(getTotal("expressions.txt"));
        
     
    }
}
