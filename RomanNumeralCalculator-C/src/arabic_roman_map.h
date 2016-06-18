#ifndef ARABIC_TO_ROMAN_MAP
#define ARABIC_TO_ROMAN_MAP
  typedef struct ARABIC_TO_ROMAN_MAP {
    int    number;
    char*  roman;
  } arabic_to_roman_map;
  
  static const int ARABIC_TO_ROMAN_MAP_SIZE = 13;

  static arabic_to_roman_map map[13]  = {{1000, "M"}, {900, "CM"}, {500, "D"}, {400, "CD"}, {100, "C"}, {90, "XC"}, {50, "L"}, {40, "XL"}, {10, "X"}, {9, "IX"}, {5, "V"}, {4, "IV"}, {1, "I"}};
#endif
