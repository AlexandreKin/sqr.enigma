package enigma;

/** Class that represents a reflector in the enigma.
 *  @author
 */

//Constructeur
public class Reflector extends Rotor {
	
	int[] reflection;
	
	public static Reflector reflectorFactory(String str){
		//trim enleve les espaces au début et fin de la chaine de caractère
		char[] s = str.trim().replace(" ", "").toCharArray();
		int[] cipher = new int[26];
		for (int i = 0; i< 26; i++){
			cipher[i] = toIndex(s[i]);
		}
		return new Reflector(cipher);
	}
	
	Reflector(int[] r){
		super(r,0);
		reflection = r;
	}
	
	/*
	 * La fonction suivante renvois la conversion du paramètre d'entrée en fonction de la position
	 */
        
    public int convertForward(int p) {
        return ((reflection[((p)%26+26)%26])%26+26)%26;
    }

    /*
     * La fonction suivante renvoie une valeur inutile
     */
    @Override
    public int convertBackward(int unused) {
        throw new UnsupportedOperationException();
    }

    /*
     * La fonction suivante ne fais rien : le rotor ne devrait pas avancer
     */
    @Override
    public void advance() {
    }

}
