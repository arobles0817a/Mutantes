/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aseneg.mutante.interfaz.impl;

import com.aseneg.mutante.entidad.MutanteEntidad;
import com.aseneg.mutante.interfaz.MutanteInterfaz;
import com.aseneg.mutante.repositorio.MutanteRepositorio;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ing. Arobles
 */
@Service
public class MutanteInterfazImpl implements MutanteInterfaz {

    private final MutanteRepositorio mutanteRepositorio;

    public MutanteInterfazImpl(MutanteRepositorio mutanteRepositorio) {
        this.mutanteRepositorio = mutanteRepositorio;
    }

    @Override
    public MutanteEntidad registrarAdn(MutanteEntidad mutanteEntidad) {
        return this.mutanteRepositorio.save(mutanteEntidad);
    }

    @Override
    public int countarMutantes() {
        return this.mutanteRepositorio.countarMutantes();
    }

    @Override
    public int contarHumanos() {
        return this.mutanteRepositorio.contarHumanos();
    }
}
