# CS 301 Project 5: Postfix Expression Evaluator

## Objective
The goal of this project is to implement a robust and efficient Java program capable of evaluating arithmetic expressions presented in **Postfix Notation** (Reverse Polish Notation or RPN). The program is designed to read expressions from a file and utilize modern Java collections for stack operations.

---

## Technologies and Design

| Component | Specification | Rationale (Best Practice) |
|-----------|--------------|---------------------------|
| **Data Structure** | `Deque` interface implemented by `ArrayDeque` | `ArrayDeque` is the recommended, more efficient approach for stack operations in Java (constant time performance for push/pop) compared to the legacy `Stack` class. |
| **Input Source** | Reads from `expression.txt` file. | File-based input using the `Scanner` class to process tokens line by line. |
| **Accepted Operators** | `+`, `-`, `*`, `/` | Standard binary arithmetic operators. |
| **Operand Type** | `int` values. | Ensures correct handling of integer arithmetic and conversion from string tokens. |

---

## Implementation Details

The core functionality is encapsulated in the `getTotal(String filename)` method, which follows these steps:

1. **File Reading**: Uses a nested `Scanner` approach to read the file line-by-line and token-by-token.
2. **Token Processing**: Iterates through each token. If the token is an operator, it performs the RPN logic. If it is a number, it is pushed onto the stack.
3. **RPN Logic**: When an operator is encountered, two operands are popped from the stack (`numOne` and `numTwo`), the operation is performed, and the result is pushed back onto the stack. *(Note: Order of subtraction and division is handled correctly for RPN)*.

---

## Robust Error and Edge Case Handling

A primary focus of this project was implementing robust error checking as per the design specifications:

| Error Type | Handling Mechanism |
|------------|-------------------|
| **Division by Zero** | Implemented a specific check within the division case (`/`) to ensure the divisor is non-zero. The program outputs an error message and stops processing if this condition is met. |
| **Too Many Operators** | Handled using a `try-catch` block for `EmptyStackException` when attempting to pop two operands, correctly identifying an underflow. |
| **Too Many Operands** | After the entire file is processed, the stack size is checked. If `stack.size() > 1`, it indicates unused operands, and an error message is printed. |
| **File Not Found** | A `try-catch` block handles `FileNotFoundException` during file initialization. |
| **Invalid Input** | The code includes logic to handle `NumberFormatException` if a non-operator string cannot be parsed into an `int`. |

---

## Project Structure and Execution

### Directory Layout
The required project structure is:
```
project5/
├── src/
│   ├── package5/
│   │   ├── Project5.java          # Driver Class - Contains getTotal method
│   │   └── Project5Test.java      # JUnit Test Class
│   └── expression.txt              # Input File
└── ...                             # Other project files
```

### Running the Program
The driver class, `Project5.java`, is executed directly. It calls the `getTotal()` method, reads the `expression.txt` file, and outputs the result to standard output.

**Sample Output Example:**
```
Input Expression (from expression.txt): 5 9 8 + 4 6 * * 7 + *
Output: 2075
```

---

## Unit Testing (JUnit)

The `Project5Test.java` class provides comprehensive unit tests, ensuring:

- ✅ **Correct Calculation**: Tests for all four arithmetic operations and complex expressions.
- ✅ **Edge Case Tests**: Includes dedicated tests to trigger and confirm correct handling of:
  - Division by Zero
  - Too Many Operators (Stack Underflow)
  - Too Many Operands (Stack Leftover)
  - File Not Found

---

## Key Features

- 🚀 **Modern Java Collections**: Uses `ArrayDeque` for optimal performance
- 🛡️ **Robust Error Handling**: Comprehensive error checking for all edge cases
- 📝 **File-Based Input**: Reads expressions from external files
- ✅ **JUnit Testing**: Complete test coverage for validation
- 🎯 **RPN Algorithm**: Correct implementation of Reverse Polish Notation evaluation

---

## Technologies Used

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![JUnit](https://img.shields.io/badge/JUnit-25A162?style=for-the-badge&logo=junit5&logoColor=white)

---

## Author

**E Perez Ramos**  
Central Washington University - CS 301: Data Structures
