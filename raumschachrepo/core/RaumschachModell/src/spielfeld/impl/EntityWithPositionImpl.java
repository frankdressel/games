/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package spielfeld.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import spielfeld.EntityWithPosition;
import spielfeld.Koordinate;
import spielfeld.SpielfeldPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity With Position</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link spielfeld.impl.EntityWithPositionImpl#getPosition <em>Position</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EntityWithPositionImpl extends EObjectImpl implements EntityWithPosition {
    /**
     * The cached value of the '{@link #getPosition() <em>Position</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPosition()
     * @generated
     * @ordered
     */
    protected Koordinate position;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EntityWithPositionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SpielfeldPackage.Literals.ENTITY_WITH_POSITION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Koordinate getPosition() {
        if (position != null && position.eIsProxy()) {
            InternalEObject oldPosition = (InternalEObject)position;
            position = (Koordinate)eResolveProxy(oldPosition);
            if (position != oldPosition) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpielfeldPackage.ENTITY_WITH_POSITION__POSITION, oldPosition, position));
            }
        }
        return position;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Koordinate basicGetPosition() {
        return position;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPosition(Koordinate newPosition) {
        Koordinate oldPosition = position;
        position = newPosition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SpielfeldPackage.ENTITY_WITH_POSITION__POSITION, oldPosition, position));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SpielfeldPackage.ENTITY_WITH_POSITION__POSITION:
                if (resolve) return getPosition();
                return basicGetPosition();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case SpielfeldPackage.ENTITY_WITH_POSITION__POSITION:
                setPosition((Koordinate)newValue);
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
            case SpielfeldPackage.ENTITY_WITH_POSITION__POSITION:
                setPosition((Koordinate)null);
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
            case SpielfeldPackage.ENTITY_WITH_POSITION__POSITION:
                return position != null;
        }
        return super.eIsSet(featureID);
    }

} //EntityWithPositionImpl
