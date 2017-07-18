package com.base.game;

import com.base.engine.components.GameComponent;
import com.base.engine.core.Quaternion;
import com.base.engine.core.Vector3f;

public class Rotate extends GameComponent
{
	float rotAngle = 0;
	float rotSpeed;// = (float)Math.random()/100;
	Vector3f rotAxis = new Vector3f(0,1,0);
	
	public Rotate(float RotSpeed)
	{
		this.rotSpeed = RotSpeed;
	}
	
	@Override
	public void Update(float delta)
	{
		rotAngle -= rotSpeed;
		GetTransform().SetRot(new Quaternion((rotAxis),(float) Math.toRadians(rotAngle)));
	}
}
