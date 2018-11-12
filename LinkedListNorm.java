package ds_lab;
/*
 * normal linked list used to hold pointers to neighbor vertex
 */

public class LinkedListNorm
{
    /*
     * Need to add to list, no need to delete
     * Make this doubly linked list
     */
    NodeVertex head;
    NodeVertex tail;
    
    /*
     * add node at end of list
     */
    public void append(NodeVertex newNode)
    {    
        //NodeVertex newNode = new NodeVertex(newData);
        
        if(head==null)
        {
            newNode.prev = null;
            head = newNode;
            tail = newNode;
            return;
        }
        
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    } 
    
    /*
     * (non-Javadoc)
     * toString
     * 
     */
    public String toString()
    {
        NodeVertex temp = head;
        String str = "";
        while(temp != null)
        {
            str += temp.toString() + ", ";
            temp = temp.next;
        }
        
        return str;
    }
    

    

}
