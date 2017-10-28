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
 * A representation of the model object '<em><b>Entity With Position</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link spielfeld.EntityWithPosition#getPosition <em>Position</em>}</li>
 * </ul>
 * </p>
 *
 * @see spielfeld.SpielfeldPackage#getEntityWithPosition()
 * @model abstract="true"
 * @generated
 */
public interface EntityWithPosition extends EObject {
    /**
     * Returns the value of the '<em><b>Position</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Position</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Position</em>' reference.
     * @see #setPosition(Koordinate)
     * @see spielfeld.SpielfeldPackage#getEntityWithPosition_Position()
     * @model required="true"
     * @generated
     */
    Koordinate getPosition();

    /**
     * Sets the value of the '{@link spielfeld.EntityWithPosition#getPosition <em>Position</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Position</em>' reference.
     * @see #getPosition()
     * @generated
     */
    void setPosition(Koordinate value);

} // EntityWithPosition
