const elementos = document.querySelector("#dark-mode");
const boton = document.querySelector("#selectMode");

boton.onclick = (evento) => {
	if (boton.checked) {
		elementos.classList.add("dark-mode");
	} else {
		elementos.classList.remove("dark-mode")
	}
}