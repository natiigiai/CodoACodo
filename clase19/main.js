console.log("==================== Eventos ====================")

// Event
const foo = event => {
	// evento, evt or e
	console.log(event); 
};

const btn = document.querySelector("#alert");
btn.addEventListener("click", foo); 

let header = document.querySelector("h1");
header.addEventListener("click", funcionEvento);

function funcionEvento(evento) {
	console.log(evento.target)
}

// On Events: nos permiten asignar funciones a los eventos 
function miFuncion() {
	console.log("Ejecutamos un on event en una propiedad html")
}

let elementoOn = document.querySelector("#miFuncion");
elementoOn.onclick = function() {
	console.log("Ejecutamos un on event sin necesidad de llamar a la función en html")
}

// eventos del mouse
 const mouseEventos = evento => {
    const { type } = evento;
    const mouseEvent = document.querySelector('#mouseEvent');
        mouseEvent.textContent = `Qué evento se está ejecutando? ${type}`;
}
const gridItem = document.querySelector("#grid-item");
gridItem.addEventListener("click", mouseEventos);
gridItem.addEventListener("dblclick", mouseEventos);
gridItem.addEventListener("mouseenter", mouseEventos);
gridItem.addEventListener("mouseleave", mouseEventos);
gridItem.addEventListener("mousemove", mouseEventos);
gridItem.addEventListener("mousedown", mouseEventos);
gridItem.addEventListener("mouseup", mouseEventos);


// eventos del teclado 

const tecladoEventos = evento => {
	const { type } = evento;
	console.log(`Se ejecuto: ${type}`)
};
window.addEventListener("keydown", tecladoEventos);
window.addEventListener("keyup", tecladoEventos);
window.addEventListener("keypress", tecladoEventos);

let keyActions = evento => {
	let {type, keyCode, key, code} = evento;
	let tecla = document.querySelector("#teclado");
	tecla.innerHTML = `<ul> 
							<li>keyCode: ${keyCode}</li>
							<li>key: ${key}</li>
							<li>code: ${code}</li>
						</ul>
	`
}
window.addEventListener("keypress", keyActions);

// event.preventDefault: elimina la función por defecto de un elemento
let cargarEnlace = evento => {
	console.log("No podes");
	evento.preventDefault(); // eliminamos la función x defecto de a
}
let link = document.querySelector("a");
link.addEventListener("click", cargarEnlace);

// remove event: para eliminar un evento de un elemento
let eliminar = document.querySelector("a");
eliminar.removeEventListener("click", cargarEnlace); 

// eventos para formularios: focus, blur, change
const txt = document.querySelector("input[type='text']");
txt.addEventListener("focus", (evento) => {
	evento.target.style.background = "tomato";
});

txt.addEventListener("blur", (evento) => {
	evento.target.style.background = "blue";
})

const selectElement = document.querySelector(".select");
selectElement.addEventListener("change", (evento) => {
	console.log(evento);
	const result = document.querySelector(".result");
	  result.textContent = `Seleccionaste ${evento.target.value}`;
})

// operador ternario: condicional() ? true : false
let condicion = true;
condicion ? console.log("paso la condición") : console.log("no paso la condición")

if (condicion) { // lo mismo
	console.log("paso la condición")
} else {
	console.log("no paso la condición")
}

let otroEjemplo = Math.PI > 4 ? "Si" : "No";


// Objetos
const persona = {
	nombre: "pepito",
	edad: 35,
	direccion: "calle 123",
} 
// 2 formas de acceder a los objetos: [] o .
console.log(persona.nombre, persona.edad) // pepito
console.log(persona["edad"]);

let str = "inmutable";
console.log(str[0]) // i
str[0] = "ñ";
console.log(str[0]) // i

let arr = ["uno", "dos", "tres", "cuatro"]
console.log(arr); // "uno", "dos", "tres", "cuatro"
arr[0] = "mutable";
console.log(arr); // "mutable", "dos", "tres", "cuatro"

/* for .. of | for(variable of iterable) // {sentencia}
No se puede usar en objetos */
const miArray = ["A", "B", "C", "D", "E", "F", "G"]
for(let elementos of miArray) {
	console.log(elementos)
}
/* for .. in | for(variable in objeto) { // sentencia } */
let colores = {
	a: "rojo",
	b: "azul",
	c: "verde",
}
for(const prop in colores) {
	console.log(`El color ${prop} es ${colores[prop]}`);
}
