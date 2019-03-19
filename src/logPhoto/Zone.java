package tp1;

/**
 * Classe qui defini l'objet Zone
 * 
 * 
 * @author N'TSOUAGLO Kokou Gawonou
 * @author Cristian Gavidia
 * 
 * @version 7 Oct 2018
 */
public class Zone {
	
	private	int	_noZone;
	private int _indiceDebut;
	private int _indiceFin;
	private int _indFinPrec;
	private int _milieu;
	private int _milieuSuiv;
	
	/**
	 * Constructeur de l'objet
	 * 
	 * @param _indiceDebut
	 * @param _indiceFin   
	 */
	protected Zone(int _indiceDebut, int _indiceFin) {
		this._indiceDebut = _indiceDebut;
		this._indiceFin = _indiceFin;
		this._indFinPrec =0;
		this._milieu = 0;
		this._milieuSuiv=0;
	}
	protected int get_noZone() {
		return _noZone;
	}

	protected void set_noZone(int _noZone) {
		this._noZone = _noZone;
	}
	
	protected int get_indFinPrec() {
		return _indFinPrec;
	}

	protected void set_indFinPrec(int _indFinPrec) {
		this._indFinPrec = _indFinPrec;
	}

	protected int get_milieuSuiv() {
		return _milieuSuiv;
	}

	protected void set_milieuSuiv(int _milieuSuiv) {
		this._milieuSuiv = _milieuSuiv;
	}

	protected int get_milieu() {
		return _milieu;
	}

	protected void set_milieu(int _milieu) {
		this._milieu = _milieu;
	}

	protected int get_indiceDebut() {
		return _indiceDebut;
	}

	protected void set_indiceDebut(int _indiceDebut) {
		this._indiceDebut = _indiceDebut;
	}

	protected int get_indiceFin() {
		return _indiceFin;
	}

	protected void set_indiceFin(int _indiceFin) {
		this._indiceFin = _indiceFin;
	}

}
