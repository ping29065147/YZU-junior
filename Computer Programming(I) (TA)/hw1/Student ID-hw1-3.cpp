// Determine whether a number is a palindrome.
#include <iostream>
#include <string>
using namespace std; 

int main()
{
   int number; // user input number

   cout << "Enter a 5-digit number: "; // prompt for a number
   cin >> number; // get number

   cout << number << " is" << ((to_string(number)[0] == to_string(number)[4] && to_string(number)[1] == to_string(number)[3]) ? " " : " not ") << "a palindrome.\n";

   system( "pause" );
} // end main