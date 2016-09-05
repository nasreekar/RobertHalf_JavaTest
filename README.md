
Solution for the **quickest route** between any two given stations.

The scenario 
============

Given an abstract set of train stations (as given below) with predefined routes and travel times, "The quickest route between any two given stations is ..”

Train stations and travel times 
* A to B takes 3 minutes 
* B to A takes 3 minutes 
* A to D takes 6 minutes 
* B to C takes 7 minutes 
* C to D takes 8 minutes 
* D to E takes 9 minutes 
* E to D takes 9 minutes 
* D to C takes 9 minutes 
* D to B takes 5 minutes 
* C to E takes 3 minutes 

Solution
==========

I tried to solve this question in **Java** and using [***Dijkstra's algorithm***](https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm). 

The videos below can be used for better understanding of the algorithm.
* [Graphs: Dijkstra's Algorithm](https://www.youtube.com/watch?v=8Ls1RqHCOPw)
* [Shortest Path using Dijkstra's Algorithm](https://www.youtube.com/watch?v=WN3Rb9wVYDY)

**Input fields**: Starting point and End point (for eg: A,E or D,A etc)
As of now, hardcoded the map values inside the code (Can be changed to manual entry if needed)

Conclusion
==========

This may not be the optimum solution and also I heard that this can be solved using another algorithm called [***AStar Algorithm***](https://en.wikipedia.org/wiki/A*_search_algorithm) though I'm not sure of how to use this algorithm.
