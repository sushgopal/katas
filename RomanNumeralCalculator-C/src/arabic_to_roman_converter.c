#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include "arabic_to_roman_converter.h"
#include "arabic_roman_map.h"

static bool is_zero(int n);
static bool is_greater_than_equal_to(int x, int y);
static void add_roman_character_to_result(char* result, char* roman_character);
static void decrement_current_number(int *current_number, int decrement_by);
static char* convert(int current_number, char* result);

char* convert_to_roman(int arabic) {
  char *roman = (char *) calloc(10, sizeof(char));
  return convert(arabic, roman);
}			

static char* convert(int current_number, char* result) {     
  if(is_zero(current_number)) {
    return result;
  }

  int counter;
  for(counter=0; counter < ARABIC_TO_ROMAN_MAP_SIZE; counter++) {
    
    if(is_greater_than_equal_to(current_number, map[counter].number)) {

      add_roman_character_to_result(result, map[counter].roman);
      decrement_current_number(&current_number, map[counter].number);

      return convert(current_number, result);
    }

  }

  return "Error occurred during arabic to roman numeral conversion!";
}

static bool is_zero(int n) {
  return n == 0;
}

static bool is_greater_than_equal_to(int x, int y) {
  return x >= y;
}

static void add_roman_character_to_result(char* result, char* roman_character) {
  strcat(result, roman_character);
}
 
static void decrement_current_number(int *current_number, int decrement_by) {
  *current_number-=decrement_by;
}

