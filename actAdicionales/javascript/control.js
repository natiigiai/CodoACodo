var usuario = document.getElementById("usuario");
var clave = document.getElementById("clave");

function enviarForm(){
	let mensaje = '';
	let ok = false;
	if (usuario.value == '' || clave.value == '') {
		mensaje = 'Los campus Usuario y Clave no pueden estar vacios!';
		console.log(mensaje);
	}else{
		if (usuario.value != '') {
			if (usuario.value.includes('@') == true && clave.value != '') {
				ok = true;
			}else {
				mensaje = 'El usuario debe incluir arroba y la clave no puede estar vacia';
				console.log(mensaje);
				ok = false;
			}
		}
	}
	if (ok==false) {
		alert(mensaje);
		console.log(mensaje);
	}
	
	return ok;
}