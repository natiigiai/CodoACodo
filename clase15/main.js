function miPrimeraFuncion(num1, num2){ //funcion declarativa
	return num1 * num2;
}

miPrimeraFuncion(7,5);

function funcionSinParametros(){
	return 5+7;
}

let producto = miPrimeraFuncion(4,3.5);

let funcionExpresiva = function(){   //el navegador la va a cargar cuando llegue a esta linea, antes no e puede usar
	let a = "Podemos definir variables dentro de las funciones";
	console.log(a);
}

funcionExpresiva();

function misDatos(nombre, apellido, edad){
	return 'Me llamo '+ nombre + ' ' + apellido + 'y tengo '+ edad + 'años';
}

console.log(misDatos('Natalia','Giai',27));

let valor = 150;
let dolarPesos = function(dolar){
	return dolar*valor;
}

console.log(dolarPesos(5));

let otraFuncion = function(){
	let x = "Hola";
	var y = 1;

	if (true) {
		let x = "Chau";   //es otra variable diferente (vaariable local)
		var y = 5000;	//sobreescribe a la misma variable (variable global)
		console.log('let x = ${x}');
		console.log('var y = ${y}');
	}
	console.log('let x = ${x}');
	console.log('var y = ${y}');

}


//////////callbACK
///
function saludar(callback){
	callback(); //utejectamos la función pero NO la creamos, solo estamos llamando a algo que todavía no existe como si existiera	
}

saludar(function(){//aca va  A EXISSTIR LA FUNCION CALLBACK
	console.log('Hola');
}); //solo estamos definiendo la funcion NO la estamos ejecutandp
