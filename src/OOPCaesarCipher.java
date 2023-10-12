public class OOPCaesarCipher {
    //  alphabet and shifterAlphabet are fields
    private static String alphabet;
    private static String shiftedAlphabet;

    // This is constructor, a code that gets run to initialize an object when it gets created using new
    // Constructor has same name as the class it's contained in
    // Constructor has no return types, not even void
    // Don't call constructor directly, instead call as part of creating an object with new keyword
    // If no constructor is written, the compiler will write it automatically with no arguments and no body, such as public CaesarCipher() { }
    public OOPCaesarCipher(int key) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
    }

    public static void encrypt(String input) {
        StringBuilder sb = new StringBuilder(input);
        for(int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            int indx = alphabet.indexOf(c);

            if(indx != -1) {
                c = shiftedAlphabet.charAt(indx);
                sb.setCharAt(i, c);
            }
        }
    }

    public static void main(String[] args){
        OOPCaesarCipher cc = new OOPCaesarCipher(20);
        // System.out.println(cc.alphabet);
    }
}
