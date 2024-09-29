public class Diameter {
    class Pair{
        int height;
        int longestDiameter;
        Pair(int height, int longestDiameter){
            this.height=height;
            this.longestDiameter=longestDiameter;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return diameterOfBinaryTree_(root).longestDiameter;
    }
    public Pair diameterOfBinaryTree_(TreeNode root) {
        if(root == null){
            return new Pair(-1, 0);
        }
        if(root.left == null && root.right == null){
            return new Pair(0, 0);
        }
        Pair lans = diameterOfBinaryTree_(root.left);
        Pair rans = diameterOfBinaryTree_(root.right);
        return new Pair
        (
            Math.max(lans.height, rans.height)+1,
            Math.max(Math.max(lans.longestDiameter, rans.longestDiameter),lans.height+rans.height+2)
        );
    }
}
