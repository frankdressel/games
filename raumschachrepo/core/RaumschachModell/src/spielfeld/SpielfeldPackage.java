/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package spielfeld;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see spielfeld.SpielfeldFactory
 * @model kind="package"
 * @generated
 */
public interface SpielfeldPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "spielfeld";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://spielfeld/1.0";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "spielfeld";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    SpielfeldPackage eINSTANCE = spielfeld.impl.SpielfeldPackageImpl.init();

    /**
     * The meta object id for the '{@link spielfeld.impl.EntityWithPositionImpl <em>Entity With Position</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see spielfeld.impl.EntityWithPositionImpl
     * @see spielfeld.impl.SpielfeldPackageImpl#getEntityWithPosition()
     * @generated
     */
    int ENTITY_WITH_POSITION = 6;

    /**
     * The feature id for the '<em><b>Position</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENTITY_WITH_POSITION__POSITION = 0;

    /**
     * The number of structural features of the '<em>Entity With Position</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENTITY_WITH_POSITION_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link spielfeld.impl.SelectablePositionImpl <em>Selectable Position</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see spielfeld.impl.SelectablePositionImpl
     * @see spielfeld.impl.SpielfeldPackageImpl#getSelectablePosition()
     * @generated
     */
    int SELECTABLE_POSITION = 8;

    /**
     * The feature id for the '<em><b>Position</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECTABLE_POSITION__POSITION = ENTITY_WITH_POSITION__POSITION;

    /**
     * The feature id for the '<em><b>Selected</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECTABLE_POSITION__SELECTED = ENTITY_WITH_POSITION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Selectable Position</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECTABLE_POSITION_FEATURE_COUNT = ENTITY_WITH_POSITION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link spielfeld.impl.ColoredSelectableImpl <em>Colored Selectable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see spielfeld.impl.ColoredSelectableImpl
     * @see spielfeld.impl.SpielfeldPackageImpl#getColoredSelectable()
     * @generated
     */
    int COLORED_SELECTABLE = 9;

    /**
     * The feature id for the '<em><b>Position</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLORED_SELECTABLE__POSITION = SELECTABLE_POSITION__POSITION;

    /**
     * The feature id for the '<em><b>Selected</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLORED_SELECTABLE__SELECTED = SELECTABLE_POSITION__SELECTED;

    /**
     * The feature id for the '<em><b>Farbe</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLORED_SELECTABLE__FARBE = SELECTABLE_POSITION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Colored Selectable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLORED_SELECTABLE_FEATURE_COUNT = SELECTABLE_POSITION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link spielfeld.impl.FigurImpl <em>Figur</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see spielfeld.impl.FigurImpl
     * @see spielfeld.impl.SpielfeldPackageImpl#getFigur()
     * @generated
     */
    int FIGUR = 0;

    /**
     * The feature id for the '<em><b>Position</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGUR__POSITION = COLORED_SELECTABLE__POSITION;

    /**
     * The feature id for the '<em><b>Selected</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGUR__SELECTED = COLORED_SELECTABLE__SELECTED;

    /**
     * The feature id for the '<em><b>Farbe</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGUR__FARBE = COLORED_SELECTABLE__FARBE;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGUR__NAME = COLORED_SELECTABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGUR__ID = COLORED_SELECTABLE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Zugset Normal</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGUR__ZUGSET_NORMAL = COLORED_SELECTABLE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Zugset Angriff</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGUR__ZUGSET_ANGRIFF = COLORED_SELECTABLE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Active</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGUR__ACTIVE = COLORED_SELECTABLE_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Figur</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGUR_FEATURE_COUNT = COLORED_SELECTABLE_FEATURE_COUNT + 5;

    /**
     * The meta object id for the '{@link spielfeld.impl.KoordinateImpl <em>Koordinate</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see spielfeld.impl.KoordinateImpl
     * @see spielfeld.impl.SpielfeldPackageImpl#getKoordinate()
     * @generated
     */
    int KOORDINATE = 1;

    /**
     * The feature id for the '<em><b>Ebene</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int KOORDINATE__EBENE = 0;

    /**
     * The feature id for the '<em><b>Buchstabe</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int KOORDINATE__BUCHSTABE = 1;

    /**
     * The feature id for the '<em><b>Zahl</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int KOORDINATE__ZAHL = 2;

    /**
     * The number of structural features of the '<em>Koordinate</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int KOORDINATE_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link spielfeld.impl.ZugsetImpl <em>Zugset</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see spielfeld.impl.ZugsetImpl
     * @see spielfeld.impl.SpielfeldPackageImpl#getZugset()
     * @generated
     */
    int ZUGSET = 2;

    /**
     * The feature id for the '<em><b>Straight Line</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ZUGSET__STRAIGHT_LINE = 0;

    /**
     * The feature id for the '<em><b>Jumps</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ZUGSET__JUMPS = 1;

    /**
     * The number of structural features of the '<em>Zugset</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ZUGSET_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link spielfeld.impl.StraightLineImpl <em>Straight Line</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see spielfeld.impl.StraightLineImpl
     * @see spielfeld.impl.SpielfeldPackageImpl#getStraightLine()
     * @generated
     */
    int STRAIGHT_LINE = 3;

    /**
     * The feature id for the '<em><b>Position</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRAIGHT_LINE__POSITION = ENTITY_WITH_POSITION__POSITION;

    /**
     * The feature id for the '<em><b>Max Dist</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRAIGHT_LINE__MAX_DIST = ENTITY_WITH_POSITION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Straight Line</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRAIGHT_LINE_FEATURE_COUNT = ENTITY_WITH_POSITION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link spielfeld.impl.ZugImpl <em>Zug</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see spielfeld.impl.ZugImpl
     * @see spielfeld.impl.SpielfeldPackageImpl#getZug()
     * @generated
     */
    int ZUG = 4;

    /**
     * The feature id for the '<em><b>Figur</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ZUG__FIGUR = 0;

    /**
     * The feature id for the '<em><b>Start Position</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ZUG__START_POSITION = 1;

    /**
     * The feature id for the '<em><b>End Position</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ZUG__END_POSITION = 2;

    /**
     * The number of structural features of the '<em>Zug</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ZUG_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link spielfeld.impl.FieldImpl <em>Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see spielfeld.impl.FieldImpl
     * @see spielfeld.impl.SpielfeldPackageImpl#getField()
     * @generated
     */
    int FIELD = 5;

    /**
     * The feature id for the '<em><b>Position</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIELD__POSITION = COLORED_SELECTABLE__POSITION;

    /**
     * The feature id for the '<em><b>Selected</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIELD__SELECTED = COLORED_SELECTABLE__SELECTED;

    /**
     * The feature id for the '<em><b>Farbe</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIELD__FARBE = COLORED_SELECTABLE__FARBE;

    /**
     * The feature id for the '<em><b>Attackable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIELD__ATTACKABLE = COLORED_SELECTABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Possible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIELD__POSSIBLE = COLORED_SELECTABLE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Field</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIELD_FEATURE_COUNT = COLORED_SELECTABLE_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link spielfeld.impl.JumpImpl <em>Jump</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see spielfeld.impl.JumpImpl
     * @see spielfeld.impl.SpielfeldPackageImpl#getJump()
     * @generated
     */
    int JUMP = 7;

    /**
     * The feature id for the '<em><b>Position</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JUMP__POSITION = ENTITY_WITH_POSITION__POSITION;

    /**
     * The number of structural features of the '<em>Jump</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JUMP_FEATURE_COUNT = ENTITY_WITH_POSITION_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link spielfeld.Farbe <em>Farbe</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see spielfeld.Farbe
     * @see spielfeld.impl.SpielfeldPackageImpl#getFarbe()
     * @generated
     */
    int FARBE = 10;


    /**
     * Returns the meta object for class '{@link spielfeld.Figur <em>Figur</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Figur</em>'.
     * @see spielfeld.Figur
     * @generated
     */
    EClass getFigur();

    /**
     * Returns the meta object for the attribute '{@link spielfeld.Figur#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see spielfeld.Figur#getName()
     * @see #getFigur()
     * @generated
     */
    EAttribute getFigur_Name();

    /**
     * Returns the meta object for the attribute '{@link spielfeld.Figur#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see spielfeld.Figur#getId()
     * @see #getFigur()
     * @generated
     */
    EAttribute getFigur_Id();

    /**
     * Returns the meta object for the reference '{@link spielfeld.Figur#getZugsetNormal <em>Zugset Normal</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Zugset Normal</em>'.
     * @see spielfeld.Figur#getZugsetNormal()
     * @see #getFigur()
     * @generated
     */
    EReference getFigur_ZugsetNormal();

    /**
     * Returns the meta object for the reference '{@link spielfeld.Figur#getZugsetAngriff <em>Zugset Angriff</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Zugset Angriff</em>'.
     * @see spielfeld.Figur#getZugsetAngriff()
     * @see #getFigur()
     * @generated
     */
    EReference getFigur_ZugsetAngriff();

    /**
     * Returns the meta object for the attribute '{@link spielfeld.Figur#isActive <em>Active</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Active</em>'.
     * @see spielfeld.Figur#isActive()
     * @see #getFigur()
     * @generated
     */
    EAttribute getFigur_Active();

    /**
     * Returns the meta object for class '{@link spielfeld.Koordinate <em>Koordinate</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Koordinate</em>'.
     * @see spielfeld.Koordinate
     * @generated
     */
    EClass getKoordinate();

    /**
     * Returns the meta object for the attribute '{@link spielfeld.Koordinate#getEbene <em>Ebene</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ebene</em>'.
     * @see spielfeld.Koordinate#getEbene()
     * @see #getKoordinate()
     * @generated
     */
    EAttribute getKoordinate_Ebene();

    /**
     * Returns the meta object for the attribute '{@link spielfeld.Koordinate#getBuchstabe <em>Buchstabe</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Buchstabe</em>'.
     * @see spielfeld.Koordinate#getBuchstabe()
     * @see #getKoordinate()
     * @generated
     */
    EAttribute getKoordinate_Buchstabe();

    /**
     * Returns the meta object for the attribute '{@link spielfeld.Koordinate#getZahl <em>Zahl</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Zahl</em>'.
     * @see spielfeld.Koordinate#getZahl()
     * @see #getKoordinate()
     * @generated
     */
    EAttribute getKoordinate_Zahl();

    /**
     * Returns the meta object for class '{@link spielfeld.Zugset <em>Zugset</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Zugset</em>'.
     * @see spielfeld.Zugset
     * @generated
     */
    EClass getZugset();

    /**
     * Returns the meta object for the containment reference list '{@link spielfeld.Zugset#getStraightLine <em>Straight Line</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Straight Line</em>'.
     * @see spielfeld.Zugset#getStraightLine()
     * @see #getZugset()
     * @generated
     */
    EReference getZugset_StraightLine();

    /**
     * Returns the meta object for the containment reference list '{@link spielfeld.Zugset#getJumps <em>Jumps</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Jumps</em>'.
     * @see spielfeld.Zugset#getJumps()
     * @see #getZugset()
     * @generated
     */
    EReference getZugset_Jumps();

    /**
     * Returns the meta object for class '{@link spielfeld.StraightLine <em>Straight Line</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Straight Line</em>'.
     * @see spielfeld.StraightLine
     * @generated
     */
    EClass getStraightLine();

    /**
     * Returns the meta object for the attribute '{@link spielfeld.StraightLine#getMaxDist <em>Max Dist</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Max Dist</em>'.
     * @see spielfeld.StraightLine#getMaxDist()
     * @see #getStraightLine()
     * @generated
     */
    EAttribute getStraightLine_MaxDist();

    /**
     * Returns the meta object for class '{@link spielfeld.Zug <em>Zug</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Zug</em>'.
     * @see spielfeld.Zug
     * @generated
     */
    EClass getZug();

    /**
     * Returns the meta object for the reference '{@link spielfeld.Zug#getFigur <em>Figur</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Figur</em>'.
     * @see spielfeld.Zug#getFigur()
     * @see #getZug()
     * @generated
     */
    EReference getZug_Figur();

    /**
     * Returns the meta object for the reference '{@link spielfeld.Zug#getStartPosition <em>Start Position</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Start Position</em>'.
     * @see spielfeld.Zug#getStartPosition()
     * @see #getZug()
     * @generated
     */
    EReference getZug_StartPosition();

    /**
     * Returns the meta object for the reference '{@link spielfeld.Zug#getEndPosition <em>End Position</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>End Position</em>'.
     * @see spielfeld.Zug#getEndPosition()
     * @see #getZug()
     * @generated
     */
    EReference getZug_EndPosition();

    /**
     * Returns the meta object for class '{@link spielfeld.Field <em>Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Field</em>'.
     * @see spielfeld.Field
     * @generated
     */
    EClass getField();

    /**
     * Returns the meta object for the attribute '{@link spielfeld.Field#isAttackable <em>Attackable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Attackable</em>'.
     * @see spielfeld.Field#isAttackable()
     * @see #getField()
     * @generated
     */
    EAttribute getField_Attackable();

    /**
     * Returns the meta object for the attribute '{@link spielfeld.Field#isPossible <em>Possible</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Possible</em>'.
     * @see spielfeld.Field#isPossible()
     * @see #getField()
     * @generated
     */
    EAttribute getField_Possible();

    /**
     * Returns the meta object for class '{@link spielfeld.EntityWithPosition <em>Entity With Position</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Entity With Position</em>'.
     * @see spielfeld.EntityWithPosition
     * @generated
     */
    EClass getEntityWithPosition();

    /**
     * Returns the meta object for the reference '{@link spielfeld.EntityWithPosition#getPosition <em>Position</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Position</em>'.
     * @see spielfeld.EntityWithPosition#getPosition()
     * @see #getEntityWithPosition()
     * @generated
     */
    EReference getEntityWithPosition_Position();

    /**
     * Returns the meta object for class '{@link spielfeld.Jump <em>Jump</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Jump</em>'.
     * @see spielfeld.Jump
     * @generated
     */
    EClass getJump();

    /**
     * Returns the meta object for class '{@link spielfeld.SelectablePosition <em>Selectable Position</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Selectable Position</em>'.
     * @see spielfeld.SelectablePosition
     * @generated
     */
    EClass getSelectablePosition();

    /**
     * Returns the meta object for the attribute '{@link spielfeld.SelectablePosition#isSelected <em>Selected</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Selected</em>'.
     * @see spielfeld.SelectablePosition#isSelected()
     * @see #getSelectablePosition()
     * @generated
     */
    EAttribute getSelectablePosition_Selected();

    /**
     * Returns the meta object for class '{@link spielfeld.ColoredSelectable <em>Colored Selectable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Colored Selectable</em>'.
     * @see spielfeld.ColoredSelectable
     * @generated
     */
    EClass getColoredSelectable();

    /**
     * Returns the meta object for the attribute '{@link spielfeld.ColoredSelectable#getFarbe <em>Farbe</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Farbe</em>'.
     * @see spielfeld.ColoredSelectable#getFarbe()
     * @see #getColoredSelectable()
     * @generated
     */
    EAttribute getColoredSelectable_Farbe();

    /**
     * Returns the meta object for enum '{@link spielfeld.Farbe <em>Farbe</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Farbe</em>'.
     * @see spielfeld.Farbe
     * @generated
     */
    EEnum getFarbe();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    SpielfeldFactory getSpielfeldFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link spielfeld.impl.FigurImpl <em>Figur</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see spielfeld.impl.FigurImpl
         * @see spielfeld.impl.SpielfeldPackageImpl#getFigur()
         * @generated
         */
        EClass FIGUR = eINSTANCE.getFigur();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIGUR__NAME = eINSTANCE.getFigur_Name();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIGUR__ID = eINSTANCE.getFigur_Id();

        /**
         * The meta object literal for the '<em><b>Zugset Normal</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FIGUR__ZUGSET_NORMAL = eINSTANCE.getFigur_ZugsetNormal();

        /**
         * The meta object literal for the '<em><b>Zugset Angriff</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FIGUR__ZUGSET_ANGRIFF = eINSTANCE.getFigur_ZugsetAngriff();

        /**
         * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIGUR__ACTIVE = eINSTANCE.getFigur_Active();

        /**
         * The meta object literal for the '{@link spielfeld.impl.KoordinateImpl <em>Koordinate</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see spielfeld.impl.KoordinateImpl
         * @see spielfeld.impl.SpielfeldPackageImpl#getKoordinate()
         * @generated
         */
        EClass KOORDINATE = eINSTANCE.getKoordinate();

        /**
         * The meta object literal for the '<em><b>Ebene</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute KOORDINATE__EBENE = eINSTANCE.getKoordinate_Ebene();

        /**
         * The meta object literal for the '<em><b>Buchstabe</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute KOORDINATE__BUCHSTABE = eINSTANCE.getKoordinate_Buchstabe();

        /**
         * The meta object literal for the '<em><b>Zahl</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute KOORDINATE__ZAHL = eINSTANCE.getKoordinate_Zahl();

        /**
         * The meta object literal for the '{@link spielfeld.impl.ZugsetImpl <em>Zugset</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see spielfeld.impl.ZugsetImpl
         * @see spielfeld.impl.SpielfeldPackageImpl#getZugset()
         * @generated
         */
        EClass ZUGSET = eINSTANCE.getZugset();

        /**
         * The meta object literal for the '<em><b>Straight Line</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ZUGSET__STRAIGHT_LINE = eINSTANCE.getZugset_StraightLine();

        /**
         * The meta object literal for the '<em><b>Jumps</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ZUGSET__JUMPS = eINSTANCE.getZugset_Jumps();

        /**
         * The meta object literal for the '{@link spielfeld.impl.StraightLineImpl <em>Straight Line</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see spielfeld.impl.StraightLineImpl
         * @see spielfeld.impl.SpielfeldPackageImpl#getStraightLine()
         * @generated
         */
        EClass STRAIGHT_LINE = eINSTANCE.getStraightLine();

        /**
         * The meta object literal for the '<em><b>Max Dist</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute STRAIGHT_LINE__MAX_DIST = eINSTANCE.getStraightLine_MaxDist();

        /**
         * The meta object literal for the '{@link spielfeld.impl.ZugImpl <em>Zug</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see spielfeld.impl.ZugImpl
         * @see spielfeld.impl.SpielfeldPackageImpl#getZug()
         * @generated
         */
        EClass ZUG = eINSTANCE.getZug();

        /**
         * The meta object literal for the '<em><b>Figur</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ZUG__FIGUR = eINSTANCE.getZug_Figur();

        /**
         * The meta object literal for the '<em><b>Start Position</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ZUG__START_POSITION = eINSTANCE.getZug_StartPosition();

        /**
         * The meta object literal for the '<em><b>End Position</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ZUG__END_POSITION = eINSTANCE.getZug_EndPosition();

        /**
         * The meta object literal for the '{@link spielfeld.impl.FieldImpl <em>Field</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see spielfeld.impl.FieldImpl
         * @see spielfeld.impl.SpielfeldPackageImpl#getField()
         * @generated
         */
        EClass FIELD = eINSTANCE.getField();

        /**
         * The meta object literal for the '<em><b>Attackable</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIELD__ATTACKABLE = eINSTANCE.getField_Attackable();

        /**
         * The meta object literal for the '<em><b>Possible</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIELD__POSSIBLE = eINSTANCE.getField_Possible();

        /**
         * The meta object literal for the '{@link spielfeld.impl.EntityWithPositionImpl <em>Entity With Position</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see spielfeld.impl.EntityWithPositionImpl
         * @see spielfeld.impl.SpielfeldPackageImpl#getEntityWithPosition()
         * @generated
         */
        EClass ENTITY_WITH_POSITION = eINSTANCE.getEntityWithPosition();

        /**
         * The meta object literal for the '<em><b>Position</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ENTITY_WITH_POSITION__POSITION = eINSTANCE.getEntityWithPosition_Position();

        /**
         * The meta object literal for the '{@link spielfeld.impl.JumpImpl <em>Jump</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see spielfeld.impl.JumpImpl
         * @see spielfeld.impl.SpielfeldPackageImpl#getJump()
         * @generated
         */
        EClass JUMP = eINSTANCE.getJump();

        /**
         * The meta object literal for the '{@link spielfeld.impl.SelectablePositionImpl <em>Selectable Position</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see spielfeld.impl.SelectablePositionImpl
         * @see spielfeld.impl.SpielfeldPackageImpl#getSelectablePosition()
         * @generated
         */
        EClass SELECTABLE_POSITION = eINSTANCE.getSelectablePosition();

        /**
         * The meta object literal for the '<em><b>Selected</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SELECTABLE_POSITION__SELECTED = eINSTANCE.getSelectablePosition_Selected();

        /**
         * The meta object literal for the '{@link spielfeld.impl.ColoredSelectableImpl <em>Colored Selectable</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see spielfeld.impl.ColoredSelectableImpl
         * @see spielfeld.impl.SpielfeldPackageImpl#getColoredSelectable()
         * @generated
         */
        EClass COLORED_SELECTABLE = eINSTANCE.getColoredSelectable();

        /**
         * The meta object literal for the '<em><b>Farbe</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COLORED_SELECTABLE__FARBE = eINSTANCE.getColoredSelectable_Farbe();

        /**
         * The meta object literal for the '{@link spielfeld.Farbe <em>Farbe</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see spielfeld.Farbe
         * @see spielfeld.impl.SpielfeldPackageImpl#getFarbe()
         * @generated
         */
        EEnum FARBE = eINSTANCE.getFarbe();

    }

} //SpielfeldPackage
