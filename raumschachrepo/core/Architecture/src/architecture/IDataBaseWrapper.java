/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package architecture;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IData Base Wrapper</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see architecture.ArchitecturePackage#getIDataBaseWrapper()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IDataBaseWrapper extends EObject {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Retrieves the actual name of the player based on the ip from the database.
     * @return The name of the player.
     * <!-- end-model-doc -->
     * @model kind="operation" required="true"
     * @generated
     */
    String getNameForActualPlayer();

} // IDataBaseWrapper
