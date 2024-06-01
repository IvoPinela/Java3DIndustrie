package libproject.shapes;

import javax.media.j3d.Appearance;
import javax.media.j3d.GeometryArray;
import javax.media.j3d.IndexedTriangleArray;
import javax.media.j3d.QuadArray;
import javax.media.j3d.Shape3D;
import javax.media.j3d.TriangleArray;
import javax.media.j3d.TriangleFanArray;
import javax.media.j3d.TriangleStripArray;
import javax.vecmath.Point3f;

import com.sun.j3d.utils.geometry.GeometryInfo;
import com.sun.j3d.utils.geometry.NormalGenerator;

public class HexagonalPrism extends Shape3D {

	  public HexagonalPrism(float height, float baseSize, Appearance app) {
	        int n = 6; // Número de vértices na base (um hexágono)
	        int totalVertices = n * 2; 
	        int totalIndices = n * 6 * 3; // Número total de índices

	        IndexedTriangleArray ita = new IndexedTriangleArray(totalVertices, IndexedTriangleArray.COORDINATES, totalIndices);

	        Point3f[] pts = new Point3f[totalVertices];

	        int index = 0;
	        for (int i = 0; i < n; i++) {
	            double angle = 2.0 * Math.PI * i / n;
	            float x = (float) (baseSize * Math.cos(angle));
	            float y = (float) (baseSize * Math.sin(angle));
	            float z = 0;

	            pts[index++] = new Point3f(x, y, z); 
	            pts[index++] = new Point3f(x, y, height); 
	        }

	        ita.setCoordinates(0, pts);

	        index = 0;
	        for (int i = 0; i < n; i++) {
	            int a = i * 2; 
	            int b = (i + 1) % n * 2; 
	            int c = a + 1; 
	            int d = b + 1; 

	          
	            ita.setCoordinateIndex(index++, a);
	            ita.setCoordinateIndex(index++, b);
	            ita.setCoordinateIndex(index++, c);

	          
	            ita.setCoordinateIndex(index++, b);
	            ita.setCoordinateIndex(index++, d);
	            ita.setCoordinateIndex(index++, c);
	        }

	       
	        for (int i = 0; i < n; i++) {
	           
	            int a = i * 2;
	            int b = (i + 1) % n * 2;
	            int c = a + 1;
	            int d = b + 1;

	         
	            int e = totalVertices - 2; 
	            int f = totalVertices - 1; 

	           
	            ita.setCoordinateIndex(index++, a);
	            ita.setCoordinateIndex(index++, b);
	            ita.setCoordinateIndex(index++, e);

	            
	            ita.setCoordinateIndex(index++, c);
	            ita.setCoordinateIndex(index++, d);
	            ita.setCoordinateIndex(index++, f);
	        }

	       
	        GeometryInfo gi = new GeometryInfo(ita);
	        NormalGenerator ng = new NormalGenerator();
	        ng.generateNormals(gi);

	        setGeometry(gi.getGeometryArray());
	        setAppearance(app);

	        setCapability(ALLOW_LOCAL_TO_VWORLD_READ);
	    }
	}