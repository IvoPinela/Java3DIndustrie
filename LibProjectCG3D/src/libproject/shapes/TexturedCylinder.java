package libproject.shapes;

import javax.media.j3d.Appearance;
import javax.media.j3d.IndexedQuadArray;
import javax.media.j3d.IndexedTriangleArray;
import javax.media.j3d.Shape3D;
import javax.vecmath.Point3f;
import javax.vecmath.TexCoord2f;
import com.sun.j3d.utils.geometry.Cylinder;

import com.sun.j3d.utils.geometry.GeometryInfo;
import com.sun.j3d.utils.geometry.NormalGenerator;

public class TexturedCylinder extends Shape3D {

    public TexturedCylinder(Appearance app, int numDivisions, float height, float radius) {
        int numVertices = numDivisions * 2 + 2;  
        int numIndices = numDivisions * 18;

        Point3f[] coords = new Point3f[numVertices];
        TexCoord2f[] tex = new TexCoord2f[numVertices];
        int[] coordsIndices = new int[numIndices];
        int[] texIndices = new int[numIndices];

      
        for (int i = 0; i < numDivisions; i++) {
            float angle = (float) (2 * Math.PI * i / numDivisions);
            float x = radius * (float) Math.cos(angle);
            float y = radius * (float) Math.sin(angle);

            coords[i] = new Point3f(x, y, 0);  
            tex[i] = new TexCoord2f((float) i / numDivisions, 0);

            coords[i + numDivisions] = new Point3f(x, y, height);  
            tex[i + numDivisions] = new TexCoord2f((float) i / numDivisions, 1);
        }

        
        coords[numDivisions * 2] = new Point3f(0, 0, 0);
        tex[numDivisions * 2] = new TexCoord2f(0.5f, 0.5f);

        coords[numDivisions * 2 + 1] = new Point3f(0, 0, height);
        tex[numDivisions * 2 + 1] = new TexCoord2f(0.5f, 0.5f);

    
        int index = 0;

        // Base
        for (int i = 0; i < numDivisions; i++) {
            coordsIndices[index] = numDivisions * 2;  
            texIndices[index++] = numDivisions * 2;

            coordsIndices[index] = i;
            texIndices[index++] = i;

            coordsIndices[index] = (i + 1) % numDivisions;
            texIndices[index++] = (i + 1) % numDivisions;
        }

        // Topo
        for (int i = 0; i < numDivisions; i++) {
            coordsIndices[index] = numDivisions * 2 + 1;  
            texIndices[index++] = numDivisions * 2 + 1;

            coordsIndices[index] = i + numDivisions;
            texIndices[index++] = i + numDivisions;

            coordsIndices[index] = (i + 1) % numDivisions + numDivisions;
            texIndices[index++] = (i + 1) % numDivisions + numDivisions;
        }

        // Lateral
        for (int i = 0; i < numDivisions; i++) {
            coordsIndices[index] = i;
            texIndices[index++] = i;

            coordsIndices[index] = (i + 1) % numDivisions;
            texIndices[index++] = (i + 1) % numDivisions;

            coordsIndices[index] = i + numDivisions;
            texIndices[index++] = i + numDivisions;

            coordsIndices[index] = (i + 1) % numDivisions;
            texIndices[index++] = (i + 1) % numDivisions;

            coordsIndices[index] = (i + 1) % numDivisions + numDivisions;
            texIndices[index++] = (i + 1) % numDivisions + numDivisions;

            coordsIndices[index] = i + numDivisions;
            texIndices[index++] = i + numDivisions;
        }

        
        IndexedTriangleArray ita = new IndexedTriangleArray(numVertices, IndexedTriangleArray.COORDINATES | IndexedTriangleArray.TEXTURE_COORDINATE_2, numIndices);
        ita.setCoordinates(0, coords);
        ita.setCoordinateIndices(0, coordsIndices);
        ita.setTextureCoordinates(0, 0, tex);
        ita.setTextureCoordinateIndices(0, 0, texIndices);

        
        GeometryInfo gi = new GeometryInfo(ita);
        NormalGenerator ng = new NormalGenerator();
        ng.generateNormals(gi);

     
        setGeometry(gi.getGeometryArray());
        setAppearance(app);
    }
}