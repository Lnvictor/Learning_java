/*
 * @author: Victor Pereira
 *
 * Implementation of the "ZigZagCOnversion" Problem solution
 * Exercise Link: leetcode.com/problems/zigzag-conversion/
 *
 * version : 1.1
*/

class ZigZagConversion {

    public String convert(String origin_str, int num_rows) {
        String converted_string = "";
        int interval = ((num_rows - 1) * 2);

        for (int i = 0; i < num_rows; i++) {
            int current_pos = i;

            while (current_pos < origin_str.length()) {
                converted_string = converted_string.concat(origin_str.substring(current_pos, current_pos + 1));

                if (i > 0 && i < (num_rows - 1)) {
                    int next_pos = ((num_rows - i - 2) * 2 + 2);
                    current_pos += next_pos;

                    if (current_pos < origin_str.length()) {
                        converted_string += origin_str.substring(current_pos, current_pos + 1);
                        current_pos += (interval - next_pos);
                        next_pos = interval - next_pos;
                    }

                } else {
                    current_pos += interval;
                }

            }
        }

        return converted_string;
    }

    public static void main(final String[] args) {
        ZigZagConversion C = new ZigZagConversion();
        System.out.println(C.convert("ALMANAQUE", 3));
    }
}
