
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LBals
 */
public class Save implements Serializable {
    
    static final long serialVersionUID = 42L;
    
    private int worldNum;
    private int x;
    private int y;
    private Inventory i;
    private ArrayList<Boolean> b = new ArrayList<>();
    
    
    public Save(Inventory i, Player p, Game g, ArrayList<Activator> a){
        worldNum = g.getWorldNum();
        x = p.getX();
        y = p.getY();
        this.i = i;   
        for(Activator activator: a){
            b.add(activator.activated);            
        }
    } 
    
    public int getWorld(){
        return worldNum;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public Inventory getInventory(){
        return i;  
    }
    
    public ArrayList<Boolean> getActivators(){
        return b;
    } 
    
    public static void save(String fn, Save s) throws FileNotFoundException, IOException {
        FileOutputStream fout = new FileOutputStream(fn);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(s);
        fout.close();
    }
      

    public static Save load(String fn) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream(fn);
        ObjectInputStream ois = new ObjectInputStream(fin);
        Save s = (Save) ois.readObject();
        fin.close();
        
        return s;
    }
}
