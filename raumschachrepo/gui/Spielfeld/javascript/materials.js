//A black field.
var materialblackField = new THREE.MeshBasicMaterial({
	color : 0xF7BE81
});
//A white field.
var materialwhiteField = new THREE.MeshBasicMaterial({
	color : 0xE6E6E6
});
//A field, where a selected figure can be moved to.
var materialMoveToField = new THREE.MeshBasicMaterial({
	color : 0x04B404
});
//A field, which can be attacked by the selected figure.
var materialAttackField = new THREE.MeshBasicMaterial({
	color : 0x8A0808
});
//A selected black figure.
var materialblackSelected = new THREE.MeshLambertMaterial({
	color : 0xFF0000,
	shading : THREE.FlatShading
});
//A selected white figure.
var materialwhiteSelected = new THREE.MeshLambertMaterial({
	color : 0x2E2EFE,
	shading : THREE.FlatShading
});
//A black figure.
var materialblack = new THREE.MeshLambertMaterial({
	color : 0xff8000,
	shading : THREE.FlatShading
});
//A white figure.
var materialwhite = new THREE.MeshLambertMaterial({
	color : 0x848484,
	shading : THREE.FlatShading
});