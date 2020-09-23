/* esto también	
	es un 
		comentario */

// Ejemplos de nombres de variables válidos
let usuario; 
let Prueba;
let _apellido;
let $edad;
let camelCase;
let nombreApellido;
let snake_case;
let nombre_apellido;
let PascalCase; 
let NombreApellido;

/* Ejemplos de nombres de variables incorrectos
let 123nombre;
let nombre-apellido;
let break;
let class;
let super;
let this;
let new; */

console.log("----- var, let y const -----");

// var
var miNombre; 
miNombre = "Aylén";
// var miNombre = "Rosa"; es válido

// let 
let miEdad = 21;
miEdad = 50;
// let miEdad = 60; error
console.log("Tengo " + miEdad + " años" );

// const usuario2;  error las constantes se inicializan siempre
const usuario2 = "Pepe";
// usuario2 = "Juan"; error las constantes no se pueden reasignar

let variableGlobal;

function Ejemplo() {
	let variableLocal; 
	/*
		ámbito de mi variableLocal 
	*/
}

console.log("----- tipos de datos -----");

// string
let str = "String con comillas dobles";
let str2 = 'String con comillas simples';
let str3 = `String con acento agudo`; // alt+96
let str4 = `${str} y ${str2}`; // let str4 = str + " y " + str2;

// number
let num = 123; // número entero
let num2 = 10.20;
let num3 = -80;
console.log("no es un número"*2); // NaN -> Not a Number
let num4 = num * num2;
let num5 = num3 / num4;
let num6 = num + num2;
let num7 = num3 - num4;

// boolean
let soyVerdadero = true;
let soyFalso = false;
let soyMayor = 4>1;
console.log(soyMayor); // true

// null
let valorAdefinir = null;
valorAdefinir = 90;

// undefined
let sinDefinir;

/* alert("Hola"); // pasamos un contenido y muestra un mensaje
prompt("¿Cómo te llamas?"); // pedirle datos al usuario */

// alert("Hola " + prompt("¿Cómo te llamas?"));

// let username = prompt("¿Cómo te llamas?"); // la diferencia es que username va a quedar guardado en un espacio de memoria.
// alert("Hola " + username);

console.log("Hola, Mundo!"); // muestra un mensaje en la consola
console.error("Este es un mensaje de error");
console.warn("Este es un mensaje de advertencia");
console.info
("Este es un mensaje de información");
// console.clear(); 
document.write("<h1> Introducción a JavaScript </h1>"); // escribir cosas en nuestro html
// objeto.funcion();

console.log("----- funciones string -----");

// string.length()
let cantidad = 'asdfg'; // 5
console.log(cantidad.length);

// string.repeat(n)
let repetir = "bla "
let repetir7 = repetir.repeat(7)
console.log(repetir7)

// string.replace(str1,str2) (valor q busca, valor q reemplaza)
let hola = "hola";
console.log(hola);
console.log(hola.replace("hola", "chau"));