package com.mariugo.crud.swing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    
    private int id;
    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private String cpf;
    
    
}
