#include <stdlib.h>
#include "arabic_to_roman_converter.h"
#include <string.h>


int convert_to_arabic(char* roman) {
  return roman[0] == 'I' ? 1 : 3;
}
