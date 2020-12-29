console.log("==================== Vue ====================")
let app = new Vue ({ // con new vue instanciamos el objeto y todo esto lo guardamos en una variable
	el: "#app", // en la propiedad el (elemento) traemos al selector del elemento con el que vamos a trabajar
	data: { // data es un objeto, todo lo que este acá va a interacturar con el DOM
		valorModel: "hola",
		valorBind: "hola",
		link: "https://vuejs.org/v2/guide/installation.html",
		nombreLink: "vue.js",
		nombre: "",
		tecnologias: ["HTML", "CSS", "Bootstrap", "JavaScript", "Vue"],
	   },
	methods: { // es otro objeto donde vamos a guardar las funciones que vamos a agregar a vue
		
	}
})

new Vue ({
	el: "#formVue",
	data: {
		tareas: [],
		nuevaTarea: "",
	},
	methods: {
		guardarTarea() {
			this.tareas.push(this.nuevaTarea) // la palabra revervada this que hace referencia al objeto q estamos utilizando
			this.nuevaTarea = " "
		}
	}
}) 

/* lo mismo pero con vanilla (js puro)
let formulario = document.querySelector("form");
let ul = document.querySelector("ul");
let input = document.querySelector(".input");
let tareas = [];
 
formulario.onsubmit = ev => { // ejecuta el codigo cuando hace el submit
 	ev.preventDefault(); // detenemos el submit
 	tareas.push(input.value);
 	let li = document.createElement("li"); // es un método que crea un nodo del elemento q indiquemos
 	li.innerHTML = input.value;
 	ul.appendChild(li); // appendChild pone al nodo li dentro del nodo ul
 	input.value = null // borramos el valor del input para seguir agregando elementos a la lista
} 
*/