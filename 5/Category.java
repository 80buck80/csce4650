public class Category {

  public static final int CLASS  = 0;
  public static final int FUNCTION = 1;
  public static final int VARIABLE = 2;

  public static String toString (int category) {
    switch (category) {
      case CLASS  		: return "class ";
      case FUNCTION 	: return "function ";
      case VARIABLE   : return "variable ";
      default        	: return null;
    }
  }

}
