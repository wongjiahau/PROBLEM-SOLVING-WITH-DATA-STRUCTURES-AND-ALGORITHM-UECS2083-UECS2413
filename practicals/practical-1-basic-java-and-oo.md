# Practical Exercise 1 – Basic Java and Object-oriented Programming

## Overall Objective
By the end of this practical, you should:  
- understand and be able to use the integrated development environment (IDE) for Java  
- be able to create, edit, and run your Java programs

## Background
You will need to know:
1.	data types, values and variables	
2.	input/output	
3.	selection and iteration	
4.	methods	
5.	arrays	
6.	strings
7.	objects and classes
8.	inheritance and polymorphism
9.	exception handlings
10. abstract classes and interfaces

## Part 1: Discussion
Type all of the following code, save the program as specified.
Compile the file. Why did it fail?

```java
// saved as Test1.java
public class Testing1 {
   public static void main(String args) {
      System.out.println("What's wrong with this program?");
   }
}
```
**Answer**: Should be `String[] args` not `String args`.

<br>
```
// saved as Test2.java
public class Test2 {
   public void main(String[] args) {
      System.out.println("What's wrong with this program?")
   }
}
```
**Answer**: Should be `public static void`, not `public void`.