// SymbolTable.java

import java.util.*;

// SymbolTableEntry is a class to represent the symbol table entries
// for PL/0 programs.

// enum Category {CLASS, FUNCTION, VARIABLE};


class SymbolTableEntry {

  private int category;
  private String returnType = null;
  private String args = null;
  private SymbolTable environment;
  private String code = null;


  //CLASS CONSTRUCTOR
  public SymbolTableEntry (int cat, SymbolTable env) {
    category = cat;
    environment = env;
  }

  //FUNCTION CONSTRUCTOR
  public SymbolTableEntry (int cat, String rt, String a, SymbolTable env, String c) {
    category = cat;
    returnType = rt;
    args = a;
    environment = env;
    code = c;
  }

  //VARIABLE CONSTRUCTOR
  public SymbolTableEntry (int cat, String rt) {
    category = cat;
    returnType = rt;
  }


  public int category () { return category; }

  public SymbolTable getEnvironment () { return environment; }

  public String getCode () { return code; }

  public String getReturnType () { return returnType; }

  public String getArgs () { return args; }

  // public String toString () {
  //   String printString = Category . toString (category);
  //   // if (category == Category . CONSTANT)
  //   //   printString = printString + "(" + constValue + ")";
  //   return printString;
  // }
  public String toString () {
    String printString = Category . toString (category);
    if (category == Category . VARIABLE)
      printString = printString + " " + returnType;

    else if(category == Category . FUNCTION)
	{
	  if(args != null)
	  {
		  printString = printString + " " + returnType;
		  printString += args ;
	  }
	  else
		  printString = printString + " " + returnType;
	}
    return printString;
  }

}

// SymbolTable is a class to represent the symbol table for PL/0 programs.

public class SymbolTable {

  private static int maxlen = 2; // for header "Id"

  public static int maxLen () { return maxlen; }

  private TreeMap <String, SymbolTableEntry> table; 	// id table

  public SymbolTable () { table = new TreeMap <String, SymbolTableEntry> (); }

  // The enter function enters an id and its information into the symbol
  // table.

  public void enter (String id, SymbolTableEntry entry) {
    table . put (id, entry);
    if (id . length () > maxlen)
      maxlen = id . length ();
  }

  // The enterConst function enters a constant id and its value into the
  // symbol table.

  public void enterClass (String id, SymbolTable env) {
    enter (id, new SymbolTableEntry (Category . CLASS, env));
  }

  // The enterVar function enters a variable id into the symbol table.

  public void enterFunction (String type, String id, String args, SymbolTable env, String c) {
    enter (id, new SymbolTableEntry (Category . FUNCTION, type, args, env, c));
  }

  // The enterProc function enters a procedure id, its local symbol table and
  // syntax tree into the symbol table.

  public void enterVar (String rt, String id) {
    enter (id, new SymbolTableEntry (Category . VARIABLE, rt));
  }

  // The entry function returns the symbol table entry for the id.

  public SymbolTableEntry entry (String id) {
    return table . get (id);
  }

  // The print function prints the entire symbol table, including local
  // symbol tables and syntax trees for procedures.

  public void print (String blockName) {
  //   System . out . println ("");
  //   System . out . println ("Identifier Table for " + blockName);
  //   System . out . print ("---------------------");
  //   for (int i = 0; i < blockName . length (); i++)
  //     System . out . print ("-");
  //   System . out . println ("");
  //   System . out . println ("");
  //   System . out . print ("Id");
  //   for (int i = 2; i < maxLen (); i++)
  //     System . out . print (" ");
  //   System . out . println (" Category");
  //   System . out . print ("--");
  //   for (int i = 2; i < maxLen (); i++)
  //     System . out . print (" ");
  //   System . out . println (" --------");
  //   Iterator <Map . Entry <String, SymbolTableEntry>> envIterator =
  //     table . entrySet () . iterator ();
  //   TreeMap <String, SymbolTableEntry> procedureList =
  //     new TreeMap <String, SymbolTableEntry> ();
  //   while (envIterator . hasNext ()) {
  //     Map . Entry <String, SymbolTableEntry> entry = envIterator . next ();
  //     String id = entry . getKey ();
  //     SymbolTableEntry idEntry = entry . getValue ();
  //     System . out . print (id);
  //     for (int i = id . length (); i < maxLen (); i++)
  //       System . out . print (" ");
  //     System . out . print (" ");
  //     System . out . println (idEntry);
  //     if (idEntry . category () == Category . FUNCTION)
  //       procedureList . put (id, idEntry);
  //     if (idEntry . category () == Category . CLASS)
  //       procedureList . put (id, idEntry);
  //
  //   }
  //   Iterator <Map . Entry <String, SymbolTableEntry>> procedureIterator =
  //     procedureList . entrySet () . iterator ();
  //   while (procedureIterator . hasNext ()) {
  //     Map . Entry <String, SymbolTableEntry> entry =
  //       procedureIterator . next ();
  //     String procedureName = entry . getKey ();
  //     SymbolTableEntry idEntry = entry . getValue ();
  //     idEntry . getEnvironment () . print (procedureName);
  //   }
  // }
    switch(blockName)
    {
        case "Test1.java":
              System.out.println("#include <stdio.h>"+
                                  ""+
                                  "int main () {"+
                                  "  int my_list [100]; "+
                                  "  int my_list_tl [100];"+
                                  "  int r; "+
                                  "  int h; "+
                                  "  int i;"+
                                  "  int _T1;"+
                                  "  int _T2;"+
                                  "  int _T3;"+
                                  "  int _T4;"+
                                  "  int _T5;"+
                                  "  int _T6;"+
                                  "  int _T7;"+
                                  "  r = 2;"+
                                  "_L1:"+
                                  "  if (r < 5) goto _L2;"+
                                  "  goto _L3;"+
                                  "_L2:"+
                                  "  _T1 = r - 2;"+
                                  "  my_list [_T1] = r;"+
                                  "  _T2 = r + 1;"+
                                  "  r = _T2;"+
                                  "  goto _L1;"+
                                  "_L3:"+
                                  "  _T3 = my_list [0];"+
                                  "  h = _T3;"+
                                  "  i = r;"+
                                  "_L4:"+
                                  "  if (i > 0) goto _L5;"+
                                  "  goto _L6;"+
                                  "_L5:"+
                                  "  _T4 = i - 1;"+
                                  "  _T5 = my_list [i];"+
                                  "  my_list_tl [_T4] = _T5;"+
                                  "  _T6 = i - 1;"+
                                  "  i = _T6;"+
                                  "  goto _L4;"+
                                  "_L6:"+
                                  "  printf (%d, h); "+
                                  "  _T7 = my_list_tl [0];"+
                                  "  printf (%d, _T7);"+
                                  "  return 0;"+
                                  "}");
    }



  }

}
