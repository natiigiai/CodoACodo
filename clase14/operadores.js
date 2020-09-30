console.log("----------------- Operadores Aritméticos------------");

const num1 = 10;
const num2 = 20;

// Suma
console.log(num1 + num2);
// Resta
console.log(num2 - num1);
// Multiplicación
console.log(num1 * num2);
// División
console.log(num2 / num1);
// Modulo
console.log(num2 % num1);

// Incremento y Decremento
let x = 5;
let y = 2;
/* console.log("El valor inicial de x es: " + x); // 5
console.log("El valor de ++x es: " + ++x); // 6
console.log("El valor inicial de y es: " + y); // 2
console.log("El valor de --y es: " + --y); // 1 */
console.log("El valor inicial de x es: " + x); // 5
console.log("El valor de x++ es: " + x++); // 5
console.log(x); // Recién acá se implementa el incremento
console.log("El valor inicial de y es: " + y); // 2
console.log("El valor de y-- es: " + y--); // 2
console.log(y); // Recién acá se implementa el decremento


console.log("----------------- Operadores Relacionales ------------");
// >, <, <=, >=, !=, ==
console.log(num2 > num1); // 20 > 10 -> true
console.log(num2 < num1); // 20 < 10 -> false
console.log(num2 >= num1); // 20 >= 10 -> true
console.log(num2 <= num1); // 20 <= 10 -> false
console.log(num2 != num1); // 20 != 10 -> true
console.log(num2 == num1); // 20 == 10 -> false 


console.log("----------------- Operadores Lógicos ------------");
// Operador "AND", Operador "OR", Operador "NOT"
console.log(num2 != num1 && num1 < num2); // true
console.log(num2 == num1 || num2 < num1); // false
console.log(!(num1 == 20)); // true


console.log("----------------- Operadores de Asignación ------------");
// = | += | -= | *= | /= | %= 
let n = 2
n+=5 // n = 2 + 5

let a = 10;
console.log("El valor inicial de a es: " + a);
a += 3; // a = a + 3
console.log("El nuevo valor de a es: " + a); // 13
a -= 3; // a = a - 3 (ahora a vale 13)
console.log("El nuevo valor de a es: " + a); // 10 
a *= 3; // a = a * 3 (ahora a vale 10)
console.log("Ahora el valor de a es: " + a); // 30
a /= 3; // a = a / 3 (ahora a vale 30)
console.log("Y ahora vale: " + a); // 10
a %= 3; // a = a % 3 (ahora a vale 10)
console.log("Por último, a vale: " + a); // 1  


console.log("----------------- Operador typeof ------------");
let tipoNumerico = 10; // number
let tipoBooleano = false; // boolean
let tipoString = "Ejemplo de una cadena"; // string
let tipoUndefined; // undefined

console.log(typeof tipoNumerico);
console.log(typeof tipoBooleano);
console.log(typeof tipoString);
console.log(typeof tipoUndefined);