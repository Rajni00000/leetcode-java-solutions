
import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int index,
                           List<String> parts,
                           List<String> result) {

        // We need exactly 4 parts
        if (parts.size() == 4) {
            if (index == s.length()) {
                result.add(String.join(".", parts));
            }
            return;
        }

        // Try segments of length 1, 2, and 3
        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) {
                break;
            }

            String part = s.substring(index, index + len);

            // No leading zeros
            if (part.length() > 1 && part.charAt(0) == '0') {
                break;
            }

            // Segment must be between 0 and 255
            int num = Integer.parseInt(part);
            if (num > 255) {
                break;
            }

            parts.add(part);

            backtrack(s, index + len, parts, result);

            // Backtrack: remove the last segment
            parts.remove(parts.size() - 1);
        }
    }
}
