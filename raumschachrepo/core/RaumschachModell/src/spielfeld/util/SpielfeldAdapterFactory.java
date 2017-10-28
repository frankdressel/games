/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package spielfeld.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import spielfeld.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see spielfeld.SpielfeldPackage
 * @generated
 */
public class SpielfeldAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static SpielfeldPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SpielfeldAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = SpielfeldPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SpielfeldSwitch<Adapter> modelSwitch =
        new SpielfeldSwitch<Adapter>() {
            @Override
            public Adapter caseFigur(Figur object) {
                return createFigurAdapter();
            }
            @Override
            public Adapter caseKoordinate(Koordinate object) {
                return createKoordinateAdapter();
            }
            @Override
            public Adapter caseZugset(Zugset object) {
                return createZugsetAdapter();
            }
            @Override
            public Adapter caseStraightLine(StraightLine object) {
                return createStraightLineAdapter();
            }
            @Override
            public Adapter caseZug(Zug object) {
                return createZugAdapter();
            }
            @Override
            public Adapter caseField(Field object) {
                return createFieldAdapter();
            }
            @Override
            public Adapter caseEntityWithPosition(EntityWithPosition object) {
                return createEntityWithPositionAdapter();
            }
            @Override
            public Adapter caseJump(Jump object) {
                return createJumpAdapter();
            }
            @Override
            public Adapter caseSelectablePosition(SelectablePosition object) {
                return createSelectablePositionAdapter();
            }
            @Override
            public Adapter caseColoredSelectable(ColoredSelectable object) {
                return createColoredSelectableAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link spielfeld.Figur <em>Figur</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see spielfeld.Figur
     * @generated
     */
    public Adapter createFigurAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link spielfeld.Koordinate <em>Koordinate</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see spielfeld.Koordinate
     * @generated
     */
    public Adapter createKoordinateAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link spielfeld.Zugset <em>Zugset</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see spielfeld.Zugset
     * @generated
     */
    public Adapter createZugsetAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link spielfeld.StraightLine <em>Straight Line</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see spielfeld.StraightLine
     * @generated
     */
    public Adapter createStraightLineAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link spielfeld.Zug <em>Zug</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see spielfeld.Zug
     * @generated
     */
    public Adapter createZugAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link spielfeld.Field <em>Field</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see spielfeld.Field
     * @generated
     */
    public Adapter createFieldAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link spielfeld.EntityWithPosition <em>Entity With Position</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see spielfeld.EntityWithPosition
     * @generated
     */
    public Adapter createEntityWithPositionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link spielfeld.Jump <em>Jump</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see spielfeld.Jump
     * @generated
     */
    public Adapter createJumpAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link spielfeld.SelectablePosition <em>Selectable Position</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see spielfeld.SelectablePosition
     * @generated
     */
    public Adapter createSelectablePositionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link spielfeld.ColoredSelectable <em>Colored Selectable</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see spielfeld.ColoredSelectable
     * @generated
     */
    public Adapter createColoredSelectableAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //SpielfeldAdapterFactory
