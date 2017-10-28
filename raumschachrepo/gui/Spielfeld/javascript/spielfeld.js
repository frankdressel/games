var container;
var camera, scene, renderer, projector, mouse3D, isMouseDown = false, onMouseDownPosition, radious = 2300, theta = 110, onMouseDownTheta = 110, phi = 60, onMouseDownPhi = 60;

// The width of the checker board.
var width = 350;
var halfWidth = width / 2;
// The height of a single board.
var boardHeight = 5;
// The distance in y-direction between the boards.
var yDist = 200;
// The offset in y-direction.
var offsetY = 350;
//The shift of the boards in x-direction.
var xSteps=250;
//The offset in x-direction.
var offsetX = 2*xSteps;
// The size of one cell.
var fieldSize = width / 5;

// The name for the figures.
var pNameBlack = 'black pawn';
var pNameWhite = 'white pawn';
var cNameBlack = 'black castle';
var cNameWhite = 'white castle';
var bNameWhite = 'white bishop';
var bNameBlack = 'black bishop';
var qNameWhite = 'white queen';
var qNameBlack = 'black queen';
var kNameWhite = 'white king';
var kNameBlack = 'black king';
var knNameWhite = 'white knight';
var knNameBlack = 'black knight';
var uNameWhite = 'white unicorn';
var uNameBlack = 'black unicorn';

init();
render();

function init() {

	container = document.createElement('div');
	document.body.appendChild(container);

	onMouseDownPosition = new THREE.Vector2();
	projector = new THREE.Projector();

	camera = new THREE.Camera(40, window.innerWidth / window.innerHeight, 1,
			10000);
	camera.position.x = radious * Math.sin(theta * Math.PI / 360)
			* Math.cos(phi * Math.PI / 360);
	camera.position.y = radious * Math.sin(phi * Math.PI / 360);
	camera.position.z = radious * Math.cos(theta * Math.PI / 360)
			* Math.cos(phi * Math.PI / 360);

	scene = new THREE.Scene();

	/*
	 * Checker board.
	 */
	checkerBoard();

	// Lights
	var ambientLight = new THREE.AmbientLight(0xBDBDBD);
	scene.addLight(ambientLight);

	var directionalLight = new THREE.DirectionalLight(0xFFFFFF);
	directionalLight.position.x = radious;
	directionalLight.position.y = radious;
	directionalLight.position.z = 0;
	directionalLight.position.normalize();
	scene.addLight(directionalLight);

	directionalLight = new THREE.DirectionalLight(0x848484);
	directionalLight.position.x = -radious;
	directionalLight.position.y = radious;
	directionalLight.position.z = 0;
	directionalLight.position.normalize();
	scene.addLight(directionalLight);

	renderer = new THREE.CanvasRenderer();
	renderer.setSize(window.innerWidth, window.innerHeight);

	container.appendChild(renderer.domElement);

	// Add the listeners.
	document.addEventListener('mousemove', onDocumentMouseMove, false);
	document.addEventListener('mousedown', onDocumentMouseDown, false);
	document.addEventListener('mouseup', onDocumentMouseUp, false);
	document.addEventListener('DOMMouseScroll', onDocumentMouseWheel, false);
}

function onDocumentMouseWheel(event) {
	radious -= event.detail * 10;

	camera.position.x = radious * Math.sin(theta * Math.PI / 360)
			* Math.cos(phi * Math.PI / 360);
	camera.position.y = radious * Math.sin(phi * Math.PI / 360);
	camera.position.z = radious * Math.cos(theta * Math.PI / 360)
			* Math.cos(phi * Math.PI / 360);
	camera.updateMatrix();

	render();

}

function onDocumentMouseMove(event) {

	event.preventDefault();

	if (isMouseDown) {

		theta = -((event.clientX - onMouseDownPosition.x) * 0.5)
				+ onMouseDownTheta;
		phi = ((event.clientY - onMouseDownPosition.y) * 0.5) + onMouseDownPhi;

		phi = Math.min(180, Math.max(0, phi));

		camera.position.x = radious * Math.sin(theta * Math.PI / 360)
				* Math.cos(phi * Math.PI / 360);
		camera.position.y = radious * Math.sin(phi * Math.PI / 360);
		camera.position.z = radious * Math.cos(theta * Math.PI / 360)
				* Math.cos(phi * Math.PI / 360);
		camera.updateMatrix();

	}

	render();

}

function onDocumentMouseDown(event) {

	event.preventDefault();

	isMouseDown = true;

	onMouseDownTheta = theta;
	onMouseDownPhi = phi;
	onMouseDownPosition.x = event.clientX;
	onMouseDownPosition.y = event.clientY;
}

function onDocumentMouseUp(event) {

	event.preventDefault();

	isMouseDown = false;

	onMouseDownPosition.x = event.clientX - onMouseDownPosition.x;
	onMouseDownPosition.y = event.clientY - onMouseDownPosition.y;

	findAndProcessClicked(event);

	render();
}

function render() {
	renderer.render(scene, camera);
}