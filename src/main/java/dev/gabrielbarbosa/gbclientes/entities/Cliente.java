package dev.gabrielbarbosa.gbclientes.entities;

import dev.gabrielbarbosa.gbclientes.dto.ClienteDTO;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cpf;

    private Double income;

    private LocalDate birthDate;

    private Integer children;

    public Cliente() {
    }

    public Cliente(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public Cliente(ClienteDTO clienteDTO) {
        this.id = clienteDTO.getId();
        this.name = clienteDTO.getName();
        this.cpf = clienteDTO.getCpf();
        this.income = clienteDTO.getIncome();
        this.birthDate = clienteDTO.getBirthDate();
        this.children = clienteDTO.getChildren();
    }

    public void update(ClienteDTO clienteDTO) {
        this.name = clienteDTO.getName();
        this.cpf = clienteDTO.getCpf();
        this.income = clienteDTO.getIncome();
        this.birthDate = clienteDTO.getBirthDate();
        this.children = clienteDTO.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }
}
