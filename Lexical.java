import java.util.*;

public class Lexical {
	public static void Ellenorzes(int sor) {
		if(sor == 2) {
			System.out.print("<azonosító>");
		}
		if(sor == 4) {
			System.out.print("<szám>");
		}
		if(sor == 6) {
			System.out.print("<{} kommentár>");
		}
		if(sor == 10) {
			System.out.print("<(**) kommentár>");
		}
		if(sor == 12) {
			System.out.print("<:= értékadás>");
		}
		if(sor == 14) {
			System.out.print("<<= jel>");
		}
		if(sor == 15) {
			System.out.print("<<> jel>");
		}
		if(sor == 17) {
			System.out.print("<>= jel>");
		}
		if(sor == 18) {
			System.out.print("<hiba>");
		}
	}
	
	public static int VisszaKezdő(int sor) {
		if(sor == 2 || sor == 4 || sor == 6 || sor == 10 || sor == 12 || sor == 14 || sor == 15 || sor == 17 || sor == 18) {
			sor = 0;
		}
		return sor;
	}

	public static void main(String[] args) {
		// declaration
		Scanner sc = new Scanner(System.in);
		String word = "";
		int sor = 0;
		int oszlop = 0;
		boolean van = false;
		String szavak = "aábcdeéfghiíjkljmnopqrstuúüűvwxyz";
		String szamok = "0123456789";
		
		// table
		int table[][] = {
				{1,3,5,18,7,18,18,11,18,13,16,0,18,20},
				{1,1,2,2,2,2,2,2,2,2,2,2,2,2},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{4,3,4,4,4,4,4,4,4,4,4,4,4,4},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{5,5,5,6,5,5,5,5,5,5,5,5,5,18},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{19,19,19,19,19,8,19,19,19,19,19,19,19,18},
				{8,8,8,8,8,9,8,8,8,8,8,8,8,8},
				{8,8,8,8,8,9,10,8,8,8,8,8,8,18},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{19,19,19,19,19,19,19,19,12,19,19,19,19,18},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{19,19,19,19,19,19,19,19,14,19,19,19,19,18},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{19,19,19,19,19,19,19,19,17,19,19,19,19,18},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0}
		};
		
		
		System.out.println("Írja be a szót, amit elemezni szeretne: ");
		word = sc.nextLine();
		System.out.println(word);
		
		for(int i = 0; i < word.length(); i++) {
			// az adott elem betű-e?
			for(int j = 0; j < szavak.length(); j++) {
				if(word.charAt(i) == szavak.charAt(j)) {
					van = true;
					oszlop = 0;
					sor = table[sor][oszlop];
					break;
				}
			}
			
			// az adott elem szám-e? 
			for(int j = 0; j < szamok.length(); j++) {
				if(word.charAt(i) == szamok.charAt(j)) {
					van = true;
					oszlop = 1;
					sor = table[sor][oszlop];
					break;
				}
			}
			
			// {
			if(word.charAt(i) == '{') {
				van = true;
				oszlop = 2;
				sor = table[sor][oszlop];
			}
			
			// }
			if(word.charAt(i) == '}') {
				van = true;
				oszlop = 3;
				sor = table[sor][oszlop];
			}
			
			// (
			if(word.charAt(i) == '(') {
				van = true;
				oszlop = 4;
				sor = table[sor][oszlop];
			}
			
			// *
			if(word.charAt(i) == '*') {
				van = true;
				oszlop = 5;
				sor = table[sor][oszlop];
			}
			
			// )
			if(word.charAt(i) == ')') {
				van = true;
				oszlop = 6;
				sor = table[sor][oszlop];
			}
			
			// :
			if(word.charAt(i) == ':') {
				van = true;
				oszlop = 7;
				sor = table[sor][oszlop];
			}
			
			// =
			if(word.charAt(i) == '=') {
				van = true;
				oszlop = 8;
				sor = table[sor][oszlop];
			}
			
			// <
			if(word.charAt(i) == '<') {
				van = true;
				oszlop = 9;
				sor = table[sor][oszlop];
			}
			
			// >
			if(word.charAt(i) == '>') {
				van = true;
				oszlop = 10;
				sor = table[sor][oszlop];
			}
			
			// szóköz
			if(word.charAt(i) == ' ') {
				van = true;
				oszlop = 11;
				sor = table[sor][oszlop];
			}
			
			// $
			if(word.charAt(i) == '$') {
				van = true;
				oszlop = 13;
				sor = table[sor][oszlop];
			}
			
			// egyéb
			if(van == false) {
				oszlop = 12;
				sor = table[sor][oszlop];
			}
			
			Ellenorzes(sor);
			sor = VisszaKezdő(sor);
		}
		
		
	}

}
