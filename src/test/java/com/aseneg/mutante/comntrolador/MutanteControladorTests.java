/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aseneg.mutante.comntrolador;

import com.aseneg.mutante.controlador.MutanteControlador;
import com.aseneg.mutante.dto.AdnDTO;
import com.aseneg.mutante.dto.AdnEstadisticaDTO;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.springframework.test.util.AssertionErrors.assertTrue;

/**
 *
 * @author Ing.Arobles
 */
@SpringBootTest
class MutanteControladorTests {

    @Autowired
    private MutanteControlador mutanteControlador;

    @Test
    void statsWhenPostMutante() throws Exception {
        try {
            String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
            AdnDTO entidad = new AdnDTO();
            List<String> mutantes = Arrays.asList(dna);
            entidad.setDna(mutantes);
            ResponseEntity entity = mutanteControlador.verificaAdn(entidad);
            assertNotNull(entity);

        } catch (Exception e) {
            assertTrue(e.getMessage(), false);
        }
    }

    @Test
    void getMutantes() throws Exception {
        try {
            List<AdnEstadisticaDTO> list = mutanteControlador.listarEstadisticaAdn();
            assertNotNull(list);

        } catch (Exception e) {
            assertTrue(e.getMessage(), false);
        }

    }

}
