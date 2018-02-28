package gui;

import java.awt.Color;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class MapModes {
	private Map<Integer,String> numeMapModeDictonary;
	private Map<String,Integer> nameMapModeDictonary;
	private Map<Integer,MapMode> numMapModeDictonary;
	private TileButtonGrid myTileButtonGrid;
	private int selectedMapMode;
	
	public MapModes(TileButtonGrid grid) {
		myTileButtonGrid = grid;
		selectedMapMode = 4;
		nameMapModeDictonary = new HashMap<String,Integer>();
		numMapModeDictonary = new HashMap<Integer,MapMode>();
		numeMapModeDictonary = new HashMap<Integer, String>();
		addMapMode("height",new MapMode_Height(grid));
		addMapMode("temperature", new MapMode_Temperature(grid));
		addMapMode("rainfall", new MapMode_Rainfall(grid));
		addMapMode("coordinate", new MapMode_Coord(grid));
		addMapMode("three mapmode", new MapMode_Three(grid));
	}
	
	public int size() {
		return numMapModeDictonary.size();
	}
	
	public int getMapModeIndex() {
		return selectedMapMode;
	}
	
	public String getMapModeName(int index) {
		return numeMapModeDictonary.get(index);
	}
	
	public void updateTileButton(TileButton button) {
		getMapMode().updateTileButton(button);
	}
	
	private MapMode getMapMode(String name) {
		return getMapMode(nameMapModeDictonary.get(name));
	}
	
	private MapMode getMapMode(int num) {
		return numMapModeDictonary.get(num);
	}
	
	public void setMapMode(String name) {
		setMapMode(nameMapModeDictonary.get(name));
	}
	
	public void setMapMode(int num) {
		selectedMapMode = num;
	}
	
	
	private MapMode getMapMode() {
		return getMapMode(selectedMapMode);
	}
	
	private void addMapMode(String name, MapMode mapMode) {
		int num = nameMapModeDictonary.size();
		nameMapModeDictonary.put(name, num);
		numeMapModeDictonary.put(num, name);
		numMapModeDictonary.put(num, mapMode);
	}
	
	private class MapMode_Rainfall extends MapMode_Value{

		public MapMode_Rainfall(TileButtonGrid grid) {
			super(grid);
		}

		@Override
		public int getValue(TileButton button) {
			return button.getTile().getRainfall();
		}
		
	}
	
	private class MapMode_Temperature extends MapMode_Value{

		public MapMode_Temperature(TileButtonGrid grid) {
			super(grid);
		}

		@Override
		public int getValue(TileButton button) {
			return button.getTile().getTemperature();
		}
		
	}
	
	private class MapMode_Height extends MapMode_Value{

		public MapMode_Height(TileButtonGrid grid) {
			super(grid);
		}

		@Override
		public int getValue(TileButton button) {
			return button.getTile().getHeight();
		}
		
	}
	
	private abstract class MapMode_Value extends MapMode{

		public MapMode_Value(TileButtonGrid grid) {
			super(grid);
		}

		public abstract int getValue(TileButton button); 
		
		@Override
		public String getText(TileButton button) {
			return "" + getValue(button);
		}

		@Override
		public Color getForeground(TileButton button) {
			double h = getValue(button);
			h=(h*225)/100;
			
			return new Color((int)h,(int)h,(int)h);
		}

		@Override
		public Color getBackground(TileButton button) {
			double h = getValue(button);
			h=(h*225)/100;
			h=255-h;
			return new Color((int)h,(int)h,(int)h);
		}
		
	}
	
	private class MapMode_Three extends MapMode{

		public MapMode_Three(TileButtonGrid grid) {
			super(grid);
		}

		@Override
		public String getText(TileButton button) {
			return "";
			/*
			int height = cch(button.getTile().getHeight());
			int rainfall = cch(button.getTile().getRainfall());
			int temperature = cch(button.getTile().getTemperature());
			return height + "%, " + rainfall + "%, " + temperature + "%";
			*/
		}

		@Override
		public Color getForeground(TileButton button) {
			return Color.WHITE;
		}

		@Override
		public Color getBackground(TileButton button) {
			int height = cch(button.getTile().getHeight());
			int rainfall = cch(button.getTile().getRainfall());
			int temperature = cch(button.getTile().getTemperature());
			return new Color(height,rainfall,temperature);
		}
		
		private int cch(int num) {
			double temp = num;
			num*=255;
			num/=100;
			return (int) temp;
		}
		
	}
	
	private class MapMode_Coord extends MapMode{

		public MapMode_Coord(TileButtonGrid grid) {
			super(grid);
		}

		@Override
		public String getText(TileButton button) {
			return button.getPoint().getX() + ", "+ button.getPoint().getY();
		}

		@Override
		public Color getForeground(TileButton button) {
			return Color.WHITE;
		}

		@Override
		public Color getBackground(TileButton button) {
			return Color.BLUE;
		}
		
	}
	
	private abstract class MapMode{
		TileButtonGrid myTileButtonGrid;
		
		public MapMode(TileButtonGrid grid) {
			myTileButtonGrid = grid;
		}
		
		public void updateTileButton(TileButton button) {
			 updateText(button);
			 setBorder(button);
			 setForeground(button);
			 setBackground(button);
		}
		
		public abstract String getText(TileButton button);
		public abstract Color getForeground(TileButton button);
		public abstract Color getBackground(TileButton button);
		
		public Border getBorder(TileButton button) {
			 return BorderFactory.createEmptyBorder();
		}

		public void updateText(TileButton button) {
			button.setText(getText(button));
		}
		
		public void setBorder(TileButton button) {
			button.setBorder(getBorder(button));
		}
		
		public void setForeground(TileButton button) {
			if(System.getProperty("os.name") == "Mac") {
				button.setForeground(getBackground(button));
			}
			else {
				button.setForeground(getForeground(button));
			}
		}
		
		
		public void setBackground(TileButton button) {
			if(System.getProperty("os.name") != "Mac") {
				button.setBackground(getBackground(button));
			}
		}
	}
}
