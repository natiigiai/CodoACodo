<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Comments</title>
        <%@include file="../views/meta_imports.html" %>
        <link rel="stylesheet" href="../css/views.css"/>
        <link rel="stylesheet" href="../css/productComment.css"/>
        <script defer src="../js/components/cardComment.js"></script>
        <script defer src="../js/mainVue.js"></script>
    </head>
    <body>
        <!--pagina-->
        <div id="app" class="grid">
            <!-- The Modal -->
            <div class="modal" id="sendComment">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">What did you think of the product?</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <form action="">
                                <textarea name="comment" placeholder="Comment........." class="form-control w-100"></textarea>
                                <div class="input-group my-2 form-content-range">
                                    <input name="rate" type="range" class="custom-range" min="0" max="5" step="0.1" v-model="numberRate">
                                    <span class="form-control text-dark" :class="[classRate]">{{numberRate}}</span>
                                </div>
                                <input type="submit" class="btn btn-primary btn-block">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="../views/header.jsp" %>
            <div class="grid-product-comment main">
                <div class="product-img">
                    <img
                        src="https://picsum.photos/300/300"
                        class="img-fluid w-100"
                        alt="img-random"
                        />
                </div>
                <div class="product-data">
                    <div title="header-product-data">
                        <h3 class="text-center display-4">Product</h3>
                        <div class="progress my-2">
                            <div class="progress-bar bg-success" style="width: 100%"></div>
                            <span class="rate-number"> (4.7 de 5)</span>
                        </div>
                    </div>
                    <div class="description">
                        <p>
                            Lorem ipsum dolor sit amet consectetur adipisicing elit.
                            Deserunt earum id commodi quis dolores rerum vitae temporibus
                            officia odit.
                        </p>
                    </div>
                    <div class="d-flex justify-content-between">
                        <div class="price">
                            <span>500$</span>
                        </div>
                    </div>
                    <div title="botonera">
                        <button class="btn btn-outline-primary">Add to Cart</button>
                        <button class="btn btn-primary" data-toggle="modal" data-target="#sendComment">Comment</button>
                    </div>
                </div>
                <!--Comments-->
                <div class="product-comments border-top">
                    <!-- card-comment -->
                    <card-comment></card-comment>
                </div>
            </div>
            <%@include file="../views/footer.html" %>
        </div>
    </body>
</html>
