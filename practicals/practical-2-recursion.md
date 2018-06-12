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
