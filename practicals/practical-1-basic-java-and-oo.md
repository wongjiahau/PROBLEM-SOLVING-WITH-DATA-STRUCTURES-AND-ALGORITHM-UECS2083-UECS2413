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
### Question 1
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
**Answer**: 
-	Should be `public static void`, not `public void`.
-	Missing semicolon 

### Question 2
What problem arises in compiling the following program?

```java
class A {
   public A(int x) {}
}

class B extends A {
   public B() {}
}
```

Answer: The constructor of `B` did not call the constructor of `A`. To call the constructor of super(aka parent) class, we need to use `super();`.


### Question 3 
Show the output of the following programs:

```java
// Program 1
public class Test {
   public static void main(String args[]) {
      A a = new A(3);
   }
}

class A extends B {
   public A(int n) {
      System.out.println("A’s constructor is invoked.");
   }
}

class B {
   public B() {
      System.out.println("B’s constructor is invoked.");
   }
}
```
Output:
```
B’s constructor is invoked.
A’s constructor is invoked.
```
Reference: [Why is constructor of super class invoked first?](https://stackoverflow.com/questions/7173019/why-is-constructor-of-super-class-invoked-when-we-declare-the-object-of-sub-clas)
<hr>

