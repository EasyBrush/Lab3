package ds_lab;

public class NodeVertex
{
    int data;
    NodeVertex next;
    NodeVertex prev;
    
    LinkedListNorm neighbors;
    
    //constructor to create new node
    NodeVertex(int d)
    {
        data = d;
        next = null;
        prev = null;
        
        neighbors = null;
    }
    
    public String toString()
    {
        return Integer.toString(data);
    }
}
