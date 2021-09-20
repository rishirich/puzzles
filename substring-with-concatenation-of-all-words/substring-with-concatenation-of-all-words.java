class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> matchingSubstringIndices = new ArrayList();
        List<String> originalKeyList = Arrays.asList(words);
        Map<String, Integer> stringOccurrences = new HashMap();
        int lengthOfSubstring = originalKeyList.get(0).length() * words.length;
        int wordLength = words[0].length();
        int start = 0;    
        int end = wordLength - 1;
        
        for(int j = 0 ; j<words.length;j++) {
            int freq = 1;
            if(stringOccurrences.containsKey(words[j]))
                freq = stringOccurrences.get(words[j]) + 1;
            stringOccurrences.put(words[j], freq);
        }
            
        int index = 0;
        Map<String,Integer> tempMap = new HashMap(stringOccurrences);
       
        while(end<s.length() && start <= s.length() - lengthOfSubstring) {
            String substring = s.substring(end-wordLength+1, end+1);
            if(tempMap.containsKey(substring)) {
                if (tempMap.get(substring) > 1)
                    tempMap.put(substring, tempMap.get(substring)-1);
                else
                    tempMap.remove(substring);
                end = end + wordLength;
            } else {
                if(!stringOccurrences.containsKey(substring)) 
                    start = start+1;//end+1;
                else
                    start = start +1;//start + wordLength;
                tempMap = new HashMap(stringOccurrences);
                end = start+wordLength-1;
                index = start;
            }
            
            if(tempMap.isEmpty()) {
                matchingSubstringIndices.add(index);
                tempMap = new HashMap(stringOccurrences);
                start = index+1;//index + wordLength;
                index = start;
                end = start + wordLength - 1;
            }
        }
        
        return matchingSubstringIndices;
    }
}