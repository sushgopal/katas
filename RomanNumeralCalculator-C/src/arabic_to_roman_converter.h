#ifndef ARABIC_TO_ROMAN_H
#define ARABIC_TO_ROMAN_H

char* convert_to_roman(int arabic);

typedef struct ARABIC_TO_ROMAN {
   int    number;
   char*  roman;
} arabic_to_roman;

static const arabic_to_roman _1000_M = {1000, "M"};
static const arabic_to_roman _900_CM = {900, "CM"};
static const arabic_to_roman _500_D  = {500, "D"};
static const arabic_to_roman _400_CD = {400, "CD"};
static const arabic_to_roman _100_C  = {100, "C"};
static const arabic_to_roman _90_XC  = {90, "XC"};
static const arabic_to_roman _50_L   = {50, "L"};
static const arabic_to_roman _40_XL  = {40, "XL"};
static const arabic_to_roman _10_X   = {10, "X"};
static const arabic_to_roman _9_IX   = {9, "IX"};
static const arabic_to_roman _5_V    = {5, "V"};
static const arabic_to_roman _4_IV   = {4, "IV"};
static const arabic_to_roman _1_I    = {1, "I"};

#endif
