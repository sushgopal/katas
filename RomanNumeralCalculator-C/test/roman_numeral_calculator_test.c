#include<stdlib.h>
#include <check.h>
#include "../src/roman_numeral_calculator.h"

START_TEST(should_convert_first_arg_to_arabic)
{
    char* result = add("I","I");
    ck_assert(result=="abbc");
    //ck_assert_msg(1==2, "Expected 1 but was %d",2);
}
END_TEST

Suite* get_test_suite(void) {
    Suite *test_suite = suite_create("Roman Numeral Calculator");
    TCase *test_cases = tcase_create("Adding Roman Numerals");

    tcase_add_test(test_cases, should_convert_first_arg_to_arabic);
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
