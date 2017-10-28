package moduliertersingvogel.nexus.model;

/**
 * A representation of the model object '<em><b>ebene</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class Ebene extends Positioniert {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private Ebenenstatus status = Ebenenstatus.VOLL;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private Ebenenfarbe farbe = Ebenenfarbe.ORANGE;

	/**
	 * Returns the value of '<em><b>status</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>status</b></em>' feature
	 * @generated
	 */
	public Ebenenstatus getStatus() {
		return status;
	}

	/**
	 * Sets the '{@link Ebene#getStatus() <em>status</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param the
	 *            new value of the '{@link Ebene#getStatus() status}' feature.
	 * @generated
	 */
	public void setStatus(Ebenenstatus newStatus) {
		status = newStatus;
	}

	/**
	 * Returns the value of '<em><b>farbe</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>farbe</b></em>' feature
	 * @generated
	 */
	public Ebenenfarbe getFarbe() {
		return farbe;
	}

	/**
	 * Sets the '{@link Ebene#getFarbe() <em>farbe</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param the
	 *            new value of the '{@link Ebene#getFarbe() farbe}' feature.
	 * @generated
	 */
	public void setFarbe(Ebenenfarbe newFarbe) {
		farbe = newFarbe;
	}

	/**
	 * A toString method which prints the values of all EAttributes of this
	 * instance. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return "ebene " + " [status: " + getStatus() + "]" + " [farbe: "
				+ getFarbe() + "]";
	}
}
