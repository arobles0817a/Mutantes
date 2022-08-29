/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aseneg.mutante.servicio.impl;

import com.aseneg.mutante.entidad.MutanteEntidad;
import com.aseneg.mutante.repositorio.MutanteRepositorio;
import org.springframework.stereotype.Service;
import com.aseneg.mutante.servicio.MutanteServicio;

/**
 *
 * @author Ing. Arobles
 */
@Service
public class MutanteServicioImpl implements MutanteServicio {

    private final MutanteRepositorio mutanteRepositorio;

    public MutanteServicioImpl(MutanteRepositorio mutanteRepositorio) {
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
