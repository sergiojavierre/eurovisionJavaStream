package com.sergiojavierre.domain;

import java.util.HashMap;

public class Participante implements Comparable{

    private final String nombre;
    private final HashMap<Participante,Integer> votosJueces, votosPublico;
    private Integer votosTotales;

    public Participante(String nombre) {
        this.nombre = nombre;
        this.votosJueces = new HashMap<>();
        this.votosPublico = new HashMap<>();
        this.votosTotales = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getVotosTotales() {
        return votosTotales;
    }

    public void addVotos(Integer votos){
        this.votosTotales += votos;
    }

    public void setVotosJueces(Participante participante, Integer votos){
        this.votosJueces.put(participante,votos);
    }

    public void setVotosPublico(Participante participante, Integer votos){
        this.votosPublico.put(participante,votos);
    }

    public Boolean isInVotosJueces(Participante participante){
        return this.votosJueces.containsKey(participante);
    }

    public Boolean isInVotosPublico(Participante participante){
        return this.votosPublico.containsKey(participante);
    }


    @Override
    public int compareTo(Object o) {
        Participante otro = (Participante)o;
        return nombre.compareTo(otro.getNombre());
    }

    @Override
    public String toString() {
        return "("+votosTotales+")"+"\t"+nombre;
    }
}
