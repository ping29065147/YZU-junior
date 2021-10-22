#include "sample.h"
#define arraySize  200

bool sample::less(int hugeInt1[], int hugeInt2[], int size1, int size2)
{
    if (size1 != size2) return size1 < size2;
    for (int i = size1 - 1; i >= 0; --i) if (hugeInt1[i] != hugeInt2[i]) return hugeInt1[i] < hugeInt2[i];
    return false;
}

void sample::decrement(int hugeInt[], int size)
{
    int x[arraySize] = {};
    x[0] = 1;
    subtraction(hugeInt, x, size, 1);
}

void sample::subtraction(int minuend[], int subtrahend[], int& minuendSize, int subtrahendSize)
{
    for (int i = 0; i < minuendSize; ++i) minuend[i] -= subtrahend[i];
    for (int i = 0; i < minuendSize; ++i) if (minuend[i] < 0) --minuend[i + 1], minuend[i] += 10;
    while (minuend[minuendSize - 1] == 0 && minuendSize > 1) --minuendSize;
}

void sample::multiplication(int multiplicand[], int multiplier[], int& multiplicandSize, int multiplierSize)
{
    int product[arraySize * 2] = {};
    int productSize = multiplicandSize + multiplierSize;

    for (int i = 0; i < multiplicandSize; ++i) for (int j = 0; j < multiplierSize; ++j) product[i + j] += multiplicand[i] * multiplier[j];
    for (int i = 0; i < productSize; ++i) if (product[i] >= 10) product[i + 1] += product[i] / 10, product[i] %= 10;
    while (product[productSize - 1] == 0 && productSize > 1) --productSize;
    for (int i = 0; i < (multiplicandSize = productSize); ++i) multiplicand[i] = product[i];
}

void sample::division(int dividend[], int divisor[], int quotient[], int remainder[],
    int dividendSize, int divisorSize, int& quotientSize, int& remainderSize)
{
    for (int i = 0; i < (remainderSize = dividendSize); ++i) remainder[i] = dividend[i];
    if (less(dividend, divisor, dividendSize, divisorSize)) quotientSize = 1, quotient[0] = 0;
    else
    {
        int n = dividendSize - divisorSize;
        int buffer[arraySize] = {};
        int bufferSize = divisorSize + n;
        quotientSize = dividendSize - divisorSize;

        for (int i = 0; i < divisorSize; ++i) buffer[i + n] = divisor[i];
        if (less(dividend, buffer, dividendSize, bufferSize)) divideBy10(buffer, bufferSize);
        else ++quotientSize;

        for (int i = 0; i < quotientSize; ++i) quotient[i] = 0;
        for (int i = quotientSize - 1; i >= 0; --i)
        {
            while (!less(remainder, buffer, remainderSize, bufferSize))
            {
                subtraction(remainder, buffer, remainderSize, bufferSize);
                ++quotient[i];
                if (isZero(remainder, remainderSize)) return;
            }
            divideBy10(buffer, bufferSize);
        }
    }
}

bool sample::isZero(int hugeInt[], int size)
{
    for (int i = 0; i < size; i++)
        if (hugeInt[i] != 0)
            return false;
    return true;
}

void sample::divideBy10(int hugeInt[], int& size)
{
    if (size == 1)
        hugeInt[0] = 0;
    else
    {
        for (int i = 1; i < size; i++)
            hugeInt[i - 1] = hugeInt[i];

        size--;
        hugeInt[size] = 0;
    }
}