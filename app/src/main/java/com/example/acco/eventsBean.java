package com.example.acco;

public class eventsBean {

        private String Titol;
        private String Categoria;
        private String Data;
        private String Hora;
        private String Localitat;
        private String enllaç;

        public eventsBean(String titol, String categoria, String data, String hora, String localitat, String enllaç) {
            Titol = titol;
            Categoria = categoria;
            Data = data;
            Hora = hora;
            Localitat = localitat;
            this.enllaç = enllaç;
        }

        public String getTitol() {
            return Titol;
        }

        public void setTitol(String titol) {
            Titol = titol;
        }

        public String getCategoria() {
            return Categoria;
        }

        public void setCategoria(String categoria) {
            Categoria = categoria;
        }

        public String getData() {
            return Data;
        }

        public void setData(String data) {
            Data = data;
        }

        public String getHora() {
            return Hora;
        }

        public void setHora(String hora) {
            Hora = hora;
        }

        public String getLocalitat() {
            return Localitat;
        }

        public void setLocalitat(String localitat) {
            Localitat = localitat;
        }

        public String getEnllaç() {
            return enllaç;
        }

        public void setEnllaç(String enllaç) {
            this.enllaç = enllaç;
        }

        @Override
        public String toString() {
            return "eventsBean{" +
                    "Titol='" + Titol + '\'' +
                    ", Categoria='" + Categoria + '\'' +
                    ", Data='" + Data + '\'' +
                    ", Hora='" + Hora + '\'' +
                    ", Localitat='" + Localitat + '\'' +
                    ", enllaç='" + enllaç + '\'' +
                    '}';
        }
    }

