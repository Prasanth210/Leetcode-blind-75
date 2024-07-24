
//using DP -> tabulation
public class Climbing_Stairs {
        public static int climbStairs(int n) {
            if(n == 0 || n == 1){
                return 1;
            }
            int [] tab=new int[n+1];
            tab[0]=1;
            tab[1]=1;
            for(int i=2;i<=n;i++){
                tab[i]=tab[i-1]+tab[i-2];
            }
            return tab[n];
        }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
