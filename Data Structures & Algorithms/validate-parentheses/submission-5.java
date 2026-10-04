class Solution {
    public boolean isValid(String s) {
        ArrayList<Character> stack = new ArrayList<>();
        Map<Character, Character> brMap = new HashMap();

        brMap.put(')', '(');
        brMap.put(']', '[');
        brMap.put('}', '{');

        for(char br : s.toCharArray()) {
            if(Set.of('(', '{', '[').contains(br)) {
                stack.add(br);
            } else if (Set.of(')', '}', ']').contains(br)) {
                if(stack.size() == 0) return false;
                if(brMap.get(br) != stack.getLast()) return false;
                stack.removeLast();
            }
        }

        if(stack.size() == 0) return true;

        return false;
}
}