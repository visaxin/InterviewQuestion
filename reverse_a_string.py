#solution_1
my_string = "abandon"

my_reversed_string = my_string[::-1]

print my_reversed_string

#solution_2

def reverse(text):
	if len(text)<=1:
		return text
	return reverse(text[1:])+text[0]
#test

my_string_two = "abandon"

print reverse(my_string_two)

#solution_3

def reverse_two(text):
	reversed_string = ""
	i=1
	while (i <= len(text)):
		reversed_string +=text[len(text)-i]
		i+=1
	return reversed_string
#test

my_string_three = "abandon"

print reverse_two(my_string_three)