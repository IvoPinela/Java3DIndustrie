package libproject.shapes;

import javax.media.j3d.Appearance;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Group;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3f;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.picking.PickTool;



public class MechanicalArm extends BranchGroup {
	
	public MechanicalArm(float size, Appearance iron, Appearance cobre) {
       
        Cylinder base = new Cylinder(0.4f, 0.05f, Cylinder.GENERATE_NORMALS, 38, 1, iron);

        Transform3D tr = new Transform3D();
        tr.set(new Vector3f(0, 0.045f + 0.005f, 0));
        TransformGroup tg = new TransformGroup(tr);
        tg.addChild(base);
        addChild(tg);

  
        Box bodyExt = new Box(size,  1.5f*size, size, Box.GENERATE_NORMALS | Box.GENERATE_TEXTURE_COORDS, cobre);

        tr = new Transform3D();
        
        tr.setTranslation(new Vector3f(0, 1.5f*size + 0.005f+0.040f, 0));
        tg = new TransformGroup(tr);
        tg.addChild(bodyExt);
        addChild(tg);
        

        Box bodyInt = new Box(size * 0.8f, size*1.5f, size * 0.8f, Box.GENERATE_NORMALS | Box.GENERATE_TEXTURE_COORDS, iron);

         tr = new Transform3D();
        tr.setTranslation(new Vector3f(0, 2 * size + 2 * size * 0.8f + 0.005f + 0.040f, 0));
         tg = new TransformGroup(tr);
        tg.addChild(bodyInt);
        addChild(tg);
        

        Box upperArm = new Box(size * 0.8f, size * 2f, size * 0.8f, Box.GENERATE_NORMALS | Box.GENERATE_TEXTURE_COORDS, iron);

    
         tr = new Transform3D();
         tr.rotX(Math.toRadians(45)); 
         tr.setTranslation(new Vector3f(0, 4.9f * size*1.25f+ 0.005f, 0.23f));
         tg = new TransformGroup(tr);
         tg.addChild(upperArm);
        addChild(tg);
    

        Cylinder largerCylinder = new Cylinder(0.15f, size * 3f, Cylinder.GENERATE_NORMALS, 38, 1, cobre);

         tr = new Transform3D();
         tr.rotX(Math.toRadians(45)); 
        tr.setTranslation(new Vector3f(0, 8f * size+ 0.005f, 3f*size));  
        
         tg = new TransformGroup(tr);
         tg.addChild(largerCylinder);
        addChild(tg);

        // Larger Cylinder
        Cylinder Cylinder2 = new Cylinder(0.20f, size * 1.5f, Cylinder.GENERATE_NORMALS, 38, 1, iron);

         tr = new Transform3D();
         tr.rotX(Math.toRadians(45)); 
        tr.setTranslation(new Vector3f(0, 9.5f * size+ 0.005f, 4.5f*size));  
         tg = new TransformGroup(tr);
         tg.addChild(Cylinder2);
        addChild(tg);
        
        
        Claw claw=new Claw(0.3f,0.2f, cobre);
		PickTool.setCapabilities(claw, PickTool.INTERSECT_TEST);
		tr=new Transform3D();
		tr.setScale(0.5f);

		
		  tr.rotX(Math.toRadians(-45)); 
		tr.setTranslation(new Vector3f(0, 10.1f * size + 0.005f,5f * size));
	        
		tg=new TransformGroup(tr);
		tg.addChild(claw);
		addChild(tg);
		
		
		HexagonalPrism prims1 = new HexagonalPrism(0.4f*size,0.8f*size,cobre);
		   tr = new Transform3D();
		   tr.rotY(Math.toRadians(-90)); 
	        tr.setTranslation(new Vector3f(-0.8f*size, 4.8f * size+ 0.005f, -0f*size));  
	  	 
	         tg = new TransformGroup(tr);
	         tg.addChild(prims1);
	        addChild(tg);
	        
	        
	    	HexagonalPrism prims2 = new HexagonalPrism(0.4f*size,0.8f*size,cobre);
			   tr = new Transform3D();
			   tr.rotY(Math.toRadians(90)); 
		        tr.setTranslation(new Vector3f(0.8f*size, 4.8f * size+ 0.005f, -0f*size));  
		  	 
		         tg = new TransformGroup(tr);
		         tg.addChild(prims2);
		        addChild(tg);
	
    }
	
}
