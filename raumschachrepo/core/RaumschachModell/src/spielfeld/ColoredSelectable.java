/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package spielfeld;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Colored Selectable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link spielfeld.ColoredSelectable#getFarbe <em>Farbe</em>}</li>
 * </ul>
 * </p>
 *
 * @see spielfeld.SpielfeldPackage#getColoredSelectable()
 * @model
 * @generated
 */
public interface ColoredSelectable extends SelectablePosition {
    /**
     * Returns the value of the '<em><b>Farbe</b></em>' attribute.
     * The literals are from the enumeration {@link spielfeld.Farbe}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Farbe</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Farbe</em>' attribute.
     * @see spielfeld.Farbe
     * @see #setFarbe(Farbe)
     * @see spielfeld.SpielfeldPackage#getColoredSelectable_Farbe()
     * @model required="true"
     * @generated
     */
    Farbe getFarbe();

    /**
     * Sets the value of the '{@link spielfeld.ColoredSelectable#getFarbe <em>Farbe</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Farbe</em>' attribute.
     * @see spielfeld.Farbe
     * @see #getFarbe()
     * @generated
     */
    void setFarbe(Farbe value);

} // ColoredSelectable
