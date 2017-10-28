package nexus._1;

/**
 * A representation of the model object '<em><b>gestalt</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class Gestalt extends Positioniert {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private Spieler spieler = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private int weite = 0;

	/**
	 * Returns the value of '<em><b>spieler</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>spieler</b></em>' feature
	 * @generated
	 */
	public Spieler getSpieler() {
		return spieler;
	}

	/**
	 * Sets the '{@link Gestalt#getSpieler() <em>spieler</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param the
	 *            new value of the '{@link Gestalt#getSpieler() spieler}'
	 *            feature.
	 * @generated
	 */
	public void setSpieler(Spieler newSpieler) {
		spieler = newSpieler;
	}

	/**
	 * Returns the value of '<em><b>weite</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>weite</b></em>' feature
	 * @generated
	 */
	public int getWeite() {
		return weite;
	}

	/**
	 * Sets the '{@link Gestalt#getWeite() <em>weite</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param the
	 *            new value of the '{@link Gestalt#getWeite() weite}' feature.
	 * @generated
	 */
	public void setWeite(int newWeite) {
		weite = newWeite;
	}

	/**
	 * A toString method which prints the values of all EAttributes of this
	 * instance. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return "gestalt " + " [weite: " + getWeite() + "]";
	}
}
