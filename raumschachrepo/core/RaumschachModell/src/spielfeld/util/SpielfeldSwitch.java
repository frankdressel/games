/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package spielfeld.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import spielfeld.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see spielfeld.SpielfeldPackage
 * @generated
 */
public class SpielfeldSwitch<T> extends Switch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static SpielfeldPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SpielfeldSwitch() {
        if (modelPackage == null) {
            modelPackage = SpielfeldPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @parameter ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case SpielfeldPackage.FIGUR: {
                Figur figur = (Figur)theEObject;
                T result = caseFigur(figur);
                if (result == null) result = caseColoredSelectable(figur);
                if (result == null) result = caseSelectablePosition(figur);
                if (result == null) result = caseEntityWithPosition(figur);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SpielfeldPackage.KOORDINATE: {
                Koordinate koordinate = (Koordinate)theEObject;
                T result = caseKoordinate(koordinate);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SpielfeldPackage.ZUGSET: {
                Zugset zugset = (Zugset)theEObject;
                T result = caseZugset(zugset);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SpielfeldPackage.STRAIGHT_LINE: {
                StraightLine straightLine = (StraightLine)theEObject;
                T result = caseStraightLine(straightLine);
                if (result == null) result = caseEntityWithPosition(straightLine);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SpielfeldPackage.ZUG: {
                Zug zug = (Zug)theEObject;
                T result = caseZug(zug);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SpielfeldPackage.FIELD: {
                Field field = (Field)theEObject;
                T result = caseField(field);
                if (result == null) result = caseColoredSelectable(field);
                if (result == null) result = caseSelectablePosition(field);
                if (result == null) result = caseEntityWithPosition(field);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SpielfeldPackage.ENTITY_WITH_POSITION: {
                EntityWithPosition entityWithPosition = (EntityWithPosition)theEObject;
                T result = caseEntityWithPosition(entityWithPosition);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SpielfeldPackage.JUMP: {
                Jump jump = (Jump)theEObject;
                T result = caseJump(jump);
                if (result == null) result = caseEntityWithPosition(jump);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SpielfeldPackage.SELECTABLE_POSITION: {
                SelectablePosition selectablePosition = (SelectablePosition)theEObject;
                T result = caseSelectablePosition(selectablePosition);
                if (result == null) result = caseEntityWithPosition(selectablePosition);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SpielfeldPackage.COLORED_SELECTABLE: {
                ColoredSelectable coloredSelectable = (ColoredSelectable)theEObject;
                T result = caseColoredSelectable(coloredSelectable);
                if (result == null) result = caseSelectablePosition(coloredSelectable);
                if (result == null) result = caseEntityWithPosition(coloredSelectable);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Figur</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Figur</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFigur(Figur object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Koordinate</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Koordinate</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseKoordinate(Koordinate object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Zugset</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Zugset</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseZugset(Zugset object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Straight Line</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Straight Line</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStraightLine(StraightLine object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Zug</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Zug</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseZug(Zug object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Field</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Field</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseField(Field object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Entity With Position</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Entity With Position</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEntityWithPosition(EntityWithPosition object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Jump</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Jump</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseJump(Jump object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Selectable Position</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Selectable Position</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSelectablePosition(SelectablePosition object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Colored Selectable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Colored Selectable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseColoredSelectable(ColoredSelectable object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(EObject object) {
        return null;
    }

} //SpielfeldSwitch
