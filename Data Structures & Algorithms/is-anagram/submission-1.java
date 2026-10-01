class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() == t.length() && s.length() == 0)
            return true;

        if(s.length() != t.length())
            return false;

        HashMap<Character, Integer> freqs = new HashMap<>();
        HashMap<Character, Integer> freqt = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            freqs.putIfAbsent(s.charAt(i), 1);

            if (freqs.containsKey(s.charAt(i))) {
                
                freqs.put(s.charAt(i), freqs.get(s.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {

            freqt.putIfAbsent(t.charAt(i), 1);

            if (freqt.containsKey(t.charAt(i))) {
                
                freqt.put(t.charAt(i), freqt.get(t.charAt(i)) + 1);
            }
        }

        for (char key : freqs.keySet()) {
            
            if(freqs.get(key) != freqt.get(key))
                return false;
        }

        return true;
    }
}
