package libproject.shapes;

import javax.media.j3d.Appearance;
import javax.media.j3d.IndexedTriangleArray;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TriangleArray;
import javax.vecmath.Point3f;
import com.sun.j3d.utils.geometry.GeometryInfo;
import com.sun.j3d.utils.geometry.NormalGenerator;

public class Claw extends Shape3D {

    public Claw(float height, float baseSize, Appearance app) {
        int n = 6; // Número de vértices na base 
        int totalVertices = n + 1; 
        int totalIndices = n * 4 * 3 + n * 3; 

        IndexedTriangleArray ita = new IndexedTriangleArray(totalVertices, IndexedTriangleArray.COORDINATES, totalIndices);

        Point3f[] pts = new Point3f[totalVertices];

        int index = 0;
        for (int i = 0; i < n; i++) {
            double angle = 2.0 * Math.PI * i / n;
            float x = (float) (baseSize * Math.cos(angle));
            float y = (float) (baseSize * Math.sin(angle));
            float z = 0;

            pts[index++] = new Point3f(x, y, z);
        }

       
        pts[index++] = new Point3f(0, 0, height);

        ita.setCoordinates(0, pts);

        index = 0;
        for (int i = 0; i < n; i++) {
            int a = i;
            int b = (i + 1) % n;
            int c = n; 

           
            ita.setCoordinateIndex(index++, a);
            ita.setCoordinateIndex(index++, b);
            ita.setCoordinateIndex(index++, c);
            
            ita.setCoordinateIndex(index++, a);
            ita.setCoordinateIndex(index++, c);
            ita.setCoordinateIndex(index++, b);
        }

       
        GeometryInfo gi = new GeometryInfo(ita);
        NormalGenerator ng = new NormalGenerator();
        ng.generateNormals(gi);

        setGeometry(gi.getGeometryArray());
        setAppearance(app);
    }
}