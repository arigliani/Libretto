package it.polito.tdp.libretto.model;

import java.util.*;

import it.polito.tdp.libretto.db.EsameDAO;

public class Model {
     private List<Esame> esami;
     
     public Model(){
    	 this.esami=new ArrayList<Esame>();
     }
     
     /**
      * aggiungo un esame all elenco degli esami presenti,
      * verificando che non ci sia.
      * Non si lascia mai il silent failor, si mette quindi o che ritorna un buoolean, oppure 
      * che mi fa partire l' eccezione
      * @param e
      * @return true se l' hainserito, false se gia esistente e quindi non lo aggiunge
      */
    public boolean addEsame(Esame e){
    	EsameDAO dao= new EsameDAO();
    	return dao.create(e);
    }
    
    public Esame trovaEsame( String codice){
    	
        EsameDAO dao= new EsameDAO();
        
        Esame e=dao.find(codice);
        
        return e;
    	
    	
    }
}
