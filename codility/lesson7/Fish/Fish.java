package com.codility.lesson7.Fish;

import java.util.Stack;

/**
 * Created by alterG on 04.05.2017.
 */
public class Fish {
    public static void main(String[] args) {
        int[] A = {4, 3, 2, 1, 5};
        int[] B = {0, 1, 0, 0, 0};
        Fish a = new Fish();
        System.out.println(a.solution(A, B));
    }
    public int solution(int[] A, int[] B) {

        class FishC {
            int dir;

            public int getDir() {
                return dir;
            }

            public int getSize() {
                return size;
            }

            int size;

            public FishC(int dir, int size) {
                this.dir=dir;
                this.size=size;
            }
        }
        if (A.length == 0) return 0;
        Stack<FishC> stream = new Stack<>();
        stream.push(new FishC(B[0], A[0]));
        for (int i = 1; i < A.length; i++) {
            FishC cur = new FishC(B[i], A[i]);
            if (cur.getDir() == 0 && stream.peek().getDir() == 1) {
                FishC last = stream.pop();
                if (cur.getSize()>last.getSize()) {
                    if (!stream.isEmpty()) i--;
                    else stream.push(cur);
                }
                else {
                    stream.push(last);
                }
            }
            else {
                stream.push(cur);
            }
        }
        return stream.size();
    }
}
