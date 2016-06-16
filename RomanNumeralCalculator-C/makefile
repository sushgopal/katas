LIBS=-lcheck_pic -pthread -lrt -lm -lsubunit
SRC=src
TEST=test
OBJECTS=roman_to_arabic_converter.o arabic_to_roman_converter.o arabic_to_roman_converter_test.o roman_numeral_calculator.o
GCC_OPTIONS=-Wall -c

%.o: $(SRC)/%.c $(SRC)/%.h
	gcc $(GCC_OPTIONS) $<

tests: roman-numeral-calculator
	./roman-numeral-calculator

roman-numeral-calculator: $(OBJECTS)
	gcc -o $@ $^ $(LIBS)

clean: $(OBJECTS)
	rm *.o
