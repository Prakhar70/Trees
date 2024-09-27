public class widthOfBT {
    public int widthOfTree(TreeNode root){
        int[] minMax = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        if(root == null){
            return 0;
        }
        widthOfTree(root, minMax,0);
        return (minMax[1] - minMax[0]) +1;
    }

    private void widthOfTree(TreeNode root, int[] minMax, int vl) {
        
        if(root == null){
            return ;
        }
        minMax[0]=Math.min(minMax[0], vl);
        minMax[1]=Math.max(minMax[1], vl);
        widthOfTree(root.left, minMax, vl-1);
        widthOfTree(root.right, minMax, vl+1);
    }
    
}
