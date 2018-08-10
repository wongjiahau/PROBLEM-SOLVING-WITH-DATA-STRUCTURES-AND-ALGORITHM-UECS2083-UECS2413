# Case Study 2
You have been hired to write part of the employee database for Haddock Shipping, a global package shipping and delivery company.  
Employees are added to the database via the following method call:
```java
AddEmployee(InfoRecord  newRecord, String  theBoss, int  hiringDate);
```
where newRecord is the new employee's information record,  
theBoss is the new employee's boss,  
and hiringDate is an integer representing the date the employee was hired (the higher the number, the later the date).  
You might use different data structures for the following parts (a) and (b).

a.	Your task is to store information for the union workers who deliver the packages around the city. Each worker is assigned a route, and every four months, each worker gets to choose a new route if he or she wants. However, these choices are made in order of seniority, i.e., the worker who has been with Haddock Shipping the longest has highest seniority and gets to pick first.
The company is growing quickly, so new workers are frequently added to the collection of union workers employed by Haddock Shipping. Workers quitting (and thus being removed from the database) occur far less quickly, our greater concern is speeding up the addition of new workers and the traversal of the collection of workers in the order of greatest to lowest seniority. Explain which data structure you would use to implement the collection of workers and how you would implement insertion, removal, and traversal-in-seniority-order on this structure. 

```
ANSWER
Linked List, because our greatest concern is to speed up data insertion. 
```

b.	Your second task is to store information about the company managers. Managers get points based on good performance. When a manager leaves the company, it opens up a vacancy, and the people who had that manager as a boss, the one with the most points gets promoted into the position. This leaves a new vacancy - the newly promoted employee's old job - which is filled in the same way, until finally a lowest-level manager, who was only the boss of the union workers but no managers, gets promoted and the company then hires a new manager to fill that vacancy (union workers have no desire to be promoted to management). Explain which data structure you would use to implement this collection of managers and how you would use that implementation in the promotion algorithm.

```
ANSWER
Since we have no maximum on the number of people who can have the same boss, use a General Ordered Tree.
```
