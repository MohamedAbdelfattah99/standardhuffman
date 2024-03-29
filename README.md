<!-- ABOUT THE PROJECT -->
## About The Project

The technique works by creating a binary tree of nodes. These can be stored in a regular array, the size of which depends on the number of symbols, n {\displaystyle n} n. A node can be either a leaf node or an internal node. Initially, all nodes are leaf nodes, which contain the symbol itself, the weight (frequency of appearance) of the symbol and optionally, a link to a parent node which makes it easy to read the code (in reverse) starting from a leaf node. Internal nodes contain a weight, links to two child nodes and an optional link to a parent node. As a common convention, bit '0' represents following the left child and bit '1' represents following the right child. A finished tree has up to n {\displaystyle n} n leaf nodes and n − 1 {\displaystyle n-1} n-1 internal nodes. A Huffman tree that omits unused symbols produces the most optimal code lengths.
The process begins with the leaf nodes containing the probabilities of the symbol they represent. Then, the process takes the two nodes with smallest probability, and creates a new internal node having these two nodes as children. The weight of the new node is set to the sum of the weight of the children. We then apply the process again, on the new internal node and on the remaining nodes (i.e., we exclude the two leaf nodes), we repeat this process until only one node remains, which is the root of the Huffman tree.

<!-- AUTHORS -->
 ## AUTHORS
* Mohamed Abd el-fattah - [LinkedIn](https://www.linkedin.com/in/mohamed-abdelfattah-28a283189/) - abdelfattahmohamed968@gmail.com
* Mohamed Ashraf Badwi - [LinkedIn](https://www.linkedin.com/in/mohamed-moussa-baab731a5/) - mohamedmoussa44444@gmail.com

