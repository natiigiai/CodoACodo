// console.log("----------------- While ------------");

/*console.log(1);
console.log(2);
console.log(3);
console.log(4);
console.log(5);
console.log(6);
console.log(7);
console.log(8);
console.log(9);
console.log(10); */

let i = 5;
while (i <= 10) {
	console.log(i)
	i++;
}

let color = "";
while (color != "rosa") {
	color = prompt("Escribí un color (rosa para salir)")
} 


console.log("----------------- For ------------");
for (let indice = 1; indice <= 10; indice++) {
	console.log(indice)
}

/* omitir partes del for
let indice = 1;
for (; indice <= 10; indice++) {
	console.log(indice)
}

let indice = 1;
for (; indice <= 10;) {
	console.log(indice++)
}  */

console.log("----------------- Ejemplo ------------");
let number = parseInt(prompt("Ingrese un número"));
for (let n = 1; n<=10; n++) {
	if (n == 1) {
		document.write(`<h2>Tabla del ${number} </h2>`);
	}
	document.write(`<p> ${number} x ${n} = ${number * n} </p>`);
}