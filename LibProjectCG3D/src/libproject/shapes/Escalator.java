package libproject.shapes;



import javax.media.j3d.Alpha;
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Font3D;
import javax.media.j3d.RotationInterpolator;
import javax.media.j3d.Text3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Cylinder;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3f;

import com.sun.j3d.utils.picking.PickTool;


public class Escalator extends BranchGroup {

    public Escalator(float sizeX, float sizeY, float sizeZ, Appearance app, Appearance app2) {
        Box box = new Box(sizeX, sizeY, sizeZ, Box.GENERATE_NORMALS | Box.GENERATE_TEXTURE_COORDS, app);

        Transform3D tr = new Transform3D();
        TransformGroup tg = new TransformGroup(tr);
        tg.addChild(box);

        int numCylinders = (int) (sizeX / 0.1f);
        float cylinderSpacing = sizeX / (numCylinders + 1);

        float cylinderHeight = sizeY * 8.0f;
        float cylinderRadius = 0.1f;

        for (int i = 0; i < numCylinders * 2; i++) {
            Cylinder cylinder = new Cylinder(cylinderRadius, cylinderHeight, app2);

            Transform3D cylinderTransform = new Transform3D();
            cylinderTransform.rotX(Math.toRadians(90));
    
            
            float totalWidth = numCylinders * cylinderSpacing * 3;
            float startX = (sizeX - totalWidth) / 2.0f;

            float cylinderX = startX + i * cylinderSpacing;
            cylinderTransform.setTranslation(new Vector3f(cylinderX, 0.5f * sizeY + 0.01f, 0f));

            TransformGroup cylinderTG = new TransformGroup(cylinderTransform);
            cylinderTG.addChild(cylinder);

            tg.addChild(cylinderTG);
        }

        addChild(tg);
    }
}