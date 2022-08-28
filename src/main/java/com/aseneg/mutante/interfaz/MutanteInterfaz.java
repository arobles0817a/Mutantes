/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aseneg.mutante.interfaz;
import com.aseneg.mutante.entidad.MutanteEntidad;

/**
 *
 * @author Ing.Arobles
 */
public interface MutanteInterfaz {

    public MutanteEntidad registrarAdn(MutanteEntidad mutanteEntidad);

    public int countarMutantes();
    public int contarHumanos();
}
