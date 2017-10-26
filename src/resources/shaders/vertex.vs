#version 330

layout (location=0) in vec3 position;
layout (location=1) in vec2 texCoord;
layout (location=2) in vec3 vertexNormal;

out vec2 outTexCoord;
out vec3 mvVertexNormal;
out vec3 mvVertexPos;

uniform mat4 modelView;
uniform mat4 projection;

void main()
{
    vec4 mvPos = modelView * vec4(position, 1.0);
    gl_Position = projection * mvPos;
    outTexCoord = texCoord;
    mvVertexNormal = normalize(modelView * vec4(vertexNormal, 0.0)).xyz;
    mvVertexPos = mvPos.xyz;
}