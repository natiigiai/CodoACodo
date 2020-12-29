fetch("CommentsByIdProduct?id=13")
        .then((response) => response.json())
        .then((json) => console.log(json));

fetch("allproducts")
        .then((response) => response.json())
        .then((json) => console.log(json));
fetch("CleanDemo")
        .then((response) => response.json())
        .then((json) => console.log(json));
