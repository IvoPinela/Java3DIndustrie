package libproject.shapes;

import javax.media.j3d.Appearance;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3f;

import com.sun.j3d.utils.geometry.Box;

public class Person extends BranchGroup {
	public Person(float size, Appearance cobre,Appearance iron) {
		 Box bodyExt = new Box(size/2, size, size/2, Box.GENERATE_NORMALS | Box.GENERATE_TEXTURE_COORDS, cobre);

		  Transform3D tr = new Transform3D();
	        tr.set(new Vector3f(0, 0.045f + 0.005f, 0));
	        TransformGroup tg = new TransformGroup(tr);
	        tr.setTranslation(new Vector3f(0.2f,0.22f, 0.5f));
	        tg = new TransformGroup(tr);
	        tg.addChild(bodyExt);
	        addChild(tg);
	        
	        
	        
	        Box head = new Box(size/2, size/4, size/2, Box.GENERATE_NORMALS | Box.GENERATE_TEXTURE_COORDS, iron);

			   tr = new Transform3D();
		        tr.set(new Vector3f(0, 0.045f + 0.005f, 0));
		         tg = new TransformGroup(tr);
		        tr.setTranslation(new Vector3f(0.2f,0.28f+size, 0.5f));
		        tg = new TransformGroup(tr);
		        tg.addChild(head);
		        addChild(tg);
		        
		        Box arm = new Box(size/6, size/2, size/6, Box.GENERATE_NORMALS | Box.GENERATE_TEXTURE_COORDS, iron);

				   tr = new Transform3D();
			        tr.set(new Vector3f(0, 0.045f + 0.005f, 0));
			         tg = new TransformGroup(tr);
			        tr.setTranslation(new Vector3f(0.35f,size, 0.5f));
			        tg = new TransformGroup(tr);
			        tg.addChild(arm);
			        addChild(tg);
			        
			        Box arm2 = new Box(size/6, size/2, size/6, Box.GENERATE_NORMALS | Box.GENERATE_TEXTURE_COORDS, iron);

					   tr = new Transform3D();
				        tr.set(new Vector3f(0, 0.045f + 0.005f, 0));
				         tg = new TransformGroup(tr);
				        tr.setTranslation(new Vector3f(0.05f,size, 0.5f));
				        tg = new TransformGroup(tr);
				        tg.addChild(arm2);
				        addChild(tg);
	}
}

	

