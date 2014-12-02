package genieprojet.gui;

import genieprojet.annuaire.Utilisateur;
import genieprojet.controleurs.AnnuaireControleur;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import genieprojet.util.IObserver;

/**
 *
 * @author Coq
 */
public class UsersUI extends javax.swing.JFrame implements IObserver{

    private DefaultTableModel model;
    AnnuaireControleur controller;
    Utilisateur selectedUser;

    /**
     * Creates new form UsersUI
     */
    public UsersUI() {
        initComponents();
        controller = new AnnuaireControleur();
        controller.ajouterObserver(this);
        initTable();
        reloadFullTable();
        addManualListener();
    }
    
    
    
    private void initTable(){
        String[] colName = {"Identificateur", "Prénom", "Nom", "Niveau"};
        model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
            }
        };
        allTable.setModel(model);
        model.setColumnIdentifiers(colName);
    }
    
    @Override
    public void update(){
        reloadTable();
    }
    
    private void reloadFullTable(){
        disableFields();
        fillTable(controller.getAllUsers());
    }
    
    public void reloadTable(){
        disableFields();
        clearInfos();
        ArrayList<Utilisateur> users = controller.findUsers(searchField.getText());
        fillTable(users);
    }

    private void fillTable(ArrayList<Utilisateur> users) {
        clearTable();
            for (Utilisateur u : users) {
                model.addRow(new String[]{
                    u.getID(),
                    u.getPrenom(),
                    u.getNom(),
                    u.getNiveauString()
                });
        }
    }
    
    private void clearTable(){
        allTable.clearSelection();
        model.setRowCount(0);
    }

    private void fillInfos(Utilisateur user) {
        niveauField.setSelectedItem(user.getNiveauString());
        nomField.setText(user.getNom());
        nom2Field.setText(user.getPrenom());
    }

    private void clearInfos() {
        selectedUser = null;

        nomField.setText("");
        nom2Field.setText("");
    }
    
    private void enableFields(){
        niveauField.setEnabled(true);
        nomField.setEnabled(true);
        nom2Field.setEnabled(true);
    }
    
    private void disableFields(){
        niveauField.setEnabled(false);
        nomField.setEnabled(false);
        nom2Field.setEnabled(false);
    }

    private void addManualListener() {
        allTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                try {
                    deleteButton.setEnabled(true);
                    enableFields();
                    String ID = allTable.getValueAt(allTable.getSelectedRow(), 0).toString();

                    selectedUser = controller.getUser(ID);
                    fillInfos(selectedUser);
                } catch (Exception e) { //Empeche de planter lors du refresh de la table
                    //System.out.println("Selection vide UserUI");
                    clearInfos();
                    disableFields();
                    deleteButton.setEnabled(false);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        userListPanel = new javax.swing.JTabbedPane();
        allPanel = new javax.swing.JScrollPane();
        allTable = new javax.swing.JTable();
        clientInfoPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nom2Label = new javax.swing.JLabel();
        nom2Field = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        nomField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        niveauField = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                UsersUI.this.windowClosing(evt);
            }
        });

        searchButton.setText("Rechercher");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        addButton.setText("Ajouter");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        closeButton.setText("Fermer");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        userListPanel.setName("All"); // NOI18N

        allTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Identificateur", "Prénom", "Nom", "Niveau"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        allPanel.setViewportView(allTable);

        userListPanel.addTab("Utilisateurs", allPanel);

        jLabel2.setText("Niveau d'accès  :");

        jLabel3.setText("Nom :");

        nom2Label.setText("Prénom :");

        nom2Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom2FieldActionPerformed(evt);
            }
        });

        deleteButton.setText("Supprimer");
        deleteButton.setEnabled(false);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        nomField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomFieldActionPerformed(evt);
            }
        });

        saveButton.setText("Sauvegarder");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        niveauField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Prepose", "Sous-directeur", "Directeur" }));

        javax.swing.GroupLayout clientInfoPanelLayout = new javax.swing.GroupLayout(clientInfoPanel);
        clientInfoPanel.setLayout(clientInfoPanelLayout);
        clientInfoPanelLayout.setHorizontalGroup(
            clientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(nom2Label)
                    .addComponent(saveButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(clientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nom2Field)
                    .addComponent(nomField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(clientInfoPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(deleteButton))
                    .addComponent(niveauField, 0, 167, Short.MAX_VALUE))
                .addContainerGap())
        );
        clientInfoPanelLayout.setVerticalGroup(
            clientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(niveauField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(clientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(nomField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(clientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nom2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nom2Label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 247, Short.MAX_VALUE)
                .addGroup(clientInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(saveButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addButton))
                    .addComponent(userListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(clientInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(clientInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(addButton)
                    .addComponent(closeButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        reloadTable();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        CreateUserUI createUI = new CreateUserUI(controller);
        createUI.setVisible(true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.windowClosing(null);
        this.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void nom2FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom2FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom2FieldActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        controller.retirerUtilisateur(selectedUser.getID());
        allTable.clearSelection();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void nomFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomFieldActionPerformed

    private void windowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_windowClosing
        new PortailUI().setVisible(true);
    }//GEN-LAST:event_windowClosing

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        controller.saveUtilisateur(
            selectedUser,
            niveauField.getSelectedItem().toString(),
            nomField.getText(),
            nom2Field.getText()
        );
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JScrollPane allPanel;
    private javax.swing.JTable allTable;
    private javax.swing.JPanel clientInfoPanel;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox niveauField;
    private javax.swing.JTextField nom2Field;
    private javax.swing.JLabel nom2Label;
    private javax.swing.JTextField nomField;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JTabbedPane userListPanel;
    // End of variables declaration//GEN-END:variables
}
