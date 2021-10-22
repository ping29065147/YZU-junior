#ifndef SAMPLE_H
#define SAMPLE_H

class sample
{

public:

	bool less(int hugeInt1[], int hugeInt2[], int size1, int size2);
	void decrement(int hugeInt[], int size);
	void subtraction(int minuend[], int subtrahend[], int& minuendSize, int subtrahendSize);
	void multiplication(int multiplicand[], int multiplier[], int& multiplicandSize, int multiplierSize);
	void division(int dividend[], int divisor[], int quotient[], int remainder[], int dividendSize, int divisorSize, int& quotientSize, int& remainderSize);

private:

	bool isZero(int hugeInt[], int size);
	void divideBy10(int hugeInt[], int& size);

};

#endif // !SAMPLE_H
