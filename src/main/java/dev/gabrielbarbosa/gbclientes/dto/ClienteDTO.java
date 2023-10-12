package dev.gabrielbarbosa.gbclientes.dto;

import dev.gabrielbarbosa.gbclientes.entities.Cliente;

import java.time.LocalDate;

public class ClienteDTO {

    private Long id;

    private String name;

    private String cpf;

    private Double income;

    private LocalDate birthDate;

    private Integer children;

    public ClienteDTO(Cliente cliente) {
        id = cliente.getId();
        name = cliente.getName();
        cpf = cliente.getCpf();
        income = cliente.getIncome();
        birthDate = cliente.getBirthDate();
        children = cliente.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
