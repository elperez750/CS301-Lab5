/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package package5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author elper
 */
public class Project5Test {
    
    public Project5Test() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getTotal method, of class Project5.
     */
    @Test
    public void testAddition() {
        System.out.println("Testing addition");
        int expResult = 11;
        int result = Project5.getTotal("testAddition.txt");
        assertEquals(expResult, result);
       }
    
    
    @Test
    public void testSubtraction() {
        System.out.println("Testing subtraction");
        int expResult = 7;
        int result = Project5.getTotal("TestSubtraction.txt");
        assertEquals(expResult, result);
        
    }

    
    @Test
    public void testMultiplication() {
        System.out.println("Testing multiplication");
        int expResult = 1600;
        int result = Project5.getTotal("TestMultiplication.txt");
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testDivision() {
        System.out.println("Testing division");
        int expResult = 2;
        int result = Project5.getTotal("testDivision.txt");
        assertEquals(expResult, result);
    }
    
    
    
    @Test
    public void testComplex() {
        System.out.println("Testing complex expression");
        int expResult = 2075;
        int result = Project5.getTotal("expressions.txt");
        assertEquals(expResult, result);
        
    }
   
    
}
