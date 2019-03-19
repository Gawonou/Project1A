package tp1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * Classe definit l'image à etre modifiée
 * 
 * 
 * @author N'TSOUAGLO Kokou Gawonou
 * @author Cristian Gavidia
 * 
 * @version 6 Oct 2018
 */
public class Image {

	protected BufferedImage bImage = null;
	int width;
	int height;
	int count;
	ArrayList<Integer> compRouge = new ArrayList<Integer>();
	ArrayList<Integer> compBleu  = new ArrayList<Integer>();
	ArrayList<Integer> compVert  = new ArrayList<Integer>();
	Histogramme hRouge;
	Histogramme hVert;
	Histogramme hBleu;

	/**
	 * @param nomFichier
	 * @throws ImageNonLueException 
	 * @throws ImageInvalideException 
	 */
	public Image(String nomFichier) throws ImageNonLueException, ImageInvalideException {
		try {
			bImage = ImageIO.read(new File(nomFichier));
			this.width = bImage.getWidth();
			this.height = bImage.getHeight();
		} catch (IOException e) {
			throw new ImageNonLueException();
		} catch (NullPointerException f) {
			throw new ImageInvalideException();
		}
		
	}

	/**
	 * méthode qui rempli les Histogrammes
	 * 
	 */
	public void remplirHistogramme() {
		
		
		for(int i=0; i<height; i++) {
        
			for(int j=0; j<width; j++) {
				count++;
				Couleur c = new Couleur(bImage.getRGB(j, i));

				compRouge.add(c.getRouge());				
				compVert.add(c.getVert());  
				compBleu.add(c.getBleu());
			}
        }
		this.hRouge = new Histogramme(compRouge);
		this.hVert  = new Histogramme(compVert);
		this.hBleu  = new Histogramme(compBleu);
     }
	
	/**
	 * méthode qui cree les zones a traiter
	 * 
	 */
	public void creerZones() {
		
		this.hRouge.faireZones();		
		this.hVert.faireZones();	
		this.hBleu.faireZones();
	}
	
	/**
	 * methode qui applique le premier algorithme
	 * 
	 */
	public void correction1() {
		 		
			for(int i=0; i<height; i++) {
				for(int j=0; j<width; j++) {
					Couleur c = new Couleur(bImage.getRGB(j, i));
					
					c.setRouge(calcComposante1(c.getRouge(), this.hRouge));
					c.setVert(calcComposante1(c.getVert(), this.hVert));
					c.setBleu(calcComposante1(c.getBleu(), this.hBleu));		
									
					bImage.setRGB(j, i, c.getArgb());
				}				
			}		
	}

	/**
	 * methode qui applique le deuxieme algorithme
	 * 
	 */
	public void correction2() {
		
			for(int i=0; i<height; i++) {
				for(int j=0; j<width; j++) {
					Couleur c = new Couleur(bImage.getRGB(j, i));
					
					c.setRouge(calcComposante2(c.getRouge(), this.hRouge));
					c.setVert(calcComposante2(c.getVert(), this.hVert));
					c.setBleu(calcComposante2(c.getBleu(), this.hBleu));
															
					bImage.setRGB(j, i, c.getArgb());
				}		
			}
	}

	/*
	 * premier algorithme de correction
	 * 
	 * @param vInitiale valeur de la composante
	 * @param h Histogramme de la composante
	 */
	public int calcComposante1(int vInitiale, Histogramme h){
		
		int noZone 		= h.getNoZone(vInitiale);
		int valeurDebut = h.getDebutZone(0);
		int valeurFin 	= h.getFinaleZones();
//		int dividende	=  256 * (vInitiale - valeurDebut);
//		int diviseur	=	(valeurFin - valeurDebut +1);
		int VCorrige 	= (256 * (vInitiale - valeurDebut))/(valeurFin - valeurDebut +1);
//		System.out.println("debut:==>" + valeurDebut +  "     - Finzone ==>:" + valeurFin + "     "
//					 +  " ( vInitial===>:"+ vInitiale +"            - vDebut:===>" + valeurDebut +")");						
		return VCorrige;
	}
	
	
	/*
	 * deuxiéme algorithme de correction
	 * 
	 * @param vInitiale valeur de la composante
	 * @param h Histogramme de la composante
	 */
	public int calcComposante2(int vInitiale, Histogramme h){	
	
	int noZone     = h.getNoZone(vInitiale);
	int valeurDebut= h.getDebutZone(noZone);
	int valeurFin  = h.getFinZone(noZone);
	int milieu	=	h.getMilieu(noZone);
	int milieuSuivant = h.getMilieuSuiv(noZone); 
	
	if (noZone <= h.zones.size()-2)
		milieuSuivant = h.getMilieu(noZone+1);
	else 
		milieuSuivant = 255;
	
	int dividende1 = (milieuSuivant - milieu) + 1;
	int dividende2 = (vInitiale - valeurDebut);
	int dividende = dividende1 * dividende2;
	int diviseur = (valeurFin - valeurDebut) +1;
	int division = dividende/diviseur;
	int VCorrige   =  milieu + division;
	

//	if (vInitiale == 1) {
	//System.out.println("Msuiv:==>" + milieuSuivant +  "     - Milieu ==>:" + milieu + "     "
		//	 +  " ( vInitial===>:"+ vInitiale +"            - vDebut:===>" + valeurDebut +")");

//	System.out.println("diviseur : (vFin:" + valeurFin + " - vDebut:" + valeurDebut + "+1) =" + diviseur); 
//	System.out.println( "zone:"+ noZone + " M:" + milieu +"+(" + dividende + " / "+ diviseur +") ==" + VCorrige );
//	}
	
	return VCorrige;
	
}

	/**
	 * méthode qui sauvegarde l'image traitée
	 * dans le même format que l'image d'origine
	 * 
	 * @param format de l'image
	 * @param nom du Fichier
	 * @param message de sortie
	 * @throws PasSauvegardeException 
	 * 
	 */
	public void sauvegarder(String format, String nom, String msg) throws PasSauvegardeException {
		String nomFichier= nom + "." + format;
		try {
			ImageIO.write(bImage, format, new File(nomFichier));
			System.out.println(msg + "(" + nomFichier + ")");
		} catch (IOException e) {
			throw new PasSauvegardeException();
		}

	}
	/**
	 * méthode qui affiche les zones
	 *  
	 * 
	 */
	public void afficherZones() {
		
		System.out.println("Zones histogramme Rouge" );
		hRouge.afficherZone();
		System.out.println("Zones histogramme Vert" );
		hVert.afficherZone();
		System.out.println("Zones histogramme Bleu" );
		hBleu.afficherZone();;
		
	}
	
		
	
}
