package standardhuffman;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;
/**
 *
 * @author ta7a
 */
public class StandardHuffman {
    public static Scanner input = new Scanner(System.in);
    public static Vector<Node> myNodes = new Vector<>();
    public static Node root = new Node();
    public  static  String output=null;
    public static Vector<String> binary = new Vector<>();
    public static void calc_freq()
    {      
            Vector<String> myTags = new Vector<>();
            String text = input.next();
            int counter = 0;
            boolean bool = false;
            for(int i = 0; i < text.length(); i++)
            {
                char c = text.charAt(i);
                for(int j = 0; j < myTags.size(); j++)
                {
                    if(myTags.get(j)==c)
                        bool = true;
                }
                
                if(!bool)
                {
                    myTags.add(c);
                    for(int k = 0; k < text.length(); k++)
                    {
                        if(c==text.charAt(k))
                            counter++;
                    }
                    Node temp = new Node();
                    temp.freq = counter;
                    temp.symbol = c+"";
                    myNodes.add(temp);
                }

                counter=0;
                bool=false;
            }
              
    }        
    public static void Sort()
    {
        for(int i = 0; i < myNodes.size() - 1; i++)
        {
            for(int j = 0; j < myNodes.size() - i - 1; j++)
            {
                if(myNodes.get(j).freq < myNodes.get(j+1).freq)
                {
                    String symbol = myNodes.get(j).symbol;
                    myNodes.get(j).symbol = myNodes.get(j+1).symbol;
                    myNodes.get(j+1).symbol = symbol;
                    
                    int freq = myNodes.get(j).freq;
                    myNodes.get(j).freq = myNodes.get(j+1).freq;
                    myNodes.get(j+1).freq = freq;
                    
                    String nodeCode = myNodes.get(j).nodeCode;
                    myNodes.get(j).nodeCode = myNodes.get(j+1).nodeCode;
                    myNodes.get(j+1).nodeCode = nodeCode;
                    
                    Node left = myNodes.get(j).left;
                    myNodes.get(j).left = myNodes.get(j+1).left;
                    myNodes.get(j+1).left = left;
                    
                    Node right = myNodes.get(j).right;
                    myNodes.get(j).right = myNodes.get(j+1).right;
                    myNodes.get(j+1).right = right;
                    
                    Node parent = myNodes.get(j).parent;
                    myNodes.get(j).parent = myNodes.get(j+1).parent;
                    myNodes.get(j+1).parent = parent;
                    
                }
            }
        }
    }
    public static void Compress()
    {
        while(myNodes.size()>1)
        {
            Sort();
            root.right = myNodes.get(myNodes.size()-1);
            root.left = myNodes.get(myNodes.size()-2);
            root.right.parent = root;
            root.left.parent = root;
            
            Node temp = new Node();
            temp.freq = myNodes.get(myNodes.size()-1).freq + myNodes.get(myNodes.size()-2).freq;
            temp.symbol = myNodes.get(myNodes.size()-2).symbol + "+" +myNodes.get(myNodes.size()-1).symbol;
            temp.left = myNodes.get(myNodes.size()-2);
            temp.right = myNodes.get(myNodes.size()-1);
            
            myNodes.remove(myNodes.size()-1);
            myNodes.remove(myNodes.size()-1);
            myNodes.add(temp);
        }
            root = myNodes.get(0);
    }
       public static void Code()
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        root.nodeCode="";
        while (!queue.isEmpty()) {

            Node tempNode = queue.poll();
            
               if (tempNode.left != null) {
                tempNode.left.nodeCode = tempNode.nodeCode + "1";
                  queue.add(tempNode.left);
                
                
            }

          if (tempNode.right != null) {
                tempNode.right.nodeCode = tempNode.nodeCode + "0";
                queue.add(tempNode.right);

            }
        }

    }
    public static void Tree()
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {

            Node tempNode = queue.poll();
            System.out.println(tempNode.symbol+" "+tempNode.freq);  
            System.out.println(tempNode.nodeCode);
                              output+=tempNode.nodeCode;

            if (tempNode.left != null) {
                queue.add(tempNode.left);

            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);

            }
        }
    }
    
    public static void main(String[] args) {
        calc_freq();
        Compress();
        Code();
        Tree();
                System.out.println(output);

    }
    
//aaaaaaaaaabbbbbccbbdddeeeeeegggggggg
}
