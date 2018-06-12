# Practical Exercise 2 – Recursion

## Overall Objective
### To write programs that use recursive implementation.
Background
You will need to know:
1.	basic Java programming knowledge	
2.	methods	
3. 	loop concepts
4. 	recursion

## Description
### Part 1: Discussion

### 1.	What is a recursive method?
```
A recursive method is the one that call itself.
```
<hr>  

### Describe the characteristics of recursive methods.  

```
One or more base cases (the simplest case) are used to stop recursion.
Every recursive call reduces the original problem, 
brining it increasingly close to base case until it becomes that case.
```
<hr>

### 2.	What is a cause of a stack-overflow exception?
```
When a method is invoked, its content are placed into a stack, 
if the method is recursively invoked, it is possible that the stack space is exhausted. 
This cases is stack overflow.
```

### 3.	Which of the following statements are true?  
a.	Any non-recursive method can be converted into a recursive method.
**True.**

b.	Non-recursive methods take more resources to execute than recursive methods.
**False**

c.	Recursive methods without selection statement lead to infinite recursion.
**True.**

d.	Recursive definition does not guarantee that a recursive code is the best way to solve a problem.
**False.**

<hr>

### 4.	Consider ComputeFactorial.java program in the main textbook, how many times is the `factorial` method invoked for `factorial(5)`? What is the base case?
Six times (base case factorial(0)).
Base case is n = 0.

### 5. Consider ComputeFibonacci.java program in the main textbook, how many times is the `fib` method invoked for `fib(3)`? What are the base cases?
Five times.
Base cases are index = 0 and index =1

### 6.	Consider RecursivePalindromeUsingSubstring.java program in the main textbook, how many times is the `isPalindrome` method invoked for `isPalindrome(abdxcxdba)`? What are the base cases?
Five times.  
Base cases are `s.length() <= 1` and `s.charAt(0) != s.charAt(s.length() - 1)`

### 7.	Consider TowersOfHanoi.java program in the main textbook, how many times is the moveDisks method invoked for moveDisks(5, 'A', 'B', 'C')?
2^5 - 1 = 31 times.

### 8.	Show the output of the following programs. Also, identify base cases and recursive calls.
```java
public class Test {
	public static void main(String[] args) {
		System.out.println("GCD is " + xMethod(48, 18));
	}

	public static int xMethod(int n1, int n2) {
		int remainder;

		remainder = n1 % n2;
		if (remainder == 0)
			return n2;
		else
			return xMethod(n2, remainder);
	}
}
```
Answer: GCD is 6
```java
public class Test {
	public static void main(String[] args) {
		System.out.println("Exponent is " + xMethod(3, 4));
	}

	public static long xMethod(int base, int exponent) {
		if (exponent == 0)
			return 1;
		else
			return base * xMethod(base, exponent - 1);
	}
}
```
Answer: Exponent is 81
