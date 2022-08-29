package com.aseneg.mutante.util;

import com.aseneg.mutante.dto.AdnDTO;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author Ing.Arobles
 */
@ExtendWith(MockitoExtension.class)
class MetodosUtilTests {

    @InjectMocks
    private MetodosUtil metodosUtil;

    @Test
    void isMutantDNAWhenAdnDTOThenVerdadero() {
        //Given
        final AdnDTO adnDTO = this.AdnDTOBuild();
        //When
        boolean mutantDNA = this.metodosUtil.isMutantDNA(adnDTO);
        //Then
        assertTrue(mutantDNA);
    }

    @Test
    void isMutantDNAWhenAdnDTOThenFalso() {
        //Given
        final AdnDTO adnDTO = new AdnDTO();
        adnDTO.setDna(Arrays.asList("ATGCGA", "CAGTGC"));
        //When
        boolean mutantDNA = this.metodosUtil.isMutantDNA(adnDTO);
        //Then
        assertFalse(mutantDNA);
    }

    @Test
    void listaMatrizAdnWhenAdnDTOThenListaNoNula() {
        // When
        char[][] listaAdn = this.metodosUtil.listaMatrizAdn(AdnDTOBuild());
        // Then
        Assertions.assertNotNull(listaAdn);
    }

    private AdnDTO AdnDTOBuild() {
        final AdnDTO adnDTO = new AdnDTO();
        adnDTO.setDna(Arrays.asList("ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"));
        return adnDTO;
    }

}
