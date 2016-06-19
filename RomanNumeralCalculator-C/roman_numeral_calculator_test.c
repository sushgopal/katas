#include<stdlib.h>
#include <check.h>
#include "src/roman_numeral_calculator.h"
#include <stdio.h>

START_TEST(add_two_arabic_numerals){
  char* result = add("C\0","LXII\0");
  ck_assert_str_eq(result, "CLXII");
  free(result);
}
END_TEST

START_TEST(subtract_two_arabic_numerals) {
  char* result = subtract("XLIII\0", "I\0");
  ck_assert_str_eq(result, "XLII");
  free(result);
}
END_TEST

Suite* make_roman_numeral_calculator_test_suite(void) {
  Suite *test_suite = suite_create("Roman Numeral Calculator");
  TCase *test_cases = tcase_create("should ");

  tcase_add_test(test_cases, add_two_arabic_numerals);
  tcase_add_test(test_cases, subtract_two_arabic_numerals);

  suite_add_tcase(test_suite, test_cases);

  return test_suite;
}

int main(void) {
  int number_failed;

  Suite *test_suite = make_roman_numeral_calculator_test_suite();
  SRunner *sr = srunner_create(test_suite);

  srunner_run_all(sr, CK_NORMAL);
  number_failed = srunner_ntests_failed(sr);
  srunner_free(sr);
  return (number_failed == 0) ? 0 : 1;
}
