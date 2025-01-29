Rasterization Pipeline: Tests each triangle against pixels by computing a bounding box
- Apply transformation matrix
- Intialise z buffer
- Rasterize each triangle in each shape
	- compute normal for shading
	- compute rectangular bounds [ identifies 2d screen space are affected by 3d object ]
	- loop through every pixel in bounding box
	- check if pixel is inside the triangle
	- compute z depth
- set color of pixel if z buffer is smallest

Ray Tracing Pipeline: Shoots a ray from camera through each pixel using mathematical equations
- Generate a ray from camera passing through lookAt
- Loop through all objects and find closest intersection
- Anti aliasing to sample out colours

