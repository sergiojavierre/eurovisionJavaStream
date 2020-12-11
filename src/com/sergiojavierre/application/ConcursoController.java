package com.sergiojavierre.application;

import com.sergiojavierre.domain.Participante;

import java.util.*;

public class ConcursoController {

    List<Participante> participantes;
    Random random;

    public ConcursoController(){
        participantes = new ArrayList<>();
        random = new Random();
        loadData();
    }

    private void loadData(){
        participantes.add(new Participante("Serbia"));
        participantes.add(new Participante("Moldavia"));
        participantes.add(new Participante("Hungría"));
        participantes.add(new Participante("Ucrania"));
        participantes.add(new Participante("Suecia"));
        participantes.add(new Participante("Austria"));
        participantes.add(new Participante("Noruega"));
        participantes.add(new Participante("Dinamarca"));
        participantes.add(new Participante("Eslovenia"));
        participantes.add(new Participante("Holanda"));
        participantes.add(new Participante("Albania"));
        participantes.add(new Participante("República Checa"));
        participantes.add(new Participante("Lituania"));
        participantes.add(new Participante("Israel"));
        participantes.add(new Participante("Estonia"));
        participantes.add(new Participante("Bulgaria"));
        participantes.add(new Participante("Rumanía"));
        participantes.add(new Participante("Finlandia"));
        participantes.add(new Participante("Irlanda"));
        participantes.add(new Participante("Chipre"));
        //big five
        participantes.add(new Participante("Alemania"));
        participantes.add(new Participante("Italia"));
        participantes.add(new Participante("Reino Unido"));
        participantes.add(new Participante("Francia"));
        participantes.add(new Participante("España"));
    }

    public void start(){
        for(Participante participante: participantes){
            for(int puntos = 1; puntos <= 12; puntos++){
                if(puntos != 9 && puntos!= 11) {
                    Participante votadoPublico = null, votadoJueces = null;
                    //votosPublico
                    do {
                        int indexParticipante = random.nextInt(participantes.size());
                        votadoPublico = participantes.get(indexParticipante);
                    } while (votadoPublico == participante || participante.isInVotosPublico(participante));
                    participante.setVotosPublico(votadoPublico, puntos);
                    votadoPublico.addVotos(puntos);
                    //votosJueces
                    do {
                        int indexParticipante = random.nextInt(participantes.size());
                        votadoJueces = participantes.get(indexParticipante);
                    } while (votadoJueces == participante || participante.isInVotosJueces(participante));
                    participante.setVotosJueces(votadoJueces, puntos);
                    votadoJueces.addVotos(puntos);
                }
            }
        }
        Collections.sort(participantes);
    }

    public void lista(){
         participantes.forEach(System.out::println);
    }

    public void busca(){
        Participante participanteAlta = participantes.stream().max(Comparator.comparing(Participante::getVotosTotales)).get();
        Participante participanteBaja = participantes.stream().min(Comparator.comparing(Participante::getVotosTotales)).get();
        System.out.println("El ganador es: "+participanteAlta.getNombre()+" con "+participanteAlta.getVotosTotales()+ " votos");
        System.out.println("El perdedor es: "+participanteBaja.getNombre()+" con "+participanteBaja.getVotosTotales()+ " votos");
    }

}
