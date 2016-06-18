LIBS=-lcheck_pic -pthread -lrt -lm -lsubunit
SRC=src
TEST=test
OBJ1=roman_to_arabic_converter.o roman_to_arabic_converter_test.o
OBJ2=arabic_to_roman_converter.o arabic_to_roman_converter_test.o
OBJ3=roman_numeral_calculator.o roman_numeral_calculator_test.o
OBJ4=run_tests.o

GCC_OPTIONS=-Wall -c

%.o: $(SRC)/%.c $(SRC)/%.h
	gcc $(GCC_OPTIONS) $<

tests: run-tests
	./run-tests

run-tests: $(OBJ1)
	gcc -o $@ $^ $(LIBS)

clean: $(OBJECTS)
	rm *.o
