//////////callbACK
///
function saludar(callback){
	callback(); //utejectamos la función pero NO la creamos, solo estamos llamando a algo que todavía no existe como si existiera	
}

saludar(function(){//aca va  A EXISSTIR LA FUNCION CALLBACK
	console.log('Hola');
}); //solo estamos definiendo la funcion NO la estamos ejecutando

//una funcion que recibe a otra funcion como parametro es una funcion de orden superior
//paradigma funcional
//se usan cuando tenemos un proceso que depende del resultado de otro proceso
//
function saludar(name,callback){
	callback(name); //en la callback pasamos como argumento name
}

saludar('Pepito', function(name){
	console.log('Hola ',name);
});

//otra forma
function saludar(name,callback){
	callback(name); //en la callback pasamos como argumento name
}

function saludo(name){
	console.log('Hola ',name);
}

saludar('Pepe', saludo);

////funcion de la callback: poner funciones dentro de funciones
///ejemplo
///sumar dos numeros
///al resultado de la suma lo queremos multiplicar
///a eso lo queremos dividir por 2
///al resultado de la division le restamos un numero
///
///
function sumar(num1, num2, callback){
	callback(num1+num2); //necesitamos el resultado de ese proceso por eso la callback
}

function multiplicar(num, callback){
	callback(num*num);
}

function dividir(num, callback){
	callback(num/2);
}

function restar(num, callback){
	callback(num-10);
}

function esMAyor(num, callback){
	if (num>10) {
		callback("es mayor a 10");
	}else{
		callback("es menor a 10");
	}
}

sumar(5,2,function(resultSuma){
	console.log('Suma: ',resultSuma);
	multiplicar(resultSuma,function(resultProducto){
		console.log('Multiplicación de la suma:', resultProducto);
		dividir(resultProducto, function(resultDividir){
			console.log('Producto dividido 2: ', resultDividir);
			restar(resultDividir, function(resultResta){
				console.log('Result division - 10: ', resultResta);
				esMAyor(resultResta, function(resultFinal){
					console.log('El resultado final ',resultFinal);
				})
			})
		})
	})
});

////tareaa! acomodar esto
///
///
///funciones flecha
///funciones anonimas con sintaxis compacta
///van a tener el operador flecha entre los parametros
///


const suma = (a,b) =>{ //la flecha es igual que function
	return a+b;
};

/////////////////////arreglos
///
////dos formas de declarar array
///
///1 -> mas recomendada
let arreglo = ['Hola', 'Chau',1,2,3,true,false];
////2
let arreglo2 = new new Array('uno','dos',3);


//  miArray = [0,  1,  2,  3,  4,  5,  6,  7, ...]
let miArray = [7, 13, 26, 14, 17, 32, 29, 10, 4, 2];
console.log(miArray);
miArray.sort(function(a,b){return a-b}) // ordenado de menor a mayor
console.log(miArray);


let listaNombres = ['Evangelina', 'Natalia', 'Debora', 'Yamila', 'Lucia'];
console.log(listaNombres.sort()); //ordena alfabeticamente
console.log('Ultimo elemento: '+listaNombres[listaNombres.length-1]);
listaNombres.push('Rocio'); //añade elemento al final
console.log(listaNombres);
listaNombres.unshift('Pepe'); //añade un valor al inicio
console.log(listaNombres);
console.log('los nombres de algunas personas del curso son: '+ listaNombres.join(", ")); //imprime los elementos de un array como string
listaNombres.shift(); //borra un elemento del inicio
console.log(listaNombres);
listaNombres.splice(1,2); //borra elemento es la posicion y el seguno la cantidad a borrar
console.log(listaNombres);
listaNombres.splice(1, 0, "Enrique", "Julian"); //borro un elemento y agrego 2


