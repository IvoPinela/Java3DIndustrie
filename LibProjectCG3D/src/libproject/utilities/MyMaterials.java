package libproject.utilities;

import javax.media.j3d.Material;

public class MyMaterials extends Material {

	public static int BRASS=0;
	public static int BRONZE=1;
	public static int WOOD=2;
	public static int IRON=3;
	public static int RUBBER=4;
	
	
	public MyMaterials(int type) {
		switch (type) {
		case 0: 
			setAmbientColor(0.329412f,0.223529f,0.027451f);
			setDiffuseColor(0.790392f,0.568637f,0.113725f);
			setSpecularColor(0.992157f,0.941176f,0.807843f);
			setShininess(27.8974f);
			break;
		case 1: 
			setAmbientColor(0.2125f,0.1275f,0.054f);
			setDiffuseColor(0.714f,0.4284f,0.18144f);
			setSpecularColor(0.393548f,0.271906f,0.177721f);
			setShininess(25.6f);
			break;
	
	case 2: 
		   setAmbientColor(0.3f, 0.2f, 0.15f);       
		    setDiffuseColor(0.8f, 0.6f, 0.4f);       
		    setSpecularColor(0.4f, 0.3f, 0.2f);       
		    setShininess(30.0f);
		break;
		
	case 3: 
		setAmbientColor(0.25f, 0.25f, 0.25f);    
		setDiffuseColor(0.7f, 0.7f, 0.7f);       
		setSpecularColor(0.8f, 0.8f, 0.8f);      
		setShininess(50.0f); 
		break;
		
	case 4: 
		setAmbientColor(0.05f, 0.05f, 0.05f);   
		setDiffuseColor(0.2f, 0.2f, 0.2f);      
		setSpecularColor(0.0f, 0.0f, 0.0f);      
		setShininess(1.0f);  
		break;
	
		}
	}
}
