package com.base.game;

import com.base.engine.components.BaseLight;
import com.base.engine.components.DirectionalLight;
import com.base.engine.components.GameComponent;
import com.base.engine.core.Input;
import com.base.engine.core.Vector3f;
import com.base.engine.rendering.RenderingEngine;
import com.base.engine.rendering.Shader;

public class IlluminationComponent extends DirectionalLight
{
	public float luminosity = 1.0f;
	
		public IlluminationComponent(Vector3f color, float luminosity)
		{
			super(color, luminosity);

		}

		public Vector3f GetDirection()
		{
			return GetTransform().GetTransformedRot().GetForward();
		}
	
	
	@Override
	public void Update(float delta)
	{
		this.SetIntensity(luminosity);
		
	}
	
	@Override 
	public void Input(float delta)
	{
		if(Input.GetKey(Input.KEY_1)) luminosity+= 0.001f;
		if(Input.GetKey(Input.KEY_2)) luminosity-= 0.001f;
	}
	
	
}
