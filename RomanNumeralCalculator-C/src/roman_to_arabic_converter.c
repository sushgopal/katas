#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>
#include "arabic_to_roman_converter.h"
#include "arabic_roman_map.h"

static char NULL_CHARACTER = '\0';
static int NO_LENGTH = 0;
static int FIRST_INDEX = 0;
static int DEFAULT_RESULT = 0;

static bool is_empty(const char* string);
static bool string_ends_with(const char* main, const char* substring);
static void remove_from_end(char** to_remove_from, const char* to_remove);
static char* substring(const char* src, const int length);

int convert_to_arabic(char* roman) {
  int result = DEFAULT_RESULT;
  int i;
  
  while(!is_empty(roman)) {
    for(i=ARABIC_TO_ROMAN_MAP_SIZE-1; i>=FIRST_INDEX; i--) {
      if(string_ends_with(roman, map[i].roman)) {
        result = result + map[i].number;
        remove_from_end(&roman, map[i].roman);
        break;
      }
    }
  }
  
  return result;
}

static bool is_empty(const char* string) {
  return strlen(string) == NO_LENGTH;
}

static bool string_ends_with(const char* main, const char* substring) {
  int main_length = strlen(main);
  int substring_length = strlen(substring);
  
  if(substring_length > main_length) {
    return false;
  }

  int i = main_length - 1;
  int j = substring_length -1;

  while(i>=FIRST_INDEX && j>=FIRST_INDEX) {
    if(toupper(main[i]) != substring[j]) {
      return false;
    }
    i--;
    j--;
  }
  return true;
}

static void remove_from_end(char** to_remove_from, const char* to_remove) {
  int length_to_remove = strlen(to_remove);
  int length_of_result = strlen(*to_remove_from) - length_to_remove;  

  char* result = substring(*to_remove_from, length_of_result);
  *to_remove_from = result;
}

static char* substring(const char* source, const int length) {
  int i;
  char* result = (char*) calloc(strlen(source), sizeof(char));
  
  for(i=FIRST_INDEX; i<length; i++) {
    result[i] = source[i];
  }
  result[i] = NULL_CHARACTER;
  
  return result;
}

