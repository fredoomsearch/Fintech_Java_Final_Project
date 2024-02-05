package com.bolsadeideas.springboot.app.models.DTO;

public class ScoreDTO {

    private int score;
    private int reportado;
    private int habilitado;
    private int numeroCuenta;


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getReportado() {
        return reportado;
    }

    public void setReportado(int reportado) {
        this.reportado = reportado;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public ScoreDTO() {
    }
}
