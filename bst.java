public class bst {

    private node root;

    public bst()
    {
        this.root = null;
    }

    public void add(int value)
    {
        root = add(value, root);
    }

    private node add(int value, node tree)
    {
        if (tree == null)
        {
            return new node(value, null, null);
        }

        if (value < tree.getValue())
        {
            tree.setLeft(add(value, tree.getLeft()));
        }
        else
        {
            tree.setRight(add(value, tree.getRight()));
        }
        return tree;
    }

    public int getNumLeaves()
    {
        return getNumLeaves(root);
    }

    private int getNumLeaves(node tree)
    {
        if (tree == null)
        {
            return 0;
        }
        else if (tree.getLeft() == null && tree.getRight() == null)
        {
            return 1;
        }
        else
        {
            return getNumLeaves(tree.getLeft()) + getNumLeaves(tree.getRight());
        }
    }

    public int getNumLevels()
    {
        return getNumLevels(root);
    }
    
    private int getNumLevels(node tree)
    {
        if (tree == null)
        {
            return 0;
        }
        else
        {
            int numLeft = getNumLevels(tree.getLeft());
            int numRight = getNumLevels(tree.getRight());
            
            if (numLeft > numRight)
            {
                return numLeft + 1;
            }
            else
            {
                return numRight + 1;
            }
        }
    }

    public int getHeight()
    {
        return getNumLevels() - 1;
    }
    
    public int getNumNodes()
    {
        return getNumNodes(root);
    }

    private int getNumNodes(node tree)
    {
        if (tree == null)
        {
            return 0;
        }
        else
        {
            return 1 + getNumNodes(tree.getLeft()) + getNumNodes(tree.getRight());
        }
    }

    public boolean isFull()
    {
        return isFull(root);
    }
    
    private boolean isFull(node tree)
    {
        return getNumNodes(tree) == Math.pow(2, getNumLevels(tree)) - 1;
    }
    
    public boolean isComplete()
    {
        return isComplete(root);
    }
    
    public boolean isComplete(node tree)
    {
        if(getNumNodes() == Math.pow(2, getNumLevels()) - 1)
        {
            return true;
        }
        else
        {
            if (tree != null)
            {
                if (getNumNodes(tree.getRight()) > 1 && !isFull(tree.getLeft()))
                {
                    return false;
                }
                if (tree.getLeft() == null && tree.getRight() != null)
                {
                    return false;
                }
                return isComplete(tree.getLeft()) && isComplete(tree.getRight()); 
            }
            else
            {
                return true;
            }
        }
    }

    public String inOrder()
    {
        return inOrder(root);
    }
    
    private String inOrder(node tree)
    {
        if (tree != null)
        {
            return inOrder(tree.getLeft()) + tree.getValue() + " " + inOrder(tree.getRight());
        }
        return "";
    }
    
    public String preOrder()
    {
        return preOrder(root);
    }
    
    private String preOrder(node tree)
    {
        if (tree != null)
        {
            return tree.getValue() + " " + preOrder(tree.getLeft()) + preOrder(tree.getRight());
        }
        return "";
    }
    
    public String postOrder()
    {
        return postOrder(root);
    }
    
    private String postOrder(node tree)
    {
        if (tree != null)
        {
            return postOrder(tree.getLeft()) + postOrder(tree.getRight()) + tree.getValue() + " ";
        }
        return "";
    }

    public String toString() {
        return "IN ORDER\n" + inOrder() + "\n\nPRE ORDER\n" + preOrder() + "\n\nPOST ORDER\n" + postOrder();
        
    }
    
}

class node {

    private int value;
    private node left;
    private node right;

    public node(int value, node left, node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public node getLeft() {
        return left;
    }

    public void setLeft(node left) {
        this.left = left;
    }

    public node getRight() {
        return right;
    }

    public void setRight(node right) {
        this.right = right;
    }
}