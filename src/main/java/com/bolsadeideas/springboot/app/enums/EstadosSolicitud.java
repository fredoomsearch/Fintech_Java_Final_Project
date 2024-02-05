package com.bolsadeideas.springboot.app.enums;

public enum EstadosSolicitud {
    NO_ENVIADO(1, "No Enviado"),
    APROBADO(2, "Aprobado"),
    RECHAZADO(3, "Rechazado");

    private final Integer index;
    private final String label;

    EstadosSolicitud(Integer index, String label) {
        this.index = index;
        this.label = label;
    }

    public Integer getIndex() {
        return index;
    }

    public String getLabel() {
        return label;
    }
}
