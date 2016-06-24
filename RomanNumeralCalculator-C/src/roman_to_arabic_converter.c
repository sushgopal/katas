#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include "arabic_to_roman_converter.h"
#include "arabic_roman_map.h"

static bool is_empty(char* string);
static bool string_ends_with(char* main, char* substring);
static void remove_from_end(char** to_remove_from, char* to_remove);
static char* substring(char* src, int length);

int convert_to_arabic(char* roman) {
  int result = 0;
  int i;
  
  while(!is_empty(roman)) {
    for(i=ARABIC_TO_ROMAN_MAP_SIZE-1; i>=0; i--) {
      if(string_ends_with(roman, map[i].roman)) {
        result = result + map[i].number;
        remove_from_end(&roman, map[i].roman);
        break;
      }
    }
  }
  
  return result;
}

static bool is_empty(char* string) {
  return strlen(string) == 0;
}

static bool string_ends_with(char* main, char* substring) {
  int main_length = strlen(main);
  int substring_length = strlen(substring);
  
  if( substring_length > main_length ) {
    return false;
  }

  int i = main_length - 1;
  int j = substring_length -1;

  while( i>=0 && j>=0 ) {
    if(main[i] != substring[j]) {
      return false;
    }
    i--;
    j--;
  }
  return true;
}

static void remove_from_end(char** to_remove_from, char* to_remove) {
  int length_to_remove = strlen(to_remove);
  int length_of_result = strlen(*to_remove_from) - length_to_remove;  

  char* result = substring(*to_remove_from, length_of_result);
  *to_remove_from = result;
}

static char* substring(char* source, int length) {
  int i;
  char* result = (char*) calloc(strlen(source), sizeof(char));
  
  for(i=0; i<length; i++) {
    result[i] = source[i];
  }
  result[i] = '\0';
  
  return result;
}

