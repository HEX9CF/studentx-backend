package studentx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentx.mapper.DriftBottleMapper;
import studentx.pojo.DriftBottle;
import studentx.service.DriftBottleService;

import java.time.LocalDateTime;

/**
 * 漂流瓶服务实现类
 *
 * @author HEX9CF
 * @date 2024/06/01
 */
@Slf4j
@Service
public class DriftBottleServiceImpl extends ServiceImpl<DriftBottleMapper, DriftBottle> implements DriftBottleService{
    @Autowired
    private DriftBottleMapper driftBottleMapper;

    @Override
    public boolean add(DriftBottle driftBottle) {
        LocalDateTime time = LocalDateTime.now();
        driftBottle.setCreateTime(time);
        driftBottle.setUpdateTime(time);
        return driftBottleMapper.insert(driftBottle) > 0;
    }

    @Override
    public boolean modify(DriftBottle driftBottle) {
        LocalDateTime time = LocalDateTime.now();
        driftBottle.setUpdateTime(time);
        return driftBottleMapper.updateById(driftBottle) > 0;
    }

    @Override
    public boolean delete(DriftBottle driftBottle) {
        return driftBottleMapper.deleteById(driftBottle) > 0;
    }

    @Override
    public DriftBottle getRandomByStatus(Integer status){
        QueryWrapper<DriftBottle> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 1);
        queryWrapper.orderByAsc("rand()");
        queryWrapper.last("limit 1");
        return driftBottleMapper.selectOne(queryWrapper);
    }
}
