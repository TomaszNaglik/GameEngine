package com.base.game;

import com.base.engine.components.BaseLight;
import com.base.engine.components.DirectionalLight;
import com.base.engine.components.GameComponent;
import com.base.engine.core.Input;
import com.base.engine.core.Vector3f;
import com.base.engine.rendering.RenderingEngine;
import com.base.engine.rendering.Shader;

public class IlluminationComponent extends GameComponent
{
	public float IntensityDelta = 0.0001f;;
	public DirectionalLight DL;
	
		public IlluminationComponent(DirectionalLight dl)
		{
			this.DL = dl;
		}

	@Override
	public void Update(float delta)
	{
				
	}
	
	@Override 
	public void Input(float delta)
	{
		if(Input.GetKey(Input.KEY_1)) DL.SetIntensity(DL.GetIntensity()+IntensityDelta);
		if(Input.GetKey(Input.KEY_2)) DL.SetIntensity(DL.GetIntensity()-IntensityDelta);
		
		if(DL.GetIntensity()>1) DL.SetIntensity(1.0f);
		if(DL.GetIntensity()<0) DL.SetIntensity(0.0f);
	}
}
