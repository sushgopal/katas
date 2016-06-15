#include <check.h>
#include "../src/roman_numeral_calculator.h"

START_TEST(test_roman_numeral_calculator_create) {
	ck_assert(1==2);
}
END_TEST

Suite * get_test_suite(void) {
    Suite *test_suite = suite_create("Roman Numeral Calculator");
    TCase *test_cases = tcase_create("Core");

    tcase_add_test(test_cases, test_roman_numeral_calculator_create);
    suite_add_tcase(test_suite, test_cases);

    return test_suite;
}

int main(void) {
    int number_failed;

    Suite *test_suite = get_test_suite();
    SRunner *sr = srunner_create(test_suite);

    srunner_run_all(sr, CK_ENV);
    number_failed = srunner_ntests_failed(sr);
    srunner_free(sr);
    return (number_failed == 0) ? 0 : 1;
}
