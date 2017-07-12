// Created by Tomasz Naglik 02.06.2017

package com.base.game;
import com.base.engine.components.*;
import com.base.engine.core.*;
import com.base.engine.rendering.*;

public class TestSphere extends Game
{
		
	public void Init()
	{
		//Lighting
		
		
		GameObject DirectionalLight_Object = new GameObject();
		IlluminationComponent illuminationComponent = new IlluminationComponent(new Vector3f(1,2,2), 1.0f);
		DirectionalLight_Object.AddComponent(illuminationComponent);
		
		
		//FreeCamera
		GameObject FreeCam = new 	GameObject();
		FreeCam.AddComponent(new FreeLook(0.5f)).AddComponent(new FreeMove(10.0f))
				.AddComponent(new Camera(new Matrix4f().InitPerspective((float) Math.toRadians(70.0f),
				(float) Window.GetWidth() / (float) Window.GetHeight(), 0.01f, 1000.0f)));
		
		
		//Mesh
		Vertex[] vertices = {	new Vertex(new Vector3f(0,0,0), new Vector2f(0,0)),
								new Vertex(new Vector3f(5,5,0), new Vector2f(0,1)),
								new Vertex(new Vector3f(10,0,0), new Vector2f(1,0))};
		
		int[] indices = {3,2,1};
		
		Mesh mesh = new Mesh(vertices, indices, true);
		Material material = new Material(new Texture("bricks2.jpg"), 1, 8,
				new Texture("bricks2_normal.png"), new Texture("bricks2_disp.jpg"), 0.04f, -1.0f);
		
		
		MeshRenderer meshRenderer = new MeshRenderer(mesh, material);		
		GameObject planeObject = new GameObject();
		planeObject.AddComponent(meshRenderer);
		planeObject.GetTransform().GetPos().Set(0, 0, 5);
		//planeObject.GetTransform().GetRot().Set(new Quaternion(0,1,0,1));
		
		Mesh tempMesh = new Mesh("monkey3.obj");
		MeshRenderer tempMeshRenderer = new MeshRenderer(tempMesh, material);
		
		GameObject monkey = new GameObject();
		monkey.AddComponent(tempMeshRenderer);
		FreeCam.GetTransform().SetPos(new Vector3f(0,0,10));
		FreeCam.GetTransform().SetRot(new Quaternion(0,4.5f,0,1));
		
		monkey.GetTransform().SetPos(new Vector3f(0,0,8));
		
		AddObject(FreeCam);;
		AddObject(DirectionalLight_Object);
		AddObject(planeObject);
		AddObject(monkey);
		
		
	}
	
	
}
