#include <stdlib.h>
#include <check.h>
#include "src/roman_numeral_calculator.h"
#include "roman_numeral_calculator_test.h"

START_TEST(add_two_arabic_numerals){
  char* result = add("C","LXII");
  ck_assert_str_eq(result, "CLXII");
  free(result);
}
END_TEST

START_TEST(subtract_two_arabic_numerals) {
  char* result = subtract("XLIII", "XVII");
  ck_assert_str_eq(result, "XXVI");
  free(result);
}
END_TEST

START_TEST(subtract_two_arabic_numerals_irrespective_of_order) {
  char* result = subtract("II","IX");
  ck_assert_str_eq(result, "VII");
  free(result);
}
END_TEST

Suite* make_roman_numeral_calculator_test_suite() {
  Suite *test_suite = suite_create("Roman Numeral Calculator");
  TCase *test_cases = tcase_create("should");

  tcase_add_test(test_cases, add_two_arabic_numerals);
  tcase_add_test(test_cases, subtract_two_arabic_numerals);
  tcase_add_test(test_cases, subtract_two_arabic_numerals_irrespective_of_order);

  suite_add_tcase(test_suite, test_cases);

  return test_suite;
}
