/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package architecture;

import java.util.List;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.swt.widgets.Display;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IDisplay Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see architecture.ArchitecturePackage#getIDisplayProvider()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IDisplayProvider extends EObject {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Allows access to all displays registered. This is useful if you want to show for example messages to <b>all</b> players.
     * 
     * @return A {@link EList} of {@link Display}s
     * <!-- end-model-doc -->
     * @model kind="operation" dataType="architecture.EDisplay"
     * @generated
     */
    List<Display> getAllDisplays();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Allows access to a {@link Display}.
     * 
     * @param id  The {@link HttpSession#getId()}.
     * @return The {@link Display} belonging to the {@link HttpSession} with the given id.
     * 
     * <!-- end-model-doc -->
     * @model dataType="architecture.EDisplay" required="true"
     * @generated
     */
    Display getDisplay(String id);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Maps a given {@link Display} to a given {@link HttpSession#getId()}.
     * 
     * @param string The {@link HttpSession#getId()}.
     * @param disp The {@link Display}.
     * 
     * <!-- end-model-doc -->
     * @model displayDataType="architecture.EDisplay"
     * @generated
     */
    void addDisplay(String id, Display display);

} // IDisplayProvider
