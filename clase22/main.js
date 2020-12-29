/*
	Acá van los componentes
*/
Vue.component("etiqueta-vue", { // recibe dos argumentos: el nombre del componente y el objeto con las propiedades
	props: ["titulo"],  // lo que definimos acá lo vamos a poder usar como atributo en html
	template: ` <div>
				 <div class="jumbotron">
				   <h1 class="display-4">{{titulo}}</h1>
  					<p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
  					<hr class="my-4">
  					<p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
  					<a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
				</div>  
			</div>
				`, // acá va el código html como string y solo tiene que tener un elemento raiz
})

let app = new Vue ({
	el: "#app",
	data: {
		valor: 1,
		contador: 1,
		num1: 1,
		num2: 5,
		link: "https://picsum.photos",
		alto: 10,
		ancho: 10,
	},
	methods: {
		enviar(){

		},
		masUno() {
			this.contador++
		}
	},
	computed: { // computed para las funciones que retornen algo
		multiplicar() {
			return this.num1 * this.num2
		},
		linkCompleto() {
			return `${this.link}/${this.ancho*10}/${this.alto*10}`
		}
	}
})