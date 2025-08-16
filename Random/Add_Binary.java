import java.math.BigInteger;
class Solution {

    // Bad solution
    public String addBinary(String a, String b) {
       BigInteger num1 = new BigInteger(a, 2);
       BigInteger num2 = new BigInteger(b, 2);
       BigInteger sum = num1.add(num2);
       return sum.toString(2);
    }

    // Good Solution
    public String addBinaryOptimized(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while( i>= 0 || j >= 0 || carry == 1){
            if(i >= 0) {
                carry += a.charAt(i) - '0';
                i--;
            }

            if(j >= 0) {
                carry += b.charAt(j) - '0';
                j--;
            }
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();

    
}

}

