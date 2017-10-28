// The selected figure.
var selected;

/**
 * Finds by raycasting the figure which was clicked and calls the appropriate
 * Java-methods in the Spiellogik-plugin.
 * 
 * @param event
 *            The mouse event generated at a given point.
 */
function findAndProcessClicked(event) {
	var vector = new THREE.Vector3(
			(event.clientX / renderer.domElement.width) * 2 - 1,
			-(event.clientY / renderer.domElement.height) * 2 + 1, 0.5);
	projector.unprojectVector(vector, camera);
	var ray = new THREE.Ray(camera.position, vector.subSelf(camera.position)
			.normalize());
	var intersects = ray.intersectScene(scene);

	if (intersects.length > 0) {
		// The position of the selected object.
		var posit = recalculatePositionForFigure(intersects[0].object);
		// Scan all the figures.
		for ( var name in figures) {
			if (figures[name] == intersects[0].object) {
				// Call the selects function.
				fObjectSelected(name, posit[0], posit[1], posit[2]);

				// Stop searching for matching entries.
				return;
			}
		}
		// The position of the selected object.
		var posit = recalculatePositionForFields(intersects[0].object);
		// Scan all the cubes.
		for ( var name in checkers) {
			if (checkers[name] == intersects[0].object) {
				// Call the selects function.
				fObjectSelected('checker',posit[0], posit[1], posit[2]);

				// Stop searching for matching entries.
				return;
			}
		}
	}
}

/**
 * Calculates the coordinates of an object on the 3d checker board.
 * 
 * @param object
 *            The figure, for which the checkerboard coordinates should be
 *            determined.
 * @returns {Array} The 3d coordinates on the board.
 */
function recalculatePositionForFigure(object) {
	var ret = new Array();
	ret[0] = (object.position.y + offsetY - boardHeight) / yDist;
	ret[1] = (object.position.x + halfWidth+ret[0]*xSteps-offsetX) / fieldSize;
	ret[2] = (object.position.z + halfWidth) / fieldSize;

	return ret;
}

/**
 * Calculates the coordinates of a field of the 3d checker board.
 * 
 * @param object
 *            The field, for which the checkerboard coordinates should be
 *            determined.
 * @returns {Array} The 3d coordinates on the board.
 */
function recalculatePositionForFields(object) {
	var ret = new Array();
	ret[0] = (object.position.y + offsetY) / yDist;
	ret[1] = (object.position.x + halfWidth+ret[0]*xSteps-offsetX) / fieldSize;
	ret[2] = (object.position.z + halfWidth) / fieldSize;

	return ret;
}