const fs = require("fs") // importing the file system module. This module is used to read and write files


const employees = []

// one way to add an employee
employees.push({
    "name": "Fahad",
    "id": 1,
    "salary": 1000
})

// another way to add an employee
const pathan = {
    "name": "Pathan",
    "id": 2,
    "salary": 2000
}
employees.push(pathan)


// printing the employees
console.log(employees)
/* output
[
  { name: 'Fahad', id: 1, salary: 1000 },
  { name: 'Pathan', id: 2, salary: 2000 }
]
*/

// stringifying the employees
console.log(JSON.stringify(employees))
/* output
[{"name":"Fahad","id":1,"salary":1000},{"name":"Pathan","id":2,"salary":2000}]
*/

// writing the employees to a file
fs.writeFileSync("./learningProtobuf/employees.json", JSON.stringify(employees)) // this will create a file named employees.json and write the employees array to it.