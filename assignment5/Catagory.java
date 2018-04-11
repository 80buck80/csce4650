// Category.java

// Category is a class to represent the categories of identifiers in a PL/0
// program.

public class Category {

  public static final int CLASS  = 0;
  public static final int FUNCTION  = 1;
  public static final int OBJECT = 2;

  public static String toString (int category) {
    switch (category) {
      case CLASS  : return "class ";
      case FUNCTION  : return "function ";
      case OBJECT : return "object";
      default        : return null;
    }
  }

}
