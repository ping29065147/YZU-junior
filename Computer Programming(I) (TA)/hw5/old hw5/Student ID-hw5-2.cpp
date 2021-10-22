#include <iostream>
using namespace std;

// returns a power p of 2 such that p <= number < 2 * p,
// for example, if number is in [ 8, 15 ], then returns 8
int computePower( int number );

// prints the binary representation of number,
// for example, if number is 10, then prints 1010
void displayBinary( int number, int power );

// returns the sum of all bits of the binary representation of number,
// or equivalently the number of 1s in the binary representation of number,
// for example, if number is 10, then returns 2
int sumBits( int number, int power );

int main()
{
   int number;
   cin >> number;
   while( number > 0 )
   {
      int power = computePower( number );

      cout << "The parity of ";
      displayBinary( number, power );

      cout << " is " << sumBits( number, power ) << " (mod 2).\n";

      cin >> number;
   }

   system( "pause" );
}

int computePower( int number )
{
    return (number > 1 ? 2 * computePower(number / 2) : 1);
}

void displayBinary( int number, int power )
{
    if (power > 0) cout << ((number & power) > 0 ? 1 : 0), displayBinary(number, power / 2);
    /*if (power > 0)
    {
        if (number - power >= 0) cout << 1, displayBinary(number - power, power / 2);
        else cout << 0, displayBinary(number, power / 2);       
    }*/
}

int sumBits( int number, int power )
{
    return (power > 0 ? ((number & power) > 0 ? 1 : 0) + sumBits(number, power / 2) : 0);
}