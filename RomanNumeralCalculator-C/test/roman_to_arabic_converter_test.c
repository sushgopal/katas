#include <stdlib.h>
#include <check.h>
#include "roman_to_arabic_converter_test.h"
#include "../src/roman_to_arabic_converter.h"

void convert_to_arabic_and_assert(char* roman, int expected) {
  int actual = convert_to_arabic(roman);
  ck_assert_int_eq(actual, expected);
}

START_TEST(_I_to_1) {  
   convert_to_arabic_and_assert("I", 1);
}
END_TEST

START_TEST(_III_to_3) {
   convert_to_arabic_and_assert("III", 3);
}
END_TEST

START_TEST(_IV_to_4) {
   convert_to_arabic_and_assert("IV", 4);
}
END_TEST

START_TEST(_V_to_5) {
   convert_to_arabic_and_assert("V", 5);
}
END_TEST

START_TEST(_IX_to_9) {
   convert_to_arabic_and_assert("IX", 9);
}
END_TEST

START_TEST(_X_to_10) {
   convert_to_arabic_and_assert("X", 10);
}
END_TEST

START_TEST(_XLV_to_45) {
   convert_to_arabic_and_assert("XLV", 45);
}
END_TEST

START_TEST(_CMXCIX_to_999) {
   convert_to_arabic_and_assert("CMXCIX", 999);
}
END_TEST

Suite* make_roman_to_arabic_converter_test_suite(void) {
  Suite *test_suite = suite_create("Roman to Arabic Numeral Converter");
  TCase *test_cases = tcase_create("should convert");

  tcase_add_test(test_cases, _I_to_1);
  tcase_add_test(test_cases, _III_to_3); 
  tcase_add_test(test_cases, _IV_to_4);
  tcase_add_test(test_cases, _V_to_5);
  tcase_add_test(test_cases, _IX_to_9);
  tcase_add_test(test_cases, _X_to_10);
  tcase_add_test(test_cases, _XLV_to_45);
  tcase_add_test(test_cases, _CMXCIX_to_999);	

  suite_add_tcase(test_suite, test_cases);

  return test_suite;
}
