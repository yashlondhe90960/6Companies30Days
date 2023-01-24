public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), s, 0, 0);
        return res;
    }

    private void dfs(List<String> res, StringBuilder temp, String s, int start, int count) {
        if (count == 4) {
            if (start == s.length()) {
                res.add(temp.toString());
            }
            return;
        }
        for (int i = start; i < s.length() && i < start + 3; i++) {
            String segment = s.substring(start, i + 1);
            if (isValid(segment)) {
                int len = temp.length();
                if (count > 0) {
                    temp.append(".");
                }
                temp.append(segment);
                dfs(res, temp, s, i + 1, count + 1);
                temp.setLength(len);
            }
        }
    }

    private boolean isValid(String segment) {
        if (segment.length() == 0 || segment.length() > 3 || (segment.charAt(0) == '0' && segment.length() > 1) || Integer.parseInt(segment) > 255) {
            return false;
        }
        return true;
    }
}