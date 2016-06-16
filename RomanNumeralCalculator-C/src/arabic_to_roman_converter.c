#include <stdlib.h>
#include <string.h>
#include "arabic_to_roman_converter.h"

char* convert(int arabic_numeral) {
	char *roman_numeral = (char *) malloc(20);
	int i=0;
	while(i < arabic_numeral) {
		roman_numeral[i]='I';
		i++;
	}
	
	roman_numeral[i]='\0';
	return roman_numeral;
}
