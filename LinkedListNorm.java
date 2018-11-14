package ds_lab;
/**
 * Doubly linked list with head and tail pointer
 * @author Bryan Cheung
 */

public class LinkedListNorm
{

    NodeVertex head;
    NodeVertex tail;
    //NodeVertex tempHead;
    
    
    /**
     * add node at end of list
     * @param newNode
     */
    public void append(NodeVertex newNode)
    {    

        
        if(head==null)
        {
            newNode.prev = null;
            head = newNode;
            tail = newNode;
            
            return;
        }
        else
        {
            tail.next = newNode;
            newNode.prev = tail;
            //newNode.next = null;
            tail = newNode;
            
        }
        
        /*tail.next = newNode;
        newNode.prev = tail;
        newNode.next = null;
        tail = newNode;*/
        
    } 
    
    /**
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
    
    /**
     * removes last item
     */
    
    public void remove()
    {      
        if(!isEmpty())
        {  
            if(head == tail)
            {
                head = null;
                tail = null;
            }
            else
            {
                tail = tail.prev;
                tail.next = null;
            }       
        }
    }
    
    /**
     * finds and returns node corresponding to data
     * @param id value
     */
    public NodeVertex search(int x) 
    { 
        NodeVertex current = head;    //Initialize current 
        while (current != null) 
        { 
            if (current.data == x) 
                return current;    //data found 
            current = current.next; 
        } 
        return null;    //data not found 
    } 
    
    /**
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
    /**
     * returns string buffer
     * @return
     */
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
    
    /**
     * returns size of linked list
     */
    public int Size()
    {
        int count =0;
        NodeVertex current = head;
        while(current != null)
        {
            current = current.next;
            count +=1;
        }
        return count;
    }
    
    

    

}
