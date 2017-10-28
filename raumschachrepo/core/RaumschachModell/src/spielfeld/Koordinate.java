/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package spielfeld;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Koordinate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link spielfeld.Koordinate#getEbene <em>Ebene</em>}</li>
 *   <li>{@link spielfeld.Koordinate#getBuchstabe <em>Buchstabe</em>}</li>
 *   <li>{@link spielfeld.Koordinate#getZahl <em>Zahl</em>}</li>
 * </ul>
 * </p>
 *
 * @see spielfeld.SpielfeldPackage#getKoordinate()
 * @model
 * @generated
 */
public interface Koordinate extends EObject {
    /**
     * Returns the value of the '<em><b>Ebene</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ebene</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ebene</em>' attribute.
     * @see #setEbene(int)
     * @see spielfeld.SpielfeldPackage#getKoordinate_Ebene()
     * @model default="0"
     * @generated
     */
    int getEbene();

    /**
     * Sets the value of the '{@link spielfeld.Koordinate#getEbene <em>Ebene</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ebene</em>' attribute.
     * @see #getEbene()
     * @generated
     */
    void setEbene(int value);

    /**
     * Returns the value of the '<em><b>Buchstabe</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Buchstabe</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Buchstabe</em>' attribute.
     * @see #setBuchstabe(int)
     * @see spielfeld.SpielfeldPackage#getKoordinate_Buchstabe()
     * @model default="0"
     * @generated
     */
    int getBuchstabe();

    /**
     * Sets the value of the '{@link spielfeld.Koordinate#getBuchstabe <em>Buchstabe</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Buchstabe</em>' attribute.
     * @see #getBuchstabe()
     * @generated
     */
    void setBuchstabe(int value);

    /**
     * Returns the value of the '<em><b>Zahl</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Zahl</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Zahl</em>' attribute.
     * @see #setZahl(int)
     * @see spielfeld.SpielfeldPackage#getKoordinate_Zahl()
     * @model default="0"
     * @generated
     */
    int getZahl();

    /**
     * Sets the value of the '{@link spielfeld.Koordinate#getZahl <em>Zahl</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Zahl</em>' attribute.
     * @see #getZahl()
     * @generated
     */
    void setZahl(int value);

} // Koordinate
