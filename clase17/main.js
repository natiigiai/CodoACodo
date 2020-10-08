//////////////////////Strings
///
///
///
console.log('includes');
let email = "natiigiai@gmail.com";
if(email.includes("@")){
	console.log('La dirección de correo electrónico es valido')
} else {
	console.log('Ingrese una dirección de correo electronico válido')
}

console.log('trim - trinEnd - trimStart');
/*quitar espacios en blanco*/
let userName = "      name123         ";
console.log(userName);
console.log(userName.trim());
console.log(userName.trimStart());
console.log(userName.trimEnd());

console.log('Substring (inicio, fin) ')
//corta texto
let cortar = "Vamos a cortar este string";
console.log(cortar);
console.log(cortar.substring(0,5));

console.log('split');
//corta un strng por el patron indicado
//
let txt = "lorem ipsum dolor sit amet";
console.log(txt.split(" ")); //cada vez que encuentra un espacio crea un nuevo elemento
console.log(txt.split(" ",3));

console.log(txt.charAt(0)); //devuelve el valor que hay en una posicion

console.log('repeat'); //repite la cantidad de veces que indicamos
let repetir = "JavaScript ";
console.log(repetir.replace(4));


///////ejemplos

console.log('forEach()');
let arreglo = [1,2,3,4,5,6,7,8,9,10];
arreglo.forEach(function(elemento, index, arreglo)){
	console.log(elemento); //obligatorio
	console.log(index);
	console.log(arreglo);
}

arreglo.forEach(elemento => { 
	console.log(elemento)
});

for (arreglo; arreglo <= 10; arreglo++) {
	console.log(arreglo);
}

////every()    vrifica si todos los valores cumplen una determinada condicion. Devuelve un booleano
///
const nros = [8,13,56,77,2,17,64];
function menorA100(numeros){
	return numeros<100;
}

console.log(nros.every(menorA100));

console.log(nros.every(n => n<50));

//some() devuelve true si alguno de los eleentos del array cumple la condicion

let num = [20,1,3,58,66,135,324,756,0];
console.log(num.some(numero => numero >10));


//map
//similar a foreach. pero a diferencia de foreach devuelve un arreglo nuevo
const pares = [2,4,6,8,10,12,14,16,18,20,22,24,26,28,30];
const impares = pares.map((nro)=> nro+1);
console.log(pares);
console.log(impares);

const numeros2 = [2,3,4,8];
const potencia = numeros2.map((numero)=>Math.pow(numero, 2));
console.log(numeros2);
console.log(potencia);

let lista = ["home", "about", "proyect", "contact"];
let nav = lista.map((item) => '<li>${item}</li>');
document.write(nav.join(' '));


console.log('find()'); //devuelve el primer elemento del arreglo que cumple la condicion pasada por parametro
const buscar = [30,34,50,100];
const x = buscar.find(elemento => elemento > 20);
console.log(x);
let peliculas = ["Shrek", "Harry Potter", "Star Trek"];
let hp = peliculas.find(pelicula =>{
	return pelicula.includes("Potter");
});

//filter -> recorre el array y devuelve los eleentos que cumplen la condicion
//
let personas = [19,22,28,35,44,10,12,33,15,40,13,17,18];
let mayores = personas.filter((persona)=>persona>=18);
console.log(mayores);