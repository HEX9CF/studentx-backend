package studentx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import studentx.pojo.DriftBottle;

/**
 * 漂流瓶服务
 *
 * @author HEX9CF
 * @date 2024/06/01
 */
public interface DriftBottleService extends IService<DriftBottle> {
    boolean add(DriftBottle driftBottle);
    boolean modify(DriftBottle driftBottle);
    boolean delete(DriftBottle driftBottle);
    DriftBottle getRandomByStatus(Integer status);
}
