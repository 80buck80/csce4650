/*
    README.txt
    Programmer: Ka Son Chan KaSonChan@my.unt.edu
    Class: CSCE 3650, Spring 2013
    Due: May 8, 2013
    cse01.cse.unt.edu
*/

All result codes is generated into to equivalent c source code and each
compilation is written to a Test.c file and shown on the screen.

Instruction to execute the code in cse01 machine:

(1)	To compile all the files, enter:
    make clean TinyJava
    * make clean removes all the files generated previously.

(2)	To execute the files, enter:
    make Test1
    make Test2
    make Test3
    make Test4

(3) To compile the Test.c that is generated in last step, enter:
    make Test

(4) To execute the previous step, enter:
    ./Test

(5) To clean just the Test executable file, enter:
    make cleanTest
    * make cleanTest only removes the Test.c executable.
    * Remove the Test executable before compile another Test case.

I also include a typescript folder which contains the following to show my 
working testing cases of the Test1 to Test4 codes.
    typescript1
    typescript2
    typescript3
    typescript4

Sample Test:
S300:~/Documents/CSCE3650/CSCE3650KaSonChanHW6$ make Test1
java -cp .:java-cup-11a-runtime.jar TinyJavaParsST < Tests/Test1.java
Source Program
--------------

// Test1.java

import java.util.*;

class Test1 {

  public static void main (String args []) {
    int my_list [] = new int [100]; 
    int my_list_tl [] = new int [100];
    int r; int h; int i;
    {
      r = 2;
      while (r < 5) {  
        my_list [r - 2] = r;
        r = r + 1;
      }  
      h = my_list [0];
      i = r;
      while (i > 0) {
    my_list_tl [i - 1] = my_list [i];
    i = i - 1;
      }
    }
    System . out . println (h); 
    System . out . println (my_list_tl [0]);
  }
}

##### SYMBOL TABLE #####

Identifier Table for Class
--------------------------

Id      Category        Type
--      --------        ----
Test1       classes     classes

Identifier Table for Test1
--------------------------

Id      Category        Type
--      --------        ----
main        function        classes

Identifier Table for main
-------------------------

Id      Category        Type
--      --------        ----
my_list     variable        integer
my_list_tl      variable        integer
r       variable        integer
h       variable        integer
i       variable        integer

##### EQUIVALENT C CODE #####

#include <stdio.h>
#include <stdlib.h>

int main(int argc, char * argv[]) {
int my_list[100] ;
int my_list_tl[100] ;
int r;
int h;
int i;
{
r = 2;
while (r < 5) {
my_list[r - 2] = r;
r = r + 1;
}
h = my_list[0];
i = r;
while (i > 0) {
my_list_tl[i - 1] = my_list[i];
i = i - 1;
}
}
printf("%d\n", h);
printf("%d\n", my_list_tl[0]);
}


