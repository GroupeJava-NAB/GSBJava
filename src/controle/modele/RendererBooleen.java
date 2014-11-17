package controle.modele;


import java.awt.Component; 
  
import javax.swing.Icon; 
import javax.swing.ImageIcon;  
import javax.swing.JTable;  
import javax.swing.table.DefaultTableCellRenderer; 
  
public class RendererBooleen extends DefaultTableCellRenderer { 
   private static final long serialVersionUID = 1L; 
 
   private Icon carteOui; 
   private Icon carteNon; 
 
   public RendererBooleen() { 
      super(); 
      carteOui = new ImageIcon(getClass() 
            .getResource("/images/gestion/carte.png")); 
      carteNon = new ImageIcon(getClass() 
            .getResource("/images/gestion/vide.png")); 
   } 
 
   public Component getTableCellRendererComponent(JTable table, 
         Object value, boolean isSelected, boolean hasFocus, 
         int row, int column) { 
      super.getTableCellRendererComponent(table, value, 
            isSelected, hasFocus, row, column); 
      Boolean carte_fidele = (Boolean)value; 
      setText(""); 
      if(carte_fidele){ 
         setIcon(carteOui); 
      } else { 
         setIcon(carteNon); 
      } 
      // pour centrer les donn�es de la colonne 
      setHorizontalAlignment(CENTER); 
      return this; 
   } 
}
