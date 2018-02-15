package datastructures;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

public abstract class tReadable implements Serializable{		
	
	/*
	These methods must be implemented by any tReadable Object
	 */
	
	public abstract String getReadableClassType();	
	
	public abstract void edit();
	
	/*
	These are the rest of the tReadable Object methods
	 */
	
	public String getFileExtension() {
		return "." + this.getReadableClassType().toLowerCase();
	}

	
	public boolean tReadableSavePrompt(JFrame parent) throws FileNotFoundException, IOException, ClassNotFoundException{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Choose a location to save the " + this.getReadableClassType());
		
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		int returnValue = fileChooser.showOpenDialog(parent);
	    switch ( returnValue )
	    {
	    case JFileChooser.APPROVE_OPTION:
			File file = fileChooser.getSelectedFile();
			String fileName = JOptionPane.showInputDialog(fileChooser, "Input name of file: " + this.getReadableClassType() + " (" + this.getFileExtension() + ")");
			file = new File(file + "/" + fileName + this.getFileExtension());
			tReadableSaveFile(file);
			
			return true;
	    case JFileChooser.CANCEL_OPTION:
	        break;
	    default:
	        break;
	    }
		return false;		
	}
	
	public static tReadable tReadableLoadPrompt(JFrame parent, String readableClassType, String fileExtension) throws FileNotFoundException, IOException, ClassNotFoundException {				
		JFileChooser fileChooser = new JFileChooser();
		
		fileChooser.setDialogTitle("Load a " + readableClassType + "(" + fileExtension + ")");
		
		fileChooser.setAcceptAllFileFilterUsed(false);		
		
		fileChooser.setFileFilter(new FileFilter() {

			@Override
			public boolean accept(File f) {
				return f.getName().endsWith(fileExtension);
			}

			@Override
			public String getDescription() {
				return fileExtension;
			}
		
		});
		
		int returnValue = fileChooser.showOpenDialog(parent);
	    switch ( returnValue )
	    {
	    case JFileChooser.APPROVE_OPTION:
	    	File file = fileChooser.getSelectedFile();
	    	tReadable object= tReadableLoadFile(file);
			return object;
	    case JFileChooser.CANCEL_OPTION:
	        break;
	    default:
	        break;
	    }
		return null;
	}
	
	public void tReadableSaveFile(File file) throws FileNotFoundException, IOException, ClassNotFoundException{
		FileOutputStream saveFile = new FileOutputStream(file);
		ObjectOutputStream save = new ObjectOutputStream(saveFile);
		save.writeObject(this);
		save.close();
	}
	
	public static tReadable tReadableLoadFile(File file) throws FileNotFoundException, IOException, ClassNotFoundException{
		FileInputStream saveFile = new FileInputStream(file);
		ObjectInputStream restore = new ObjectInputStream(saveFile);
		tReadable object = (tReadable) restore.readObject();
		return object;
	}

}
