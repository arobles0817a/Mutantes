package com.aseneg.mutante.controlador;

import com.aseneg.mutante.dto.AdnDTO;
import com.aseneg.mutante.dto.AdnEstadisticaDTO;
import com.aseneg.mutante.entidad.MutanteEntidad;
import com.aseneg.mutante.util.MetodosUtil;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aseneg.mutante.servicio.MutanteServicio;

/**
 *
 * @author Ing.Arobles
 */
@RestController
@RequestMapping(value = "/mutant/")
public class MutanteControlador {

    private static final Logger log = LoggerFactory.getLogger(MutanteControlador.class);

    private final MetodosUtil metodosUtil;
    private final MutanteServicio mutanteServicio;

    public MutanteControlador(MetodosUtil metodosUtil, MutanteServicio mutanteInterfaz) {
        this.metodosUtil = metodosUtil;
        this.mutanteServicio = mutanteInterfaz;
    }

    @PostMapping()
    public ResponseEntity<MutanteEntidad> verificaAdn(@RequestBody AdnDTO adnDTO) {
        MutanteEntidad entidad = new MutanteEntidad();
        MutanteEntidad mutanteEntidad = null;
        boolean isMutante = false;
        try {
            entidad.setTexto(adnDTO.getDna().toString());
            isMutante = metodosUtil.isMutantDNA(adnDTO);
            entidad.setMutante(isMutante);
            mutanteEntidad = mutanteServicio.registrarAdn(entidad);

        } catch (Exception e) {
            log.error("Error inesperperado al intentar ejecutar la peticion: {}", e);
        }
        return new ResponseEntity<>(mutanteEntidad, isMutante ? HttpStatus.OK : HttpStatus.FORBIDDEN);
    }

    @GetMapping()
    public List<AdnEstadisticaDTO> listarEstadisticaAdn() {
        List<AdnEstadisticaDTO> estadisticaDTOs = new LinkedList<>();
        AdnEstadisticaDTO adnEstadisticaDTO = new AdnEstadisticaDTO();
        try {
            int cantidadHumano = mutanteServicio.contarHumanos();
            int cantidadMutante = mutanteServicio.countarMutantes();
            adnEstadisticaDTO.setCountHumanoDna(cantidadHumano);
            adnEstadisticaDTO.setCountMmutantDna(cantidadMutante);
            adnEstadisticaDTO.setRadio(cantidadHumano == 0 ? 0 : cantidadMutante / cantidadHumano);
            estadisticaDTOs.add(adnEstadisticaDTO);
        } catch (Exception e) {
            log.error("Error inesperperado al intentar ejecutar la peticion: {}" + e);
        }

        return estadisticaDTOs;
    }
}
