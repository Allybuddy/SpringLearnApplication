package com.example.springLearn.Practice.LeetCode;

public class BestTimeToBuyAndSellStock {

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        int minNo = prices[0];
        int minIndex = 0;

        for(int i = 0; i< length; i++){
            if(prices[i] < minNo){
                minNo = prices[i];
                minIndex = i;
            }
        }
        int maxNo = minNo;
        int maxIndex = minIndex;
        for(int j = minIndex; j< length; j++){
            if(maxNo < prices[j]){
                maxNo = prices[j];
                maxIndex = j;
            }
        }
        return maxNo - minNo;
    }
    public static void main(String[] args) {
        
        int[] prices = {7,1,5,3,6,4};
        var res = maxProfit(prices);
        System.out.println(res);
    }
}
