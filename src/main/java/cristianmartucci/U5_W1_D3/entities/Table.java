package cristianmartucci.U5_W1_D3.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Table {
    private int table_id;
    private int capacity;
    private boolean  state;
}
