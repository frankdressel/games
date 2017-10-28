/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package raumschachmodell.modell.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import raumschachmodell.figures.FigurProvider;
import raumschachmodell.modell.RaumschachModellPackage;
import raumschachmodell.modell.Spiel;
import raumschachmodell.modell.Spieler;

import spielfeld.Farbe;
import spielfeld.Field;
import spielfeld.Figur;
import spielfeld.Koordinate;
import spielfeld.Zug;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Spiel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link raumschachmodell.modell.impl.SpielImpl#getBeschreibung <em>Beschreibung</em>}</li>
 *   <li>{@link raumschachmodell.modell.impl.SpielImpl#getSpieler <em>Spieler</em>}</li>
 *   <li>{@link raumschachmodell.modell.impl.SpielImpl#getId <em>Id</em>}</li>
 *   <li>{@link raumschachmodell.modell.impl.SpielImpl#getZuege <em>Zuege</em>}</li>
 *   <li>{@link raumschachmodell.modell.impl.SpielImpl#getActive <em>Active</em>}</li>
 *   <li>{@link raumschachmodell.modell.impl.SpielImpl#getFigures <em>Figures</em>}</li>
 *   <li>{@link raumschachmodell.modell.impl.SpielImpl#getFields <em>Fields</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpielImpl extends EObjectImpl implements Spiel {
    /**
     * The default value of the '{@link #getBeschreibung() <em>Beschreibung</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBeschreibung()
     * @generated
     * @ordered
     */
    protected static final String BESCHREIBUNG_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getBeschreibung() <em>Beschreibung</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBeschreibung()
     * @generated
     * @ordered
     */
    protected String beschreibung = BESCHREIBUNG_EDEFAULT;

    /**
     * The cached value of the '{@link #getSpieler() <em>Spieler</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSpieler()
     * @generated
     * @ordered
     */
    protected EList<Spieler> spieler;

    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final long ID_EDEFAULT = 0L;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected long id = ID_EDEFAULT;

    /**
     * The cached value of the '{@link #getZuege() <em>Zuege</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getZuege()
     * @generated
     * @ordered
     */
    protected EList<Zug> zuege;

    /**
     * The default value of the '{@link #getActive() <em>Active</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getActive()
     * @generated
     * @ordered
     */
    protected static final Farbe ACTIVE_EDEFAULT = Farbe.ORANGE;

    /**
     * The cached value of the '{@link #getActive() <em>Active</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getActive()
     * @generated
     * @ordered
     */
    protected Farbe active = ACTIVE_EDEFAULT;

    /**
     * The cached value of the '{@link #getFigures() <em>Figures</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFigures()
     * @generated
     * @ordered
     */
    protected EList<Figur> figures;

    /**
     * The cached value of the '{@link #getFields() <em>Fields</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFields()
     * @generated
     * @ordered
     */
    protected EList<Field> fields;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    protected SpielImpl() {
        super();
        FigurProvider.initialGameSetting(this);
        setId(System.currentTimeMillis());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RaumschachModellPackage.Literals.SPIEL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getBeschreibung() {
        return beschreibung;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBeschreibung(String newBeschreibung) {
        String oldBeschreibung = beschreibung;
        beschreibung = newBeschreibung;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RaumschachModellPackage.SPIEL__BESCHREIBUNG, oldBeschreibung, beschreibung));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Spieler> getSpieler() {
        if (spieler == null) {
            spieler = new EObjectResolvingEList<Spieler>(Spieler.class, this, RaumschachModellPackage.SPIEL__SPIELER);
        }
        return spieler;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public long getId() {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setId(long newId) {
        long oldId = id;
        id = newId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RaumschachModellPackage.SPIEL__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Zug> getZuege() {
        if (zuege == null) {
            zuege = new EObjectResolvingEList<Zug>(Zug.class, this, RaumschachModellPackage.SPIEL__ZUEGE);
        }
        return zuege;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Farbe getActive() {
        return active;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setActive(Farbe newActive) {
        Farbe oldActive = active;
        active = newActive == null ? ACTIVE_EDEFAULT : newActive;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RaumschachModellPackage.SPIEL__ACTIVE, oldActive, active));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Figur> getFigures() {
        if (figures == null) {
            figures = new EObjectResolvingEList<Figur>(Figur.class, this, RaumschachModellPackage.SPIEL__FIGURES);
        }
        return figures;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Field> getFields() {
        if (fields == null) {
            fields = new EObjectResolvingEList<Field>(Field.class, this, RaumschachModellPackage.SPIEL__FIELDS);
        }
        return fields;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public void reset() {
        // Detach the adapters.
        FigurProvider.resetFields(this);
        FigurProvider.resetFigures(this);
        // Set the active color to gray.
        this.setActive(Farbe.GRAU);
        // Reset the Spieler colors.
        for (Spieler spieler : getSpieler()) {
            spieler.setFarbe(Farbe.UNSET);
        }
        //Clear the zug list.
        getZuege().clear();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public List<Figur> createCopy() {
        return FigurProvider.getCopied(this);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RaumschachModellPackage.SPIEL__BESCHREIBUNG:
                return getBeschreibung();
            case RaumschachModellPackage.SPIEL__SPIELER:
                return getSpieler();
            case RaumschachModellPackage.SPIEL__ID:
                return getId();
            case RaumschachModellPackage.SPIEL__ZUEGE:
                return getZuege();
            case RaumschachModellPackage.SPIEL__ACTIVE:
                return getActive();
            case RaumschachModellPackage.SPIEL__FIGURES:
                return getFigures();
            case RaumschachModellPackage.SPIEL__FIELDS:
                return getFields();
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
            case RaumschachModellPackage.SPIEL__BESCHREIBUNG:
                setBeschreibung((String)newValue);
                return;
            case RaumschachModellPackage.SPIEL__SPIELER:
                getSpieler().clear();
                getSpieler().addAll((Collection<? extends Spieler>)newValue);
                return;
            case RaumschachModellPackage.SPIEL__ID:
                setId((Long)newValue);
                return;
            case RaumschachModellPackage.SPIEL__ZUEGE:
                getZuege().clear();
                getZuege().addAll((Collection<? extends Zug>)newValue);
                return;
            case RaumschachModellPackage.SPIEL__ACTIVE:
                setActive((Farbe)newValue);
                return;
            case RaumschachModellPackage.SPIEL__FIGURES:
                getFigures().clear();
                getFigures().addAll((Collection<? extends Figur>)newValue);
                return;
            case RaumschachModellPackage.SPIEL__FIELDS:
                getFields().clear();
                getFields().addAll((Collection<? extends Field>)newValue);
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
            case RaumschachModellPackage.SPIEL__BESCHREIBUNG:
                setBeschreibung(BESCHREIBUNG_EDEFAULT);
                return;
            case RaumschachModellPackage.SPIEL__SPIELER:
                getSpieler().clear();
                return;
            case RaumschachModellPackage.SPIEL__ID:
                setId(ID_EDEFAULT);
                return;
            case RaumschachModellPackage.SPIEL__ZUEGE:
                getZuege().clear();
                return;
            case RaumschachModellPackage.SPIEL__ACTIVE:
                setActive(ACTIVE_EDEFAULT);
                return;
            case RaumschachModellPackage.SPIEL__FIGURES:
                getFigures().clear();
                return;
            case RaumschachModellPackage.SPIEL__FIELDS:
                getFields().clear();
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
            case RaumschachModellPackage.SPIEL__BESCHREIBUNG:
                return BESCHREIBUNG_EDEFAULT == null ? beschreibung != null : !BESCHREIBUNG_EDEFAULT.equals(beschreibung);
            case RaumschachModellPackage.SPIEL__SPIELER:
                return spieler != null && !spieler.isEmpty();
            case RaumschachModellPackage.SPIEL__ID:
                return id != ID_EDEFAULT;
            case RaumschachModellPackage.SPIEL__ZUEGE:
                return zuege != null && !zuege.isEmpty();
            case RaumschachModellPackage.SPIEL__ACTIVE:
                return active != ACTIVE_EDEFAULT;
            case RaumschachModellPackage.SPIEL__FIGURES:
                return figures != null && !figures.isEmpty();
            case RaumschachModellPackage.SPIEL__FIELDS:
                return fields != null && !fields.isEmpty();
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
        result.append(" (beschreibung: ");
        result.append(beschreibung);
        result.append(", id: ");
        result.append(id);
        result.append(", active: ");
        result.append(active);
        result.append(')');
        return result.toString();
    }

} //SpielImpl
