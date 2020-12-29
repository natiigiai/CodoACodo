Vue.component("card-product", {
template:`
    <div class="card">
        <div class="card-content-img">
            <img src="https://picsum.photos/300" alt="img-random" class="w-100 h-100"/>
        </div>
        <div class="card-body">
            <div>
                <h5 class="card-title text-center fa-2x">Tittle</h5>
                <div class="progress my-1">
                    <div
                        class="progress-bar bg-success"
                        style="width: 100%"
                        ></div>
                    <span class="rate-number"> (4.5 de 5)</span>
                </div>
            </div>
            <p>3000$</p>
            <div class="btns-product">
                <a href="#" class="btn btn-outline-primary" @click="AddCart">Add To Cart</a>
                <a href="html/productComments.jsp" class="btn btn-primary">Go Comments</a>
            </div>
        </div>
    </div>`,
    methods:{
        AddCart(){
            this.$emit('EventAddCart');
        }
    }
})
