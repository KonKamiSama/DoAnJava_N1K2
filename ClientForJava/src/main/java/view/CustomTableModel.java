package view;

import javax.swing.table.DefaultTableModel;

public class CustomTableModel extends DefaultTableModel {
    private int editableRowIndex = -1;

    @Override
    public boolean isCellEditable(int row, int column) {
        return row == editableRowIndex;
    }

    public void setEditableRow(int rowIndex) {
        this.editableRowIndex = rowIndex;
    }

    public void clearEditableRow() {
        this.editableRowIndex = -1;
    }
}
