package libproject.shapes;

import javax.media.j3d.Appearance;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.PolygonAttributes;
import javax.media.j3d.QuadArray;
import javax.media.j3d.Shape3D;
import javax.media.j3d.TriangleArray;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;

public class FloorTriangle extends Shape3D {

    public FloorTriangle(int divisions, float min, float max, Color3f color1, Color3f color2, boolean solid) {

        int n = divisions;
        float a = min;
        float b = max;
        float divX = (b - a) / n;

        int m = divisions;
        float c = min;
        float d = max;
        float divZ = (d - c) / m;

        int totalVertices = (m * n * 3 * 2);

        Point3f[] pts = new Point3f[totalVertices];
        Color3f[] colors = new Color3f[totalVertices];

        int idx = 0;
        boolean invert = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Triangle 1
                pts[idx] = new Point3f(a + i * divX, 0, c + j * divZ);
                colors[idx] = (invert ? color1 : color2);
                idx++;

                pts[idx] = new Point3f(a + i * divX, 0, c + (j + 1) * divZ);
                colors[idx] = (invert ? color1 : color2);
                idx++;

                pts[idx] = new Point3f(a + (i + 1) * divX, 0, c + j * divZ);
                colors[idx] = (invert ? color1 : color2);
                idx++;

                // Triangle 2
                pts[idx] = new Point3f(a + i * divX, 0, c + (j + 1) * divZ);
                colors[idx] = (!invert ? color1 : color2);
                idx++;

                pts[idx] = new Point3f(a + (i + 1) * divX, 0, c + (j + 1) * divZ);
                colors[idx] = (!invert ? color1 : color2);
                idx++;

                pts[idx] = new Point3f(a + (i + 1) * divX, 0, c + j * divZ);
                colors[idx] = (!invert ? color1 : color2);
                idx++;

                invert = !invert;
            }
            if (n % 2 == 0) {
                invert = !invert;
            }
        }

        TriangleArray geom = new TriangleArray(totalVertices, TriangleArray.COORDINATES | TriangleArray.COLOR_3);
        geom.setCoordinates(0, pts);

        Appearance app = new Appearance();
        if (solid) {
            geom.setColors(0, colors);
            app.setPolygonAttributes(new PolygonAttributes(PolygonAttributes.POLYGON_FILL, PolygonAttributes.CULL_NONE, 0));
        } else {
            app.setColoringAttributes(new ColoringAttributes(color1, ColoringAttributes.SHADE_FLAT));
            app.setPolygonAttributes(new PolygonAttributes(PolygonAttributes.POLYGON_LINE, PolygonAttributes.CULL_NONE, 0));
        }
        setGeometry(geom);
        setAppearance(app);
    }
}