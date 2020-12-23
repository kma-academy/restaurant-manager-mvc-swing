package views.admin;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import models.Model;
import utils.ErrorPopup;
import utils.IconManager;

/**
 *
 * @author Tran Duc Cuong<clonebmn2itt@gmail.com>
 */
public abstract class ManagerPaneView<T extends Model> extends JPanel {

    DefaultTableModel tableModel = new DefaultTableModel();
    IconManager im = new IconManager();
    ArrayList<T> tableData = new ArrayList<>();

    public ManagerPaneView() {
        initComponents();
        tblData.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tblData.getTableHeader().setOpaque(false);
        tblData.getTableHeader().setBackground(new Color(51, 175, 255));
        tblData.getTableHeader().setForeground(new Color(255, 255, 255));
        ((DefaultTableCellRenderer) tblData.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.LEFT);
        tblData.setAutoCreateRowSorter(true);
        btnAdd.setIcon(im.getIcon("add_25px.png"));
        btnEdit.setIcon(im.getIcon("edit_25px.png"));
        btnDelete.setIcon(im.getIcon("delete_25px.png"));
        btnSync.setIcon(im.getIcon("sync_25px.png"));
        tblData.setModel(tableModel);
//        cbx_list.putClientProperty("JButton.buttonType", "roundRect");
        btnAdd.putClientProperty("JButton.buttonType", "roundRect");
        btnDelete.putClientProperty("JButton.buttonType", "roundRect");
        btnEdit.putClientProperty("JButton.buttonType", "roundRect");
        btnSync.putClientProperty("JButton.buttonType", "roundRect");
    }

    public JComboBox<String> getCboSearchField() {
        return cboSearchField;
    }

    public void setCboSearchField(JComboBox<String> cboSearchField) {
        this.cboSearchField = cboSearchField;
    }

    public JTextField getTxtSearch() {
        return txtSearch;
    }

    public void setTxtSearch(JTextField txtSearch) {
        this.txtSearch = txtSearch;
    }

    public DefaultTableModel getTableModel() {
        return this.tableModel;
    }

    public void showError(String message) {
        ErrorPopup.show(new Exception(message));
    }

    public void showError(Exception e) {
        ErrorPopup.show(e);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    //Lấy các nút để set event
    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public JButton getBtnSync() {
        return btnSync;
    }

    public ArrayList<T> getTableData() {
        return tableData;
    }

    public void setTableData(ArrayList<T> tableData) {
        this.tableData = tableData;
        renderTable();
    }

    public JTable getTblData() {
        return tblData;
    }

    // Lấy id các hàng đc chọn
    public int[] getSelectedIds() {

        int selectedRows[] = tblData.getSelectedRows();
        int selectedIds[] = new int[selectedRows.length];
        for (int i = 0; i < selectedRows.length; i++) {
            int selectedRow = selectedRows[i];
            int id = (int) tblData.getValueAt(selectedRow, 0);
            selectedIds[i] = id;
        }
        return selectedIds;
    }

    // Lấy id hàng chọn đầu
    public int getSelectedId() {

        int selectedRow = tblData.getSelectedRow();
        if (selectedRow < 0) {
            return -1;
        }
        int id = (int) tblData.getValueAt(selectedRow, 0);
        return id;
    }

    public void renderTable() {
        tableModel.setNumRows(0);
        try {
            for (T item : tableData) {
                tableModel.addRow(item.toRowTable());
            }
        } catch (Exception e) {
            showError(e);
        }
    }

    public abstract void setTableModel();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnDelete = new javax.swing.JButton();
        btnSync = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        cboSearchField = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(118, 215, 196));
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setPreferredSize(new java.awt.Dimension(1008, 680));
        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setOpaque(false);

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblData.setFocusable(false);
        tblData.setRowHeight(25);
        tblData.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblData);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete.setText("Xóa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 42;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 15, 5);
        jPanel1.add(btnDelete, gridBagConstraints);

        btnSync.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSync.setText("Sync");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 42;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 15, 5);
        jPanel1.add(btnSync, gridBagConstraints);

        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEdit.setText("Sửa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 42;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 15, 5);
        jPanel1.add(btnEdit, gridBagConstraints);

        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAdd.setText("Thêm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 42;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 15, 5);
        jPanel1.add(btnAdd, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.LINE_END);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 10));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(1008, 40));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        txtSearch.setBackground(new java.awt.Color(118, 215, 196));
        txtSearch.setForeground(new java.awt.Color(153, 153, 153));
        txtSearch.setText("Search");
        txtSearch.setAlignmentX(0.0F);
        txtSearch.setAlignmentY(0.0F);
        txtSearch.setBorder(null);
        txtSearch.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel2.add(txtSearch);

        cboSearchField.setMinimumSize(new java.awt.Dimension(100, 25));
        cboSearchField.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel2.add(cboSearchField);

        add(jPanel2, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSync;
    private javax.swing.JComboBox<String> cboSearchField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
