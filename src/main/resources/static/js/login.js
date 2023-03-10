// Call the dataTables jQuery plugin
$(document).ready(function() {
    //on ready
});

async function iniciarSesion(){
  let datos={};
  datos.email=document.getElementById('txtEmail').value;
  datos.password=document.getElementById('txtPassword').value;

  const response = await fetch('api/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body:JSON.stringify(datos)
  });

    const respuesta = await response.json();
    if (respuesta.success != 'FAIL') {
    localStorage.token = respuesta.token;
    localStorage.email = datos.email;
    window.location.href='usuarios.html';
    }
    else alert('Credenciales incorrectas. Por favor intente nuevamente');
}