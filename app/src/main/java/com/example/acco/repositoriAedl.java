package com.example.acco;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class repositoriAedl {



        private static repositoriAedl repo_aedl = new repositoriAedl();
        private TreeMap<String, llista_aedl> lltajug = new TreeMap<>();

        public static repositoriAedl getInstance() {
            return repo_aedl;
        }

        private repositoriAedl() {
            saveLead(new llista_aedl("01","Mancomunitat de l'Horta Sud","C/ Cervantes, 19 Torrent","adl@mancohortasud.es","961572011", R.drawable.esc_manco));
            saveLead(new llista_aedl("02","Alaquàs","Carrer Major, 88","adl@alaquas.org","96 151 94 00", R.drawable.esc_alaquas));
            saveLead(new llista_aedl("03","Albal","C/ Maestro Ramón Sanchis Rovira, 9","lidiaj@albal.es; leticiar@albal.es","96 122 05 04", R.drawable.esc_albal));
            saveLead(new llista_aedl("04","Alcasser","Plaza del Castell, 1","adl@alcasser.es","96 124 03 47 / 655 619 376", R.drawable.esc_alcasser));
            saveLead(new llista_aedl("05","Aldaia","C/ Ricardo Fuster s/n","adl@ajuntamentaldaia.org","96 198 88 15/607 998 065", R.drawable.esc_aldaia));
            saveLead(new llista_aedl("06","Alfafar","Plaça Corts Valencianes","adl@alfafar.es","963182448", R.drawable.esc_alfafar));
            saveLead(new llista_aedl("07","Benetusser","Miguel Hernández, 30","empleo@benetusser.es","963765852", R.drawable.es_benetusser));
            saveLead(new llista_aedl("08","Beniparrell","Las Escuelas, 20","beniparrell_per@gva.es","961201902", R.drawable.esc_beniparrell));
            saveLead(new llista_aedl("09","Catarroja","Cami Reial, 22","adl@catarroja.es","961261301",  R.drawable.esc_catarroja));
            saveLead(new llista_aedl("10","Lloc Nou","Plaza Mayor, 5","llocnou.administracio@cv.gva.es","963751908", R.drawable.esc_llocnou));
            saveLead(new llista_aedl("11","Manises","Valencia, 22-baix","rafael.mercader@manises.es","961524632", R.drawable.esc_manises));
            saveLead(new llista_aedl("12","Massanassa","Calle Mayor, 15","aedl@massanassa.es","961255500/961251533", R.drawable.esc_massanassa));
            saveLead(new llista_aedl("13","Mislata","C/ Antonio Aparici, nº 4-6","adl@mislata.es"," 963990256/963991116", R.drawable.esc_mislata));
            saveLead(new llista_aedl("14","Paiporta","Santa Ana, 35", "agenciacolocacion@paiporta.es","963972474", R.drawable.esc_paiporta));
            saveLead(new llista_aedl("15","Picanya","Avinguda Alqueria de Moret, 41","cmedina@picanya.org","96 1594460", R.drawable.esc_picanya));
            saveLead(new llista_aedl("16","Picassent","Carles Albors 16,2ª (Centro Social)","aedlpicassent@picassent.es","961230690", R.drawable.esc_picassent));
            saveLead(new llista_aedl("17","Quart de Poblet", "C/ José Mª Coll, 8","adl.coordinacio@quartdepoblet.org;adl.projectes@quartdepoblet.org","96 184 92 53",  R.drawable.esc_quart));
            saveLead(new llista_aedl("18","Sedaví","Placa Jaume I, 5","adl@sedavi.es","963185040", R.drawable.esc_sedavi));
            saveLead(new llista_aedl("19","Silla","Pl. del poble, 1","ades@silla.es","96 1219795", R.drawable.esc_silla));
            saveLead(new llista_aedl("20","Torrent","Valencia 42-48","baixaulis@torrent.es;zaragozas@torrent.es","961111868", R.drawable.esc_torrent ));
            saveLead(new llista_aedl("21","Xirivella","Montealegre -6","adl@xirivella.es","963836424", R.drawable.esc_xirivella));
        }

        private void saveLead(llista_aedl lead) {
            lltajug.put(lead.getOrdre(), lead);
        }

        public List<llista_aedl> getLeads() {

            return new ArrayList<>(lltajug.values());
        }
    }

