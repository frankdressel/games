package nexus._1;

import java.util.ArrayList;
import java.util.List;

/**
 * A representation of the model object '<em><b>spiel</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class Spiel {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * The turnPlayedByAllPlayers attribute indicates the number of turns played
	 * by all players. <!-- end-model-doc -->
	 * 
	 * @generated
	 */
	private int turnPlayedByAllPlayers = 0;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private List<Ebene> ebenen = new ArrayList<Ebene>();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private String id = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private List<Spieler> beteiligteSpieler = new ArrayList<Spieler>();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private List<Zug> zuege = new ArrayList<Zug>();

	/**
	 * Returns the value of '<em><b>turnPlayedByAllPlayers</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * The turnPlayedByAllPlayers attribute indicates the number of turns played
	 * by all players. <!-- end-model-doc -->
	 * 
	 * @return the value of '<em><b>turnPlayedByAllPlayers</b></em>' feature
	 * @generated
	 */
	public int getTurnPlayedByAllPlayers() {
		return turnPlayedByAllPlayers;
	}

	/**
	 * Sets the '{@link Spiel#getTurnPlayedByAllPlayers()
	 * <em>turnPlayedByAllPlayers</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * The turnPlayedByAllPlayers attribute indicates the number of turns played
	 * by all players. <!-- end-model-doc -->
	 * 
	 * @param the
	 *            new value of the '{@link Spiel#getTurnPlayedByAllPlayers()
	 *            turnPlayedByAllPlayers}' feature.
	 * @generated
	 */
	public void setTurnPlayedByAllPlayers(int newTurnPlayedByAllPlayers) {
		turnPlayedByAllPlayers = newTurnPlayedByAllPlayers;
	}

	/**
	 * Returns the value of '<em><b>ebenen</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>ebenen</b></em>' feature
	 * @generated
	 */
	public List<Ebene> getEbenen() {
		return ebenen;
	}

	/**
	 * Adds to the <em>ebenen</em> feature.
	 * 
	 * @generated
	 */
	public void addToEbenen(Ebene ebenenValue) {
		if (!ebenen.contains(ebenenValue)) {
			ebenen.add(ebenenValue);
		}
	}

	/**
	 * Removes from the <em>ebenen</em> feature.
	 * 
	 * @generated
	 */
	public void removeFromEbenen(Ebene ebenenValue) {
		if (ebenen.contains(ebenenValue)) {
			ebenen.remove(ebenenValue);
		}
	}

	/**
	 * Clears the <em>ebenen</em> feature.
	 * 
	 * @generated
	 */
	public void clearEbenen() {
		while (!ebenen.isEmpty()) {
			removeFromEbenen(ebenen.iterator().next());
		}
	}

	/**
	 * Sets the '{@link Spiel#getEbenen() <em>ebenen</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param the
	 *            new value of the '{@link Spiel#getEbenen() ebenen}' feature.
	 * @generated
	 */
	public void setEbenen(List<Ebene> newEbenen) {
		ebenen = newEbenen;
	}

	/**
	 * Returns the value of '<em><b>id</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>id</b></em>' feature
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the '{@link Spiel#getId() <em>id</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param the
	 *            new value of the '{@link Spiel#getId() id}' feature.
	 * @generated
	 */
	public void setId(String newId) {
		id = newId;
	}

	/**
	 * Returns the value of '<em><b>beteiligteSpieler</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>beteiligteSpieler</b></em>' feature
	 * @generated
	 */
	public List<Spieler> getBeteiligteSpieler() {
		return beteiligteSpieler;
	}

	/**
	 * Adds to the <em>beteiligteSpieler</em> feature.
	 * 
	 * @generated
	 */
	public void addToBeteiligteSpieler(Spieler beteiligteSpielerValue) {
		if (!beteiligteSpieler.contains(beteiligteSpielerValue)) {
			beteiligteSpieler.add(beteiligteSpielerValue);
		}
	}

	/**
	 * Removes from the <em>beteiligteSpieler</em> feature.
	 * 
	 * @generated
	 */
	public void removeFromBeteiligteSpieler(Spieler beteiligteSpielerValue) {
		if (beteiligteSpieler.contains(beteiligteSpielerValue)) {
			beteiligteSpieler.remove(beteiligteSpielerValue);
		}
	}

	/**
	 * Clears the <em>beteiligteSpieler</em> feature.
	 * 
	 * @generated
	 */
	public void clearBeteiligteSpieler() {
		while (!beteiligteSpieler.isEmpty()) {
			removeFromBeteiligteSpieler(beteiligteSpieler.iterator().next());
		}
	}

	/**
	 * Sets the '{@link Spiel#getBeteiligteSpieler() <em>beteiligteSpieler</em>}
	 * ' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param the
	 *            new value of the '{@link Spiel#getBeteiligteSpieler()
	 *            beteiligteSpieler}' feature.
	 * @generated
	 */
	public void setBeteiligteSpieler(List<Spieler> newBeteiligteSpieler) {
		beteiligteSpieler = newBeteiligteSpieler;
	}

	/**
	 * Returns the value of '<em><b>zuege</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>zuege</b></em>' feature
	 * @generated
	 */
	public List<Zug> getZuege() {
		return zuege;
	}

	/**
	 * Adds to the <em>zuege</em> feature.
	 * 
	 * @generated
	 */
	public void addToZuege(Zug zuegeValue) {
		if (!zuege.contains(zuegeValue)) {
			zuege.add(zuegeValue);
		}
	}

	/**
	 * Removes from the <em>zuege</em> feature.
	 * 
	 * @generated
	 */
	public void removeFromZuege(Zug zuegeValue) {
		if (zuege.contains(zuegeValue)) {
			zuege.remove(zuegeValue);
		}
	}

	/**
	 * Clears the <em>zuege</em> feature.
	 * 
	 * @generated
	 */
	public void clearZuege() {
		while (!zuege.isEmpty()) {
			removeFromZuege(zuege.iterator().next());
		}
	}

	/**
	 * Sets the '{@link Spiel#getZuege() <em>zuege</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param the
	 *            new value of the '{@link Spiel#getZuege() zuege}' feature.
	 * @generated
	 */
	public void setZuege(List<Zug> newZuege) {
		zuege = newZuege;
	}

	/**
	 * A toString method which prints the values of all EAttributes of this
	 * instance. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return "spiel " + " [turnPlayedByAllPlayers: "
				+ getTurnPlayedByAllPlayers() + "]" + " [id: " + getId() + "]";
	}
}
