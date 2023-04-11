public class doublylinkedlist {
    
    private node head;
    
    public doublylinkedlist() 
    {
        this.head = null;
    }
    
    public void add(int value)
    {
        // Adds the value to the end of the list
        if (head == null)
        {
            head = new node(value, null, null);
        }
        else
        {
            node temp = head;
            node prev = head;
            while (temp.getNext() != null)
            {
                temp = temp.getNext();
                prev = temp;
            }
            temp.setNext(new node(value, prev, null));
        }
    }
    
    public int size()
    {
        node temp = head;
        if (head == null)
        {
            return 0;
        }
        else
        {
            int size = 1;
            while (temp.getNext() != null)
            {
                size++;
                temp = temp.getNext();
            }
            return size;
        }
    }
    
    public void deleteOdd()
    {
        int size = size();
        node temp = head, prev = null;
        
        for (int i = 0; i < size; i++)
        {
            if (temp.getValue() % 2 != 0)
            {
                if (prev == null)
                {
                    head = temp.getNext();
                    temp = head;
                }
                else if (temp.getNext() == null)
                {
                    prev.setNext(null);
                    temp.setPrevious(null);
                }
                else
                {
                    prev.setNext(temp.getNext());
                    temp.setPrevious(prev);
                    temp = temp.getNext();
                }
                
            }
            else
            {
                prev = temp;
                temp = temp.getNext(); 
            }
        }
        
    }
    
    @Override
    public String toString()
    {
        String output = "[";
        node temp = head;
        
        if (head == null)
        {
            return "[]";
        }
        
        while (temp.getNext() != null)
        {
            output += temp.getValue() + ", ";
            temp = temp.getNext();
        }
        
        output += temp.getValue();
        return output + "]";
    }
    
}

class node {
    
    private Integer value;
    private node previous;
    private node next;

    public node(Integer value, node previous, node next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public node getPrevious() {
        return previous;
    }

    public void setPrevious(node previous) {
        this.previous = previous;
    }  
    
    public node getNext() {
        return next;
    }

    public void setNext(node next) {
        this.next = next;
    }  
    
}
