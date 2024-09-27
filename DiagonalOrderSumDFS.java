import java.util.ArrayList;

class DiagonalOrderSumDFS {
    public static ArrayList <Integer> diagonalSum(Node root) 
    {   
        ArrayList<Integer> ans=new ArrayList<>();
        diagonalSum(root, ans, 0);
        return ans;
    }

    private static void diagonalSum(Node root, ArrayList<Integer> ans, int dn) {
        if(root==null){
            return;
        }
        if(dn==ans.size()){
            ans.add(0);
        }
        ans.set(dn, ans.get(dn)+root.data);
        diagonalSum(root.left, ans, dn+1);
        diagonalSum(root.right, ans, dn);

    }
}