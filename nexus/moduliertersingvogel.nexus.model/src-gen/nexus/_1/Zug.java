package nexus._1;

/**
 * A representation of the model object '<em><b>Zug</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class Zug {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private int turn = 0;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private Gestalt gestalt = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private Ebene ziel = null;

	/**
	 * Returns the value of '<em><b>turn</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>turn</b></em>' feature
	 * @generated
	 */
	public int getTurn() {
		return turn;
	}

	/**
	 * Sets the '{@link Zug#getTurn() <em>turn</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param the
	 *            new value of the '{@link Zug#getTurn() turn}' feature.
	 * @generated
	 */
	public void setTurn(int newTurn) {
		turn = newTurn;
	}

	/**
	 * Returns the value of '<em><b>gestalt</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>gestalt</b></em>' feature
	 * @generated
	 */
	public Gestalt getGestalt() {
		return gestalt;
	}

	/**
	 * Sets the '{@link Zug#getGestalt() <em>gestalt</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param the
	 *            new value of the '{@link Zug#getGestalt() gestalt}' feature.
	 * @generated
	 */
	public void setGestalt(Gestalt newGestalt) {
		gestalt = newGestalt;
	}

	/**
	 * Returns the value of '<em><b>ziel</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>ziel</b></em>' feature
	 * @generated
	 */
	public Ebene getZiel() {
		return ziel;
	}

	/**
	 * Sets the '{@link Zug#getZiel() <em>ziel</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param the
	 *            new value of the '{@link Zug#getZiel() ziel}' feature.
	 * @generated
	 */
	public void setZiel(Ebene newZiel) {
		ziel = newZiel;
	}

	/**
	 * A toString method which prints the values of all EAttributes of this
	 * instance. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return "Zug " + " [turn: " + getTurn() + "]";
	}
}
