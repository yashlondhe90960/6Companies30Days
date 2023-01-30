class Solution {
        public int getLastMoment(int n, int[] left, int[] right) {
                int l = 0, r = 0;
                for (int i : left)
                        l = Math.max(l, i);
                for (int i : right)
                        r = Math.max(r, n - i);
                return Math.max(l, r);

        }
}