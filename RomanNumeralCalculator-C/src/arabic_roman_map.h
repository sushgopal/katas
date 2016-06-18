#ifndef ARABIC_TO_ROMAN_MAP
#define ARABIC_TO_ROMAN_MAP
  typedef struct ARABIC_TO_ROMAN_MAP {
    int    number;
    char*  roman;
  } arabic_to_roman_map;

  static const arabic_to_roman_map _1000_M = {1000, "M"};
  static const arabic_to_roman_map _900_CM = {900, "CM"};
  static const arabic_to_roman_map _500_D  = {500, "D"};
  static const arabic_to_roman_map _400_CD = {400, "CD"};
  static const arabic_to_roman_map _100_C  = {100, "C"};
  static const arabic_to_roman_map _90_XC  = {90, "XC"};
  static const arabic_to_roman_map _50_L   = {50, "L"};
  static const arabic_to_roman_map _40_XL  = {40, "XL"};
  static const arabic_to_roman_map _10_X   = {10, "X"};
  static const arabic_to_roman_map _9_IX   = {9, "IX"};
  static const arabic_to_roman_map _5_V    = {5, "V"};
  static const arabic_to_roman_map _4_IV   = {4, "IV"};
  static const arabic_to_roman_map _1_I    = {1, "I"};
#endif
