/*
 * Unselects the previous selection (if any).
 */
function unhighlightFigure(name) {
	figures[name].materials[0]=figuresBackup[name];
}

/*
 * Highlights the given object and sets/unsets the selected object.
 */
function highlightFigure(name) {
	var object = figures[name];
	if (object.materials[0] == materialwhite) {
		selected = object;
		object.materials[0] = materialwhiteSelected;

	} else if (object.materials[0] == materialwhiteSelected) {
		object.materials[0] = materialwhite;
		selected = null;
	}

	if (object.materials[0] == materialblack) {
		selected = object;
		object.materials[0] = materialblackSelected;
	} else if (object.materials[0] == materialblackSelected) {
		object.materials[0] = materialblack;
		selected = null;
	}
}

/**
 * Highlights a field with the given coordinate in move or attack mode.
 * 
 * @param ebene
 *            The ebene coordinate of the figure in the 3d space.
 * @param buchstabe
 *            The buchstabe coordinate of the figure in the 3d space.
 * @param zahl
 *            The zahl coordinate of the figure in the 3d space.
 * @param move
 *            True, if this is a move field, false if it is a attack field.
 */
function highlightField(ebene, buchstabe, zahl, move) {
	var object = checkers['' + ebene + buchstabe + zahl];
	if (move) {
		object.materials[0] = materialMoveToField;
	} else {
		object.materials[0] = materialAttackField;
	}
}

/**
 * Unhighlights a field with the given coordinate.
 
  * @param ebene
 *            The ebene coordinate of the figure in the 3d space.
 * @param buchstabe
 *            The buchstabe coordinate of the figure in the 3d space.
 * @param zahl
 *            The zahl coordinate of the figure in the 3d space.
 */
function unhighlightField(ebene, buchstabe, zahl) {
	var object = checkers['' + ebene + buchstabe + zahl];
	object.materials[0]=checkersBackup['' + ebene + buchstabe + zahl];
}