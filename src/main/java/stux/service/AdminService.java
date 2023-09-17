package stux.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import stux.pojo.Admin;

public interface AdminService extends IService<Admin> {
    boolean save(Admin admin);
    boolean modify(Admin admin);
    boolean delete(Integer id);
    boolean login(Admin admin);
    IPage<Admin> getPage(int currentPage, int pageSize);
    IPage<Admin> getPage(int currentPage, int pageSize, Admin admin);

}
