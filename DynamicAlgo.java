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
    
    public static void main(String[] args) {
        DynamicAlgo algo = new DynamicAlgo();
        //algo.fibonacciNumber(3);
        algo.uglyNumber(150);
    }
    
}
