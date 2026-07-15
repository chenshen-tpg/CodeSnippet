package main.Coding.Algorithms.Normal.MaximumU_1710;

import java.util.Arrays;

public class SampleAns {
    public static void main(String[] args) {

    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a, b)->Integer.compare(b[1],a[1]));
        int ans=0;
        for(int i=0; i<boxTypes.length; i++){
            if(boxTypes[i][0]<=truckSize){
                truckSize-=boxTypes[i][0];
                ans+=(boxTypes[i][0]*boxTypes[i][1]);
            }
            else if(truckSize>0&&truckSize<boxTypes[i][0]){
                ans+=(truckSize*boxTypes[i][1]);
                truckSize=0;
                break;
            }
        }
        return ans;
    }
}
