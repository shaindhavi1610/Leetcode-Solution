class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();

        boolean dp[][]=new boolean[n+1][m+1];

        dp[0][0]=true;

        for(int j=1;j<=m;j++){
            dp[0][j]=false;
        }

        for(int i=1;i<=n;i++){
            boolean flag=true;
            for(int ii=1;ii<=i;ii++){
                if(p.charAt(ii-1)!='*'){
                    flag=false;
                    break;
                }
            }
            dp[i][0]=flag;
        }


        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                char sc=s.charAt(j-1);
                char pc=p.charAt(i-1);

                if(sc==pc || pc=='?') dp[i][j]=dp[i-1][j-1];
                else if(pc=='*'){
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }
                else dp[i][j]=false;
            }
        }

        return dp[n][m];
    }
}