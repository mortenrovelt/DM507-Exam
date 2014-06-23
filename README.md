# DM507-Exam


Useful scripts for automating parts of the DM507 exam.


## Features

- Master Theorem Solver
- Red-Black BST with visualization (third-party in Other folder)
- Hash-table with open addressing
    - Linear probing
    - Quadratic probing 
    - Double hashing
- Sorting
    - Insertion sort
    - Merge sort
    - Quick sort
    - Counting sort
- Disjoint sets with visualization 
    - Linked list
    - Tree with and without path compression (option)
- Graph implementation (no algorithms yet)



## TODO

- Red-black BST with visualization
- Heap with visualization
- Graph algorithms
    - BFS
    - DFS
    - Topological sort (e.g. using DFS)
    - Bellman-Ford
    - Dijkstra
    - DAG shortest path
- Sorting
    - Heap sort
    - Radix sort
- Examples of dynamic programming
- Other implementations of interesting algorithms

## Usage

Usage depends on the specific implementation in question. Usually, it involves editing and recompiling Java or Python code, so make sure that you have these installed along with a decent editor (Vim). 



## Notes

### Master Theorem

A note on the master theorem solver: The implementation can solve more recurrence relations than the theorem presented in the course can. This is usually the case if the result is something times (log n)^i, where i is greater than 1. Only use this to check result.


### Graphviz

Some of the scripts output graphs in Graphviz DOT format. Make sure that you have Graphviz installed: 

```
sudo apt-get install graphviz
```

Save the output from the script to a file, e.g. `file.dot`, and then use the command 

```
dot -Tpdf file.dot -o file.pdf
```

to generate a PDF of the graph
