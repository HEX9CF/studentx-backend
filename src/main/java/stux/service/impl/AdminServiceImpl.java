package stux.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stux.mapper.AdminMapper;
import stux.pojo.Admin;
import stux.service.AdminService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理服务实现类
 *
 * @author HEX9CF
 * @date 2023/09/17
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public boolean save(Admin admin) {
        return false;
    }

    @Override
    public boolean modify(Admin admin) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean login(Admin admin) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("username", admin.getUsername());
        map.put("password", admin.getPassword());
        queryWrapper.allEq(map);
        List<Admin> admins = adminMapper.selectList(queryWrapper);
        return !admins.isEmpty();
    }

    @Override
    public IPage<Admin> getPage(int currentPage, int pageSize) {
        return null;
    }

    @Override
    public IPage<Admin> getPage(int currentPage, int pageSize, Admin admin) {
        return null;
    }
}
