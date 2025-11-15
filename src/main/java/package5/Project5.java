/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
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
        Deque<Integer> stack = new ArrayDeque();
        List<String> operators = new ArrayList<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        
        
  
        try {
            File expressions = new File("src/" + filename);
            Scanner FileReader = new Scanner(expressions);
            
            while (FileReader.hasNextLine()) {
                
                Scanner LineReader = new Scanner(FileReader.nextLine());
                
                while (LineReader.hasNext()) {
                    
                    String currentLine = LineReader.next();
                    if(operators.contains(currentLine)) {
                        
                        try {
                        int numOne = stack.pop();
                        int numTwo = stack.pop();
                        
                      
                          switch(currentLine) {
                            case "+": stack.addFirst(numOne + numTwo);
                            case "-": stack.addFirst(numTwo - numOne);
                            case "*": stack.addFirst(numOne * numTwo);
                            case "/":
                                if (numOne == 0) {
                                    System.out.println("Error: Division by zero detected.");
                                    stack.addFirst(numTwo); 
                                    stack.addFirst(numOne);
                                    
                                    
                                    break;
                                }
                                else {
                                    
                                
                             
                                   
                               stack.addFirst(numTwo / numOne);
                            
                            }
                        }
                        }
                        catch(EmptyStackException e) {
                            System.out.println("Too many operators");
                        }
                      
                    }
                    else {
                      stack.addFirst(Integer.valueOf(currentLine));

                    }
                    

                }
               
                
            }
            
        }
        catch (FileNotFoundException e) {
               System.out.println("This file was not found");
        }
        
        
        if (stack.size() > 1) {
            System.out.println("Too many operands");
            return -1;
            
        }
       
        return stack.pop();
        
         
    }
        
    

    public static void main(String[] args) {
        
        System.out.println(getTotal("expressions.txt"));
        
     
    }
}
