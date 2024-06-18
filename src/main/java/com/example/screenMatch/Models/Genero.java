package com.example.screenMatch.Models;

public enum Genero {
    ACAO("Action"),
    ROMANCE("Romance"),
    COMEDIA("Comedy"),
    DRAMA("Drama"),
    CRIME("Crime");

    private String generoOmdb;

    Genero(String generoOmdb) {
        this.generoOmdb = generoOmdb;
    }

    public static Genero fromString(String text){
        for (Genero genero : Genero.values()){
            if(genero.generoOmdb.equalsIgnoreCase(text)){
                return genero;
            }
        }
        throw new IllegalArgumentException("Nenhuma Categoria encontrada");
    }
}
