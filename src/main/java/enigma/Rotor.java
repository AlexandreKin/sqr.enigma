package enigma;

public class Rotor {

    private int position;
    private int[] cipher = new int[26];
    private int[] bcipher = new int[26];
    private int notch1 = -1;
    private int notch2 = -1;

    public int getPosition() {
        return position;
    }

    public void setPosition(int posn) {
        position = posn;
    }
    /*
     * La fonction suivante sert � preparer le message � �tre chiffre, elle supprime tous les espaces present dans la chaine d'entr�e
     */
	public static Rotor rotorFactory(String str, String notches){
		//trim enleve les espaces au d�but et fin de la chaine de caract�re
		char[] s = str.trim().replace(" ", "").toCharArray();
		int[] cipher = new int[26]; //creer un tableau d'entier de la taille de l'alphabet
		for (int i = 0; i< 26; i++){
			cipher[i] = toIndex(s[i]);
		}
		s = notches.trim().replace(" and ", "").toCharArray();
		//En fonction de la taille de la tableau de chaine, on fait
		if (s.length == 2){
			return new Rotor(cipher, toIndex(s[0]), toIndex(s[1]));
		} else {
			return new Rotor(cipher, toIndex(s[0]));
		}
		
	}
	//notch = indicateur qui va permettre de faire tourner les rotors (apr�s chaque caract�re)
	Rotor(int[] c, int notch1, int notch2) {
		this.notch1 = notch1;
		this.notch2 = notch2;
		cipher = c;
		createBCipher();
	}
	
	Rotor(int[] c, int notch1) {
		this.notch1 = notch1;
		cipher = c;
		createBCipher();
	}

    public int convertForward(int p) {
        return ((cipher[((p+position)%26+26)%26]-position)%26+26)%26;
    }

    public int convertBackward(int e) {
        return ((bcipher[((e+position)%26+26)%26]-position)%26+26)%26;
    }
    
   
    //Permet de faire changer la position des rotors
    public void advance() {
        position = (position+1) % 26;
    }
    
    protected boolean atNotch() {
        return (position == notch1 || position == notch2);
    }
    
    /*
     * La fonction suivante retourne l'entier pass� en param�tre en une lettre majuscule
     * gr�ce a :+ 'A'
     */

    protected static char toLetter(int p) {
        return (char)(p + 'A');
    }

    /*
     * La fonction suivante est l'inverse de la fonction pr�c�dente.
     * Celle-ci retourne un entier � partir d'une lettre pass�e en param�tre
     */

    
    protected static int toIndex(char c) {
        return c - 'A';
    }
    
	private void createBCipher() {
		for(int i =0; i<26; i++)
			bcipher[cipher[i]] = i;
	}



}
