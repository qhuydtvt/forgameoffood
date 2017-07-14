package techkids.vn.gameoffoodsender;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by huynq on 7/14/17.
 */
@IgnoreExtraProperties
public class RecordModel {
    public String name;
    public String idFCM;

    public RecordModel(String name, String idFCM) {
        this.name = name;
        this.idFCM = idFCM;
    }

    public RecordModel() {
    }
}
