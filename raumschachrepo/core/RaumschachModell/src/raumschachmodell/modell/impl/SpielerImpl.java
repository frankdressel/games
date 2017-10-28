/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package raumschachmodell.modell.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import raumschachmodell.modell.RaumschachModellPackage;
import raumschachmodell.modell.Spieler;
import raumschachmodell.modell.State;

import spielfeld.Farbe;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Spieler</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link raumschachmodell.modell.impl.SpielerImpl#getFarbe <em>Farbe</em>}</li>
 *   <li>{@link raumschachmodell.modell.impl.SpielerImpl#getId <em>Id</em>}</li>
 *   <li>{@link raumschachmodell.modell.impl.SpielerImpl#getName <em>Name</em>}</li>
 *   <li>{@link raumschachmodell.modell.impl.SpielerImpl#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpielerImpl extends EObjectImpl implements Spieler {
    /**
     * The default value of the '{@link #getFarbe() <em>Farbe</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFarbe()
     * @generated
     * @ordered
     */
    protected static final Farbe FARBE_EDEFAULT = Farbe.ORANGE;

    /**
     * The cached value of the '{@link #getFarbe() <em>Farbe</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFarbe()
     * @generated
     * @ordered
     */
    protected Farbe farbe = FARBE_EDEFAULT;

    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getState() <em>State</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getState()
     * @generated
     * @ordered
     */
    protected static final State STATE_EDEFAULT = State.SCHACH;

    /**
     * The cached value of the '{@link #getState() <em>State</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getState()
     * @generated
     * @ordered
     */
    protected State state = STATE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SpielerImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RaumschachModellPackage.Literals.SPIELER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Farbe getFarbe() {
        return farbe;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFarbe(Farbe newFarbe) {
        Farbe oldFarbe = farbe;
        farbe = newFarbe == null ? FARBE_EDEFAULT : newFarbe;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RaumschachModellPackage.SPIELER__FARBE, oldFarbe, farbe));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getId() {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setId(String newId) {
        String oldId = id;
        id = newId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RaumschachModellPackage.SPIELER__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RaumschachModellPackage.SPIELER__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public State getState() {
        return state;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setState(State newState) {
        State oldState = state;
        state = newState == null ? STATE_EDEFAULT : newState;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RaumschachModellPackage.SPIELER__STATE, oldState, state));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RaumschachModellPackage.SPIELER__FARBE:
                return getFarbe();
            case RaumschachModellPackage.SPIELER__ID:
                return getId();
            case RaumschachModellPackage.SPIELER__NAME:
                return getName();
            case RaumschachModellPackage.SPIELER__STATE:
                return getState();
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
            case RaumschachModellPackage.SPIELER__FARBE:
                setFarbe((Farbe)newValue);
                return;
            case RaumschachModellPackage.SPIELER__ID:
                setId((String)newValue);
                return;
            case RaumschachModellPackage.SPIELER__NAME:
                setName((String)newValue);
                return;
            case RaumschachModellPackage.SPIELER__STATE:
                setState((State)newValue);
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
            case RaumschachModellPackage.SPIELER__FARBE:
                setFarbe(FARBE_EDEFAULT);
                return;
            case RaumschachModellPackage.SPIELER__ID:
                setId(ID_EDEFAULT);
                return;
            case RaumschachModellPackage.SPIELER__NAME:
                setName(NAME_EDEFAULT);
                return;
            case RaumschachModellPackage.SPIELER__STATE:
                setState(STATE_EDEFAULT);
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
            case RaumschachModellPackage.SPIELER__FARBE:
                return farbe != FARBE_EDEFAULT;
            case RaumschachModellPackage.SPIELER__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
            case RaumschachModellPackage.SPIELER__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case RaumschachModellPackage.SPIELER__STATE:
                return state != STATE_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (farbe: ");
        result.append(farbe);
        result.append(", id: ");
        result.append(id);
        result.append(", name: ");
        result.append(name);
        result.append(", state: ");
        result.append(state);
        result.append(')');
        return result.toString();
    }

} //SpielerImpl
