/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package architecture;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IState Analyzer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The IStateAnalyzer instance is responsible for generating the statistics about the game.
 * <!-- end-model-doc -->
 *
 *
 * @see architecture.ArchitecturePackage#getIStateAnalyzer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IStateAnalyzer extends EObject {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Counts the number of controlled fields for both {@link Farbe}n and returns the corresponding number.
     * 
     * @return The strength for the two {@link Farbe}n. The key for the  {@link Map} is the {@link Farbe} and the value is the strength.
     * <!-- end-model-doc -->
     * @model required="true"
     * @generated
     */
    Map analyzeStrength();

} // IStateAnalyzer
