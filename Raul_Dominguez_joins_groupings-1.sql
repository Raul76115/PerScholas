#USE classicmodels;
/*1. Write a query to display each customer’s name (as “Customer Name”) alongside the name of the
 employee who is responsible for that customer’s orders. The employee name should be in a single 
 “Sales Rep” column formatted as “lastName, firstName”. The output should be sorted alphabetically 
 by customer name.*/

SELECT customerName AS 'Customer Name',  CONCAT(lastName,", ",firstName) AS 'Sales Rep'
FROM customers
JOIN employees ON customers.salesRepEmployeeNumber = employees.employeeNumber
ORDER BY customerName;

/*2. Determine which products are most popular with our customers. For each product, list the total 
quantity ordered along with the total sale generated (total quantity ordered * buyPrice) for that 
product. The column headers should be “Product Name”, “Total # Ordered” and “Total Sale”. List the 
products by Total Sale descending.*/

SELECT productName AS 'Product Name', SUM(quantityOrdered) AS 'Total # Ordered', 
(SUM(quantityOrdered) * buyPrice) AS 'Total Sale'
FROM products 
JOIN orderdetails ON (products.productCode = orderdetails.productCode)
GROUP BY productName
ORDER BY (SUM(quantityOrdered) * buyPrice) DESC;



/*3. Write a query which lists order status and the # of orders with that status. Column headers 
should be “Order Status” and “# Orders”. Sort alphabetically by status.*/

SELECT status AS 'Order Status',
COUNT(
CASE 
	WHEN status = 'Shipped' THEN 1 
	WHEN status = 'Resolved' THEN 1
	WHEN status = 'Cancelled' THEN 1 
	WHEN status = 'On Hold' THEN 1
	WHEN status = 'Disputed' THEN 1
	WHEN status = 'In Process' THEN 1
END) AS '# Orders'
FROM orders
GROUP BY status
ORDER BY status;



/*4. Write a query to list, for each product line, the total # of products sold from that product line. 
The first column should be “Product Line” and the second should be “# Sold”. Order by the second column
 descending.*/

SELECT productLine AS 'Product Line',SUM(quantityOrdered) AS '# Sold'
FROM products 
JOIN orderDetails ON products.productCode = orderDetails.productCode
GROUP BY productLine
ORDER BY SUM(quantityOrdered) DESC;
 

 

/*5. For each employee who represents customers, output the total # of orders that employee’s customers
 have placed alongside the total sale amount of those orders. The employee name should be output as a 
 single column named “Sales Rep” formatted as “lastName, firstName”. The second column should be titled
 “# Orders” and the third should be “Total Sales”. Sort the output by Total Sales descending. Only (and
 all) employees with the job title ‘Sales Rep’ should be included in the output, and if the employee ma
 de no sales the Total Sales should display as “0.00”.*/

SELECT CONCAT(lastName,', ', firstName) AS 'Sales Rep', COALESCE(SUM(quantityOrdered), 0) AS '# Orders',
COALESCE(SUM(quantityOrdered) * buyPrice, 0.00) AS Total_Sales 
FROM customers c 
RIGHT JOIN employees e ON c.salesRepEmployeeNumber = e.employeeNumber  
LEFT JOIN orders o ON o.customerNumber = c.customerNumber
LEFT JOIN orderdetails od ON od.orderNumber = o.orderNumber
LEFT JOIN products p ON od.productCode = p.productCode
WHERE jobTitle = 'Sales Rep'
GROUP BY CONCAT(lastName,', ', firstName)
UNION 
SELECT CONCAT(lastName,', ', firstName) AS 'Sales Rep', COALESCE(SUM(quantityOrdered),0) AS '# Orders',
COALESCE(SUM(quantityOrdered) * buyPrice, 0.00) AS Total_Sales 
FROM customers c 
LEFT JOIN employees e ON c.salesRepEmployeeNumber = e.employeeNumber 
LEFT JOIN orders o ON o.customerNumber = c.customerNumber
LEFT JOIN orderdetails od ON od.orderNumber = o.orderNumber
LEFT JOIN products p ON od.productCode = p.productCode
WHERE jobTitle = 'Sales Rep'
GROUP BY CONCAT(lastName,', ', firstName)
ORDER BY Total_Sales DESC;

/*6. Your product team is requesting data to help them create a bar-chart of monthly sales since the 
company’s inception. Write a query to output the month (January, February, etc.), 4-digit year, and 
total sales for that month. The first column should be labeled ‘Month’, the second ‘Year’, and the 
third should be ‘Payments Received’. Values in the third column should be formatted as numbers with 
two decimals – for example: 694,292.68.*/

SELECT 
CASE WHEN MONTH(paymentDate)=1 THEN 'January'
	WHEN MONTH(paymentDate)=2 THEN 'February'
    WHEN MONTH(paymentDate)=3 THEN 'March'
    WHEN MONTH(paymentDate)=4 THEN 'April'
    WHEN MONTH(paymentDate)=5 THEN 'May'
    WHEN MONTH(paymentDate)=6 THEN 'June'
    WHEN MONTH(paymentDate)=7 THEN 'July'
    WHEN MONTH(paymentDate)=8 THEN 'August'
    WHEN MONTH(paymentDate)=9 THEN 'September'
    WHEN MONTH(paymentDate)=10 THEN 'October'
    WHEN MONTH(paymentDate)=11 THEN 'November'
    WHEN MONTH(paymentDate)=12 THEN 'December'
    END AS 'Month',
YEAR(paymentDate) AS 'Year', 
FORMAT(SUM(amount),2) AS 'Payments Received'
FROM payments
GROUP BY MONTH(paymentDate),YEAR(paymentDate)
ORDER BY YEAR(paymentDate), MONTH(paymentDate) ASC;

