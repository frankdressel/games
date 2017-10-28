package nexus._1;

import java.util.ArrayList;
import java.util.List;

/**
 * A representation of the model object '<em><b>Zugliste</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class Zugliste {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private List<Zug> zuege = new ArrayList<Zug>();

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
	 * Sets the '{@link Zugliste#getZuege() <em>zuege</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param the
	 *            new value of the '{@link Zugliste#getZuege() zuege}' feature.
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
		return "Zugliste ";
	}
}
