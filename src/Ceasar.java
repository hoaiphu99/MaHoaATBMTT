import java.util.Scanner;

public class Ceasar {
	String kq;
	public Ceasar() {
		this.kq = "";
		
	}
	
	public String encrypt(String text, int k) {
		String s = "";
		text = text.toUpperCase();
		for(int i = 0; i < text.length(); i++) {
			if(text.charAt(i) == ' ') {
				s  += ' ';
			}
			else {
				s += (char) ('A' + (text.charAt(i) - 'A' + k) % 26);
			}
		}
		kq = s;
		return kq;
	}
	
	public String decrypt(String text, int k) {
		String s = "";
		for(int i = 0; i < text.length(); i++) {
			if(text.charAt(i) == ' ') {
				s  += ' ';
			}
			else {
				s += (char) ('A' + (text.charAt(i) - 'A' + (26 - k)) % 26);
			}
			
		}
		kq = s;
		return kq;
	}
	
	public static void main(String[] args) {
		String text = "lam hoai phu";
		int k = 3;
		Ceasar s = new Ceasar();
		String rs = s.encrypt(text, k);
		System.out.println("Enc: " + rs);
		System.out.println("Dec: " + s.decrypt(rs, k));
	}
}
