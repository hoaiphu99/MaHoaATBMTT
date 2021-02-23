import java.util.Random;
import java.util.Scanner;

import javax.crypto.Cipher;

public class MonoalphabeticCipher {
    public char p[]  = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z' };
    public char ch[] = { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
            'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C',
            'V', 'B', 'N', 'M' };
    public String key = "";
    public String CipherText;
    public MonoalphabeticCipher() {
    	this.key = "";
    	this.CipherText = "";
    }
    public void RandomKey() {
    	Random rd = new Random();
    	int A[] = new int[26];
    	for(int i = 0; i < A.length; i++) {
    		A[i] = i + 65;
    	}
    	char c;
    	for(int i = 65; i <= 90; i++) {
    		int temp = rd.nextInt((90 - i) + 1) + i;
    		int t = A[i - 65];
    		A[i - 65] = A[temp - 65];
    		A[temp - 65] = t;
    	}
    	for(int i = 0; i < A.length; i++) {
    		c = (char)A[i];
    		key += c;
    	}
    	
    }
    public String doEncryption(String s)
    {
        char c[] = new char[(s.length())];
        for (int i = 0; i < s.length(); i++)
        {
        	if(s.charAt(i) == ' ')
        		//c[i] += ' ';
        		CipherText += " ";
            for (int j = 0; j < 26; j++)
            {
                if (p[j] == s.charAt(i))
                {
                    c[i] += key.charAt(j) - 65;
                    break;
                }
            }
        }
        return (new String(c));
    }

    public String doDecryption(String s)
    {
        char p1[] = new char[(s.length())];
        for (int i = 0; i < s.length(); i++)
        {
        	if(s.charAt(i) == ' ')
        		p1[i] += ' ';
            for (int j = 0; j < 26; j++)
            {
                if (ch[j] == s.charAt(i))
                {
                    p1[i] = p[j];
                    break;
                }
            }
        }
        return (new String(p1));
    }
    public static void main(String[] args) {
	// write your code here
    	MonoalphabeticCipher mn = new MonoalphabeticCipher();
    	mn.RandomKey();
    	System.out.println(mn.key);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the message: ");
        String en = doEncryption(sc.nextLine().toLowerCase());
        System.out.println("Encrypted message: " + en);
        //System.out.println("Decrypted message: " + doDecryption(en));
        sc.close();
    }
}
