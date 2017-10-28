/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package spielfeld.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import spielfeld.Jump;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import spielfeld.Koordinate;
import spielfeld.SpielfeldPackage;
import spielfeld.StraightLine;
import spielfeld.Zugset;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Zugset</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link spielfeld.impl.ZugsetImpl#getStraightLine <em>Straight Line</em>}</li>
 *   <li>{@link spielfeld.impl.ZugsetImpl#getJumps <em>Jumps</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ZugsetImpl extends EObjectImpl implements Zugset {
    /**
     * The cached value of the '{@link #getStraightLine() <em>Straight Line</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStraightLine()
     * @generated
     * @ordered
     */
    protected EList<StraightLine> straightLine;

    /**
     * The cached value of the '{@link #getJumps() <em>Jumps</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getJumps()
     * @generated
     * @ordered
     */
    protected EList<Jump> jumps;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ZugsetImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SpielfeldPackage.Literals.ZUGSET;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<StraightLine> getStraightLine() {
        if (straightLine == null) {
            straightLine = new EObjectContainmentEList<StraightLine>(StraightLine.class, this, SpielfeldPackage.ZUGSET__STRAIGHT_LINE);
        }
        return straightLine;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Jump> getJumps() {
        if (jumps == null) {
            jumps = new EObjectContainmentEList<Jump>(Jump.class, this, SpielfeldPackage.ZUGSET__JUMPS);
        }
        return jumps;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SpielfeldPackage.ZUGSET__STRAIGHT_LINE:
                return ((InternalEList<?>)getStraightLine()).basicRemove(otherEnd, msgs);
            case SpielfeldPackage.ZUGSET__JUMPS:
                return ((InternalEList<?>)getJumps()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SpielfeldPackage.ZUGSET__STRAIGHT_LINE:
                return getStraightLine();
            case SpielfeldPackage.ZUGSET__JUMPS:
                return getJumps();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case SpielfeldPackage.ZUGSET__STRAIGHT_LINE:
                getStraightLine().clear();
                getStraightLine().addAll((Collection<? extends StraightLine>)newValue);
                return;
            case SpielfeldPackage.ZUGSET__JUMPS:
                getJumps().clear();
                getJumps().addAll((Collection<? extends Jump>)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case SpielfeldPackage.ZUGSET__STRAIGHT_LINE:
                getStraightLine().clear();
                return;
            case SpielfeldPackage.ZUGSET__JUMPS:
                getJumps().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case SpielfeldPackage.ZUGSET__STRAIGHT_LINE:
                return straightLine != null && !straightLine.isEmpty();
            case SpielfeldPackage.ZUGSET__JUMPS:
                return jumps != null && !jumps.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //ZugsetImpl
