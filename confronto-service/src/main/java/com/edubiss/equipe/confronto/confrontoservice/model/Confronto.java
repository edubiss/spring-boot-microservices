package com.edubiss.equipe.confronto.confrontoservice.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "confronto")
public class Confronto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String local;

	@Column
    private LocalDateTime data;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(name = "equipe_mandante")
    private Long equipeMandante;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(name = "equipe_visitante")
    private Long equipeVisitante;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocal() {
        return this.local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public LocalDateTime getData() {
        return this.data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }


    public Long getEquipeMandante() {
        return this.equipeMandante;
    }

    public void setEquipeMandante(Long equipeMandante) {
        this.equipeMandante = equipeMandante;
    }

    public Long getEquipeVisitante() {
        return this.equipeVisitante;
    }

    public void setEquipeVisitante(Long equipeVisitante) {
        this.equipeVisitante = equipeVisitante;
    }
    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Confronto)) {
            return false;
        }
        Confronto confronto = (Confronto) o;
        return Objects.equals(id, confronto.id) && Objects.equals(local, confronto.local) && Objects.equals(data, confronto.data) && Objects.equals(equipeMandante, confronto.equipeMandante) && Objects.equals(equipeVisitante, confronto.equipeVisitante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, local, data, equipeMandante, equipeVisitante);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", local='" + getLocal() + "'" +
            ", data='" + getData() + "'" +
            ", mandante='" + getEquipeMandante() + "'" +
            ", visitante='" + getEquipeVisitante() + "'" +
            "}";
    }

}
