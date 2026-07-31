class Solution {
    List<String> r = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        f("", 0, 0, n);
        return r;
    }
    void f(String s, int o, int c, int n) {
        if (s.length() == 2 * n) { r.add(s); return; }
        if (o < n) f(s + "(", o + 1, c, n);
        if (c < o) f(s + ")", o, c + 1, n);
    }
}
