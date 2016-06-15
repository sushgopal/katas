tests: roman-numeral-calculator-test
	./roman-numeral-calculator-test

roman-numeral-calculator-test: roman_numeral_calculator_test.o roman_numeral_calculator.o
	gcc -o roman-numeral-calculator-test roman_numeral_calculator.o roman_numeral_calculator_test.o -lcheck_pic -pthread -lrt -lm -lsubunit

roman_numeral_calculator_test.o: test/roman_numeral_calculator_test.c src/roman_numeral_calculator.h
	gcc -Wall -c test/roman_numeral_calculator_test.c

roman_numeral_calculator.o: src/roman_numeral_calculator.c src/roman_numeral_calculator.h
	gcc -Wall -c src/roman_numeral_calculator.c
