package moduliertersingvogel.nexus.model;

/**
 * A representation of the model object '<em><b>Spieler</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class Spieler {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * The turnPlayedByThisPlayer attribute indicates the number of turns played
	 * by this special player. This can be up to 1 more than played by others.
	 * If this is the case, this player has to wait until the others finish
	 * their turns. <!-- end-model-doc -->
	 * 
	 * @generated
	 */
	private int turnPlayedByThisPlayer = 0;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private String name = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private SpielerStates state = SpielerStates.CANMOVEFIGURE;

	/**
	 * Returns the value of '<em><b>turnPlayedByThisPlayer</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * The turnPlayedByThisPlayer attribute indicates the number of turns played
	 * by this special player. This can be up to 1 more than played by others.
	 * If this is the case, this player has to wait until the others finish
	 * their turns. <!-- end-model-doc -->
	 * 
	 * @return the value of '<em><b>turnPlayedByThisPlayer</b></em>' feature
	 * @generated
	 */
	public int getTurnPlayedByThisPlayer() {
		return turnPlayedByThisPlayer;
	}

	/**
	 * Sets the '{@link Spieler#getTurnPlayedByThisPlayer()
	 * <em>turnPlayedByThisPlayer</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * The turnPlayedByThisPlayer attribute indicates the number of turns played
	 * by this special player. This can be up to 1 more than played by others.
	 * If this is the case, this player has to wait until the others finish
	 * their turns. <!-- end-model-doc -->
	 * 
	 * @param the
	 *            new value of the '{@link Spieler#getTurnPlayedByThisPlayer()
	 *            turnPlayedByThisPlayer}' feature.
	 * @generated
	 */
	public void setTurnPlayedByThisPlayer(int newTurnPlayedByThisPlayer) {
		turnPlayedByThisPlayer = newTurnPlayedByThisPlayer;
	}

	/**
	 * Returns the value of '<em><b>name</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>name</b></em>' feature
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the '{@link Spieler#getName() <em>name</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param the
	 *            new value of the '{@link Spieler#getName() name}' feature.
	 * @generated
	 */
	public void setName(String newName) {
		name = newName;
	}

	/**
	 * Returns the value of '<em><b>state</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>state</b></em>' feature
	 * @generated
	 */
	public SpielerStates getState() {
		return state;
	}

	/**
	 * Sets the '{@link Spieler#getState() <em>state</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param the
	 *            new value of the '{@link Spieler#getState() state}' feature.
	 * @generated
	 */
	public void setState(SpielerStates newState) {
		state = newState;
	}

	/**
	 * A toString method which prints the values of all EAttributes of this
	 * instance. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return "Spieler " + " [turnPlayedByThisPlayer: "
				+ getTurnPlayedByThisPlayer() + "]" + " [name: " + getName()
				+ "]" + " [state: " + getState() + "]";
	}
}
