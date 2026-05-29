package Controlador;

import Modelo.Cliente;
import Modelo.Postulante;
import Vista.frmLogin;
import Vista.frmPrincipal;
import Vista.frmGestionOfertas;
import Vista.frmBusquedaOfertas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorLogin implements ActionListener {

    private frmLogin vistaLogin;
    private frmPrincipal vistaPrincipal;
    private frmGestionOfertas vistaGestion;
    private frmBusquedaOfertas vistaBusqueda;
    
    private List<Cliente> listaClientes;
    private List<Postulante> listaPostulantes;

    public ControladorLogin(frmLogin vl, frmPrincipal vp, frmGestionOfertas vgo, frmBusquedaOfertas vbo, 
                             List<Cliente> clientes, List<Postulante> postulantes) {
        this.vistaLogin = vl;
        this.vistaPrincipal = vp;
        this.vistaGestion = vgo;
        this.vistaBusqueda = vbo;
        this.listaClientes = clientes;
        this.listaPostulantes = postulantes;

        
        this.vistaPrincipal.btnIniciarSesion.addActionListener(this);
        
        
        this.vistaLogin.btnIngresar.addActionListener(this);
        this.vistaLogin.btnVolver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vistaPrincipal.btnIniciarSesion) {
            vistaPrincipal.setVisible(false);
            vistaLogin.setVisible(true);
        } 
        else if (e.getSource() == vistaLogin.btnIngresar) {
            ejecutarLogin();
        } 
        else if (e.getSource() == vistaLogin.btnVolver) {
            vistaLogin.setVisible(false);
            vistaPrincipal.setVisible(true);
        }
    }

    private void ejecutarLogin() {
        String user = vistaLogin.txtUsuario.getText();
        String pass = new String(vistaLogin.txtClave.getPassword());

        for (Cliente c : listaClientes) {
            if (c.getRUC().equals(user) && c.getClave().equals(pass)) {
                vistaLogin.setVisible(false);
                vistaGestion.setVisible(true);
                return;
            }
        }

        for (Postulante p : listaPostulantes) {
            if (p.getEmail().equals(user) && p.getClave().equals(pass)) {
                vistaLogin.setVisible(false);
                vistaBusqueda.setVisible(true);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Datos incorrectos.");
    }
}