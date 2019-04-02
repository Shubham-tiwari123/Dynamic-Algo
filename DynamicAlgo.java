package dynamicalgo;

import java.util.LinkedList;
import java.util.List;

public class DynamicAlgo {
    
    void fibonacciNumber(int n){
        int ans[] = new int[n+1];
        ans[0]=0;
        ans[1]=1;
        for(int i=2;i<=n;i++)
            ans[i] = ans[i-1]+ans[i-2];
        System.out.println("ans:-"+ans[3]);
    }
    
    void uglyNumber(int n){
        int[] uglyNumber = new int[n];
        int i2=0,i3=0,i5=0;
        int nextMulOf_2= 2;
        int nextMulOf_3= 3;
        int nextMulOf_5= 5;
        int nextUglyno = 0;
        uglyNumber[0]=1;
        for(int i=1;i<n;i++){
            nextUglyno = Math.min(nextMulOf_2,Math.min(nextMulOf_3, nextMulOf_5));
            uglyNumber[i]=nextUglyno;
            if(nextUglyno==nextMulOf_2){
                i2=i2+1;
                nextMulOf_2 = uglyNumber[i2]*2;
            }
            if(nextUglyno==nextMulOf_3){
                i3=i3+1;
                nextMulOf_3 = uglyNumber[i3]*3;
            }
            if(nextUglyno==nextMulOf_5){
                i5=i5+1;
                nextMulOf_5 = uglyNumber[i5]*5;
            }
        }
        System.out.println("list:-"+nextUglyno);
    }
    
    void goldMineProblem(int gold[][],int m,int n){
        
        int goldTable[][] = new int[m][n];
        for(int col=n-1;col>=0;col--){
            for(int row=0;row<m;row++){
                int right = (col == n-1) ? 0 
                        : goldTable[row][col+1]; 
                int right_up = (row == 0 || 
                              col == n-1) ? 0 : 
                        goldTable[row-1][col+1];
                 int right_down = (row == m-1 
                            || col == n-1) ? 0 : 
                          goldTable[row+1][col+1]; 
                 goldTable[row][col] = gold[row][col] 
                 + Math.max(right, Math.max(right_up,  
                                       right_down)); 
            }
        }
        int res = goldTable[0][0]; 
          
        for (int i = 1; i < m; i++) 
            res = Math.max(res, goldTable[i][0]); 
              
        System.out.println("result:-"+res);
    }
    
    public static void main(String[] args) {
        DynamicAlgo algo = new DynamicAlgo();
        //algo.fibonacciNumber(3);
        //algo.uglyNumber(150);
        
        int gold[][]= { {1, 3, 1, 5}, 
                        {2, 2, 4, 1}, 
                        {5, 0, 2, 3}, 
                        {0, 6, 1, 2} }; 
                          
        int m = 4, n = 4; 
        algo.goldMineProblem(gold, m, n);
    }
    
}
