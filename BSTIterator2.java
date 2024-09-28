

class BSTIterator2 {
    TreeNode curr;
    public BSTIterator2(TreeNode root) {
        this.curr=root;
    }
    
    public TreeNode morrisTraversal(TreeNode root) {
        TreeNode res=null;
        
        while (this.curr != null) {
            TreeNode ln = curr.left;
            if (ln == null) {
                res = this.curr;
                this.curr = curr.right;
                break;
            }
            while (ln.right != null && ln.right != this.curr) {
                ln = ln.right;
            }
            if (ln.right == null) {
                ln.right = this.curr;
                this.curr = this.curr.left;
            } else {
                ln.right = null;
                res = curr;
                curr = curr.right;
                break;
            }
        }
        return res;
    }

    public int next() {
       TreeNode res = morrisTraversal(curr);
       return res.val;
    }
    
    public boolean hasNext() {
        return this.curr!=null;
    }
}

