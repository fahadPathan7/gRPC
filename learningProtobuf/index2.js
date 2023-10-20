const Schema = require('./employees_pb');
const fs = require('fs');

const employee = new Schema.Employee();
employee.setId(1001);
employee.setName('Fahad Pathan');
employee.setSalary(50000);

// console.log(employee.getId());

// another employee
const employee2 = new Schema.Employee();
employee2.setId(1002);
employee2.setName('John Doe');
employee2.setSalary(60000);

// another employee
const employee3 = new Schema.Employee();
employee3.setId(1003);
employee3.setName('Jane Doe');
employee3.setSalary(70000);


// create an array of employees
const employees = new Schema.Employees();
employees.addEmployees(employee);
employees.addEmployees(employee2);
employees.addEmployees(employee3);

// serialize the object to binary
const bytes = employees.serializeBinary();
console.log(bytes);
fs.writeFileSync('./learningProtobuf/employeesBinary', bytes);


// deserialize the binary to object
const employees2 = Schema.Employees.deserializeBinary(bytes);
console.log(employees2.toString());