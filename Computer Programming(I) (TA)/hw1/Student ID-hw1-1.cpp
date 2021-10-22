#include <iostream> // allows program to perform input and output
using namespace std; // program uses names from the std namespace

int main()
{
   int number; // integer read from user

   cout << "Enter an integer: "; // prompt
   cin >> number; // read integer from user

   cout << "The integer " << number << " is " << (number % 2 ? "odd" : "even") << ".\n";

   system( "pause" );
} // end main