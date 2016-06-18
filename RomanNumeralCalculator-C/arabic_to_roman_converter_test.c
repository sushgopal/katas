#include <stdlib.h>
#include <check.h>
#include "src/arabic_to_roman_converter.h"

void run_test_and_assert(int input, char* expected) {
    char* actual = convert_to_roman(input);
    ck_assert_str_eq(actual, expected);
}

START_TEST(_1_to_I) {  
    run_test_and_assert(1, "I");
}
END_TEST

START_TEST(_3_to_III) {
    run_test_and_assert(3, "III");
}
END_TEST

START_TEST(_4_to_IV) {
    run_test_and_assert(4, "IV");
}
END_TEST

START_TEST(_5_to_V) {
    run_test_and_assert(5, "V");
}
END_TEST

START_TEST(_10_to_X) {
    run_test_and_assert(10, "X");
}
END_TEST

START_TEST(_45_to_XLV) {
     run_test_and_assert(45, "XLV");
}
END_TEST

START_TEST(_999_to_CMXCIX) {
     run_test_and_assert(999, "CMXCIX");
}
END_TEST

Suite* make_arabic_to_roman_converter_test_suite(void) {
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

int main(void) {
    int number_failed;

    Suite *test_suite = make_arabic_to_roman_converter_test_suite();
    SRunner *sr = srunner_create(test_suite);

    srunner_run_all(sr, CK_NORMAL);
    number_failed = srunner_ntests_failed(sr);
    srunner_free(sr);
    return (number_failed == 0) ? 0 : 1;
}
