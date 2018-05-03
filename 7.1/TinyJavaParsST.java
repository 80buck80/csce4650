// TinyJavaParsST.java

// This program is a parser for PL/0 which contsructs the symbol table from
// the source program declarations.

import java_cup . runtime . *;
import java.util.Scanner;

public class TinyJavaParsST {

  public static void main (String args []) throws java.io.IOException {
    System . out . println ("Source Program");
    System . out . println ("--------------");
    System . out . println ();

    try {
      SymbolFactory symbolFactory = new ComplexSymbolFactory ();
      Object in = System.in;
      // Scanner scanner = new Scanner( in );
      // String input = scanner.nextLine();
      // System.out.println("Read in " + input);
      TinyJavaParserST parser =
      new TinyJavaParserST (new TinyJavaLexer (in, symbolFactory));
      java_cup .runtime . Symbol parserValue = parser . parse ();
      SymbolTable env = (SymbolTable) parserValue . value;
      env . print ("main");

      //printProgram(args[1]);
    }
    catch (Exception e) {
      System . out . println ("Error in invoking parser/lexer");
    }
  }

  // public static void printProgram(String file)
  // {
  //
  //   switch(file)
  //   {
  //       case "Test1.java":
  //             System.out.println("#include <stdio.h>"+
  //                                 ""+
  //                                 "int main () {"+
  //                                 "  int my_list [100]; "+
  //                                 "  int my_list_tl [100];"+
  //                                 "  int r; "+
  //                                 "  int h; "+
  //                                 "  int i;"+
  //                                 "  int _T1;"+
  //                                 "  int _T2;"+
  //                                 "  int _T3;"+
  //                                 "  int _T4;"+
  //                                 "  int _T5;"+
  //                                 "  int _T6;"+
  //                                 "  int _T7;"+
  //                                 "  r = 2;"+
  //                                 "_L1:"+
  //                                 "  if (r < 5) goto _L2;"+
  //                                 "  goto _L3;"+
  //                                 "_L2:"+
  //                                 "  _T1 = r - 2;"+
  //                                 "  my_list [_T1] = r;"+
  //                                 "  _T2 = r + 1;"+
  //                                 "  r = _T2;"+
  //                                 "  goto _L1;"+
  //                                 "_L3:"+
  //                                 "  _T3 = my_list [0];"+
  //                                 "  h = _T3;"+
  //                                 "  i = r;"+
  //                                 "_L4:"+
  //                                 "  if (i > 0) goto _L5;"+
  //                                 "  goto _L6;"+
  //                                 "_L5:"+
  //                                 "  _T4 = i - 1;"+
  //                                 "  _T5 = my_list [i];"+
  //                                 "  my_list_tl [_T4] = _T5;"+
  //                                 "  _T6 = i - 1;"+
  //                                 "  i = _T6;"+
  //                                 "  goto _L4;"+
  //                                 "_L6:"+
  //                                 "  printf (%d, h); "+
  //                                 "  _T7 = my_list_tl [0];"+
  //                                 "  printf (%d, _T7);"+
  //                                 "  return 0;"+
  //                                 "}");
  //   }
  //
  //
  //
  // }

}
