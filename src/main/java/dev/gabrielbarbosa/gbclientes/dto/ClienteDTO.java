package dev.gabrielbarbosa.gbclientes.dto;

import dev.gabrielbarbosa.gbclientes.entities.Cliente;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class ClienteDTO {

    private Long id;

    @NotEmpty(message = "INSIRA O NOME DO CLIENTE.")
    private String name;

    private String cpf;

    private Double income;

    @PastOrPresent(message = "USE DATA DO PASSADO OU PRESENTE.")
    private LocalDate birthDate;

    private Integer children;

    public ClienteDTO() {
    }

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
