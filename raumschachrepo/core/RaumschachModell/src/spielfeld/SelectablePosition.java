/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package spielfeld;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selectable Position</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link spielfeld.SelectablePosition#isSelected <em>Selected</em>}</li>
 * </ul>
 * </p>
 *
 * @see spielfeld.SpielfeldPackage#getSelectablePosition()
 * @model
 * @generated
 */
public interface SelectablePosition extends EntityWithPosition {
    /**
     * Returns the value of the '<em><b>Selected</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Selected</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Selected</em>' attribute.
     * @see #setSelected(boolean)
     * @see spielfeld.SpielfeldPackage#getSelectablePosition_Selected()
     * @model required="true"
     * @generated
     */
    boolean isSelected();

    /**
     * Sets the value of the '{@link spielfeld.SelectablePosition#isSelected <em>Selected</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Selected</em>' attribute.
     * @see #isSelected()
     * @generated
     */
    void setSelected(boolean value);

} // SelectablePosition
