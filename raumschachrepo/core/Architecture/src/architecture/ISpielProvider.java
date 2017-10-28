/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package architecture;

import org.eclipse.emf.ecore.EObject;

import raumschachmodell.modell.Spiel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ISpiel Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The ISpielProvider instance is the central place for getting the actual game.
 * <!-- end-model-doc -->
 *
 *
 * @see architecture.ArchitecturePackage#getISpielProvider()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ISpielProvider extends EObject {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Get the game
     * @return The game.
     * <!-- end-model-doc -->
     * @model kind="operation" required="true"
     * @generated
     */
    Spiel getSpiel();

} // ISpielProvider
