// Determine whether three values represent the sides of a right triangle.
#include <iostream>
using namespace std; 

int main()
{
   int side1; // length of side 1
   int side2; // length of side 2
   int side3; // length of side 3

   // get values of three sides
   cout << "Enter side 1: ";
   cin >> side1;

   cout << "Enter side 2: ";
   cin >> side2;

   cout << "Enter side 3: ";
   cin >> side3;
   
   cout << (pow(side1, 2) == pow(side2, 2) + pow(side3, 2) || pow(side2, 2) == pow(side1, 2) + pow(side3, 2) || pow(side3, 2) == pow(side1, 2) + pow(side2, 2) ? "These are the sides of a right triangle.\n" : "These do not form a right triangle.\n");

   

   system( "pause" );
} // end main