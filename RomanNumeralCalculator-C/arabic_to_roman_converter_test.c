#include <stdlib.h>
#include <check.h>
#include "arabic_to_roman_converter_test.h"
#include "src/arabic_to_roman_converter.h"

void convert_to_roman_and_assert(int input, char* expected) {
  char* actual = convert_to_roman(input);
  ck_assert_str_eq(actual, expected);
}

START_TEST(_1_to_I) {  
  convert_to_roman_and_assert(1, "I");
}
END_TEST

START_TEST(_3_to_III) {
  convert_to_roman_and_assert(3, "III");
}
END_TEST

START_TEST(_4_to_IV) {
  convert_to_roman_and_assert(4, "IV");
}
END_TEST

START_TEST(_5_to_V) {
  convert_to_roman_and_assert(5, "V");
}
END_TEST

START_TEST(_9_to_IX) {
  convert_to_roman_and_assert(9, "IX");
}
END_TEST

START_TEST(_10_to_X) {
  convert_to_roman_and_assert(10, "X");
}
END_TEST

START_TEST(_45_to_XLV) {
   convert_to_roman_and_assert(45, "XLV");
}
END_TEST

START_TEST(_999_to_CMXCIX) {
  convert_to_roman_and_assert(999, "CMXCIX");
}
END_TEST

Suite* make_arabic_to_roman_converter_test_suite() {
    Suite *test_suite = suite_create("Arabic to Roman Numeral Converter");
    TCase *test_cases = tcase_create("should convert");

    tcase_add_test(test_cases, _1_to_I);
    tcase_add_test(test_cases, _3_to_III); 
    tcase_add_test(test_cases, _4_to_IV);
    tcase_add_test(test_cases, _5_to_V);
    tcase_add_test(test_cases, _10_to_X);
    tcase_add_test(test_cases, _45_to_XLV);
    tcase_add_test(test_cases, _999_to_CMXCIX);	

    suite_add_tcase(test_suite, test_cases);

    return test_suite;
}
