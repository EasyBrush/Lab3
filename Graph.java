package ds_lab;

import java.io.BufferedWriter;
import java.io.IOException;

public class Graph
{
    LinkedListNorm VertexList;
    LinkedListNorm currentPath;
    int size;
    private int currentPathPtr;
    private int pointer;
    NodeVertex tempNode;
    private BufferedWriter outFile;

    
    
    public Graph(int size, BufferedWriter outFile)
    {   //initialized      
        VertexList = new LinkedListNorm();
        currentPath = new LinkedListNorm();
        this.size = size;
        
        tempNode = null;
        currentPathPtr = 0;
        pointer = 0;
        /*for(int i=0; i<size+1; i++)
        {
            currentPath[i] = -1;
        }*/
        
        this.outFile = outFile;
    }    
    
    /*
     * append new vertex to list
     */
    public void append(NodeVertex node)
    {
        VertexList.append(node);
        
    }
    
    /*
     * 
     */
    //don't think I need current path
    public void traverseGraph(NodeVertex currentNode, String[] paths, LinkedListNorm currentPaths)
    {               
        //base case, check if current node is same as start point & if current path built is not empty
        if(currentNode == currentPaths.head && !currentPaths.isEmpty()) 
        {
            
            
            currentPaths.append(currentNode);
            
            //store currentPaths into string Paths
            paths[pointer++] = currentPaths.printPaths();
            currentPaths.remove();
            return;           
            
        }
        
        //need to check for repeating elements in between head and tail
        //build path
        boolean path = false;
        
        currentPaths.append(currentNode);
        
        LinkedListNorm possiblePaths = new LinkedListNorm();
        
        
        for(int i=0; i<currentNode.neighbors.Size(); i++)
        {
            if (checkPath(currentPaths, i))
            {//true -> found in list
                if(currentPaths.head.data == i)
                {
                    possiblePaths.append(currentNode.neighbors.search(i));
                    path = true;
                }
                
            }
            else
            {//false
                possiblePaths.append(currentNode.neighbors.search(i));
                path = true;
            }
            
            
        }                     
        
        
        //base case, check if path is not available
        if(path == false)
        {
            //add currentPath to pathList
            paths[pointer++] = currentPaths.printPaths();
            
            currentPaths.remove();
            return;
        }
                
        //recursion
        for(int i = 0; i<possiblePaths.Size(); i++)
        {
            traverseGraph(possiblePaths.search(i), paths, currentPaths);
        }
        currentPaths.remove();  
    }   
    
    
    /*
     * going to store final paths into an array and write entire array to outFile??
     */
    public void findPath()
    {
        String[] finalPaths = new String[50];
        
        //start with head of list of vertex list
        for(int i=0; i<VertexList.Size(); i++)
        {
            traverseGraph(VertexList.search(i), finalPaths, currentPath);
        }
        //traverseGraph(VertexList.head, finalPaths, currentPath);
        
        //write out currentPaths using printPath method
        try
        {
            outFile.write(Integer.toString(size));
            outFile.newLine();
            
            //print matrix in outFile
            
            String buffer = "Paths: ";
            
            for(int j=0; j<pointer; j++)
            {
                buffer += (finalPaths[j] + ", ");
            }
            
            outFile.write(buffer);
            outFile.newLine();
            outFile.newLine();
            
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
    }      
    
    /*
     *  
     */
    public void printPath(LinkedListNorm currentPath)
    {
        

        
        
       
    }
    
    public String toString()
    {
        return VertexList.toString();
    }
    
    /*
     * true if node is already in path, false if not found
     */
    public boolean checkPath(LinkedListNorm currentPath, int nodeData)
    {
        if(!currentPath.isEmpty())
        {
            //searches entire current path linked list
            return (currentPath.search(nodeData)!= null);
            
        }
        return false;
    }

}
