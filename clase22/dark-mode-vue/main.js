let app = new Vue ({
    el: "#app",
    data: {
        darkMode: false,
    },
    methods: {
        cambiarTema() {
            this.darkMode = this.darkMode ? false : true;
            document.querySelector("body").style.backgroundColor = this.darkMode ? "#000000" : "#FFFFFF";
            /* if (this.darkMode) {
                this.darkMode = false
            } else {
                this.darkMode = true
            }
            if (this.darkMode) {
                document.querySelector("body").style.backgroundColor = "#000000"
            } else {
                document.querySelector("body").style.backgroundColor = "#FFFFFF"
            }
            */
        },
    }
});