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
 * A representation of the model object '<em><b>Zug</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link spielfeld.Zug#getFigur <em>Figur</em>}</li>
 *   <li>{@link spielfeld.Zug#getStartPosition <em>Start Position</em>}</li>
 *   <li>{@link spielfeld.Zug#getEndPosition <em>End Position</em>}</li>
 * </ul>
 * </p>
 *
 * @see spielfeld.SpielfeldPackage#getZug()
 * @model
 * @generated
 */
public interface Zug extends EObject {
    /**
     * Returns the value of the '<em><b>Figur</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Figur</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Figur</em>' reference.
     * @see #setFigur(Figur)
     * @see spielfeld.SpielfeldPackage#getZug_Figur()
     * @model required="true"
     * @generated
     */
    Figur getFigur();

    /**
     * Sets the value of the '{@link spielfeld.Zug#getFigur <em>Figur</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Figur</em>' reference.
     * @see #getFigur()
     * @generated
     */
    void setFigur(Figur value);

    /**
     * Returns the value of the '<em><b>Start Position</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Start Position</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Start Position</em>' reference.
     * @see #setStartPosition(Koordinate)
     * @see spielfeld.SpielfeldPackage#getZug_StartPosition()
     * @model required="true"
     * @generated
     */
    Koordinate getStartPosition();

    /**
     * Sets the value of the '{@link spielfeld.Zug#getStartPosition <em>Start Position</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Start Position</em>' reference.
     * @see #getStartPosition()
     * @generated
     */
    void setStartPosition(Koordinate value);

    /**
     * Returns the value of the '<em><b>End Position</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>End Position</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>End Position</em>' reference.
     * @see #setEndPosition(Koordinate)
     * @see spielfeld.SpielfeldPackage#getZug_EndPosition()
     * @model required="true"
     * @generated
     */
    Koordinate getEndPosition();

    /**
     * Sets the value of the '{@link spielfeld.Zug#getEndPosition <em>End Position</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>End Position</em>' reference.
     * @see #getEndPosition()
     * @generated
     */
    void setEndPosition(Koordinate value);

} // Zug
