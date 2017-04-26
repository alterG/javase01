package com.codility.lesson1;
/**
 * Created by alterG on 26.04.2017.
 */
class Solution {

    public static void main(String[] args) {
        Solution a = new Solution();
        System.out.println("(94) 3 = "+a.solution(94));
        System.out.println("(65) 5 = "+a.solution(65));
        System.out.println("(40) 2 = "+a.solution(40));
        System.out.println("(32) 5 = "+a.solution(32));
    }

    public int solution(int N) {
        int mask = 0x80000000;
        int maxIntBits = 32;
        int moves=0;
        // get first meaning bit
        while (((N&mask) == 0) && (maxIntBits > 0)) {
            N<<=1;
            moves++;
        }
        int maxZeroBits = 0;
        int currentZeroBits = 0;
        int bitsLeft = maxIntBits-moves;
        while (--bitsLeft > 0) {
            N<<=1;
            if ( (N&mask) == 0 )  {
                currentZeroBits++;
            }
            else {
                if (currentZeroBits > maxZeroBits) maxZeroBits = currentZeroBits;
                currentZeroBits = 0;
            }
        }
        if (currentZeroBits > maxZeroBits) maxZeroBits = currentZeroBits;
        return maxZeroBits;
    }
}

