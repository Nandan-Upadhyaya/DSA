import java.math.BigInteger;
class Solution {
    public String multiply(String num1, String num2) {
        BigInteger firstNumber = new BigInteger(num1);
        BigInteger secondNumber = new BigInteger(num2);
        BigInteger result = firstNumber.multiply(secondNumber);
        return result.toString();
    }
}