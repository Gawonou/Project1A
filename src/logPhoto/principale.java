package logPhoto;
import java.util.Scanner;


/**
 *  Classe qui corrige les couleurs sur une photo
 * 
 * 
 * @version 9 Oct 2018
 */
public class principale {

	//constantes de classe
	public final static String MSG_SOL_FICHIER = "Entrez le nom de la photo (image) à corriger. Le programme accepte les "
			                                    + "\n extension comme bmp gif jpeg jpg jpe png tif tiff wbmp : "; 
	public final static String MSG_SORTIE = "La photo a été corrigée avec success. "; 
	public final static String MSG_ERR_FORMAT = "Photo non lue, le fichier doit être de type image."
							+ "\n (bmp gif jpeg jpg jpe png tif tiff wbmp)";
	public final static String MSG_ERR_EXT = "Photo non lue, le fichier doit avoir une extension:"
			+ "\n ex: nomdefichier.jpg (ou : bmp gif jpeg jpe png tif tiff wbmp)";
	public final static String MSG_ERR_FICHIER = "Photo non lue, Verifiez le nom du fichier.";
	public final static String MSG_ERR_IMAGE = "Photo non lue, le fichier doit être une image.";
	public final static String MSG_ERR_SORTIE = "Photo non traitée. Veillez recommencer SVP.";
	public final static String AJOUT_SORTIE1 = "cls";
	public final static String AJOUT_SORTIE2 = "clc";

	
	public static void main(String[] args) {
		
		
		
		String nomFichierEntrees = lireChaine(MSG_SOL_FICHIER);
		String extEntree = null;
		String nomFichierSortie1 = null;
		String nomFichierSortie2 = null;
		
		try {
			nomFichierSortie1 = calculNomSortie(nomFichierEntrees,AJOUT_SORTIE1);
			nomFichierSortie2 = calculNomSortie(nomFichierEntrees,AJOUT_SORTIE2);
		
		}catch (FormatInvalideException e) {
			System.err.print(MSG_ERR_EXT);
			System.exit(-1);
		}
		
		Image correct1 = null;
		Image correct2 = null;
		
		try {
			
			extEntree = obtenirExtension(nomFichierEntrees);
			validerExtension(extEntree);
			correct1 = new Image( nomFichierEntrees );
			correct2 = new Image( nomFichierEntrees );

		} catch (ImageNonLueException e) {
			System.err.print(MSG_ERR_FICHIER);
			System.exit(-1);
			
		}  catch (ImageInvalideException e) {
			System.err.print(MSG_ERR_IMAGE);
			System.exit(-1);
			
		}catch (FormatInvalideException e) {
			System.err.print(MSG_ERR_FORMAT);
			System.exit(-1);
		}
			
		correct1.remplirHistogramme();
		correct2.remplirHistogramme();
		
		correct1.creerZones();
		correct2.creerZones();
		
		correct1.correction1();
//		correct2.afficherZones();
		correct2.correction2();
		
		try {
			correct1.sauvegarder(extEntree, nomFichierSortie1, MSG_SORTIE);
			correct2.sauvegarder(extEntree, nomFichierSortie2, MSG_SORTIE);
			
		}   catch (PasSauvegardeException e) {
				System.err.print(MSG_ERR_SORTIE);
				System.exit(-1);
			}
		
	}
		
	
	/**
	 * méthode qui lit le nom du fichier
     * 
     * @param question demandant le nom du fichier
     * @return nom du fichier
     */	
	public static String lireChaine( String question ) {
		Scanner sc = new Scanner( System.in );
		
		System.out.print( question );
		String nomFichier = sc.nextLine();
		
		sc.close();
		
		return nomFichier;
	}
	
	/**
	 * méthode qui genere le nom du fichier
	 * en sortie  
     * 
     * @param nom du fichier source
     * @param ajout au nom
     * @return nomSortie du fichier destination
	 * @throws FormatInvalideException 
     */	
	public static String calculNomSortie(String nom, String ajout) throws FormatInvalideException {
	
		String nomSortie;
		
		if (nom.contains("."))
			nomSortie = nom.substring(0,nom.indexOf(".")) 
				+ ajout;
		else
			throw new FormatInvalideException();
		return nomSortie;
	}
	
	/**
	 * obtient l'extension du fichier
	 * pour valider que c'est un type supporté  
     * 
     * @param  nom du fichier source
     * @return extension du fichier en entrée
	 * @throws ImageNonLueException 
     */	
	public static String obtenirExtension(String nom) throws ImageNonLueException {
	
		String extension = null;
		
		if (nom.lastIndexOf(".") != -1) { 
			extension = nom.substring(nom.lastIndexOf(".")+1);
			
		} else 
				throw new ImageNonLueException();
		
		return extension;
	}
	
	/**
	 * valider que l'image est un type supporté
	 * selon la liste d'extensions dans le TP  
     * 
     * @param  extension du fichier en entrée
	 * @throws FormatInvalideException 
     */	
	public static void validerExtension(String extension) throws FormatInvalideException {
		
		try {
			Formats.valueOf(extension.toUpperCase());
		
		} catch (IllegalArgumentException e) {
		
				throw new FormatInvalideException();
			}
	
	}	

}
