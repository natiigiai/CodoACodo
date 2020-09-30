console.log("----------------- Condicionales ------------");

console.log("----------------- if ------------");

if (5>4) { 
  console.log("5 es mayor")
}

// if - else
if ( "a" === "a") {
    console.log("pasó la condición")
} else {
  console.log("no pasó la condición")
}

// if anidados
let pepeEdad = 11;
let juanEdad = 11;
if (pepeEdad > juanEdad) {
  console.log("Pepe es mayor")
} else if (pepeEdad == juanEdad) {
  console.log("Tienen la misma edad")
} else {
  // la condición no se cumplió
  console.log("Juan es mayor");
}

console.log("----------------- switch ------------");
let numero = 5;
switch (numero) {
  case 1: 
    console.log("El número es 1");
    break;
  case 2: 
    console.log("El número es 2");
    break;
  case 3:
    console.log("El número es 3");
    break;
  case 4: 
    console.log("El número es 4");
    break;
  case 5:
    console.log("El número es 5");
    break;
  default:
    console.log("No hay coincidencias");
}

if (numero == 1) {
  console.log("El número es 1");
} else if (numero == 2) {
  console.log("El número es 2");
} else if (numero == 3) {
  console.log("El número es 3");
} else if (numero == 4) {
  console.log("El número es 4");
} else if (numero == 5) {
  console.log("El número es 5");
} else {
  console.log("No hay coincidencias");
} 