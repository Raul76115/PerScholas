#USE classicmodels;

/*1. Write a query to display the name, product line, and buy price of all products. The output
 columns should display as “Name”, “Product Line”, and “Buy Price”. The output should display 
 the most expensive items first.*/
 
 SELECT productName AS 'Name', productLine AS 'Product Line', buyPrice AS 'Buy Price' 
 FROM products 
 ORDER BY buyPrice DESC;
 
 /*2. Write a query to display the first name, last name, and city for all customers from Germany. 
 Columns should display as “First Name”, “Last Name”, and “City”. The output should be sorted by
the customer’s last name (ascending).*/

SELECT contactFirstName AS 'First Name', contactLastName AS 'Last Name', city AS 'City' 
FROM customers
WHERE country = 'Germany';

/*3. Write a query to display each of the unique values of the status field in the orders table. 
The output should be sorted alphabetically increasing. Hint: the output should show exactly 6 rows.*/

SELECT DISTINCT status AS 'Status'
FROM orders
ORDER BY status; 

/*4. Select all fields from the payments table for payments made on or after January 1, 2005. Output 
should be sorted by increasing payment date.*/

SELECT * 
FROM payments 
WHERE paymentDate > '2005-01-01'
ORDER BY paymentDate;

/*5. Write a query to display all Last Name, First Name, Email and Job Title of all employees working in
the San Francisco office. Output should be sorted by last name.*/

SELECT lastName AS 'Last Name', firstName AS 'First Name', email AS 'Email', jobTitle AS 'Job Title' 
FROM employees
WHERE officeCode = (SELECT officeCode FROM offices WHERE city = 'San Francisco')
ORDER BY lastName;

/*6. Write a query to display the Name, Product Line, Scale, and Vendor of all of the car products – both
 classical and vintage. The output should display all vintage cars first (sorted alphabetically by name), 
 and all classical cars last (also sorted alphabetically by name).*/
 
SELECT SUBSTRING(productName,5) AS 'Name', productLine AS 'Product Line', productScale AS 'Scale', productVendor AS 'Vendor'
FROM products
WHERE productLine IN ('Classic Cars', 'Vintage Cars')
ORDER BY productLine DESC, SUBSTRING(productName,5);
 
 