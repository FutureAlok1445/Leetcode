class Solution {
    public boolean isNumber(String s) {

        boolean digit = false;
        boolean dot = false;
        boolean e = false;
        boolean digitAfterE = true;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {

                digit = true;

                if (e) {
                    digitAfterE = true;
                }
            }

            else if (c == '.') {

                if (dot || e) {
                    return false;
                }

                dot = true;
            }

            else if (c == 'e' || c == 'E') {

                if (e || !digit) {
                    return false;
                }

                e = true;
                digitAfterE = false;
            }

            else if (c == '+' || c == '-') {

                if (i != 0) {
                    char previous = s.charAt(i - 1);

                    if (previous != 'e' && previous != 'E') {
                        return false;
                    }
                }
            }

            else {
                return false;
            }
        }

        if (!digit) {
            return false;
        }

        if (!digitAfterE) {
            return false;
        }

        return true;
    }
}