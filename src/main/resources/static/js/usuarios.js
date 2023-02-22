// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargaUsuarios();
  $('#usuarios').DataTable();
  muestraEmailUsuario();
});

async function cargaUsuarios(){
  const request = await fetch('api/usuarios', {
    method: 'GET',
    headers: getHeaders()
  });
  const usuarios = await request.json();
  let listadoHTML='';
  for (let usuario of usuarios){
    let botonEliminar ='<a href="#" onclick="eliminarUsuario('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
    let telefonoTexto = usuario.telefono == null ? '-' : usuario.telefono;
    let usuarioHTML= '<tr><td>'+usuario.id+
                     '<td>'+usuario.nombre+
                     '</td><td>'+usuario.email+
                     '</td><td class="text-center">'+telefonoTexto+
                     '</td><td>'+botonEliminar+'</td><tr>';
    listadoHTML+=usuarioHTML;
  }
  console.log(usuarios);

  document.querySelector('#usuarios tbody').outerHTML=listadoHTML;
}

async function eliminarUsuario(id){
    if (!confirm('¿Desea borrar el usuario?')){
        return;
    }
    alert(' voy a eliminar el usuario '+id);
    const request = await fetch('api/usuarios/'+id, {
        method: 'DELETE',
        headers: getHeaders()
    });
    location.reload();
}
function getHeaders(){
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization':localStorage.token
    };
}

function muestraEmailUsuario(){
    document.getElementById("txt-usuario-email").outerHTML=localStorage.email;
}