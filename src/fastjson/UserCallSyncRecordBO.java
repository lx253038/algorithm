package fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.ws.util.StringUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author: lixin
 * @date: 2022/1/6 4:11 下午
 * @description: 申诉电话沟通结果
 */
@Data
public class UserCallSyncRecordBO implements Serializable {

    private static final long serialVersionUID = -6217240614835687878L;


    private int callInType;

    private int callType;

    private int fromSystem;

    private int syncFileTag;

    private String fields;

    private int callStatus;

    private String uniqueid;

    private String userField;

    public JSONObject getFieldObject() {
        if (fields == null) {
            return null;
        }
        return JSON.parseObject(fields);
    }

}
