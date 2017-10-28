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

import spielfeld.Figur;
import spielfeld.Koordinate;
import spielfeld.SpielfeldPackage;
import spielfeld.Zug;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Zug</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link spielfeld.impl.ZugImpl#getFigur <em>Figur</em>}</li>
 *   <li>{@link spielfeld.impl.ZugImpl#getStartPosition <em>Start Position</em>}</li>
 *   <li>{@link spielfeld.impl.ZugImpl#getEndPosition <em>End Position</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ZugImpl extends EObjectImpl implements Zug {
    /**
     * The cached value of the '{@link #getFigur() <em>Figur</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFigur()
     * @generated
     * @ordered
     */
    protected Figur figur;

    /**
     * The cached value of the '{@link #getStartPosition() <em>Start Position</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStartPosition()
     * @generated
     * @ordered
     */
    protected Koordinate startPosition;

    /**
     * The cached value of the '{@link #getEndPosition() <em>End Position</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEndPosition()
     * @generated
     * @ordered
     */
    protected Koordinate endPosition;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ZugImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SpielfeldPackage.Literals.ZUG;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Figur getFigur() {
        if (figur != null && figur.eIsProxy()) {
            InternalEObject oldFigur = (InternalEObject)figur;
            figur = (Figur)eResolveProxy(oldFigur);
            if (figur != oldFigur) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpielfeldPackage.ZUG__FIGUR, oldFigur, figur));
            }
        }
        return figur;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Figur basicGetFigur() {
        return figur;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFigur(Figur newFigur) {
        Figur oldFigur = figur;
        figur = newFigur;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SpielfeldPackage.ZUG__FIGUR, oldFigur, figur));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Koordinate getStartPosition() {
        if (startPosition != null && startPosition.eIsProxy()) {
            InternalEObject oldStartPosition = (InternalEObject)startPosition;
            startPosition = (Koordinate)eResolveProxy(oldStartPosition);
            if (startPosition != oldStartPosition) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpielfeldPackage.ZUG__START_POSITION, oldStartPosition, startPosition));
            }
        }
        return startPosition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Koordinate basicGetStartPosition() {
        return startPosition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStartPosition(Koordinate newStartPosition) {
        Koordinate oldStartPosition = startPosition;
        startPosition = newStartPosition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SpielfeldPackage.ZUG__START_POSITION, oldStartPosition, startPosition));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Koordinate getEndPosition() {
        if (endPosition != null && endPosition.eIsProxy()) {
            InternalEObject oldEndPosition = (InternalEObject)endPosition;
            endPosition = (Koordinate)eResolveProxy(oldEndPosition);
            if (endPosition != oldEndPosition) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpielfeldPackage.ZUG__END_POSITION, oldEndPosition, endPosition));
            }
        }
        return endPosition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Koordinate basicGetEndPosition() {
        return endPosition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEndPosition(Koordinate newEndPosition) {
        Koordinate oldEndPosition = endPosition;
        endPosition = newEndPosition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SpielfeldPackage.ZUG__END_POSITION, oldEndPosition, endPosition));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SpielfeldPackage.ZUG__FIGUR:
                if (resolve) return getFigur();
                return basicGetFigur();
            case SpielfeldPackage.ZUG__START_POSITION:
                if (resolve) return getStartPosition();
                return basicGetStartPosition();
            case SpielfeldPackage.ZUG__END_POSITION:
                if (resolve) return getEndPosition();
                return basicGetEndPosition();
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
            case SpielfeldPackage.ZUG__FIGUR:
                setFigur((Figur)newValue);
                return;
            case SpielfeldPackage.ZUG__START_POSITION:
                setStartPosition((Koordinate)newValue);
                return;
            case SpielfeldPackage.ZUG__END_POSITION:
                setEndPosition((Koordinate)newValue);
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
            case SpielfeldPackage.ZUG__FIGUR:
                setFigur((Figur)null);
                return;
            case SpielfeldPackage.ZUG__START_POSITION:
                setStartPosition((Koordinate)null);
                return;
            case SpielfeldPackage.ZUG__END_POSITION:
                setEndPosition((Koordinate)null);
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
            case SpielfeldPackage.ZUG__FIGUR:
                return figur != null;
            case SpielfeldPackage.ZUG__START_POSITION:
                return startPosition != null;
            case SpielfeldPackage.ZUG__END_POSITION:
                return endPosition != null;
        }
        return super.eIsSet(featureID);
    }

} //ZugImpl
