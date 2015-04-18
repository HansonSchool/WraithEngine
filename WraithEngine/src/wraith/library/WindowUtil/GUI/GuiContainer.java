package wraith.library.WindowUtil.GUI;

import java.util.ArrayList;

public abstract class GuiContainer extends GuiComponent{
	private GuiLayout layout;
	protected final ArrayList<GuiComponent> components = new ArrayList();
	private void validate(){
		if(layout!=null){
			layout.setParentDimensions(width, height);
			layout.validateComponents(components);
		}
	}
	public void addComponent(GuiComponent component){
		if(components.size()>=layout.getMaxChildren())return;
		components.add(component);
		validate();
	}
	public void removeComponent(GuiComponent component){
		components.remove(component);
		validate();
	}
	@Override public void setSize(int width, int height){
		super.setSize(width, height);
		validate();
	}
	@Override public void setLocation(int x, int y){
		super.setLocation(x, y);
		validate();
	}
	@Override public void setSizeAndLocation(int x, int y, int width, int height){
		super.setSizeAndLocation(x, y, width, height);
		validate();
	}
}