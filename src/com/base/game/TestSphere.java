// Created by Tomasz Naglik 02.06.2017

package com.base.game;
import com.base.engine.components.*;
import com.base.engine.core.*;
import com.base.engine.rendering.*;

public class TestSphere extends Game
{
		
	public void Init()
	{
		
		//Parameters
		Quaternion fixedDirectionalLightOrientation = new Quaternion(new Vector3f(1, 0, 0), (float) Math.toRadians(-180));
		
		//Lighting
		GameObject modifiableDirectionalLight = CreateModifiableDirectionalLight();
		GameObject fixedDirectionalLight = CreateDirectionalLight().SetRotation(fixedDirectionalLightOrientation);
		GameObject FreeCam = CreateFreeCam();
		
		
		Mesh mesh3 = new Mesh("monkey3.obj");
		Material material2 = new Material(new Texture("bricks.jpg"), 1, 8,new Texture("bricks_normal.jpg"), new Texture("bricks_disp.png"), 0.04f, -1.0f);
		int spread = 1;
		int num = 1;
		for(int i=0; i<num; i++)
		{
			float n = (float)Math.random()*spread;
			float m = (float)Math.random()*spread;
			float o = (float)Math.random()*spread;
			GameObject monkey = new GameObject();
			monkey.AddComponent(new MeshRenderer(mesh3, material2));
			monkey.AddComponent(new LookAtComponent());
			monkey.GetTransform().SetPos(new Vector3f(n,m,o));
			//monkey.AddComponent(new RotateMonkey());
			AddObject(monkey);
		}
		
		
		
		
		
		//Mesh
		Vertex[] vertices = {	new Vertex(new Vector3f(-1,-1,0), new Vector2f(0,0)),
								new Vertex(new Vector3f(0,1,0), new Vector2f(0.5f,0)),
								new Vertex(new Vector3f(1,-1,0), new Vector2f(1.0f,0)),
								new Vertex(new Vector3f(0,-1,1), new Vector2f(0.5f,1.0f))};
		
		int[] indices = new int[] 	{3,1,0,
									 2,1,3,
									 0,1,2,
									 0,2,3};
		
		Mesh pyramid = new Mesh(vertices, indices,true);
		Material material = new Material(new Texture("bricks2.jpg"), 1, 8,new Texture("bricks2_normal.png"), new Texture("bricks2_disp.jpg"), 0.04f, -1.0f);
		
		GameObject myMesh = new GameObject();
		AddObject(myMesh);
		myMesh.AddComponent(new MeshRenderer(pyramid, material)).AddComponent(new Rotate(0.005f));
		myMesh.GetTransform().GetPos().Set(5, 0, 5);
		
		
		
		/*MeshRenderer meshRenderer = new MeshRenderer(mesh, material);		
		GameObject planeObject = new GameObject();
		planeObject.AddComponent(meshRenderer);
		planeObject.GetTransform().GetPos().Set(0, 0, 5);
		planeObject.GetTransform().GetRot().Set(new Quaternion(1,1,1,1));
		
		GameObject planeObject2 = new GameObject();
		planeObject2.AddComponent(new MeshRenderer(mesh3, material2));
		planeObject2.GetTransform().GetPos().Set(0, 5, 5);
		
		//GameObject planeObject3 = new GameObject();
		//planeObject3.AddComponent(new MeshRenderer(mesh4, material2));//.AddComponent(new LookAtComponent());
		//planeObject3.GetTransform().GetPos().Set(5, 5, 5);
		//planeObject2.GetTransform().GetRot().Set(new Quaternion(1,1,1,1));
		*/
		
		//myMesh.GetTransform().GetRot().Set(new Quaternion(1,1,1,1));
		
			
		
		
		//AddObject(planeObject);
		//AddObject(planeObject2);
		//AddObject(planeObject3);
		
		//AddObject(monkey);
		
		
	}
	
	
	private GameObject CreateFreeCam()
	{
		GameObject FreeCam = new 	GameObject();
		FreeCam.AddComponent(new FreeLook(0.5f)).
				AddComponent(new FreeMove(10.0f)).
				AddComponent(new Camera(new Matrix4f().InitPerspective((float) Math.toRadians(70.0f),
							(float) Window.GetWidth() / (float) Window.GetHeight(), 0.01f, 1000.0f)));
				FreeCam.GetTransform().SetPos(new Vector3f(0,0,-10));
		AddObject(FreeCam);
		return FreeCam;
	}


	private GameObject CreateDirectionalLight()
	{
		DirectionalLight dl = new DirectionalLight(new Vector3f(1,1,1), 1.0f);
		GameObject fixedDirectionalLight = new GameObject();
		fixedDirectionalLight.AddComponent(dl);
		AddObject(fixedDirectionalLight);
		return fixedDirectionalLight;
	}
	
	private GameObject CreateModifiableDirectionalLight()
	{
		DirectionalLight dl = new DirectionalLight(new Vector3f(1,1,1), 1.0f);
		GameObject modifiableDirectionalLight = new GameObject();
		modifiableDirectionalLight.AddComponent(dl);
		modifiableDirectionalLight.AddComponent(new IlluminationComponent(dl));
		AddObject(modifiableDirectionalLight);
		return modifiableDirectionalLight;
	}
	
	
}
