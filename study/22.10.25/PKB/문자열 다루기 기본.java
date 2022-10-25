class Solution {

    public boolean solution(String s) {

        int l = s.length();

        if (l != 4 && l != 6) return false;

        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);

            if (c < '0' || c > '9') return false;
        }

        return true;

    }

}
