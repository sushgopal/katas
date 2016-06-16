#include <stdlib.h>
#include <check.h>
#include "src/arabic_to_roman_converter.h"

START_TEST(one_to_I)
{
    char* result = convert(1);
    ck_assert_str_eq(result, "I");
}
END_TEST

START_TEST(two_to_II)
{
    char* result = convert(2);
    ck_assert_str_eq(result, "II");
}
END_TEST

START_TEST(three_to_III)
{
    char* result = convert(3);
    ck_assert_str_eq(result, "III");
}
END_TEST

Suite* get_test_suite(void) {
    Suite *test_suite = suite_create("Arabic to Roman Numeral Converter");
    TCase *test_cases = tcase_create("should convert");

    tcase_add_test(test_cases, one_to_I);
    tcase_add_test(test_cases, two_to_II);
    tcase_add_test(test_cases, three_to_III);
    suite_add_tcase(test_suite, test_cases);

    return test_suite;
}

int main(void) {
    int number_failed;

    Suite *test_suite = get_test_suite();
    SRunner *sr = srunner_create(test_suite);

    srunner_run_all(sr, CK_NORMAL);
    number_failed = srunner_ntests_failed(sr);
    srunner_free(sr);
    return (number_failed == 0) ? 0 : 1;
}
