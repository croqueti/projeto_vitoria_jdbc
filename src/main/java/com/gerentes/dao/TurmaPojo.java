package com.gerentes.dao;

public class TurmaPojo {
    private int id;
    private int capacidade;
    private int horario;
 
@Deprecated
public TurmaPojo(){
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public int getCapacidade() {
    return capacidade;
}

public void setCapacidade(int capacidade) {
    this.capacidade = capacidade;
}


public int getHorario() {
    return horario;
}

public void setHorario(int horario) {
    this.horario = horario;
}
}