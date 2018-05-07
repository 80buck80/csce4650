TinyJava:
	cup -parser TinyJavaParserST -symbols Symbol -expect 150 -nowarn -nosummary TinyJavaST.cup
	jflex TinyJava.jflex
	javac -cp .:java-cup-11a-runtime.jar TinyJavaLexer.java
	javac -cp .:java-cup-11a-runtime.jar TinyJavaParsST.java

Test1:
	java -cp .:java-cup-11a-runtime.jar TinyJavaParsST < Tests/Test1.java

Test2:
	java -cp .:java-cup-11a-runtime.jar TinyJavaParsST < Tests/Test2.java

Test3:
	java -cp .:java-cup-11a-runtime.jar TinyJavaParsST < Tests/Test3.java

Test4:
	java -cp .:java-cup-11a-runtime.jar TinyJavaParsST < Tests/Test4.java

Test:	
	gcc Test.c -o Test

clean:
	rm -f *.class Symbol.java TinyJavaLexer.java TinyJavaParserST.java Test *.c

cleanTest:	
	rm -f Test