/*
    TinyJavaParsST.java
    Programmer: Ka Son Chan KaSonChan@my.unt.edu
    Class: CSCE 3650, Spring 2013
    Due: May 08, 2013
    cse01.cse.unt.edu
    This program is a parser for TinyJava which contsructs the symbol table from the source program declarations.
*/

import java.util.*;
import java_cup . runtime . *;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TinyJavaParsST {

  public static void main (String args []) throws java.io.IOException {
    System . out . println ("Source Program");
    System . out . println ("--------------");
    System . out . println ();

    try 
    {
      SymbolFactory symbolFactory = new ComplexSymbolFactory ();
      TinyJavaParserST parser = new TinyJavaParserST (new TinyJavaLexer (System . in, symbolFactory));
      java_cup .runtime . Symbol parserValue = parser . parse ();

      System . out . println();
      System . out . println("##### SYMBOL TABLE #####");

      SymbolTable classes = new SymbolTable();
      classes = (SymbolTable) parserValue.value;
      classes . PrintTables();
      System . out . println();

      System . out . println("##### EQUIVALENT C CODE #####");
      System . out . println();
      classes . PrintString();

      // Write the result to the file Test.c
      try {
        File file = new File("Test.c");

        // If file doesnt exists, then create it
        if (!file.exists()) {
          file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(classes.GetString());
        bw.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    catch (Exception e) {
      System . out . println ("Error in invoking parser/lexer");
    }
  }
}
