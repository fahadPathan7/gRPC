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