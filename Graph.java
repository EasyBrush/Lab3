package ds_lab;

public class Graph
{
    LinkedListNorm VertexList;

    
    
    public Graph()
    {        
        VertexList = new LinkedListNorm();
        
    }    
    
    /*
     * append new vertice to list
     */
    public void append(NodeVertex node)
    {
        VertexList.append(node);
    }
    
    /*
     * 
     */
    public void traverseGraph(NodeVertex startNode, NodeVertex currentNode)
    {
        if(startNode == currentNode)
        {
            
        }
        
    }   
    
    
    /*
     * going to store final paths into an array and write entire array to outFile??
     */
    public void findPath()
    {
        //String[] finalPaths = new String[50];
        
        
    }      
    
    /*
     *  
     */
    public void printPath(NodeVertex currentNode)
    {
        
        
       
    }
    
    public String toString()
    {
        return VertexList.toString();
    }

}
