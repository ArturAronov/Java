package Earthquake;

public class PhraseFilter implements Filter {
    private final String where;
    private final String phrase;

    public PhraseFilter(String s, String s2) {
        where = s;
        phrase = s2;
    }

    public boolean satisfies(QuakeEntry qe) {
        String title = qe.getInfo();
        if (where.equals("start") && title.startsWith(phrase)) {
            return true;
        } else if (where.equals("end") && title.endsWith(phrase)) {
            return true;
        } else if (where.equals("any") && title.contains(phrase)) {
            return true;
        } else {
            return false;
        }
    }
}