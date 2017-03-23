package it.polito.tdp.libretto.model;

import java.time.LocalDate;

/**
     * oggetto semplice che contiene dati relativi ad un 
     * singolo esame
     * POJO - plain old object
     * 
     * dati privati(proprieta') ** e' l unica parte che non ci genera eclipse da solo
     * costruttore
     * metodi get/set
     * metodi di servizio (toString, equals, hasCose, [compareTo])
     * 
     */
public class Esame {
	private String codice;
	private String titolo;	
	private String docente;
	//private Docente docente; questo sarebbe giusto
	
	private boolean superato;
	private int voto;
	private LocalDate dataSuperamento;
	
	/**
	 * Nuovo esame, non ancora superato
	 * @param codice codice dell' esame
	 * @param titolo denominazione corso 
	 * @param docente cognome e nome del docente titolare
	 */
	public Esame(String codice, String titolo, String docente) {
		super();
		this.codice = codice;
		this.titolo = titolo;
		this.docente = docente;
		
		this.superato=false;
	}

	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * @param codice the codice to set
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * @param titolo the titolo to set
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * @return the docente
	 */
	public String getDocente() {
		return docente;
	}

	/**
	 * @param docente the docente to set
	 */
	public void setDocente(String docente) {
		this.docente = docente;
	}

	/**
	 * @return the superato
	 */
	public boolean isSuperato() {
		return superato;
	}

	/**
	 * @param superato the superato to set
	 */
	private void setSuperato(boolean superato) {
		this.superato = superato;
	}

	/**
	 * restistuisce il voto solo se l' esame � stato superato
	 * @return the voto
	 */
	public int getVoto() {
		if(this.superato)
		return voto;
		else
			throw new IllegalStateException(" Esame "+ this.codice+ " non ancora superato");
			
	}

	/**
	 * @param voto the voto to set
	 */
	public void setVoto(int voto) {
		this.voto = voto;
	}

	/**
	 * @return the dataSuperamento
	 */
	public LocalDate getDataSuperamento() {
		return dataSuperamento;
	}

	/**
	 * e' privato perche mi fa a fallare il sisteme se me lo chiama qualcun altro
	 * @param dataSuperamento the dataSuperamento to set
	 */
	private void setDataSuperamento(LocalDate dataSuperamento) {
		this.dataSuperamento = dataSuperamento;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Esame [codice=" + codice + ", titolo=" + titolo + ", docente=" + docente + ", superato=" + superato
				+ ", voto=" + voto + ", dataSuperamento=" + dataSuperamento + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}
	

	/**
	 * se l' esame non � ancora superato lo trasforma in superato con la data
	 * e l' ora passata, altrimenti errori
	 * 
	 * @param voto
	 * @param data
	 */
	public void supera( int voto, LocalDate data){
		if(!this.superato){
			//non ancora superato ok
			this.voto=voto;
			this.dataSuperamento=data;
			this.superato=true;
		}
		else{
			throw new IllegalStateException(" Esame "+ this.codice +" gia' superato");// perche non me lo dava come suggerimento?
		}
	}
	//mancano 9 minuti alla fine lezione
	
}
