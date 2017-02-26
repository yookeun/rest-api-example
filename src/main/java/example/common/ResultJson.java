package example.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yookeun on 2017. 2. 26..
 */
@Data
public class ResultJson implements Serializable {

    private static final long serialVersionUID = 7364275366203360656L;
    private int resultCode = 0;
    private String msg;
    private Object object;
    private int total = -1;			//-1은 카운트를 리턴하지 않는다는 의미이다.
    private List<?> items;
}
