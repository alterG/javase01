package com.codility.lesson5.GenomicRangeQuery;

/**
 * Created by alterG on 02.05.2017.
 */
public class GenomicRangeQuery {
    public int[] solution(String S, int[] P, int[] Q) {
        class Genom {
            private int A;
            private int C;
            private int G;
            private int T;

            public Genom(int a, int c, int g, int t) {
                A = a;
                C = c;
                G = g;
                T = t;
            }
            public Genom() {}
            public Genom diffFrom(Genom genom) {
                Genom result = new Genom();
                result.A=this.A-genom.A;
                result.C=this.C-genom.C;
                result.G=this.G-genom.G;
                result.T=this.T-genom.T;
                return result;
            }
            public int getImpactOfDiff() {
                int result = 0;
                if (this.A != 0) result = 1;
                else if (this.C != 0) result = 2;
                else if (this.G != 0) result = 3;
                else if (this.T != 0) result = 4;
                return  result;
            }
            public int getImpactByLetter(char letter) {
                switch (letter) {
                    case 'A':
                        return 1;
                    case 'C':
                        return 2;
                    case 'G':
                        return 3;
                    case 'T':
                        return 4;
                }
                return -1;
            }

        }
        Genom[] prefixGenomSum = new Genom[S.length()];
        int A = 0;
        int C = 0;
        int G = 0;
        int T = 0;
        for (int i = 0; i < S.length(); i++) {
            switch (S.charAt(i)) {
                case 'A':
                    A++;
                    break;
                case 'C':
                    C++;
                    break;
                case 'G':
                    G++;
                    break;
                case 'T':
                    T++;
                    break;
            }
            Genom current  = new Genom(A, C, G, T);
            prefixGenomSum[i] = current;
        }
        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            if (P[i] == Q[i]){
                result[i] = prefixGenomSum[0].getImpactByLetter(S.charAt(P[i]));
            } else if (P[i] == 0) {
                Genom diff = prefixGenomSum[Q[i]];
                result[i] = diff.getImpactOfDiff();

            } else {
                Genom diff = prefixGenomSum[Q[i]].diffFrom(prefixGenomSum[P[i]-1]);
                result[i] = diff.getImpactOfDiff();
            }
        }
        return result;
    }
}
