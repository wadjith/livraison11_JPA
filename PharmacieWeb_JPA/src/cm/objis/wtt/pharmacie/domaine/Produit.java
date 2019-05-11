package cm.objis.wtt.pharmacie.domaine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Cette classe représente les produits qui sont manipul�es dans l'application
 * 
 * @author thierry WADJI
 * @version 1.0
 *
 */

@Entity
public class Produit {
	
	/**
	 * Les propriétes d'un produit.
	 * reference: est le numéro de référence du produit
	 * libelle
	 * prix
	 * quantite
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(length=5, unique=true)
	private String reference;
	
	@Column(length=50)
	private String libelle;
	
	private double prix;
	private int quantite;
	
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produit(String reference, String libelle, double prix, int quantite) {
		super();
		this.reference = reference;
		this.libelle = libelle;
		this.prix = prix;
		this.quantite = quantite;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "Produit = [reference=" + reference + ", libelle=" + libelle + ", prix=" + prix + ", quantite=" + quantite
				+ "]";
	}
	
	

	
}
