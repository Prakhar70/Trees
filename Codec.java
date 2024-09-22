import java.util.Stack;

public class Codec {
    class Pair{
        TreeNode node;
        int ind;
        Pair(TreeNode node, int ind){
            this.node=node;
            this.ind= ind;
        }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "n";
        }
        StringBuilder str = new StringBuilder();
        String lstr = serialize(root.left);
        String rstr = serialize(root.right);
        return str.append(root.val).append(" ").append(lstr).append(" ").append(rstr).toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArr = data.trim().split(" ");
        Stack<Pair> st = new Stack<Pair>();
        if (dataArr[0].compareTo("n") == 0){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));
        st.push(new Pair(root, 0));
        for(int i=1;i<dataArr.length;i++){
            String str = dataArr[i];
            TreeNode nn=null;
            if (str.compareTo("n")!=0){
                nn = new TreeNode (Integer.parseInt(str));
            }   
            if (st.peek().ind == 0){
                st.peek().node.left=nn;
            }else if (st.peek().ind == 1){
                st.peek().node.right=nn;
            }
            st.peek().ind++;
            if(st.peek().ind==2){
                st.pop();
            }
            if(nn!=null){
                st.push(new Pair(nn, 0));
            }
        }
        return root;

    }
}