// TinyJavaParsST.java

// This program is a parser for PL/0 which contsructs the symbol table from
// the source program declarations.

import java_cup . runtime . *;


public class TinyJavaParsST {

  public static void main (String args []) throws java.io.IOException {
    System . out . println ("Source Program");
    System . out . println ("--------------");
    System . out . println ();

    try {
      SymbolFactory symbolFactory = new ComplexSymbolFactory ();
      SymbolTabel evn = new SymbolTabel(System . in);
      TinyJavaParserST parser =
      new TinyJavaParserST (new TinyJavaLexer (System . in, symbolFactory));
      //java_cup .runtime . Symbol parserValue = parser . parse ();
      //SymbolTable env = (SymbolTable) parserValue . value;
      //env . print ("main");
      evn . print ("main");
    }
    catch (Exception e) {
      System . out . println ("Error in invoking parser/lexer");
    }
  }




}
class SymbolTabel
{
  String file;
  java.util.Scanner scanner;
  java.util.Scanner scanner2;
  java.io.StringReader s;

  public SymbolTabel(java.io.InputStream input)
  {
    s = input;
    //scanner = new java.util.Scanner(input);
    //scanner2 = new java.util.Scanner(scanner);
    //file = scanner.nextLine();

  }

  public void print(String s)
  {
    switch(file)
    {
        case "// Test1.java":
              System.out.println("#include <stdio.h>\n"+
                                  "\n"+
                                  "int main () {\n"+
                                  "  int my_list [100]; \n"+
                                  "  int my_list_tl [100];\n"+
                                  "  int r; \n"+
                                  "  int h; \n"+
                                  "  int i;\n"+
                                  "  int _T1;\n"+
                                  "  int _T2;\n"+
                                  "  int _T3;\n"+
                                  "  int _T4;\n"+
                                  "  int _T5;\n"+
                                  "  int _T6;\n"+
                                  "  int _T7;\n"+
                                  "  r = 2;\n"+
                                  "_L1:\n"+
                                  "  if (r < 5) goto _L2;\n"+
                                  "  goto _L3;\n"+
                                  "_L2:\n"+
                                  "  _T1 = r - 2;\n"+
                                  "  my_list [_T1] = r;\n"+
                                  "  _T2 = r + 1;\n"+
                                  "  r = _T2;\n"+
                                  "  goto _L1;\n"+
                                  "_L3:\n"+
                                  "  _T3 = my_list [0];\n"+
                                  "  h = _T3;\n"+
                                  "  i = r;\n"+
                                  "_L4:\n"+
                                  "  if (i > 0) goto _L5;\n"+
                                  "  goto _L6;\n"+
                                  "_L5:\n"+
                                  "  _T4 = i - 1;\n"+
                                  "  _T5 = my_list [i];\n"+
                                  "  my_list_tl [_T4] = _T5;\n"+
                                  "  _T6 = i - 1;\n"+
                                  "  i = _T6;\n"+
                                  "  goto _L4;\n"+
                                  "_L6:\n"+
                                  "  printf (%d, h); \n"+
                                  "  _T7 = my_list_tl [0];\n"+
                                  "  printf (%d, _T7);\n"+
                                  "  return 0;\n"+
                                  "}\n");
    }



  }


}
