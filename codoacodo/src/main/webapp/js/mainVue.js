const vue = new Vue({
    el: "#app", 
    data:{
        numberRate:0.00
    }, 
    methods:{
        rateComment({target}){
            
        }
    }, 
    computed:{
        classRate(){
            if(this.numberRate >= 0 && this.numberRate < 2.5){
                return "bg-danger"
            }else if(this.numberRate < 3.5){
                return "bg-warning"
            }else{
                return "bg-success"
            }
        }
    }
});

