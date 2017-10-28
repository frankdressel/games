/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package architecture;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see architecture.ArchitecturePackage
 * @generated
 */
public interface ArchitectureFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ArchitectureFactory eINSTANCE = architecture.impl.ArchitectureFactoryImpl.init();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    ArchitecturePackage getArchitecturePackage();

} //ArchitectureFactory
