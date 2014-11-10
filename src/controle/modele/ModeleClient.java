/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.modele;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rehahla bilel
 */
public class ModeleClient  extends AbstractTableModel  {

    @Override
    public int getRowCount() {
      return lesDonnees.size();
    }

    @Override
    public int getColumnCount() {
       return lesTitres.length;
    }

    @Override
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

return lesDonnees.get(rowIndex) getDate_creation();

default:

return null;}
    
       
    public String getColumnName(int columnIndex) {
        return lesTitres[columnIndex];
    }

// pour récupérer les enreg et les mettre dans le modèle

Client instanceClient = new Client();

private ArrayList<Client> lesDonnees = instanceClient.getlesEnreg();

// les en-têtes de colonnes

private final String[] lesTitres = {"Code", "Nom",
            "Prénom", "Carte Fidélité", "Date Création"};

// pour obtenir le numéro de ligne à partir du code client

// lors d’une recherche dans l’ArrayList

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

}
public void supprimerMOD(int rowIndex) {
    lesDonnees.remove(rowIndex); 
public void modifierMOD(int firstRow, int lastRow,
                                          Client leClient) {
    // set() attend 2 paramètres, 
    // le numéro de ligne
    // et l’objet concerné par les modifications 
    lesDonnees.set(firstRow, leClient);
}


public void lireRecupMOD(){
}   
public static void main (String [] args) {

ModeleClient test = new ModeleClient();
System.out.println("NB de clients : " + test.getRowCount());
System.out.println("nom du 1er client : "
                              + test.getValueAt(0, 1));
}

