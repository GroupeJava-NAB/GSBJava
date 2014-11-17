package controle.modele;

import entite.Client;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;
public class ModeleClient extends AbstractTableModel {
    Client instanceClient = new Client();
    private ArrayList<Client> lesDonnees =
            instanceClient.getlesEnreg();
    private final String[] lesTitres = {"Code", "Nom",
        "Prénom", "Carte Fidélité", "Date Création"};
    public int getRowCount() {
        return lesDonnees.size();
    }
    public int getColumnCount() {
        return lesTitres.length;
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lesDonnees.get(rowIndex).getCode();
            case 1:
                return lesDonnees.get(rowIndex).getNom();
            case 2:
                return lesDonnees.get(rowIndex).getPrenom();
            case 3:
                return lesDonnees.get(rowIndex).isCarte_Fidele();
            case 4:
                return lesDonnees.get(rowIndex).getDate_creation();
            default:
                return null;
        }
    }

    public String getColumnName(int columnIndex) {
        return lesTitres[columnIndex];
    }
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 3:
                return Boolean.class;
            case 4:
                return Date.class;
            default:
                return Object.class;
        }
    }
    public int getNumLigne(String vCode) {
        String code = "";
        int numLigne = 0;
        for (int i = 0; i < lesDonnees.size(); i++) {
            code = lesDonnees.get(i).getCode();
            if (code.equals(vCode)) {
                numLigne = i;
            }
        }
        return numLigne;
    }

    public void creerMOD(Client leClient) {
        lesDonnees.add(leClient);
        fireTableRowsInserted(lesDonnees.size() - 1,
                lesDonnees.size() - 1);
    }

    public void supprimerMOD(int rowIndex) {
        lesDonnees.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    public void modifierMOD(int firstRow, int lastRow,
            Client leClient) {
        lesDonnees.set(firstRow, leClient);
        fireTableRowsUpdated(firstRow, lastRow);
    }
    public void lireRecupMOD(ArrayList<Client> nouvellesDonnees) {
        lesDonnees = nouvellesDonnees;
        fireTableDataChanged();
    }
    public static void main(String[] args) {
        ModeleClient test = new ModeleClient();
        System.out.println("NB de clients : "
                + test.getRowCount());
        System.out.println("nom du 1er client : "
                + test.getValueAt(0, 1));
    }
}
