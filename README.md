# 3DEngine

Basic 3D engine with rasterization, z buffering and phong shading

## Phong Shading

Ambient Lighting
``` java
float ambientStrength = 0.1;
vec4 FragColor = ambientStrength * objectColor;
```

Diffuse Lighting
Light Ray Perpendicular to Object Surface => Greatest Impact (Normal Vector)
- Normal Vector to Vertex Surface
- Normal Vector of Directed Light Ray (Light pos - Frag pos)


Normal Vector to Vertex Surface
Use surrounding vertices to figure out surface of the vertex - cross product.


Specular Lighting




https://learnopengl.com/Lighting/Basic-Lighting 