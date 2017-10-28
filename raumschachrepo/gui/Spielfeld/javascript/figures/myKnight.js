var myKnight = function () {

	var scope = this;

	THREE.Geometry.call(this);

	v( 12.525287, 0.806159, -12.525287 );
	v( 12.525287, 0.806159, 12.525287 );
	v( -12.525287, 0.806159, 12.525287 );
	v( -12.525287, 0.806159, -12.525287 );
	v( 12.525288, 76.897293, -12.525286 );
	v( 12.525286, 51.693962, 12.525288 );
	v( -12.525287, 51.693962, 12.525287 );
	v( -12.525287, 76.897293, -12.525287 );

	f4( 0, 1, 2, 3, 0.577349, -0.577349, -0.577349 );
	f4( 4, 7, 6, 5, 0.795160, 0.560564, -0.231178 );
	f4( 0, 4, 5, 1, 0.577349, -0.577349, -0.577349 );
	f4( 1, 5, 6, 2, 0.577349, -0.577349, 0.577349 );
	f4( 2, 6, 7, 3, -0.577349, -0.577349, 0.577349 );
	f4( 4, 0, 3, 7, 0.795160, 0.560564, -0.231178 );


	function v( x, y, z ) {

		scope.vertices.push( new THREE.Vertex( new THREE.Vector3( x, y, z ) ) );

	}

	function f3( a, b, c, nx, ny, nz ) {

		scope.faces.push( new THREE.Face3( a, b, c, nx && ny && nz ? new THREE.Vector3( nx, ny, nz ) : null ) );

	}

	function f4( a, b, c, d, nx, ny, nz ) {

		scope.faces.push( new THREE.Face4( a, b, c, d, nx && ny && nz ? new THREE.Vector3( nx, ny, nz ) : null ) );

	}

	function uv( u1, v1, u2, v2, u3, v3, u4, v4 ) {

		var uv = [];
		uv.push( new THREE.UV( u1, v1 ) );
		uv.push( new THREE.UV( u2, v2 ) );
		uv.push( new THREE.UV( u3, v3 ) );
		if ( u4 && v4 ) uv.push( new THREE.UV( u4, v4 ) );
		scope.uvs.push( uv );
	}

	this.computeCentroids();
	this.computeFaceNormals();
	this.sortFacesByMaterial();
}

myKnight.prototype = new THREE.Geometry();
myKnight.prototype.constructor = myKnight;