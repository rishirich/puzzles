class Solution {
    public String[] divideString(String s, int k, char fill) {
        String[] substrings = new String[s.length()/k + (s.length()%k != 0? 1:0)];
        
        StringBuilder strBuilder = new StringBuilder(s);
        while(strBuilder.length()%k != 0)
            strBuilder.append(fill);
        for(int i=0;i<substrings.length;i++)
            substrings[i] = strBuilder.substring(i*k,(i+1)*k);
                
        return substrings;
    }
}