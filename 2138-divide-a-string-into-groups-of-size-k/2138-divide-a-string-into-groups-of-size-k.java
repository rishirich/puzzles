class Solution {
    public String[] divideString(String s, int k, char fill) {
        String[] substrings = new String[s.length()/k + (s.length()%k != 0? 1:0)];
        for(int i=0;i<substrings.length;i++)
            substrings[i] = s.substring(i*k,Math.min(s.length(),(i+1)*k));
        if(substrings[substrings.length-1].length() < k)
            while(substrings[substrings.length-1].length() != k)
                substrings[substrings.length-1] += String.valueOf(fill);
        return substrings;
    }
}