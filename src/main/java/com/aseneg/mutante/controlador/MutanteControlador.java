/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aseneg.mutante.controlador;

import com.aseneg.mutante.dto.AdnDTO;
import com.aseneg.mutante.dto.AdnEstadisticaDTO;
import com.aseneg.mutante.entidad.MutanteEntidad;
import com.aseneg.mutante.interfaz.MutanteInterfaz;
import com.aseneg.mutante.util.MetodosUtil;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ing.Arobles
 */
@RestController
@RequestMapping(value = "mutant/")
public class MutanteControlador {

    private static final Logger log = LoggerFactory.getLogger(MutanteControlador.class);

    @Autowired
    private MetodosUtil metodosUtil;

    @Autowired
    private MutanteInterfaz mutanteInterfaz;

    @PostMapping()
    public ResponseEntity verificaAdn(@RequestBody AdnDTO adnDTO) {
        MutanteEntidad entidad = new MutanteEntidad();
        MutanteEntidad mutanteEntidad = null;
        boolean isMutante = false;
        try {
            entidad.setTexto(adnDTO.getDna().toString());
            isMutante = metodosUtil.isMutantDNA(adnDTO);
            entidad.setMutante(isMutante);
            mutanteEntidad = mutanteInterfaz.registrarAdn(entidad);

        } catch (Exception e) {
            log.error("Error inesperperado al intentar ejecutar la peticion: {}", e);
        }
        return new ResponseEntity<>(mutanteEntidad, isMutante ? HttpStatus.OK : HttpStatus.FORBIDDEN);
    }

    @GetMapping()
    public List<AdnEstadisticaDTO> listarEstadisticaAdn() {
        List<AdnEstadisticaDTO> estadisticaDTOs = new LinkedList();
        AdnEstadisticaDTO adnEstadisticaDTO = new AdnEstadisticaDTO();
        try {
            int cantidadHumano = mutanteInterfaz.contarHumanos();
            int cantidadMutante = mutanteInterfaz.countarMutantes();
            adnEstadisticaDTO.setCountHumanoDna(cantidadHumano);
            adnEstadisticaDTO.setCountMmutantDna(cantidadMutante);
            adnEstadisticaDTO.setRadio(cantidadHumano==0 ? 0: cantidadMutante / cantidadHumano);
            estadisticaDTOs.add(adnEstadisticaDTO);
        } catch (Exception e) {
            log.error("Error inesperperado al intentar ejecutar la peticion: {}" + e);
        }

        return estadisticaDTOs;
    }
}
