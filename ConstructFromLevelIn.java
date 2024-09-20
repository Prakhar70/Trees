import java.util.HashSet;

class ConstructFromInLevelIn{
    TreeNode buildTree(int inord[], int level[])
    {
        return buildTree(inord,0, inord.length-1, level);
    }
    public TreeNode buildTree(int[] inOrder, int isi, int iei, int[] levelOrder){
        if(isi>iei){
            return null;
        }
        TreeNode root = new TreeNode(levelOrder[0]);
        int i=isi;
        for(; i<= iei ;i++){
            if(inOrder[i]==root.val){
                break;
            }
        }
        int lenOfLeftTree  = i-isi;
        int lenOfRightTree = iei-i;
        HashSet<Integer> set = new HashSet<>();
        for (int j=isi; j<i;j++){
            set.add(inOrder[j]);
        }
        int[] leftLevelOrder = new int[lenOfLeftTree];
        int[] rightLevelOrder = new int[lenOfRightTree];
        int l=0,r=0;
        for(int j=1;j<levelOrder.length;j++){
            if(set.contains(levelOrder[j])){
                leftLevelOrder[l++] = levelOrder[j];
            }else{
                rightLevelOrder[r++] = levelOrder[j];
            }
        }
        root.left = buildTree(inOrder, isi, i-1, leftLevelOrder);
        root.right = buildTree(inOrder, i+1, iei, rightLevelOrder);

        return root;
    }
    
}