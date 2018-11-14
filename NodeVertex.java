package ds_lab;
/**
 * Node class
 * @author Bryan Cheung
 *
 */
public class NodeVertex
{
    int data;
    NodeVertex next;
    NodeVertex prev;
    
    LinkedListNorm neighbors;
    
    /**
     * constructor to create new node
     */
    NodeVertex(int d)
    {
        data = d;
        next = null;
        prev = null;
        
        neighbors = null;
    }
    /**
     * toString
     */
    public String toString()
    {
        return Integer.toString(data);
    }
    /**
     * gets id
     */
    public int getData()
    {
        return data;
    }
    
    /**
     * sets id
     * @param data
     */
    public void setData(int data)
    {
        this.data = data;
    }
    /**
     * return next
     * @return
     */
    public NodeVertex getNext()
    {
        return next;
    }
    /**
     * set next
     * @param next
     */
    public void setNext(NodeVertex next)
    {
        this.next = next;
    }
    /**
     * return prev
     */
    public NodeVertex getPrev()
    {
        return prev;
    }
    /**
     * set prev
     * @param prev
     */
    public void setPrev(NodeVertex prev)
    {
        this.prev = prev;
    }
    /**
     * return neighbors list
     */
    public LinkedListNorm getNeighbors()
    {
        return neighbors;
    }
    /**
     * set neighbors list
     * @param neighbors
     */
    public void setNeighbors(LinkedListNorm neighbors)
    {
        this.neighbors = neighbors;
    }


}
