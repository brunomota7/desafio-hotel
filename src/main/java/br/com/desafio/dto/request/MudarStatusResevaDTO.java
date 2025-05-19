package br.com.desafio.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MudarStatusResevaDTO {
    private boolean resevado;
}
