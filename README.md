# Grapher
**Grapher** is Java Graph Library made by hygoni.

I made it because I had to write same codes because there's no public graph library on java.

the Grapher folder is an eclipse project. so you can simply import it.



**Implementation :**

- used nested hashmap to represent graph
- can get max flow using ford-fulkerson algorithm 

**Packages :**

[io.github.hygoni.Graph](https://github.com/hygoni/Grapher/tree/master/Grapher/src/io/github/hygoni/Graph) - It's an eclipse project of this library

[io.github.hygoni.Examples](https://github.com/hygoni/Grapher/tree/master/Grapher/src/io/github/hygoni/Examples) - Examples of this library



**TODO List** :

- implement bfs, dfs algorithm

- optimize on bipartite matching problems

- visualize the process of bfs, dfs, network flow algorithms

  

**Notice**

Currently Not Suitable For Solving Bipartite Matching Problems:

it's because of poor time complexity of Ford-Fulkerson. going to improve it soon