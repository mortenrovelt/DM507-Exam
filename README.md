DM507-Exam
==========

Useful scripts for automating parts of the DM507 exam.



Graphs
------

Some of the scripts output graphs in Graphviz DOT format. Make sure that you have Graphviz installed: 

```
sudo apt-get install graphviz
```

Save the output from the script to a file, e.g. `file.dot`, and then use the command 

```
dot -Tpdf file.dot -o file.pdf
```

to generate a PDF of the graph
