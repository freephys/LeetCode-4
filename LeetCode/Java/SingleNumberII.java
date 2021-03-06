public class SingleNumberII {
    public int singleNumber(int[] A) {
        HashMap<Integer, Integer> single = new HashMap<Integer, Integer>();
        for (int item:A) {
            if (single.containsKey(item)) {
                single.put(item, single.get(item)+1);
            } else {
                single.put(item, 1);
            }
        }
        Iterator it = single.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            if (!pairs.getValue().equals(3)) {
                return (Integer)pairs.getKey();
            }
        }
        return 0;
    }

    // Bit manipulation
    public int singleNumberII(int[] nums) {
        int res = 0;
        int k = 0;
        while (k < 32) {
            int temp = 0;
            for (int i = 0; i < nums.length; i++) {
                temp += ((nums[i] >> k) & 1);
            }
            if (temp % 3 != 0) {
                res = res | 1 << k;
            }
            k++;
        }
        return res;
    }
}
