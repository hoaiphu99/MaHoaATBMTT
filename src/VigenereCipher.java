
public class VigenereCipher {
	private String key;
	
    public VigenereCipher() {
		super();
		this.key = "VIGENERECIPHER";
		// TODO Auto-generated constructor stub
	}
    
    public VigenereCipher(String key) {
		super();
		this.key = key;
		// TODO Auto-generated constructor stub
	}

	public String encrypt(String text)
    {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }

    public String decrypt(String text)
    {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }

    public static void main(String[] args) {
	// write your code here
    	VigenereCipher vc = new VigenereCipher();
        String message = "Hey Thang, you are very handsome bro";
        String encryptedMsg = vc.encrypt(message);
        System.out.println("String: " + message);
        System.out.println("Encrypted message: " + encryptedMsg);
        System.out.println("Decrypted message: " + vc.decrypt(encryptedMsg));
    }
}
