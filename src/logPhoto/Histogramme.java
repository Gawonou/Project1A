package tp1;

import java.util.ArrayList;

public class Histogramme {
	protected final static int HISTOGRAM_MAX = 256;
	protected final static int PAS_TROUVE = -1;

	int[] ocurrence = new int[HISTOGRAM_MAX];
	ArrayList<Zone> zones = new ArrayList<Zone>();

	protected int getOccurrence(int point) {
		return ocurrence[point];
	}

	/**
	 * @param input liste des ocurrences
	 */
	protected Histogramme(ArrayList<Integer> input) {

		for (int j = 0; j < input.size(); ++j) {			
			
			this.ocurrence[(input.get(j))]++;
			
		}
	}

	/*
	 * 
	 */
	protected void faireZones() {

		int indiceDebut = PAS_TROUVE;
		int indiceFin = PAS_TROUVE;
		int milieu = 0;

		for (int i = 0; i < ocurrence.length; ++i) {
			if (indiceDebut == PAS_TROUVE && ocurrence[i] != 0) {
				indiceDebut = i;
			}

			if (indiceDebut != PAS_TROUVE) {
				if (ocurrence[i] != 0 && i == ocurrence.length - 1)
					indiceFin = i;
				else if (ocurrence[i] == 0 && ocurrence[i - 1] != 0)
					indiceFin = i - 1;
			}

			if (indiceDebut != PAS_TROUVE && indiceFin != PAS_TROUVE) {
				
				zones.add(new Zone(indiceDebut, indiceFin));
				indiceDebut = PAS_TROUVE;
				indiceFin = PAS_TROUVE;
			}
		}
		
		for (int j = 0; j < zones.size(); ++j) {		
			
			zones.get(j).set_noZone(j);
			if (j == 0) {
				milieu = 0;
				zones.get(j).set_milieu(milieu);
			}
			else {
				
				milieu = Math.round((float) (zones.get(j-1).get_indiceFin() 
						+ (float)zones.get(j).get_indiceDebut())/2) ;

				if (j == (zones.size()-1)) {
					zones.get(j-1).set_milieuSuiv(milieu);
					zones.get(j).set_milieuSuiv(255);
				} else {
					
					zones.get(j-1).set_milieuSuiv(milieu);
				}
				
				zones.get(j).set_milieu(milieu);
				zones.get(j).set_indFinPrec( zones.get(j-1).get_indiceFin() );
			}
	
		}
	}

	/*
	 * 
	 */
	protected int getNoZone(int v) {
		int noZone = -1;
		for (int i = 0; i < zones.size(); ++i) {
			if (v >= zones.get(i).get_indiceDebut() && v <= zones.get(i).get_indiceFin())
				noZone = i;
		}
		return noZone;
	}

	/*
	 * 
	 *
	 */
	protected int getDebutZone(int z) {

		int debut = zones.get(z).get_indiceDebut();

		return debut;
	}

	/*
	 * 
	 *
	 */
	protected int getFinZone(int z) {

		int debut = zones.get(z).get_indiceFin();

		return debut;
	}

	/*
	 * 
	 *
	 */
	protected int getMilieu(int z) {

		int debut = zones.get(z).get_milieu();

		return debut;
	}

	/*
	 * 
	 *
	 */
	protected int getMilieuSuiv(int z) {

		int debut = zones.get(z).get_milieuSuiv();

		return debut;
	}

	/*
	 * 
	 */
	protected int getFinaleZones() {
		int fin = 0;
		int i = zones.size() - 1;
		if (zones.get(i) != null) {

			fin = zones.get(i).get_indiceFin();

		}
		return fin;
	}
	
	/*
	 * 
	 */
	protected void afficherZone() {
		
		System.out.println("noZone " + "debut " + "fin " + "milieu " + "finPrec " + "milieuSuiv");
		for (int j = 0; j < zones.size(); ++j) {
			if (zones.get(j).get_noZone()<10) 
				System.out.print(" ");System.out.print(zones.get(j).get_noZone() + "     ");
			if (zones.get(j).get_indiceDebut()<100) 
				System.out.print(" ");
			if (zones.get(j).get_indiceDebut()<10) 
				System.out.print(" ");
		    System.out.print(zones.get(j).get_indiceDebut() + "   ");
		    if (zones.get(j).get_indiceFin()<100) 
				System.out.print(" ");
			if (zones.get(j).get_indiceFin()<10) 
				System.out.print(" ");
		    System.out.print( zones.get(j).get_indiceFin() + "  ");
		    
		    if (zones.get(j).get_milieu()<100) 
				System.out.print(" ");
			if (zones.get(j).get_milieu()<10) 
				System.out.print(" ");
		    System.out.print( zones.get(j).get_milieu()+ "    " );
		    if (zones.get(j).get_indFinPrec()<100) 
				System.out.print(" ");
			if (zones.get(j).get_indFinPrec()<10) 
				System.out.print(" ");
		    System.out.print(zones.get(j).get_indFinPrec()+ "   " );
		    if (zones.get(j).get_milieuSuiv()<100) 
			System.out.print(" ");
		   if (zones.get(j).get_milieuSuiv()<10) 
			System.out.print(" ");
	    System.out.println( zones.get(j).get_milieuSuiv());

			
		}

		
	}
}
