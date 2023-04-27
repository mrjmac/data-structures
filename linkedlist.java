public class linkedlist<T> {

    private node head;

    public linkedlist() 
    {
        this.head = null;
    }
    
    public T get(int index) throws Exception
    {
        int currIndex = 0;
        int size = size() - 1;
        node temp = head;
        
        if (index > size || index < 0)
        {
            throw new Exception("Out of bounds");
        }
        
        while (currIndex != index)
        {
            temp = temp.getNext();
            currIndex++;
        }
        
        return (T) temp.getValue();
    }
    
    public node head()
    {
        return head;
    }
    
    public void delete(int index)
    {
        int size = size() - 1, currIndex = 0;
        if (head != null && !(index > size || index < 0))
        {
            if (index == 0)
            {
                head = head.getNext();
            }
            else
            {
                node temp = head;
                while (currIndex != index - 1)
                {
                    temp = temp.getNext();
                    currIndex++;
                }
                temp.setNext(temp.getNext().getNext()); 
            }
        }
    }
    
    public void remove(T value)
    {
        int size = size() - 1, currIndex = 0;
        if (head != null)
        {
            if (size == 1)
            {
                if (head.getValue() == value)
                {
                    head = null;
                }
            }
            else if (head.getValue() == value)
            {
                head = head.getNext();
            }
            else
            {
                node temp = head;
                while (currIndex <= size)
                {
                    if (temp.getNext().getValue() == value)
                    {
                        temp.setNext(temp.getNext().getNext()); 
                        break;
                    }
                    temp = temp.getNext();
                    currIndex++;
                }
            }
        }
    }
    
    public void add(T value)
    {
        // Adds the value to the end of the list
        if (head == null)
        {
            head = new node(value, null);
        }
        else
        {
            node temp = head;
            while (temp.getNext() != null)
            {
                temp = temp.getNext();
            }
            temp.setNext(new node(value, null));
        }
    }
    
    public void insert(int index, T value)
    {
        int size = size() - 1, currIndex = 0;
        if (head == null && index == 0)
        {
            head = new node(value, null);
        }
        else if (index <= size && index >= 0)
        {
            node ahead = head;
            node behind = null;
            if (index == 0)
            {
                head = new node(value, ahead);
            }
            else
            {
                while (currIndex < index)
                {
                    if (currIndex + 1 == index)
                    {
                        behind = ahead;
                    }
                    ahead = ahead.getNext();
                    currIndex++;
                }
                behind.setNext(new node(value, ahead));
            }
        }
        else if (index == size + 1)
        {
            add(value);
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

class node<T> {
    
    private T value;
    private node next;

    public node(T value, node next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public node getNext() {
        return next;
    }

    public void setNext(node next) {
        this.next = next;
    }  
    
}