package libproject.shapes;

import javax.media.j3d.Appearance;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.GeometryArray;
import javax.media.j3d.IndexedTriangleArray;
import javax.media.j3d.PolygonAttributes;
import javax.media.j3d.QuadArray;
import javax.media.j3d.Shape3D;
import javax.media.j3d.TriangleArray;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;

public class Octaedro extends Shape3D {

    public Octaedro(float size, Appearance app, boolean solid) {
        int numeroVertices = 8;
        int numeroFaces = 8;

        Point3f[] vertices = new Point3f[numeroVertices];

        float a = size;
        float b = a / 2;

        vertices[0] = new Point3f(-b, 0.0f, b);
        vertices[1] = new Point3f(b, 0.0f, b);
        vertices[2] = new Point3f(b, 0.0f, -b);
        vertices[3] = new Point3f(-b, 0.0f, -b);
        vertices[4] = new Point3f(0.0f, a, 0.0f);
        vertices[5] = new Point3f(0.0f, -a, 0.0f);
        vertices[6] = new Point3f(0.0f, 0.0f, a);
        vertices[7] = new Point3f(0.0f, 0.0f, -a);

        int[] indices = {
            0, 1, 4,
            1, 2, 4,
            2, 3, 4,
            3, 0, 4,
            0, 1, 5,
            1, 2, 5,
            2, 3, 5,
            3, 0, 5,
        };

        IndexedTriangleArray geom = new IndexedTriangleArray(numeroVertices, GeometryArray.COORDINATES, numeroFaces * 3);
        geom.setCoordinates(0, vertices);
        geom.setCoordinateIndices(0, indices);

       
        if (solid) {
            app.setPolygonAttributes(new PolygonAttributes(PolygonAttributes.POLYGON_FILL, PolygonAttributes.CULL_NONE, 0));
        } else {
            app.setPolygonAttributes(new PolygonAttributes(PolygonAttributes.POLYGON_LINE, PolygonAttributes.CULL_NONE, 0));
        }

        setGeometry(geom);
        setAppearance(app);
    }

  
    public void setSolid(boolean solid) {
        Appearance app = getAppearance();
        PolygonAttributes polygonAttributes = new PolygonAttributes();

        if (solid) {
            polygonAttributes.setPolygonMode(PolygonAttributes.POLYGON_FILL);
        } else {
            polygonAttributes.setPolygonMode(PolygonAttributes.POLYGON_LINE);
        }

        app.setPolygonAttributes(polygonAttributes);
    }
}