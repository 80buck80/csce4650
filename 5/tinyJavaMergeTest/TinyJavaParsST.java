// TinyJavaParsST.java

// This program is a parser for TinyC++ which also constructs the symbol table.

import java_cup . runtime . *;

public class TinyJavaParsST {

  public static void main (String args []) throws java.io.IOException {

    System . out . println ("Source Program");
    System . out . println ("--------------");
    System . out . println ("");

    try {
      SymbolFactory symbolFactory = new ComplexSymbolFactory ();
      TinyJavaParserST parser =
        new TinyJavaParserST (new TinyJavaLexer (System . in, symbolFactory));
      java_cup .runtime . Symbol parserValue = parser . parse ();
      SymbolTable env = (SymbolTable) parserValue . value;
      env . print ("Source Program");
    }
    catch (Exception e) {
      System . out . println ("Error in invoking parser/lexer");
    }
  }

}