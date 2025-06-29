
package com.mycompany.carniceria1;

import com.mycompany.carniceria1.igu.Bienvenida;
import com.mycompany.carniceria1.igu.Logueo;

public class Carniceria1 {

    public static void main(String[] args) {
        /*Bienvenida pantalla = new Bienvenida();
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null); */
        Logueo login = new Logueo();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }
}
