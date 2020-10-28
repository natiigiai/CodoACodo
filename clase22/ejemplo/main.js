new Vue ({
	el: "#app",
	data: {
		colorElemento: "",
	},
	methods: {
		cambiarColor: function(color) {
			this.colorElemento = "bg-" + color;
		},
	}
})