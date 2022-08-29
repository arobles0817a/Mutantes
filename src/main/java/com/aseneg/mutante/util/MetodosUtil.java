/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aseneg.mutante.util;

import com.aseneg.mutante.dto.AdnDTO;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ing.Arobles
 */
@Component
public class MetodosUtil {
    public boolean isMutantDNA(AdnDTO adnDTO) {
        boolean isMutualDna = false;
        char[][] dna = listaMatrizAdn(adnDTO);
        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna[0].length - 3; j++) {
                if (dna[i][j] == dna[i][j + 1]
                        && dna[i][j] == dna[i][j + 2]
                        && dna[i][j] == dna[i][j + 3]) {
                    isMutualDna = true;
                }
            }
        }
        return isMutualDna;
    }
    private char[][] listaMatrizAdn(AdnDTO adnDTO) {
        int vectorLength = adnDTO.getDna().size();
        char[][] dna = new char[vectorLength][vectorLength];

        for (int i = 0; i < vectorLength; i++) {
            String dnaRow = adnDTO.getDna().get(i);
            dna[i] = dnaRow.toUpperCase().toCharArray();
        }
        return dna;
    }
}
