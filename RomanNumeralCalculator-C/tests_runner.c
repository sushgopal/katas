#include <check.h>
#include "arabic_to_roman_converter_test.h"
#include "roman_to_arabic_converter_test.h"
#include "roman_numeral_calculator_test.h"

int main(void) {
  int failed_tests_count;

  Suite *arabic_to_roman_converter_test_suite = make_arabic_to_roman_converter_test_suite();
  Suite *roman_to_arabic_converter_test_suite = make_roman_to_arabic_converter_test_suite();
  Suite *roman_numeral_calculator_test_suite = make_roman_numeral_calculator_test_suite();
  
  SRunner *runner = srunner_create(arabic_to_roman_converter_test_suite);
  srunner_add_suite(runner, roman_to_arabic_converter_test_suite);
  srunner_add_suite(runner, roman_numeral_calculator_test_suite);  
  
  srunner_run_all(runner, CK_VERBOSE);
  
  failed_tests_count = srunner_ntests_failed(runner);
  
  srunner_free(runner);
  return (failed_tests_count == 0) ? 0 : 1;
}
