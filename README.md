# I-O-CSV-File
My objective with this was to code a program that loaded the data from a CSV file, cleaned the data using the validation rules specified below, and write it to two different output files, in two different formats.

I focused more on code quality rather than performance.

The program does the following: 
1. Reads data from the CSV file `hotels.csv`. The first line is a header which describes all field names. Headers are hotel_name, hotel_address, hotel_rating, contact, hotel_phone, and hotel_url. 
2. Validates the data. Kept it simple, with the following rules: 
- A hotel name may only contain UTF-16 characters.
- The hotel URL must be valid (came up with my own definition what it means to be "valid").
- Hotel ratings are given as a number from 0 to 5 stars.
- There may be no negative numbers.
3. Wrote the valid data in two formats: HTML and EXCEL. The output was in the same directory as the input.
