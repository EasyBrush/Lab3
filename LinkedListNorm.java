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
    NodeVertex tempHead;
    
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
     * checks if empty
     */
    public boolean isEmpty()
    {
        if(head ==null)
        {
            return true;
        }
        return false;
    }
    
    /*
     * removes last item
     */
    
    public void remove()
    {
        NodeVertex temp = null;
        
        if(!isEmpty())
        {
            tail.prev = temp;
            tail = temp;
            tail.next = null;                  
        }
    }
    
    public NodeVertex next()
    {
        if(!isEmpty())
        {
            if(tempHead == null)
            {
                tempHead = head.next;
            }
            else
            {
                tempHead = tempHead.next;
            }
        }
        
        return tempHead;
    }
    
    /*
     * finds corresponding data
     */
    public NodeVertex search(NodeVertex head, int x) 
    { 
        NodeVertex current = head;    //Initialize current 
        while (current != null) 
        { 
            if (current.data == x) 
                return current;    //data found 
            current = current.next; 
        } 
        return current;    //data not found 
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
    
    public String printPaths()
    {
        String result = "";
        NodeVertex current = head;
        while(current.next !=null)
        {
            current = current.next;
            result += current.data;
        }
        
        return result;
    }
    

    

}
