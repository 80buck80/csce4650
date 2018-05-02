#include <iostream>
#include <fstream>
#include <string>
using namespace std;


int main (int argc, char *argv[])
{
	ifstream ifs;
	ofstream ofs;
	char input[1000];

	string s;


	ifs.open(argv[1]);
	ofs.open("output.txt", ios::out | ios::app);

	while(!ifs.eof())
	{
		ifs.getline(input, 1000);
		s = string(input);
		ofs << "\"" + s + "\"+ \n";
		
	}
	
	ifs.close();
	ofs.close();

	return 0;
}
