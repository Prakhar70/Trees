import java.util.Stack;

class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        this.st=new Stack<>();
        TreeNode curr = root;
        while(curr!=null){
            this.st.push(curr);
            curr=curr.left;
        }
    }
    
    public int next() {
        TreeNode rNode = this.st.pop();
        TreeNode curr = rNode.right;
        while(curr!=null){
            this.st.push(curr);
            curr=curr.left;
        }
        return rNode.val;
    }
    
    public boolean hasNext() {
        return !this.st.isEmpty();
    }
}

