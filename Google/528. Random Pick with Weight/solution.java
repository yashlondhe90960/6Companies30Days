class Solution {
    TreeMap<Double, Integer> buckets = new TreeMap<>();

    public Solution(int[] w) {
        int total = 0;

        for (int n : w) {
            total += n;
        }

        double slot = 0;

        for (int i=0; i < w.length; i++) {
            slot += calc(w[i], total);

            buckets.put(slot, i);
        }
    }

    private double calc(double number, double total) {
        return (number / total) * 100.0;
    }
    
    public int pickIndex() {
        double index = new Random().nextDouble(100);

        double nearestKey = buckets.ceilingKey(index);

        return buckets.get(nearestKey);
    }
}