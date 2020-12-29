var nombre = document.getElementById('nombre');
var email = document.getElementById('email');
var consulta = document.getElementById('consulta');
var auxiliar = false;

function validarForm() 
{
    let ok = true;
    if ( nombre.value == '' || email.value == ''  || consulta.value == '') 
    {
        validarCampo(nombre);
        validarCampo(email);
        validarCampo(consulta);
        alert("Debe ingresar todos los datos...");
        ok = false;
    }
    if ( auxiliar == false )
    {
        ok = false;
        alert("Ha ingresado una dirección de email incorrecta...");
    }
    return ok;
}

function validarCampo(campo) 
{
    if ( campo.value == null || campo.value == '' )
    {
        campo.style.border = '2px solid red';
    }
    else
    {
        campo.style.border = '2px solid green';
    }
}

function validarMail()
{
    //Creamos un objeto 
    valueForm = email.value;
 
    // Patron para el correo
    var patron = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;
    if( valueForm.search(patron) == 0 )
    {
        //Mail correcto
        email.style.color = "black";
        auxiliar = true;
        return;
    }
    //Mail incorrecto
    email.style.color = "red";
}