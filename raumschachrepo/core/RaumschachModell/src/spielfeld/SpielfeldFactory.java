/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package spielfeld;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see spielfeld.SpielfeldPackage
 * @generated
 */
public interface SpielfeldFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    SpielfeldFactory eINSTANCE = spielfeld.impl.SpielfeldFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Figur</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Figur</em>'.
     * @generated
     */
    Figur createFigur();

    /**
     * Returns a new object of class '<em>Koordinate</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Koordinate</em>'.
     * @generated
     */
    Koordinate createKoordinate();

    /**
     * Returns a new object of class '<em>Zugset</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Zugset</em>'.
     * @generated
     */
    Zugset createZugset();

    /**
     * Returns a new object of class '<em>Straight Line</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Straight Line</em>'.
     * @generated
     */
    StraightLine createStraightLine();

    /**
     * Returns a new object of class '<em>Zug</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Zug</em>'.
     * @generated
     */
    Zug createZug();

    /**
     * Returns a new object of class '<em>Field</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Field</em>'.
     * @generated
     */
    Field createField();

    /**
     * Returns a new object of class '<em>Jump</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Jump</em>'.
     * @generated
     */
    Jump createJump();

    /**
     * Returns a new object of class '<em>Selectable Position</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Selectable Position</em>'.
     * @generated
     */
    SelectablePosition createSelectablePosition();

    /**
     * Returns a new object of class '<em>Colored Selectable</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Colored Selectable</em>'.
     * @generated
     */
    ColoredSelectable createColoredSelectable();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    SpielfeldPackage getSpielfeldPackage();

} //SpielfeldFactory
