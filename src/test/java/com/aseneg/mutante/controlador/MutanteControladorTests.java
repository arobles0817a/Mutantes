package com.aseneg.mutante.controlador;

import com.aseneg.mutante.dto.AdnDTO;
import com.aseneg.mutante.dto.AdnEstadisticaDTO;
import com.aseneg.mutante.entidad.MutanteEntidad;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.aseneg.mutante.servicio.MutanteServicio;
import com.aseneg.mutante.util.MetodosUtil;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

/**
 *
 * @author Ing.Arobles
 */
@SpringBootTest
class MutanteControladorTests {

    @Autowired
    private MutanteControlador mutanteControlador;

    private final MutanteServicio mutanteServicio = mock(MutanteServicio.class);

    @Test
    void verificaAdnWhenAdnDTOThenResponseEntityNoNulo() throws Exception {
        //Given
        final AdnDTO adnDTO = this.AdnDTOBuild();

        //When
        final ResponseEntity<MutanteEntidad> responseEntity = mutanteControlador.verificaAdn(adnDTO);

        //Then
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void verificaAdnWhenAdnDTOThenEstadoCorrecto() throws Exception {
        //Given
        final AdnDTO adnDTO = this.AdnDTOBuild();

        //When
        final ResponseEntity<MutanteEntidad> responseEntity = mutanteControlador.verificaAdn(adnDTO);

        //Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void verificaAdnWhenAdnDTOThenEstadoProhibido() throws Exception {
        //Given
        final AdnDTO adnDTO = new AdnDTO();
        adnDTO.setDna(Arrays.asList("ATGCGA", "CAGTGC"));

        //When
        final ResponseEntity<MutanteEntidad> responseEntity = mutanteControlador.verificaAdn(adnDTO);

        //Then
        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());

    }

    @Test
    void verificaAdnWhenAdnDTOThenCuerpoNulo() throws Exception {
        //Given
        final MutanteControlador controlador = new MutanteControlador(spy(MetodosUtil.class), this.mutanteServicio);

        final AdnDTO adnDTO = this.AdnDTOBuild();
        when(mutanteServicio.registrarAdn(any(MutanteEntidad.class))).thenThrow(RuntimeException.class);

        //When
        final ResponseEntity<MutanteEntidad> responseEntity = controlador.verificaAdn(adnDTO);

        //Then
        assertNull(responseEntity.getBody());
    }

    @Test
    void listarEstadisticaAdnWhenNoArgumentoThenListNoNula() throws Exception {
        //When
        List<AdnEstadisticaDTO> list = mutanteControlador.listarEstadisticaAdn();

        //Then
        assertNotNull(list);
    }

    @Test
    void listarEstadisticaAdnWhenHumanoEsVacioThenListNoNula() throws Exception {
        //Given
        final MutanteControlador controlador = new MutanteControlador(null, this.mutanteServicio);
        when(mutanteServicio.contarHumanos()).thenReturn(0);
        //When
        List<AdnEstadisticaDTO> list = controlador.listarEstadisticaAdn();

        //Then
        assertNotNull(list);
    }

    @Test
    void listarEstadisticaAdnWhenDivisorCeroThenListaVacia() throws Exception {
        //Given
        final MutanteControlador controlador = new MutanteControlador(null, this.mutanteServicio);
        when(mutanteServicio.contarHumanos()).thenThrow(RuntimeException.class);

        //When
        List<AdnEstadisticaDTO> list = controlador.listarEstadisticaAdn();

        //Then
        assertTrue(list.isEmpty());
    }

    private AdnDTO AdnDTOBuild() {
        final AdnDTO adnDTO = new AdnDTO();
        adnDTO.setDna(Arrays.asList("ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"));
        return adnDTO;
    }

}
