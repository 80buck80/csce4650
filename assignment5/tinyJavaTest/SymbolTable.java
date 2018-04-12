// SymbolTable.java

import java.util.*;

enum Category {CLASS, FUNCTION, VARIABLE}

class Type { }

// IntegerType represents the type of integer variables in Tiny C++.

class IntegerType extends Type {

  public String toString () {
    return "int";
  }

}

// ArrayType represents array types in TinyC++.

class ArrayType extends Type {

  private int dimension;
  private Type baseType;

  public ArrayType (int dim, Type base) {
    dimension = dim;
    baseType = base;
  }

  public int dimension () { return dimension; }

  public String toString () {
    return "array (" + dimension + ", " + baseType + ")";
  }

}

// ObjectType represents object types in TinyC++.

class ObjectType extends Type {

  private String className;
  private SymbolTableEntry objectType;

  public ObjectType (String className, SymbolTableEntry objectType) {
    this . className = className;
    this . objectType = objectType;
  }

  public String className () { return className; }

  public SymbolTableEntry objectType () { return objectType; }

  public String toString () {
    return className;
  }

}

// Declarator is a class which defines an identifier and its type.

class Declarator {

  private String id;
  private Type type;

  public Declarator (String id, Type type) {
    this . id = id;
    this . type = type;
  }

  public String id () { return id; }

  public Type type () { return type; }

}

// SymbolTableEntry is a class to represent the symbol table entries
// for TinyC++ programs.

class SymbolTableEntry {

  private Category category;
  private Type type;
  private SymbolTable localEnv;
  private String funcCode;

  public SymbolTableEntry (Category cat) { 
    category = cat;
  }

  public SymbolTableEntry (Category cat, Type typ) {
    category = cat;
    type = typ;
  }

  public SymbolTableEntry (Category cat, SymbolTable env) {
    category = cat;
    localEnv = env;
  }

  public SymbolTableEntry (Category cat, Type typ, SymbolTable env) {
    category = cat;
    type = typ;
    localEnv = env;
  }

  public Category category () { return category; }

  public Type type () { return type; }

  public SymbolTable localEnv () { return localEnv; }

  public String funcCode () { return funcCode; }

  public void setCode (String code) { funcCode = code; }

  public String toString () {
    String printString = category . name ();
    if (category == Category . VARIABLE || category == Category . FUNCTION)
      printString = printString + " " + type;
    return printString;
  }

}
 
// SymbolTable is a class to represent the symbol table for TinyC++ programs.

public class SymbolTable {

  private static int maxlen = 2; // for header "Id"

  public static int maxLen () { return maxlen; }

  private SymbolTable parent;				// static parent

  private TreeMap <String, SymbolTableEntry> table; 	// id table

  public SymbolTable (SymbolTable staticParent) { 
    parent = staticParent;
    table = new TreeMap <String, SymbolTableEntry> (); 
  }

  public SymbolTable parent () { return parent; }

  // The entry function returns the symbol table entry for the id, including
  // if the id appears in a parent's symbol table. If the id has not been 
  // declared, it prints an appropriate error message.

  public SymbolTableEntry entry (String id) {
    SymbolTableEntry idEntry = table . get (id);
    if (idEntry == null)
      if (parent == null)
        ErrorMessage . print ("Undeclared identifier: " + id);
      else				// not found in this scope
        idEntry = parent . entry (id); 	// check parent
    return idEntry;
  }

  // The enter function enters an id and its information into the symbol
  // table.

  public void enter (String id, SymbolTableEntry entry) {
    SymbolTableEntry idEntry = table . get (id);
    if (idEntry != null)
      ErrorMessage . print ("Identifier " + id + " already declared.");
    table . put (id, entry);
    if (id . length () > maxlen)
      maxlen = id . length ();
  }

  // The enterVar function enters a variable id into the symbol table.
 
  public void enterVar (String id, Type type) { 
    enter (id, new SymbolTableEntry (Category . VARIABLE, type));
  }

  // The enterFunc function enters a function id, its return type and its local 
  // symbol table into the symbol table. When this function is called, the local
  // symbol table contains only the formal parameters. This entry is needed to
  // allow type checking of recursive calls.

  public void enterFunc (String id, Type type, SymbolTable env) {
    enter (id, new SymbolTableEntry (Category . FUNCTION, type, env));
  }

  // The enterFuncCode function enters the code for function id into the
  // symbol table. The entry for id has already been added by enterFunc.

  public void enterFuncCode (String id, String code) {
    SymbolTableEntry idEntry = table . get (id);
    idEntry . setCode (code);
  }

  // The enterClass function enters a class id and its local symbol table 
  // into the symbol table.

  public void enterClass (String id, SymbolTable env) {
    enter (id, new SymbolTableEntry (Category . CLASS, env));
  }

  // The print function prints the entire symbol table, including local
  // symbol tables for classes and functions.

  public void print (String blockName) {
    System . out . println ();
    System . out . println ("Identifier Table for " + blockName);
    System . out . print ("---------------------");
    for (int i = 0; i < blockName . length (); i++) 
      System . out . print ("-");
    System . out . println ();
    System . out . println ();
    System . out . print ("Id");
    for (int i = 2; i < maxLen (); i++)
      System . out . print (" ");
    System . out . println (" Category Type");
    System . out . print ("--");
    for (int i = 2; i < maxLen (); i++)
      System . out . print (" ");
    System . out . println (" -------- ----");
    Iterator <Map . Entry <String, SymbolTableEntry>> envIterator = 
      table . entrySet () . iterator ();
    TreeMap <String, SymbolTableEntry> classAndFunctionList = 
      new TreeMap <String, SymbolTableEntry> ();
    while (envIterator . hasNext ()) {
      Map . Entry <String, SymbolTableEntry> entry = envIterator . next ();
      String id = entry . getKey ();
      SymbolTableEntry idEntry = entry . getValue ();
      System . out . print (id);
      for (int i = id . length (); i < maxLen (); i++)
        System . out . print (" ");
      System . out . print (" ");
      System . out . println (idEntry);
      if (idEntry . category () == Category . CLASS 
          || idEntry . category () == Category . FUNCTION)
        classAndFunctionList . put (id, idEntry);
    }
    Iterator <Map . Entry <String, SymbolTableEntry>> classAndFunctionIterator =
      classAndFunctionList . entrySet () . iterator ();
    while (classAndFunctionIterator . hasNext ()) {
      Map . Entry <String, SymbolTableEntry> entry = 
        classAndFunctionIterator . next ();
      String classOrFunctionName = entry . getKey ();
      SymbolTableEntry idEntry = entry . getValue ();
      idEntry . localEnv () . print (classOrFunctionName);
    }
  }

}
