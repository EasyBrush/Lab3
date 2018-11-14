package ds_lab;
/**
 * This class is responsible for graph traversal and path finding
 * @author Bryan Cheung
 */
import java.io.BufferedWriter;
import java.io.IOException;

public class Graph
{
    LinkedListNorm VertexList;
    //LinkedListNorm VertexList2;
    LinkedListNorm currentPath;
    int size;
    private int pointer;
    NodeVertex tempNode;
    private BufferedWriter outFile;

    
    /**
     * constructor
     * 
     * @param size
     * @param outFile
     * @param vertexList
     */
    public Graph(int size, BufferedWriter outFile, LinkedListNorm vertexList)
    {   //initialized      
        this.VertexList = vertexList;      
        
        currentPath = new LinkedListNorm();
        this.size = size;
        
        tempNode = null;
        
        pointer = 0;
        /*for(int i=0; i<size+1; i++)
        {
            currentPath[i] = -1;
        }*/
        
        this.outFile = outFile;
    }    
    
    /**
     * append new vertex to list
     * @param node
     */
    public void append(NodeVertex node)
    {
        VertexList.append(node);
        
    }
    
    /**
     * Traverses graph using depth first search
     * @param currentNode, paths[], currenPaths
     */
    public void traverseGraph(NodeVertex currentNode, String[] paths, LinkedListNorm currentPaths)
    {               
        //base case, check if current node is same as start point & if current path built is not empty
        if(!currentPaths.isEmpty() && currentNode.getData() == currentPaths.head.getData()) 
        {   
            currentPaths.append(currentNode);
            
            //store currentPaths into string Paths
            paths[pointer++] = currentPaths.toString();
            System.out.println(currentPaths);
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
            if (checkPath(currentPaths, currentNode.neighbors.get(i).getData()))
            {//true -> found in list
                if(currentPaths.head.data == currentNode.neighbors.get(i).getData())
                {
                    possiblePaths.append(currentNode.neighbors.get(i));
                    path = true;
                }
            }
            else
            {//false
                possiblePaths.append(currentNode.neighbors.get(i));
                path = true;
            }  
        }                     
               
        //base case, check if path is not available
        if(path == false)
        {
            //add currentPath to pathList
            paths[pointer++] = currentPaths.toString();
            System.out.println(currentPaths);
            currentPaths.remove();
            return;
        }
                
        //recursion
        for(int i = 0; i<possiblePaths.Size(); i++)
        {
            traverseGraph(possiblePaths.get(i), paths, currentPaths);
        }
        currentPaths.remove();  
    }   
    
    
    /**
     * initiates recursion and writes final paths to outfile
     */
    public void findPath()
    {
        String[] finalPaths = new String[50];
        
        //start with head of list of vertex list
        for(int i=0; i<VertexList.Size(); i++)
        {
            traverseGraph(VertexList.search(i), finalPaths, currentPath);
        }
          
        //write out currentPaths using printPath method
        try
        {
                       
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
    /**
     * toString 
     * returns string representation of VertexList
     */
    public String toString()
    {
        return VertexList.toString();
    }
    
    /**
     * Checks if path already contains the nodeDate
     * true if node is already in path, false if not found
     * 
     * @param currentPath, nodeData
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
