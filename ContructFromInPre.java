public class ContructFromInPre {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0 , preorder.length-1, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int psi, int pei, int isi, int iei) {
        if(psi>pei){
            return null;
        }
        TreeNode root = new TreeNode(preorder[psi]);
        int i=0;
        for(i=isi; i<=iei; i++){
            if(inorder[i]==root.val){
                break;
            }
        }
        root.left = buildTree(preorder, inorder, psi+1, psi+(i-isi), isi, i-1);
        root.right = buildTree(preorder, inorder, psi+(i-isi)+1, pei, i+1, iei);
        return root;
    }
}
