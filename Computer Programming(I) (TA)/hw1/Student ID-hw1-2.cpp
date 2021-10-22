#include <iostream> // allows program to perform input and output
#include <string>
using namespace std; // program uses names from the std namespace

int main()
{
   int number; // integer read from user

   cout << "Enter a five-digit integer: "; // prompt
   cin >> number; // read integer from user

   for (auto& i : to_string(number)) cout << i << "   ";

   system( "pause" );
} // end main