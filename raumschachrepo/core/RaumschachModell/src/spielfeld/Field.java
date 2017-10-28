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
 * A representation of the model object '<em><b>Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link spielfeld.Field#isAttackable <em>Attackable</em>}</li>
 *   <li>{@link spielfeld.Field#isPossible <em>Possible</em>}</li>
 * </ul>
 * </p>
 *
 * @see spielfeld.SpielfeldPackage#getField()
 * @model
 * @generated
 */
public interface Field extends ColoredSelectable {
    /**
     * Returns the value of the '<em><b>Attackable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Attackable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Attackable</em>' attribute.
     * @see #setAttackable(boolean)
     * @see spielfeld.SpielfeldPackage#getField_Attackable()
     * @model required="true"
     * @generated
     */
    boolean isAttackable();

    /**
     * Sets the value of the '{@link spielfeld.Field#isAttackable <em>Attackable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Attackable</em>' attribute.
     * @see #isAttackable()
     * @generated
     */
    void setAttackable(boolean value);

    /**
     * Returns the value of the '<em><b>Possible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Possible</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Possible</em>' attribute.
     * @see #setPossible(boolean)
     * @see spielfeld.SpielfeldPackage#getField_Possible()
     * @model required="true"
     * @generated
     */
    boolean isPossible();

    /**
     * Sets the value of the '{@link spielfeld.Field#isPossible <em>Possible</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Possible</em>' attribute.
     * @see #isPossible()
     * @generated
     */
    void setPossible(boolean value);

} // Field
