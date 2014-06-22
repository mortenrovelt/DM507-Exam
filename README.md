DM507-Exam
==========

Useful scripts for automating parts of the DM507 exam.

Features
--------

- Master Theorem Solver
- Sorting
    - Insertion sort
    - Merge sort
    - Quick sort
    - Counting sort
- Disjoint sets with visualization 
    - Linked list
    - Tree with and without path compression (option)
- Graph implementation (no algorithms yet)



TODO
----

- Red-black BST with visualization
- Heap with visualization
- Graph algorithms
    - BFS
    - DFS
    - Topological sort (e.g. using DFS)
    - Bellman-Ford
    - Dijkstra
    - DAG shortest path
- Hash-table
    - Linked list
    - Linear probing
    - Quadratic probing
- Sorting
    - Heap sort
    - Radix sort
- Examples of dynamic programming
- Other implementations of interesting algorithms


Graphviz
--------

Some of the scripts output graphs in Graphviz DOT format. Make sure that you have Graphviz installed: 

```
sudo apt-get install graphviz
```

Save the output from the script to a file, e.g. `file.dot`, and then use the command 

```
dot -Tpdf file.dot -o file.pdf
```

to generate a PDF of the graph
