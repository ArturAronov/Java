// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static String cesarCypher(int shiftKey, String input) {
        StringBuilder encrypted = new StringBuilder();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(shiftKey) + alphabet.substring(0, shiftKey);

        for(int i = 0; i < input.length(); i++){
            char ch = input.toUpperCase().charAt(i);
            int idx = alphabet.indexOf(ch);
            if(idx >= 0) {
                char newChar = shiftedAlphabet.charAt(idx);
                encrypted.append(newChar);
            } else {
                encrypted.append(ch);
            }
        }

        return encrypted.toString();
    }

    private static String multiKeyCesarCypher(int key1, int key2, String input) {
        StringBuilder encrypted = new StringBuilder();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        String shiftedAlphabet2 = shiftedAlphabet1.substring(key2) + shiftedAlphabet1.substring(0, key2);

        for(int i = 0; i < input.length(); i++){
            char ch = input.toUpperCase().charAt(i);
            int idx = alphabet.indexOf(ch);
            if(idx >= 0) {
                char newChar = shiftedAlphabet2.charAt(idx);
                encrypted.append(newChar);
            } else {
                encrypted.append(ch);
            }
        }

        return encrypted.toString();
    }
    private static void digitTest() {
        String test = "ABCabc0123456789';#!";
        for(int i = 0; i < test.length(); i++) {
            char ch = test.charAt(i);
            if(Character.isDigit(ch)) {
                System.out.println(ch + " is a digit");
            }

            if(Character.isAlphabetic(ch)){
                System.out.println(ch + " is alphabetic");
            }

            if(ch == '#') {
                System.out.println(ch + " is #hastag");
            }
        }
    }
    public static void main(String[] args) {
        String decrypted = multiKeyCesarCypher(8, 21, "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!");
        System.out.println(decrypted.toLowerCase());
    }
}