#include <iostream>
using namespace std;

int main()
{
   int year;
   cout << "Enter a year ( 1583-3000 ): ";
   cin >> year;

   cout << "Year " << year << " is a " << (year % 4 == 0 ? (year % 100 == 0 ? (year % 400 == 0 ? "leap" : "common") : "leap") : "common") << " year.\n";

   system( "pause" );
}