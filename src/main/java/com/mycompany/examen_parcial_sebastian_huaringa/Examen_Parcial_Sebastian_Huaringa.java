

package com.mycompany.examen_parcial_sebastian_huaringa;

import Controlador.ControladorLogin;
import Vista.*;
import Modelo.Cliente;
import Modelo.Rubro;
import Modelo.Postulante;
import java.util.ArrayList;
import java.util.List;

public class Examen_Parcial_Sebastian_Huaringa {

    public static void main(String[] args) {
       frmPrincipal vp = new frmPrincipal();
        frmLogin vl = new frmLogin();
        frmRegistroCliente vrc = new frmRegistroCliente();
        frmRegistroPostulante vrp = new frmRegistroPostulante();
        frmGestionOfertas vgo = new frmGestionOfertas();
        frmBusquedaOfertas vbo = new frmBusquedaOfertas();

        List<Cliente> listaClientes = new ArrayList<>();
        List<Postulante> listaPostulantes = new ArrayList<>();

        // AGREGO UN RUBRO DE PRUEBA Y UN CLIENTE PARA PROBAR EL LOGIN DONDE EL USUARIO ES  20123456789 Y LA CONTRASENA ES 123
        Rubro rubroPrueba = new Rubro("Tecnología", true);
        Cliente clientePrueba = new Cliente("20123456789", "Empresa Alfa S.A.", "alfa@correo.com", "Juan", "999888777", "123", rubroPrueba);
        listaClientes.add(clientePrueba);

        ControladorLogin controladorLogin = new ControladorLogin(vl, vp, vgo, vbo, listaClientes, listaPostulantes);

        vp.setVisible(true);
    }
}
