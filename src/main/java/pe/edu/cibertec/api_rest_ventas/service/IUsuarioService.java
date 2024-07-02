package pe.edu.cibertec.api_rest_ventas.service;

import pe.edu.cibertec.api_rest_ventas.model.bd.Usuario;

public interface IUsuarioService {

    Usuario obtenerUsuarioPorNomUsuario(
            String nomusuario);
}
