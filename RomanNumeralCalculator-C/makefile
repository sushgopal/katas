LIBS=-lcheck_pic -pthread -lrt -lm -lsubunit
GCC_OPTIONS=-Wall -c
SRC=src
TEST=test
OBJECTS=roman_to_arabic_converter.o roman_to_arabic_converter_test.o \
        arabic_to_roman_converter.o arabic_to_roman_converter_test.o \
        roman_numeral_calculator.o roman_numeral_calculator_test.o \
        tests_runner.o

%.o: $(SRC)/%.c $(SRC)/%.h $(SRC)/arabic_roman_map.h
	gcc $(GCC_OPTIONS) $<

tests: run-tests
	./run-tests

run-tests: $(OBJECTS)
	gcc -o $@ $^ $(LIBS)

clean:
	rm $(OBJECTS) run-tests
