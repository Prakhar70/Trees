class RecoverBST {
    public void recoverTree(TreeNode root) {
        
        TreeNode prev = null;
        TreeNode fn = null;
        TreeNode sn = null;
        TreeNode curr = root;
        while (curr != null) {
            TreeNode ln = curr.left;
            if (ln == null) {
                
                if (prev != null && prev.val > curr.val){
                    if(fn == null){
                        fn = prev;
                        sn = curr;
                    }else{
                        sn = curr;
                    }
                }
                
                prev = curr;
                curr = curr.right;
                continue;
            }
            while (ln.right != null && ln.right != curr) {
                ln = ln.right;
            }
            if (ln.right == null) {
                ln.right = curr;
                curr = curr.left;
            } else {
                ln.right = null;
                
                if (prev != null && prev.val > curr.val){
                    if(fn == null){
                        fn = prev;
                        sn = curr;
                    }else{
                        sn = curr;
                    }
                }
                prev = curr;
                curr = curr.right;
            }
        }
        int temp = fn.val;
        fn.val = sn.val;
        sn.val = temp;
    }
}