package com.edubiss.equipe.confronto.confrontoservice.model.dto;

import com.edubiss.equipe.confronto.confrontoservice.model.Confronto;

public class ConfrontoDTO extends Confronto {
    
    private Equipe mandante;
    private Equipe visitante;

    public ConfrontoDTO(Confronto c, Equipe mandante, Equipe visitante) {
        this.setId(c.getId());
        this.setLocal(c.getLocal());
        this.setData(c.getData());
        this.mandante = mandante;
        this.visitante = visitante;
    }

    public Equipe getMandante() {
        return this.mandante;
    }

    public void setMandante(Equipe mandante) {
        this.mandante = mandante;
    }

    public Equipe getVisitante() {
        return this.visitante;
    }

    public void setVisitante(Equipe visitante) {
        this.visitante = visitante;
    }

}
