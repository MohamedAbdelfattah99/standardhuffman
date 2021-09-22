/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package standardhuffman;

/**
 *
 * 
 */
public class Node {
    public String symbol;
    public int freq;
    public String nodeCode;
    public Node left;
    public Node right;
    public Node parent;
    
    public Node()
    {
        symbol = "";
        freq = 0;
        nodeCode = "";
        left = null;
        right = null;
        parent = null;
                
    }
}
