import java.util.ArrayList;

public class heap
{
    private ArrayList<Integer> list;

    public heap()
    {
        list = new ArrayList<>();
    }

    public void add(int value)
    {
	    list.add(value);
	    swapUp(list.size() - 1);
    }

   public void swapUp(int bot)
   {
       while (bot > 0)
       {
           int parent = (bot - 1) / 2;
           if (list.get(parent) < list.get(bot))
           {
               swap(parent, bot);
               bot = parent;
           }
           else
           {
               return;
           }
       }
       
   }

    public void remove( )
    {
	    list.set(0, list.get(list.size() - 1));
	    list.remove(list.size() - 1);
	    swapDown(0);
    }

    public void swapDown(int top)
    {
        while (top < list.size())
        {
            int max = 0, maxInd = 0, left = top * 2 + 1, right = top * 2 + 2;
            if (list.size() > left)
            {
                if (list.size() > right)
                {
                    max = Math.max(list.get(left), list.get(right));
                    if (max == list.get(right))
                    {
                        maxInd = right;
                    }
                    else
                    {
                        maxInd = left;
                    }
                }
                else
                {
                    max = list.get(left);
                    maxInd = left;
                }
            }
            else
            {
                return;
            }
            if (max > list.get(top))
            {
                swap(maxInd, top);
                top = maxInd;
            }
            else
            {
                return;
            }
        }

    }
	
    private void swap(int start, int finish)
    {
        list.set(finish, list.set(start, list.get(finish)));
    }

    @Override
    public String toString()
    {
    	return list.toString();
    }
}