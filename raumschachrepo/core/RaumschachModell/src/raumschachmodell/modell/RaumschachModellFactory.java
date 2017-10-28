/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package raumschachmodell.modell;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see raumschachmodell.modell.RaumschachModellPackage
 * @generated
 */
public interface RaumschachModellFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    RaumschachModellFactory eINSTANCE = raumschachmodell.modell.impl.RaumschachModellFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Spiel</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Spiel</em>'.
     * @generated
     */
    Spiel createSpiel();

    /**
     * Returns a new object of class '<em>Spieler</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Spieler</em>'.
     * @generated
     */
    Spieler createSpieler();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    RaumschachModellPackage getRaumschachModellPackage();

} //RaumschachModellFactory
