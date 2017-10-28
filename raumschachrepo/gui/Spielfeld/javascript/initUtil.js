//Stores the fields of the 3d board. 
var checkers = new Array();
var checkersBackup = new Array();

//The figures.
var figures = new Array();
var figuresBackup = new Array();

/**
 * Creates the 3d checker board.
 */
function checkerBoard() {
	// Create the cubes for the board,
	var geometry = new Cube(fieldSize, boardHeight, fieldSize);
	// Tile the planes with the cubes.
	for ( var i = 0; i < 5; i++) {
		for ( var j = 0; j < 5; j++) {
			for ( var k = 0; k < 5; k++) {
				var yPos = k * yDist - offsetY;
				var cube = new THREE.Mesh(geometry,
						((i + j + k) % 2 == 0) ? materialblackField
								: materialwhiteField);
				cube.position.z = (i * fieldSize) - halfWidth;
				cube.position.y = yPos;
				cube.position.x = (j * fieldSize) - halfWidth-k*xSteps+offsetX;
				cube.overdraw = true;
				checkers['' + k + j + i] = cube;
				//Make a backup.
				checkersBackup['' + k + j + i] = ((i
						+ j + k) % 2 == 0) ? materialblackField
						: materialwhiteField;
				;
				scene.addObject(cube);
			}
		}
	}
}

/**
 * Initialises a figure.
 * 
 * @param object
 *            The THREE.Mesh object, which should be added to the scene.
 * @param name
 *            The name of the figure.
 * @param ebene
 *            The ebene coordinate of the figure in the 3d space.
 * @param buchstabe
 *            The buchstabe coordinate of the figure in the 3d space.
 * @param zahl
 *            The zahl coordinate of the figure in the 3d space.
 */
function initFigure(object, name, ebene, buchstabe, zahl) {
	figures[""+ebene + buchstabe + zahl] = object;
	figuresBackup[""+ebene + buchstabe + zahl] = object.materials[0];
	placeFigure(object, ebene, buchstabe, zahl);
	object.overdraw = true;
	scene.addObject(object);
}

/**
 * Sets the position of a given figure to the one indicated by the coordinates.
 * 
 * @param object
 *            The object, which should be placed.
 * @param ebene
 *            The ebene coordinate of the figure in the 3d space.
 * @param buchstabe
 *            The buchstabe coordinate of the figure in the 3d space.
 * @param zahl
 *            The zahl coordinate of the figure in the 3d space.
 */
function placeFigure(object, ebene, buchstabe, zahl) {
	object.position.x = buchstabe * fieldSize - halfWidth-ebene*xSteps+offsetX;
	object.position.y = ebene * yDist - offsetY + boardHeight;
	object.position.z = zahl * fieldSize - halfWidth;
}

/**
 * Sets up all the figures for a new game.
 */
function initialGameSetting() {
	reset();
	// The black pawns.
	var geometry = new myCube();
	for ( var i = 4; i > 2; i--) {
		for ( var j = 0; j < 5; j++) {
			var pawn = new THREE.Mesh(geometry, materialblack);
			// Add the pawn to the figure array.
			initFigure(pawn, pNameBlack, i, j, 3);
		}
	}

	// The white pawns.
	geometry = new myCube();
	for ( var i = 0; i < 2; i++) {
		for ( var j = 0; j < 5; j++) {
			var pawn = new THREE.Mesh(geometry, materialwhite);
			// Add the pawn to the figure array.
			initFigure(pawn, pNameWhite, i, j, 1);
		}
	}

	// The black castles.
	geometry = new myCastle();
	var castleb1 = new THREE.Mesh(geometry, materialblack);
	initFigure(castleb1, cNameBlack, 4, 0, 4);

	geometry = new myCastle();
	var castleb2 = new THREE.Mesh(geometry, materialblack);
	initFigure(castleb2, cNameBlack, 4, 4, 4);

	// The white castles.
	geometry = new myCastle();
	var castlew1 = new THREE.Mesh(geometry, materialwhite);
	initFigure(castlew1, cNameWhite, 0, 0, 0)

	geometry = new myCastle();
	var castlew2 = new THREE.Mesh(geometry, materialwhite);
	initFigure(castlew2, cNameWhite, 0, 4, 0);

	// The white bishops.
	geometry = new myBishop();
	var bishopw1 = new THREE.Mesh(geometry, materialwhite);
	initFigure(bishopw1, bNameWhite, 1, 1, 0);

	geometry = new myBishop();
	var bishopw2 = new THREE.Mesh(geometry, materialwhite);
	initFigure(bishopw2, bNameWhite, 1, 4, 0);

	// The black bishops.
	geometry = new myBishop();
	var bishopb1 = new THREE.Mesh(geometry, materialblack);
	initFigure(bishopb1, bNameBlack, 3, 1, 4);

	geometry = new myBishop();
	var bishopb2 = new THREE.Mesh(geometry, materialblack);
	initFigure(bishopb2, bNameBlack, 3, 4, 4);

	// The white queen.
	geometry = new myQueen();
	var queenw = new THREE.Mesh(geometry, materialwhite);
	initFigure(queenw, qNameWhite, 1, 2, 0);

	// The black queen.
	geometry = new myQueen();
	var queenb = new THREE.Mesh(geometry, materialblack);
	initFigure(queenb, qNameBlack, 3, 2, 4);

	// The white king.
	geometry = new myKing();
	var kingw = new THREE.Mesh(geometry, materialwhite);
	initFigure(kingw, kNameWhite, 0, 2, 0);

	// The black king.
	geometry = new myKing();
	var kingb = new THREE.Mesh(geometry, materialblack);
	initFigure(kingb, kNameBlack, 4, 2, 4);

	// The white knights.
	geometry = new myKnight();
	var knightw1 = new THREE.Mesh(geometry, materialwhite);
	initFigure(knightw1, knNameWhite, 0, 1, 0);

	geometry = new myKnight();
	var knightw2 = new THREE.Mesh(geometry, materialwhite);
	initFigure(knightw2, knNameWhite, 0, 3, 0);

	// The black knights.
	geometry = new myKnight();
	var knightb1 = new THREE.Mesh(geometry, materialblack);
	initFigure(knightb1, knNameBlack, 4, 1, 4);
	knightb1.rotation.y = 3.14;

	geometry = new myKnight();
	var knightb2 = new THREE.Mesh(geometry, materialblack);
	initFigure(knightb2, knNameBlack, 4, 3, 4);
	knightb2.rotation.y = 3.14;

	// The white unicorns.
	geometry = new myUnicorn();
	var unicornw1 = new THREE.Mesh(geometry, materialwhite);
	initFigure(unicornw1, uNameWhite, 1, 0, 0);

	geometry = new myUnicorn();
	var unicornw2 = new THREE.Mesh(geometry, materialwhite);
	initFigure(unicornw2, uNameWhite, 1, 3, 0);

	// The black unicorns.
	geometry = new myUnicorn();
	var unicornb1 = new THREE.Mesh(geometry, materialblack);
	initFigure(unicornb1, uNameBlack, 3, 0, 4);

	geometry = new myUnicorn();
	var unicornb2 = new THREE.Mesh(geometry, materialblack);
	initFigure(unicornb2, uNameBlack, 3, 3, 4);

	render();
}

function reset(){
	for(name in figures){
		remove(name);
	}
}

function remove(name){
	scene.removeObject(figures[name]);
}

function add(name){
	scene.addObject(figures[name]);
}