package user;

import javax.swing.table.*;
import java.util.List;

public class ModelTable {
    private String[] columnNames = { "Nama", "Email", "Password" };
    private List<User> data;

    public ModelTable(List<User> data) {
        this.data = data;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public void update(User value) {
        int i = 0;

        for (User b : data) {
            if (b.getId().equals(value.getId())) {
                b = value;
                data.set(i, value);
                fireTableCellUpdated(data.size() - 1,
                        data.size() - 1);
            }
            i++;
        }
    }
        
}
