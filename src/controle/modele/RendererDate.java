package controle.modele;


import java.awt.Component; 
import java.text.DateFormat; 
import java.util.Date; 
import java.util.Locale; 
import javax.swing.JTable; 
import javax.swing.table.DefaultTableCellRenderer; 
 
public class RendererDate extends DefaultTableCellRenderer { 
    public Component getTableCellRendererComponent(JTable table, 
            Object value, boolean isSelected,  
            boolean hasFocus, int row, int column) { 
        Date date = (Date) value; 
        DateFormat df = DateFormat. 
                getDateInstance(DateFormat.SHORT, Locale.FRENCH); 
        String str = df.format(date); 
        this.setText(str); 
        this.setHorizontalAlignment(CENTER); 
        this.setBackground(null); 
        return this; 
    } 
}
