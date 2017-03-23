package it.polito.tdp.libretto.model;

import java.util.*;

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
    	if(!esami.contains(e)){
    		esami.add(e);
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    
    public Esame trovaEsame( String codice){
    	
    	//codì mi cerca l' esame che vglio, l ho potuto fare perche il mio equals si basa solo sul codice
    	int pos=this.esami.indexOf(new Esame(codice, null, null));
    	if(pos==-1){
    		return null;
    	}
    	else{
    		return esami.get(pos);
    	}
    	
    	
    }
}
