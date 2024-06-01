package libproject.shapes;

import java.awt.Component;

import javax.media.j3d.Material;
import javax.media.j3d.QuadArray;
import javax.media.j3d.Shape3D;
import javax.media.j3d.TransparencyAttributes;
import javax.vecmath.Point3f;
import javax.vecmath.TexCoord2f;
import com.jogamp.opengl.util.texture.TextureCoords;
import libproject.utilities.TextureApperance;



public class ImagePanel extends Shape3D{
	public ImagePanel(Component c,String image ,float size) {
		
		TextureApperance app=new TextureApperance(c, image, new Material(), false, false);
		TransparencyAttributes ta =new TransparencyAttributes();
		ta.setTransparencyMode(TransparencyAttributes.FASTEST);
		app.setTransparencyAttributes(ta);
		
		QuadArray panel =new QuadArray(4, QuadArray.COORDINATES| QuadArray.TEXTURE_COORDINATE_2);
		float w=size/2f;
		float ar=app.getImageHeight()/(float)app.getImageWidht();
		float h=w*ar;
		
		panel.setCoordinate(0, new Point3f(-w,-h,0));
		panel.setCoordinate(1, new Point3f(w,-h,0));
		panel.setCoordinate(2, new Point3f(w,h,0));
		panel.setCoordinate(3, new Point3f(-w,h,0));
		
		panel.setTextureCoordinate(0,0, new TexCoord2f(0,0));
		panel.setTextureCoordinate(0,1, new TexCoord2f(1f,0));
		panel.setTextureCoordinate(0,2, new TexCoord2f(1f,1f));
		panel.setTextureCoordinate(0,3, new TexCoord2f(0,1f));
		
		setGeometry(panel);
		setAppearance(app);
	}
}
