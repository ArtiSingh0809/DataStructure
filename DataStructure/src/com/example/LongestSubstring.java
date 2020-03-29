class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int initial = 0 , result = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(charMap.containsKey(c))
                if(charMap.get(c) >= initial)
                    initial = charMap.get(c) + 1;
            
            result = Math.max(result, i-initial+1);
            charMap.put(c,i);
        }
        
        return result;
    }
}
