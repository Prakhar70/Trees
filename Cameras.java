public class Cameras {
    public static int cnt;
    public int minCameraCover(TreeNode root) {
        cnt = 0;
        int rc = minCameraCover_(root);
        if(rc == 0){
            cnt++;
        }
        return cnt;
    }
    private int minCameraCover_(TreeNode root) {
        if(root == null){
            return 2;
        }
        int ln = minCameraCover_(root.left);
        int rn = minCameraCover_(root.right);
        if(ln ==0 || rn == 0){
            cnt++;
            return 1;
        }
        else if(ln == 2 && rn == 2){
            return 0;
        }
        return 2;
    }
}
