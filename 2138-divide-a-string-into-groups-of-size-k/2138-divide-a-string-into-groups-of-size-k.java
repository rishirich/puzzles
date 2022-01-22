class Solution {
    public String[] divideString(String s, int k, char fill) {
        String[] substrings = new String[s.length()/k + (s.length()%k != 0? 1:0)];
        
        while(s.length()%k != 0)
            s += fill;
        
        for(int i=0;i<substrings.length;i++)
            substrings[i] = s.substring(i*k,(i+1)*k);
                
        return substrings;
    }
}