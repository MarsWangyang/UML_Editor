package UMLObj;


import java.awt.*;
import java.util.Vector;


//the methods of group object will be pre-located up to base class(Shape)
//pop out basic objects in canvas.selectedShapeVector from canvas.allShapeObject
//the above mentioned will implement in Canvas -> public void group(), unGroup()

public class Group extends Shape{
    protected Vector<Shape> selectedShapeGroup = new Vector();
    protected int groupLeftX;
    private int groupLeftY;
    private int groupRightX;
    private int groupRightY;
    private int width;
    private int height;
    protected boolean isSelected = false;

    public Group () {

    }

    public void addSelectedShapeGroup(Vector selectedShapeVector) {
        System.out.println("Group selectedShapeVector: " + selectedShapeVector);
        for (int i = 0; i < selectedShapeVector.size(); i++) {

            this.selectedShapeGroup.add((Shape) selectedShapeVector.elementAt(i));
        }
    }



    //whole group object was moved
    public void resetLocation(Point delta) {
        for (int i = 0; i < selectedShapeGroup.size(); i++) {
            Shape obj = selectedShapeGroup.elementAt(i);
            obj.resetLocation(delta); //讓每個在group裡面的objects都能夠去更換位置
        }
        getInitPoint();
    }

    public void selectSwitch(Boolean chosen) {
        System.out.println(chosen);
        isSelected = chosen;
        System.out.println("------isSelected-------" + chosen);

        for (int i = 0; i < selectedShapeGroup.size(); i++) {
            Shape obj = selectedShapeGroup.elementAt(i);
            obj.selectSwitch(chosen);
        }

             //isSelected = chosen;
    }

    public Vector<Shape> getInnerShape() {
        return selectedShapeGroup;
    }

    //比較每個object的左上角，當作group的最左上
    @Override
    public Point getInitPoint() {
        this.groupRightX = 0;
        this.groupRightY = 0;
        this.groupLeftX = 1200;
        this.groupLeftY = 1200;
        System.out.println("heteeeeee: " + this.selectedShapeGroup);
        for(int i = 0; i < selectedShapeGroup.size(); i++) {
            Shape obj = selectedShapeGroup.elementAt(i);
            System.out.println("Group tmpShape:" + obj);
            int tmpgroupLeftX = (int) obj.getInitPoint().getX();
            int tmpgroupLeftY = (int) obj.getInitPoint().getY();
            int tmpgroupRightX = (int) obj.getInitPoint().getX() + obj.getWidth();
            int tmpgroupRightY = (int) obj.getInitPoint().getY() + obj.getHeight();

            //System.out.println("Group tmpShape_LX:" + tmpgroupLeftX);
            //System.out.println("Group tmpShape_LY:" + tmpgroupLeftY);
            if (tmpgroupLeftX < this.groupLeftX){
                this.groupLeftX = tmpgroupLeftX;
            }
            if (tmpgroupLeftY < this.groupLeftY) {
                this.groupLeftY = tmpgroupLeftY;
            }
            if (tmpgroupRightX > this.groupRightX){
                this.groupRightX = tmpgroupRightX;
            }
            if (tmpgroupRightY > this.groupRightY){
                this.groupRightY = tmpgroupRightY;
            }
                //System.out.println("Group RightX: " + this.groupRightX);
                //System.out.println("Group RightY: "+ this.groupRightY);
        }

        return new Point(groupLeftX, groupLeftY);
    }


    public int getWidth() {

        width = this.groupRightX - this.groupLeftX;
        return width;
    }

    public int getHeight() {

        height = this.groupRightY - this.groupLeftY;
        return height;
    }

    @Override
    public Port[] getPortLocation() {
        return new Port[0];
    }

    @Override
    public void draw(Graphics g) {
        for (int i = 0; i < selectedShapeGroup.size(); i++) {
            Shape obj = selectedShapeGroup.elementAt(i);
            obj.draw(g);
        }
        //g.dispose();
        if (isSelected == true) {
            g.setColor(new Color(155, 200, 123, 127));

            g.fillRect(this.groupLeftX, this.groupLeftY, width, height);
        }
    }
}
