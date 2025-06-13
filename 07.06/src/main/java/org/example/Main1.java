package org.example;
import java.util.Arrays;
public class Main1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(minThree(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
    }

    public static int[] minThree(int[] a, int t) {
        Arrays.sort(a);
        int n = a.length;
        int s = a[0] + a[1] + a[2];
        int[] r = new int[]{a[0], a[1], a[2]};

        for (int i = 0; i < n - 2; ++i) {
            int l = i + 1;
            int h = n - 1;

            while (l < h) {
                int c = a[i] + a[l] + a[h];

                if (Math.abs(c - t) < Math.abs(s - t)) {
                    s = c;
                    r = new int[]{a[i], a[l], a[h]};
                }

                if (c < t) {
                    l++;
                } else if (c > t) {
                    h--;
                } else {
                    return r;
                }
            }
        }
        return r;
    }
}
