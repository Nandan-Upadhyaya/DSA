class Solution {
    public String convert(String s, int numRows) {
    if(numRows == 1 || numRows >= s.length()) return s;
    StringBuilder[] rows = new StringBuilder[numRows];
    for(int i = 0 ; i<numRows ; i++){
        rows[i] = new StringBuilder();
    }
    int cyclelen = 2 * (numRows - 1);
    for(int i = 0 ; i< s.length() ; i++){
       int posInCycle = i % cyclelen;
       int row = posInCycle < numRows ? posInCycle : cyclelen - posInCycle;
       rows[row].append(s.charAt(i));
    }
    StringBuilder result = new StringBuilder();
    for(StringBuilder row : rows){
        result.append(row);
    }
    return result.toString();
        
    }
}