#include <stdlib.h>
#include "roman_numeral_calculator.h"
#include "arabic_to_roman_converter.h"
#include "roman_to_arabic_converter.h"

char* add(char* a, char* b) {
  int m = convert_to_arabic(a);
  int n = convert_to_arabic(b);
  return convert_to_roman(m+n);
}

char* subtract(char* a, char* b) {
  int m = convert_to_arabic(a);
  int n = convert_to_arabic(b);
  return convert_to_roman(abs(m-n));
}
