import java_cup . runtime . *;
%%
%class TinyJavaLexer
%unicode
%line
%column
%cupsym Symbol
%cup
%eofval{
return symbolFactory . newSymbol ("EOF", Symbol . EOF);
%eofval}

%{
 private SymbolFactory symbolFactory;
 public TinyJavaLexer (java.io.InputStream input, SymbolFactory sf) {
 this (input);
 symbolFactory = sf;
 }
 private void echo () { System . out . print (yytext ()); }
 public int position () { return yycolumn; }
%}
Identifier = [:letter:]("_"?([:letter:] | [:digit:]))*
Integer = [:digit:] [:digit:]*
%%

import { echo (); return symbolFactory . newSymbol ("(keyword, import)", Symbol . IMPORT); }
java { echo (); return symbolFactory . newSymbol ("(keyword, java)", Symbol . JAVA); }
util { echo (); return symbolFactory . newSymbol ("(keyword, util)", Symbol . UTIL); }
class { echo (); return symbolFactory . newSymbol ("(keyword, class)", Symbol . CLASS); }
static { echo (); return symbolFactory . newSymbol ("(keyword, static)", Symbol . STATIC); }
return { echo (); return symbolFactory . newSymbol ("(keyword, return)", Symbol . RETURN); }
public { echo (); return symbolFactory . newSymbol ("(keyword, public)", Symbol . PUBLIC); }
new { echo (); return symbolFactory . newSymbol ("(keyword, new)", Symbol . NEW); }
int { echo (); return symbolFactory . newSymbol ("(keyword, int)", Symbol . INT); }
Scanner { echo (); return symbolFactory . newSymbol ("(keyword, Scanner)", Symbol . SCANNER); }
in { echo (); return symbolFactory . newSymbol ("(keyword, in)", Symbol . IN); }
System { echo (); return symbolFactory . newSymbol ("(keyword, System)", Symbol . SYSTEM); }
void { echo (); return symbolFactory . newSymbol ("(keyword, void)", Symbol . VOID); }
main { echo (); return symbolFactory . newSymbol ("(keyword, main)", Symbol . MAIN); }
String { echo (); return symbolFactory . newSymbol ("(keyword, String)", Symbol . STRING); }
args { echo (); return symbolFactory . newSymbol ("(keyword, args)", Symbol . ARGS); }
boolean { echo (); return symbolFactory . newSymbol ("(keyword, boolean)", Symbol . BOOLEAN); }
if { echo (); return symbolFactory . newSymbol ("(keyword, if)", Symbol . IF); }
else { echo (); return symbolFactory . newSymbol ("(keyword, else)", Symbol . ELSE); }
while { echo (); return symbolFactory . newSymbol ("(keyword, while)", Symbol . WHILE); }
out { echo (); return symbolFactory . newSymbol ("(keyword, out)", Symbol . OUT); }
println { echo (); return symbolFactory . newSymbol ("(keyword, println)", Symbol . PRINTLN); }
nextInt { echo (); return symbolFactory . newSymbol ("(keyword, nextInt)", Symbol . NEXTINT); }
true { echo (); return symbolFactory . newSymbol ("(keyword, true)", Symbol . TRUE); }
false { echo (); return symbolFactory . newSymbol ("(keyword, false)", Symbol . FALSE); }
this { echo (); return symbolFactory . newSymbol ("(keyword, this)", Symbol . THIS); }
"!=" { echo (); return symbolFactory . newSymbol ("(operator, !=)", Symbol . NE); }
"<=" { echo ();return symbolFactory . newSymbol ("(operator, <=)", Symbol . LE); }
">=" { echo (); return symbolFactory . newSymbol ("(operator, >=)", Symbol . GE); }
"<" { echo (); return symbolFactory . newSymbol ("(operator, <)", Symbol . LT); }
">" { echo (); return symbolFactory . newSymbol ("(operator, >)", Symbol . GT); }
"&&" { echo (); return symbolFactory . newSymbol ("(operator, &&)", Symbol . AND); }
"||" { echo (); return symbolFactory . newSymbol ("(operator, ||)", Symbol . OR); }
// { echo (); return symbolFactory . newSymbol ("(keyword, //)", Symbol . COMMENT); }
"==" { echo (); return symbolFactory . newSymbol ("(operator, ==)", Symbol . EQ); }
";" { echo (); return symbolFactory . newSymbol ("(punctuation, ;)", Symbol . SEMICOLON); }
"{" { echo (); return symbolFactory . newSymbol ("(operator, {)", Symbol . LCURLBRACKET); }
"}" { echo (); return symbolFactory . newSymbol ("(operator, })", Symbol . RCURLBRACKET); }
"[" { echo (); return symbolFactory . newSymbol ("(operator, [", Symbol . LSQRBRACKET); }
"]" { echo (); return symbolFactory . newSymbol ("(operator, ]", Symbol . RSQRBRACKET); }
"(" { echo (); return symbolFactory . newSymbol ("(operator, ()", Symbol . LPAREN); }
")" { echo (); return symbolFactory . newSymbol ("(operator, ))", Symbol . RPAREN); }
"=" { echo (); return symbolFactory . newSymbol ("(operator, =)", Symbol . ASSIGN); }
"." { echo (); return symbolFactory . newSymbol ("(punctuation, .)", Symbol . PERIOD); }
"," { echo (); return symbolFactory . newSymbol ("(punctuation, ,)", Symbol . COMMA); }
"+" { echo (); return symbolFactory . newSymbol ("(operator, +)", Symbol . PLUS); }
"-" { echo (); return symbolFactory . newSymbol ("(operator, -)", Symbol . MINUS); }
"*" { echo (); return symbolFactory . newSymbol ("(operator, *)", Symbol . TIMES); }
"/" { echo (); return symbolFactory . newSymbol ("(operator, /)", Symbol . DIVIDE); }
"!" { echo (); return symbolFactory . newSymbol ("(operator, !)", Symbol . NOT); }


[ \t\n] { echo (); }

{Integer} { echo (); return symbolFactory . newSymbol ("(integer, " + yytext () + ")", Symbol . INTEGER, yytext ()); }
{Identifier} { echo (); return symbolFactory . newSymbol ("(identifier, " + yytext () + ")", Symbol . ID, yytext ()); }
.		{ echo (); ErrorMessage . print (yychar, "Illegal character"); }
