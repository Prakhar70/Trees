public class UniqueBT {
    public int numTrees(int n) {
        if(n==0 || n==1){
            return 1;
        }
        int ans =0;
        for(int i=0;i<Math.ceil((n-1)/2.0);i++){
            ans+=numTrees(i)*numTrees(n-1-i);
        }
        ans=ans*2;
        
        if((n-1)%2==0){
            int t=numTrees((n-1)/2);
            ans+=(t*t);
        }
        return ans;
    }
}
