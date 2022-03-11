package com.example.josemariaveraex2ev.utils;

import java.io.Serializable;

public class Pregunta implements Serializable {
    private String pregunta;
    private Boolean respuesta;

    public Pregunta(String pregunta, Boolean respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Boolean getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Boolean respuesta) {
        this.respuesta = respuesta;
    }

}
